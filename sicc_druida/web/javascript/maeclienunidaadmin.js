

/*
    INDRA/CAR/mmg
    $Id: maeclienunidaadmin.js,v 1.1 2009/12/03 19:01:40 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeClienUnidaAdminId = "";
var jsMaeClienUnidaAdminClieOidClie = "";
var jsMaeClienUnidaAdminPerdOidPeriIni = "";
var jsMaeClienUnidaAdminPerdOidPeriFin = "";
var jsMaeClienUnidaAdminZtadOidTerrAdmi = "";
var jsMaeClienUnidaAdminIndActi = "";

//Variables de paginacion, 
var maeClienUnidaAdminPageCount = 1;

//Varible de columna que representa el campo de choice
var maeClienUnidaAdminChoiceColumn = 5;

//Flag de siguiente pagina;
var maeClienUnidaAdminMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeClienUnidaAdminTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 395;
var sizeFormView = 395;
var sizeFormUpdate = 395;

//Ultima busqueda realizada
var maeClienUnidaAdminLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("maeClienUnidaAdminFrm.indActi");','focaliza("maeClienUnidaAdminFrm.indActi");','focaliza("maeClienUnidaAdminFrm.indActi");','focaliza("maeClienUnidaAdminFrm.indActi");','focaliza("maeClienUnidaAdminFrm.indActi");','focaliza("maeClienUnidaAdminFrm.indActi");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var clieOidClieDependeceMap = new Vector();
clieOidClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clieOidClieDependeceMap.agregar(['clieOidClie', padresTmp, '', 'MaeClien']);
var perdOidPeriIniDependeceMap = new Vector();
perdOidPeriIniDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
perdOidPeriIniDependeceMap.agregar(['perdOidPeriIni', padresTmp, '', 'CraPerio']);
var perdOidPeriFinDependeceMap = new Vector();
perdOidPeriFinDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
perdOidPeriFinDependeceMap.agregar(['perdOidPeriFin', padresTmp, '', 'CraPerio']);
var ztadOidTerrAdmiDependeceMap = new Vector();
ztadOidTerrAdmiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ztadOidTerrAdmiDependeceMap.agregar(['ztadOidTerrAdmi', padresTmp, '', 'ZonTerriAdmin']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeClienUnidaAdminLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeClienUnidaAdminTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function maeClienUnidaAdminInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeClienUnidaAdminFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeClienUnidaAdminFrm.accion')){
		case "query": maeClienUnidaAdminQueryInitComponents(); break;
		case "view": maeClienUnidaAdminViewInitComponents(); break;
		case "create": maeClienUnidaAdminCreateInitComponents(); break;
		case "update": maeClienUnidaAdminUpdateInitComponents(); break;
		case "remove": maeClienUnidaAdminRemoveInitComponents(); break;
		case "lov": maeClienUnidaAdminLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('maeClienUnidaAdminFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeClienUnidaAdmin')) maeClienUnidaAdminCmdRequery();
}

function maeClienUnidaAdminQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
}

function maeClienUnidaAdminViewInitComponents(){
	//En principiono se hace nada
}

function maeClienUnidaAdminCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeClienUnidaAdminFrm.clieOidClie','S', GestionarMensaje('MaeClienUnidaAdmin.clieOidClie.requiered.message'));
	
	setMV('maeClienUnidaAdminFrm.perdOidPeriIni','S', GestionarMensaje('MaeClienUnidaAdmin.perdOidPeriIni.requiered.message'));
	
	setMV('maeClienUnidaAdminFrm.perdOidPeriFin','S', GestionarMensaje('MaeClienUnidaAdmin.perdOidPeriFin.requiered.message'));
	
	setMV('maeClienUnidaAdminFrm.ztadOidTerrAdmi','S', GestionarMensaje('MaeClienUnidaAdmin.ztadOidTerrAdmi.requiered.message'));
	
	setMV('maeClienUnidaAdminFrm.indActi','S', GestionarMensaje('MaeClienUnidaAdmin.indActi.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function maeClienUnidaAdminUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeClienUnidaAdminFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		maeClienUnidaAdminTmpUpdateValues = maeClienUnidaAdminBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeClienUnidaAdminFrm.clieOidClie','S', GestionarMensaje('MaeClienUnidaAdmin.clieOidClie.requiered.message'));
		
		setMV('maeClienUnidaAdminFrm.perdOidPeriIni','S', GestionarMensaje('MaeClienUnidaAdmin.perdOidPeriIni.requiered.message'));
		
		setMV('maeClienUnidaAdminFrm.perdOidPeriFin','S', GestionarMensaje('MaeClienUnidaAdmin.perdOidPeriFin.requiered.message'));
		
		setMV('maeClienUnidaAdminFrm.ztadOidTerrAdmi','S', GestionarMensaje('MaeClienUnidaAdmin.ztadOidTerrAdmi.requiered.message'));
		
		setMV('maeClienUnidaAdminFrm.indActi','S', GestionarMensaje('MaeClienUnidaAdmin.indActi.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeClienUnidaAdminFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeClienUnidaAdminRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeClienUnidaAdminList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function maeClienUnidaAdminLovInitComponents(){
	maeClienUnidaAdminLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad








//Función que permite cargar los datos de un elemento de lov seleccionado
function maeClienUnidaAdminSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeClienUnidaAdminFrm.' + campo, id);
	set('maeClienUnidaAdminFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeClienUnidaAdminLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeClienUnidaAdminLovReturnParameters.id = '';
	maeClienUnidaAdminLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeClienUnidaAdminLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienUnidaAdminList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeClienUnidaAdminList.codSeleccionados();
	var descripcion = maeClienUnidaAdminList.extraeDato(
		maeClienUnidaAdminList.codSeleccionados()[0], maeClienUnidaAdminChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeClienUnidaAdminLovReturnParameters.id = codigo;
	maeClienUnidaAdminLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeClienUnidaAdminCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeClienUnidaAdminFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeClienUnidaAdminLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeClienUnidaAdminFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeClienUnidaAdminList", "MaeClienUnidaAdminConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeClienUnidaAdminPostQueryActions(datos);"]], "", "");	
}

function maeClienUnidaAdminCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeClienUnidaAdminFrm.lastQueryToSession'));
	var i =0;
	set('maeClienUnidaAdminFrm.clieOidClie', [paramsRequery.ij(i++)]);
	
	set('maeClienUnidaAdminFrm.perdOidPeriIni', [paramsRequery.ij(i++)]);
	
	set('maeClienUnidaAdminFrm.perdOidPeriFin', [paramsRequery.ij(i++)]);
	
	set('maeClienUnidaAdminFrm.ztadOidTerrAdmi', [paramsRequery.ij(i++)]);
	
	set('maeClienUnidaAdminFrm.indActi', paramsRequery.ij(i++));
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	maeClienUnidaAdminPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeClienUnidaAdminCmdQuery(maeClienUnidaAdminPageCount);
}

function maeClienUnidaAdminFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeClienUnidaAdminPageCount = 1;
	maeClienUnidaAdminCmdQuery(maeClienUnidaAdminPageCount);
}

function maeClienUnidaAdminPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeClienUnidaAdminLastQuery){
		maeClienUnidaAdminFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeClienUnidaAdminPageCount--;
	maeClienUnidaAdminCmdQuery(maeClienUnidaAdminPageCount);
}

function maeClienUnidaAdminNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeClienUnidaAdminLastQuery){
		maeClienUnidaAdminFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeClienUnidaAdminPageCount++;
	maeClienUnidaAdminCmdQuery(maeClienUnidaAdminPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeClienUnidaAdminPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeClienUnidaAdminListLayer', 'O');
		visibilidad('maeClienUnidaAdminListButtonsLayer', 'O');
		if(get('maeClienUnidaAdminFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeClienUnidaAdminViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeClienUnidaAdminChoiceColumn) + "</A>",
			i, maeClienUnidaAdminChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeClienUnidaAdminList.setDatos(datosTmp.filtrar([0,1,2,3,4,5],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeClienUnidaAdminTimeStamps = datosTmp.filtrar([6],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeClienUnidaAdminMorePagesFlag = true;
		maeClienUnidaAdminList.eliminar(mmgPageSize, 1);
	}else{
		maeClienUnidaAdminMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeClienUnidaAdminFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeClienUnidaAdminListLayer', 'V');
	visibilidad('maeClienUnidaAdminListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeClienUnidaAdminList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeClienUnidaAdminList.display();
	
	//Actualizamos el estado de los botones 
	if(maeClienUnidaAdminMorePagesFlag){
		set_estado_botonera('maeClienUnidaAdminPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeClienUnidaAdminPaginationButtonBar',
			3,"inactivo");
	}
	if(maeClienUnidaAdminPageCount > 1){
		set_estado_botonera('maeClienUnidaAdminPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeClienUnidaAdminPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeClienUnidaAdminPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeClienUnidaAdminPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeClienUnidaAdminUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienUnidaAdminList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeClienUnidaAdminFrm.idSelection', maeClienUnidaAdminList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeClienUnidaAdminFrm', true);
	if(validacion){
		/*set('maeClienUnidaAdminFrm.previousAction', 'update');
		set('maeClienUnidaAdminFrm.ON', 'MaeClienUnidaAdminLPStartUp');
		set('maeClienUnidaAdminFrm.conectorAction', 'MaeClienUnidaAdminLPStartUp');
		set('maeClienUnidaAdminFrm.origen', 'pagina');
		envia('maeClienUnidaAdminFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = maeClienUnidaAdminList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeClienUnidaAdminFrm.accion');
		parametros["accion"] = get('maeClienUnidaAdminFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('MaeClienUnidaAdminLPStartUp', get('maeClienUnidaAdminFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) maeClienUnidaAdminCmdRequery();
	}
}

function maeClienUnidaAdminRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienUnidaAdminList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeClienUnidaAdminList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeClienUnidaAdminFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeClienUnidaAdminList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeClienUnidaAdminTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeClienUnidaAdminFrm.timestamp', timestamps);
	envia('maeClienUnidaAdminFrm');
}

function maeClienUnidaAdminViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienUnidaAdminList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('maeClienUnidaAdminFrm.previousAction', get('maeClienUnidaAdminFrm.accion'));
	set('maeClienUnidaAdminFrm.accion', 'view');
	set('maeClienUnidaAdminFrm.origen', 'pagina');
	set('maeClienUnidaAdminFrm.ON', 'MaeClienUnidaAdminLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('maeClienUnidaAdminFrm.idSelection', maeClienUnidaAdminList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('maeClienUnidaAdminFrm');
	maeClienUnidaAdminViewDetail(maeClienUnidaAdminList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeClienUnidaAdminViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeClienUnidaAdminFrm.accion');
	parametros["accion"] = get('maeClienUnidaAdminFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('MaeClienUnidaAdminLPStartUp', get('maeClienUnidaAdminFrm.accion'), parametros, null, sizeFormView + 30);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar on dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeClienUnidaAdminFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
		
	
	if(validacion)envia('maeClienUnidaAdminFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeClienUnidaAdminRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeClienUnidaAdminFrm.accion');
	var origenTmp = get('maeClienUnidaAdminFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeClienUnidaAdminBuildUpdateRecordString() != maeClienUnidaAdminTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('maeClienUnidaAdminFrm.performRequery', 'true');
		set('maeClienUnidaAdminFrm.accion', 
			get('maeClienUnidaAdminFrm.previousAction'));
		set('maeClienUnidaAdminFrm.origen', 'menu');
		set('maeClienUnidaAdminFrm.ON', 'MaeClienUnidaAdminLPStartUp');
		set('maeClienUnidaAdminFrm.conectorAction', 'MaeClienUnidaAdminLPStartUp');
		maeClienUnidaAdminFrm.oculto='N';
		envia('maeClienUnidaAdminFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.maeClienUnidaAdminListLayer.style.display='none';
	document.all.maeClienUnidaAdminListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeClienUnidaAdminListLayer.style.display='';
	document.all.maeClienUnidaAdminListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda

	jsMaeClienUnidaAdminClieOidClie = get('maeClienUnidaAdminFrm.clieOidClie')[0];





	jsMaeClienUnidaAdminPerdOidPeriIni = get('maeClienUnidaAdminFrm.perdOidPeriIni')[0];





	jsMaeClienUnidaAdminPerdOidPeriFin = get('maeClienUnidaAdminFrm.perdOidPeriFin')[0];





	jsMaeClienUnidaAdminZtadOidTerrAdmi = get('maeClienUnidaAdminFrm.ztadOidTerrAdmi')[0];




	jsMaeClienUnidaAdminIndActi = get('maeClienUnidaAdminFrm.indActi').toString();








	var parametros = "";
	parametros += jsMaeClienUnidaAdminClieOidClie + "|";



	parametros += jsMaeClienUnidaAdminPerdOidPeriIni + "|";



	parametros += jsMaeClienUnidaAdminPerdOidPeriFin + "|";



	parametros += jsMaeClienUnidaAdminZtadOidTerrAdmi + "|";



	parametros += jsMaeClienUnidaAdminIndActi + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeClienUnidaAdminBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeClienUnidaAdminClieOidClie + "|";
	parametros += jsMaeClienUnidaAdminPerdOidPeriIni + "|";
	parametros += jsMaeClienUnidaAdminPerdOidPeriFin + "|";
	parametros += jsMaeClienUnidaAdminZtadOidTerrAdmi + "|";
	parametros += jsMaeClienUnidaAdminIndActi + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeClienUnidaAdminFrm.accion'), 
		get('maeClienUnidaAdminFrm.origen'));
	
	jsMaeClienUnidaAdminId = get('maeClienUnidaAdminFrm.id').toString();
	jsMaeClienUnidaAdminClieOidClie = get('maeClienUnidaAdminFrm.clieOidClie')[0];
	jsMaeClienUnidaAdminPerdOidPeriIni = get('maeClienUnidaAdminFrm.perdOidPeriIni')[0];
	jsMaeClienUnidaAdminPerdOidPeriFin = get('maeClienUnidaAdminFrm.perdOidPeriFin')[0];
	jsMaeClienUnidaAdminZtadOidTerrAdmi = get('maeClienUnidaAdminFrm.ztadOidTerrAdmi')[0];
	jsMaeClienUnidaAdminIndActi = get('maeClienUnidaAdminFrm.indActi').toString();

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeClienUnidaAdminFrm.accion'), 
		get('maeClienUnidaAdminFrm.origen'));


	set('maeClienUnidaAdminFrm.id', jsMaeClienUnidaAdminId);
	set('maeClienUnidaAdminFrm.clieOidClie', [jsMaeClienUnidaAdminClieOidClie]);
	set('maeClienUnidaAdminFrm.perdOidPeriIni', [jsMaeClienUnidaAdminPerdOidPeriIni]);
	set('maeClienUnidaAdminFrm.perdOidPeriFin', [jsMaeClienUnidaAdminPerdOidPeriFin]);
	set('maeClienUnidaAdminFrm.ztadOidTerrAdmi', [jsMaeClienUnidaAdminZtadOidTerrAdmi]);
	set('maeClienUnidaAdminFrm.indActi', jsMaeClienUnidaAdminIndActi);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeClienUnidaAdminFrm.errCodigo', errorCode);
	set('maeClienUnidaAdminFrm.errDescripcion', description);
	set('maeClienUnidaAdminFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	



/*
    INDRA/CAR/mmg
    $Id: maeclienclasi.js,v 1.1 2009/12/03 19:02:09 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeClienClasiId = "";
var jsMaeClienClasiCtsuOidClieTipoSubt = "";
var jsMaeClienClasiClasOidClas = "";
var jsMaeClienClasiPerdOidPeri = "";
var jsMaeClienClasiTcclOidTipoClasi = "";
var jsMaeClienClasiFecClas = "";
var jsMaeClienClasiIndPpal = "";

//Variables de paginacion, 
var maeClienClasiPageCount = 1;

//Varible de columna que representa el campo de choice
var maeClienClasiChoiceColumn = 6;

//Flag de siguiente pagina;
var maeClienClasiMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeClienClasiTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 315;
var sizeFormView = 309;
var sizeFormUpdate = 309;

//Ultima busqueda realizada
var maeClienClasiLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("maeClienClasiFrm.indPpal");','focaliza("maeClienClasiFrm.indPpal");','focaliza("maeClienClasiFrm.indPpal");','focaliza("maeClienClasiFrm.indPpal");','focaliza("maeClienClasiFrm.indPpal");','focaliza("maeClienClasiFrm.indPpal");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var ctsuOidClieTipoSubtDependeceMap = new Vector();
ctsuOidClieTipoSubtDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ctsuOidClieTipoSubtDependeceMap.agregar(['ctsuOidClieTipoSubt', padresTmp, '', 'MaeClienTipoSubti']);
var clasOidClasDependeceMap = new Vector();
clasOidClasDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clasOidClasDependeceMap.agregar(['clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', padresTmp, 'clasOidClas_tcclOidTipoClas_sbtiOidSubtClie', 'MaeTipoClienView']);
padresTmp =  new Vector();
padresTmp.cargar(['clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie'])
clasOidClasDependeceMap.agregar(['clasOidClas_tcclOidTipoClas_sbtiOidSubtClie', padresTmp, 'clasOidClas_tcclOidTipoClas', 'MaeSubtiClien']);
padresTmp =  new Vector();
padresTmp.cargar(['clasOidClas_tcclOidTipoClas_sbtiOidSubtClie'])
clasOidClasDependeceMap.agregar(['clasOidClas_tcclOidTipoClas', padresTmp, 'clasOidClas', 'MaeTipoClasiClien']);
padresTmp =  new Vector();
padresTmp.cargar(['clasOidClas_tcclOidTipoClas'])
clasOidClasDependeceMap.agregar(['clasOidClas', padresTmp, '', 'MaeClasi']);
var perdOidPeriDependeceMap = new Vector();
perdOidPeriDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
perdOidPeriDependeceMap.agregar(['perdOidPeri', padresTmp, '', 'CraPerio']);
var tcclOidTipoClasiDependeceMap = new Vector();
tcclOidTipoClasiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tcclOidTipoClasiDependeceMap.agregar(['tcclOidTipoClasi_sbtiOidSubtClie_ticlOidTipoClie', padresTmp, 'tcclOidTipoClasi_sbtiOidSubtClie', 'MaeTipoClienView']);
padresTmp =  new Vector();
padresTmp.cargar(['tcclOidTipoClasi_sbtiOidSubtClie_ticlOidTipoClie'])
tcclOidTipoClasiDependeceMap.agregar(['tcclOidTipoClasi_sbtiOidSubtClie', padresTmp, 'tcclOidTipoClasi', 'MaeSubtiClien']);
padresTmp =  new Vector();
padresTmp.cargar(['tcclOidTipoClasi_sbtiOidSubtClie'])
tcclOidTipoClasiDependeceMap.agregar(['tcclOidTipoClasi', padresTmp, '', 'MaeTipoClasiClien']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeClienClasiLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeClienClasiTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function maeClienClasiInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeClienClasiFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeClienClasiFrm.accion')){
		case "query": maeClienClasiQueryInitComponents(); break;
		case "view": maeClienClasiViewInitComponents(); break;
		case "create": maeClienClasiCreateInitComponents(); break;
		case "update": maeClienClasiUpdateInitComponents(); break;
		case "remove": maeClienClasiRemoveInitComponents(); break;
		case "lov": maeClienClasiLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('maeClienClasiFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeClienClasi')) maeClienClasiCmdRequery();
}

function maeClienClasiQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
}

function maeClienClasiViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
}

function maeClienClasiCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeClienClasiFrm.ctsuOidClieTipoSubt','S', GestionarMensaje('MaeClienClasi.ctsuOidClieTipoSubt.requiered.message'));
	
	setMV('maeClienClasiFrm.clasOidClas','S', GestionarMensaje('MaeClienClasi.clasOidClas.requiered.message'));
	
	setMV('maeClienClasiFrm.perdOidPeri','S', GestionarMensaje('MaeClienClasi.perdOidPeri.requiered.message'));
	
	setMV('maeClienClasiFrm.tcclOidTipoClasi','S', GestionarMensaje('MaeClienClasi.tcclOidTipoClasi.requiered.message'));
	
	setMV('maeClienClasiFrm.indPpal','S', GestionarMensaje('MaeClienClasi.indPpal.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function maeClienClasiUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeClienClasiFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		maeClienClasiTmpUpdateValues = maeClienClasiBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeClienClasiFrm.ctsuOidClieTipoSubt','S', GestionarMensaje('MaeClienClasi.ctsuOidClieTipoSubt.requiered.message'));
		setMV('maeClienClasiFrm.clasOidClas','S', GestionarMensaje('MaeClienClasi.clasOidClas.requiered.message'));
		setMV('maeClienClasiFrm.perdOidPeri','S', GestionarMensaje('MaeClienClasi.perdOidPeri.requiered.message'));
		setMV('maeClienClasiFrm.tcclOidTipoClasi','S', GestionarMensaje('MaeClienClasi.tcclOidTipoClasi.requiered.message'));
		setMV('maeClienClasiFrm.indPpal','S', GestionarMensaje('MaeClienClasi.indPpal.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeClienClasiFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeClienClasiRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeClienClasiList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function maeClienClasiLovInitComponents(){
	maeClienClasiLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad









//Función que permite cargar los datos de un elemento de lov seleccionado
function maeClienClasiSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeClienClasiFrm.' + campo, id);
	set('maeClienClasiFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeClienClasiLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeClienClasiLovReturnParameters.id = '';
	maeClienClasiLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeClienClasiLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienClasiList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeClienClasiList.codSeleccionados();
	var descripcion = maeClienClasiList.extraeDato(
		maeClienClasiList.codSeleccionados()[0], maeClienClasiChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeClienClasiLovReturnParameters.id = codigo;
	maeClienClasiLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeClienClasiCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeClienClasiFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeClienClasiFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeClienClasiList", "MaeClienClasiConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeClienClasiPostQueryActions(datos);"]], "", "");	
}

function maeClienClasiCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeClienClasiFrm.lastQueryToSession'));
	var i =0;
	set('maeClienClasiFrm.ctsuOidClieTipoSubt', [paramsRequery.ij(i++)]);
	
	set('maeClienClasiFrm.clasOidClas', [paramsRequery.ij(i++)]);
	
	set('maeClienClasiFrm.perdOidPeri', [paramsRequery.ij(i++)]);
	
	set('maeClienClasiFrm.tcclOidTipoClasi', [paramsRequery.ij(i++)]);
	
	set('maeClienClasiFrm.fecClas', paramsRequery.ij(i++));
	
	set('maeClienClasiFrm.indPpal', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeClienClasiPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeClienClasiCmdQuery(maeClienClasiPageCount);
}

function maeClienClasiFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeClienClasiPageCount = 1;
	maeClienClasiCmdQuery(maeClienClasiPageCount);
}

function maeClienClasiPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeClienClasiLastQuery){
		maeClienClasiFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeClienClasiPageCount--;
	maeClienClasiCmdQuery(maeClienClasiPageCount);
}

function maeClienClasiNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeClienClasiLastQuery){
		maeClienClasiFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeClienClasiPageCount++;
	maeClienClasiCmdQuery(maeClienClasiPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeClienClasiPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeClienClasiListLayer', 'O');
		visibilidad('maeClienClasiListButtonsLayer', 'O');
		if(get('maeClienClasiFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeClienClasiLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeClienClasiViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeClienClasiChoiceColumn) + "</A>",
			i, maeClienClasiChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeClienClasiList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeClienClasiTimeStamps = datosTmp.filtrar([7],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeClienClasiMorePagesFlag = true;
		maeClienClasiList.eliminar(mmgPageSize, 1);
	}else{
		maeClienClasiMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeClienClasiFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeClienClasiListLayer', 'V');
	visibilidad('maeClienClasiListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeClienClasiList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeClienClasiList.display();
	
	//Actualizamos el estado de los botones 
	if(maeClienClasiMorePagesFlag){
		set_estado_botonera('maeClienClasiPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeClienClasiPaginationButtonBar',
			3,"inactivo");
	}
	if(maeClienClasiPageCount > 1){
		set_estado_botonera('maeClienClasiPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeClienClasiPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeClienClasiPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeClienClasiPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeClienClasiUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienClasiList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeClienClasiFrm.idSelection', maeClienClasiList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeClienClasiFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeClienClasiList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeClienClasiFrm.accion');
		parametros["accion"] = get('maeClienClasiFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('MaeClienClasiLPStartUp', get('maeClienClasiFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) maeClienClasiCmdRequery();
	}
}

function maeClienClasiRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienClasiList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeClienClasiList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeClienClasiFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeClienClasiList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeClienClasiTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeClienClasiFrm.timestamp', timestamps);


	maeClienClasiFrm.oculto='S';
	envia('maeClienClasiFrm');
	maeClienClasiFrm.oculto='N';
}

function maeClienClasiViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienClasiList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeClienClasiViewDetail(maeClienClasiList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeClienClasiViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeClienClasiFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('MaeClienClasiLPStartUp', 'view', parametros, null, sizeFormView + 55);
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
	var validacion = ValidaForm('maeClienClasiFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
		
	
	if(validacion){
		maeClienClasiFrm.oculto='S';
		envia('maeClienClasiFrm');
		maeClienClasiFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeClienClasiFrm.ctsuOidClieTipoSubt').toString() == ''){
		set('maeClienClasiFrm.ctsuOidClieTipoSubt', []);
		mmgResetCombosOnCascade('ctsuOidClieTipoSubt', 'ctsuOidClieTipoSubt', 'maeClienClasi');
		
	}
	if(get('maeClienClasiFrm.clasOidClas').toString() == ''){
		set('maeClienClasiFrm.clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', []);
		mmgResetCombosOnCascade('clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', 'clasOidClas', 'maeClienClasi');
		
	}
	if(get('maeClienClasiFrm.perdOidPeri').toString() == ''){
		set('maeClienClasiFrm.perdOidPeri', []);
		mmgResetCombosOnCascade('perdOidPeri', 'perdOidPeri', 'maeClienClasi');
		
	}
	if(get('maeClienClasiFrm.tcclOidTipoClasi').toString() == ''){
		set('maeClienClasiFrm.tcclOidTipoClasi_sbtiOidSubtClie_ticlOidTipoClie', []);
		mmgResetCombosOnCascade('tcclOidTipoClasi_sbtiOidSubtClie_ticlOidTipoClie', 'tcclOidTipoClasi', 'maeClienClasi');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeClienClasiRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeClienClasiFrm.accion');
	var origenTmp = get('maeClienClasiFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeClienClasiBuildUpdateRecordString() != maeClienClasiTmpUpdateValues){
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
	document.all.maeClienClasiListLayer.style.display='none';
	document.all.maeClienClasiListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeClienClasiListLayer.style.display='';
	document.all.maeClienClasiListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeClienClasiCtsuOidClieTipoSubt = get('maeClienClasiFrm.ctsuOidClieTipoSubt')[0];
	jsMaeClienClasiClasOidClas = get('maeClienClasiFrm.clasOidClas')[0];
	jsMaeClienClasiPerdOidPeri = get('maeClienClasiFrm.perdOidPeri')[0];
	jsMaeClienClasiTcclOidTipoClasi = get('maeClienClasiFrm.tcclOidTipoClasi')[0];
	jsMaeClienClasiFecClas = get('maeClienClasiFrm.fecClas').toString();
	jsMaeClienClasiIndPpal = get('maeClienClasiFrm.indPpal').toString();
	
	
	var parametros = "";
	parametros += jsMaeClienClasiCtsuOidClieTipoSubt + "|";
	parametros += jsMaeClienClasiClasOidClas + "|";
	parametros += jsMaeClienClasiPerdOidPeri + "|";
	parametros += jsMaeClienClasiTcclOidTipoClasi + "|";
	parametros += jsMaeClienClasiFecClas + "|";
	parametros += jsMaeClienClasiIndPpal + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeClienClasiBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeClienClasiCtsuOidClieTipoSubt + "|";
	parametros += jsMaeClienClasiClasOidClas + "|";
	parametros += jsMaeClienClasiPerdOidPeri + "|";
	parametros += jsMaeClienClasiTcclOidTipoClasi + "|";
	parametros += jsMaeClienClasiFecClas + "|";
	parametros += jsMaeClienClasiIndPpal + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeClienClasiFrm.accion'), 
		get('maeClienClasiFrm.origen'));
	
	jsMaeClienClasiId = get('maeClienClasiFrm.id').toString();
	jsMaeClienClasiCtsuOidClieTipoSubt = get('maeClienClasiFrm.ctsuOidClieTipoSubt')[0];
	jsMaeClienClasiClasOidClas = get('maeClienClasiFrm.clasOidClas')[0];
	jsMaeClienClasiPerdOidPeri = get('maeClienClasiFrm.perdOidPeri')[0];
	jsMaeClienClasiTcclOidTipoClasi = get('maeClienClasiFrm.tcclOidTipoClasi')[0];
	jsMaeClienClasiFecClas = get('maeClienClasiFrm.fecClas').toString();
	jsMaeClienClasiIndPpal = get('maeClienClasiFrm.indPpal').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeClienClasiFrm.accion'), 
		get('maeClienClasiFrm.origen'));


	set('maeClienClasiFrm.id', jsMaeClienClasiId);
	set('maeClienClasiFrm.ctsuOidClieTipoSubt', [jsMaeClienClasiCtsuOidClieTipoSubt]);
	set('maeClienClasiFrm.clasOidClas', [jsMaeClienClasiClasOidClas]);
	set('maeClienClasiFrm.perdOidPeri', [jsMaeClienClasiPerdOidPeri]);
	set('maeClienClasiFrm.tcclOidTipoClasi', [jsMaeClienClasiTcclOidTipoClasi]);
	set('maeClienClasiFrm.fecClas', jsMaeClienClasiFecClas);
	set('maeClienClasiFrm.indPpal', jsMaeClienClasiIndPpal);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeClienClasiCtsuOidClieTipoSubt = '';
	jsMaeClienClasiClasOidClas = '';
	jsMaeClienClasiPerdOidPeri = '';
	jsMaeClienClasiTcclOidTipoClasi = '';
	jsMaeClienClasiFecClas = '';
	jsMaeClienClasiIndPpal = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeClienClasiFrm.errCodigo', errorCode);
	set('maeClienClasiFrm.errDescripcion', description);
	set('maeClienClasiFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	



/*
    INDRA/CAR/mmg
    $Id: maeencueaplicclien_old.js,v 1.1 2009/12/03 19:01:57 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeEncueAplicClienId = "";
var jsMaeEncueAplicClienClieOidClie = "";
var jsMaeEncueAplicClienEnseOidEncu = "";
var jsMaeEncueAplicClienReenOidResp = "";

//Variables de paginacion, 
var maeEncueAplicClienPageCount = 1;

//Varible de columna que representa el campo de choice
var maeEncueAplicClienChoiceColumn = 3;

//Flag de siguiente pagina;
var maeEncueAplicClienMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeEncueAplicClienTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 360;
var sizeFormView = 360;
var sizeFormUpdate = 150;

//Ultima busqueda realizada
var maeEncueAplicClienLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("maeEncueAplicClien","clieOidClie", false);','focalizaComboDependence("maeEncueAplicClien","clieOidClie", false);','','focalizaComboDependence("maeEncueAplicClien","clieOidClie", true);','focalizaComboDependence("maeEncueAplicClien","clieOidClie", true);',''],[3,'focalizaComboDependence("maeEncueAplicClien","enseOidEncu", false);','focalizaComboDependence("maeEncueAplicClien","enseOidEncu", false);','','focalizaComboDependence("maeEncueAplicClien","enseOidEncu", true);','focalizaComboDependence("maeEncueAplicClien","enseOidEncu", true);',''],[4,'focalizaComboDependence("maeEncueAplicClien","reenOidResp", false);','focalizaComboDependence("maeEncueAplicClien","reenOidResp", false);','focalizaComboDependence("maeEncueAplicClien","reenOidResp", false);','focalizaComboDependence("maeEncueAplicClien","reenOidResp", true);','focalizaComboDependence("maeEncueAplicClien","reenOidResp", true);','focalizaComboDependence("maeEncueAplicClien","reenOidResp", true);']]);

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
var enseOidEncuDependeceMap = new Vector();
enseOidEncuDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
enseOidEncuDependeceMap.agregar(['enseOidEncu_marcOidMarc', padresTmp, 'enseOidEncu', 'SegMarca']);
padresTmp =  new Vector();
padresTmp.cargar([])
enseOidEncuDependeceMap.agregar(['enseOidEncu_prenOidPreg', padresTmp, 'enseOidEncu', 'MaePreguEncue']);
padresTmp =  new Vector();
padresTmp.cargar(['enseOidEncu_marcOidMarc','enseOidEncu_prenOidPreg'])
enseOidEncuDependeceMap.agregar(['enseOidEncu', padresTmp, '', 'MaeEncueNse']);
var reenOidRespDependeceMap = new Vector();
reenOidRespDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
reenOidRespDependeceMap.agregar(['reenOidResp', padresTmp, '', 'MaeRespuEncue']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeEncueAplicClienLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeEncueAplicClienTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function maeEncueAplicClienInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeEncueAplicClienFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeEncueAplicClienFrm.accion')){
		case "query": maeEncueAplicClienQueryInitComponents(); break;
		case "view": maeEncueAplicClienViewInitComponents(); break;
		case "create": maeEncueAplicClienCreateInitComponents(); break;
		case "update": maeEncueAplicClienUpdateInitComponents(); break;
		case "remove": maeEncueAplicClienRemoveInitComponents(); break;
		case "lov": maeEncueAplicClienLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('maeEncueAplicClienFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeEncueAplicClien')) maeEncueAplicClienCmdRequery();
}

function maeEncueAplicClienQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
}

function maeEncueAplicClienViewInitComponents(){
	//En principiono se hace nada
}

function maeEncueAplicClienCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeEncueAplicClienFrm.clieOidClie','S', GestionarMensaje('MaeEncueAplicClien.clieOidClie.requiered.message'));
	
	setMV('maeEncueAplicClienFrm.enseOidEncu','S', GestionarMensaje('MaeEncueAplicClien.enseOidEncu.requiered.message'));
	
	setMV('maeEncueAplicClienFrm.reenOidResp','S', GestionarMensaje('MaeEncueAplicClien.reenOidResp.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function maeEncueAplicClienUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeEncueAplicClienFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		maeEncueAplicClienTmpUpdateValues = maeEncueAplicClienBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeEncueAplicClienFrm.reenOidResp','S', GestionarMensaje('MaeEncueAplicClien.reenOidResp.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeEncueAplicClienFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeEncueAplicClienRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeEncueAplicClienList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function maeEncueAplicClienLovInitComponents(){
	maeEncueAplicClienLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function maeEncueAplicClienSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeEncueAplicClienFrm.' + campo, id);
	set('maeEncueAplicClienFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeEncueAplicClienLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeEncueAplicClienLovReturnParameters.id = '';
	maeEncueAplicClienLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeEncueAplicClienLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEncueAplicClienList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeEncueAplicClienList.codSeleccionados();
	var descripcion = maeEncueAplicClienList.extraeDato(
		maeEncueAplicClienList.codSeleccionados()[0], maeEncueAplicClienChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeEncueAplicClienLovReturnParameters.id = codigo;
	maeEncueAplicClienLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeEncueAplicClienCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeEncueAplicClienFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeEncueAplicClienLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeEncueAplicClienFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeEncueAplicClienList", "MaeEncueAplicClienConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeEncueAplicClienPostQueryActions(datos);"]], "", "");	
}

function maeEncueAplicClienCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeEncueAplicClienFrm.lastQueryToSession'));
	var i =0;
	set('maeEncueAplicClienFrm.clieOidClie', [paramsRequery.ij(i++)]);
	
	set('maeEncueAplicClienFrm.enseOidEncu', [paramsRequery.ij(i++)]);
	
	set('maeEncueAplicClienFrm.reenOidResp', [paramsRequery.ij(i++)]);
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	maeEncueAplicClienPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeEncueAplicClienCmdQuery(maeEncueAplicClienPageCount);
}

function maeEncueAplicClienFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeEncueAplicClienPageCount = 1;
	maeEncueAplicClienCmdQuery(maeEncueAplicClienPageCount);
}

function maeEncueAplicClienPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeEncueAplicClienLastQuery){
		maeEncueAplicClienFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeEncueAplicClienPageCount--;
	maeEncueAplicClienCmdQuery(maeEncueAplicClienPageCount);
}

function maeEncueAplicClienNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeEncueAplicClienLastQuery){
		maeEncueAplicClienFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeEncueAplicClienPageCount++;
	maeEncueAplicClienCmdQuery(maeEncueAplicClienPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeEncueAplicClienPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeEncueAplicClienListLayer', 'O');
		visibilidad('maeEncueAplicClienListButtonsLayer', 'O');
		visibilidad('maeEncueAplicClienPreListLayer', 'O');
		if(get('maeEncueAplicClienFrm.accion') == "remove"){
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
		datosTmp.ij2("<A HREF=\'javascript:maeEncueAplicClienViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeEncueAplicClienChoiceColumn) + "</A>",
			i, maeEncueAplicClienChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeEncueAplicClienList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeEncueAplicClienTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeEncueAplicClienMorePagesFlag = true;
		maeEncueAplicClienList.eliminar(mmgPageSize, 1);
	}else{
		maeEncueAplicClienMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeEncueAplicClienFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeEncueAplicClienListLayer', 'V');
	visibilidad('maeEncueAplicClienListButtonsLayer', 'V');
	visibilidad('maeEncueAplicClienPreListLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeEncueAplicClienList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeEncueAplicClienList.display();
	
	//Actualizamos el estado de los botones 
	if(maeEncueAplicClienMorePagesFlag){
		set_estado_botonera('maeEncueAplicClienPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeEncueAplicClienPaginationButtonBar',
			3,"inactivo");
	}
	if(maeEncueAplicClienPageCount > 1){
		set_estado_botonera('maeEncueAplicClienPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeEncueAplicClienPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeEncueAplicClienPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeEncueAplicClienPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeEncueAplicClienUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEncueAplicClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeEncueAplicClienFrm.idSelection', maeEncueAplicClienList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeEncueAplicClienFrm', true);
	if(validacion){
		/*set('maeEncueAplicClienFrm.previousAction', 'update');
		set('maeEncueAplicClienFrm.ON', 'MaeEncueAplicClienLPStartUp');
		set('maeEncueAplicClienFrm.conectorAction', 'MaeEncueAplicClienLPStartUp');
		set('maeEncueAplicClienFrm.origen', 'pagina');
		envia('maeEncueAplicClienFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = maeEncueAplicClienList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeEncueAplicClienFrm.accion');
		parametros["accion"] = get('maeEncueAplicClienFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('MaeEncueAplicClienLPStartUp', get('maeEncueAplicClienFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) maeEncueAplicClienCmdRequery();
	}
}

function maeEncueAplicClienRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEncueAplicClienList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeEncueAplicClienList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeEncueAplicClienFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeEncueAplicClienList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeEncueAplicClienTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeEncueAplicClienFrm.timestamp', timestamps);
	envia('maeEncueAplicClienFrm');
}

function maeEncueAplicClienViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEncueAplicClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('maeEncueAplicClienFrm.previousAction', get('maeEncueAplicClienFrm.accion'));
	set('maeEncueAplicClienFrm.accion', 'view');
	set('maeEncueAplicClienFrm.origen', 'pagina');
	set('maeEncueAplicClienFrm.ON', 'MaeEncueAplicClienLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('maeEncueAplicClienFrm.idSelection', maeEncueAplicClienList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('maeEncueAplicClienFrm');
	maeEncueAplicClienViewDetail(maeEncueAplicClienList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeEncueAplicClienViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeEncueAplicClienFrm.accion');
	parametros["accion"] = get('maeEncueAplicClienFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('MaeEncueAplicClienLPStartUp', get('maeEncueAplicClienFrm.accion'), parametros, null, sizeFormView + 30);
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
	var validacion = ValidaForm('maeEncueAplicClienFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
		
	
	if(validacion)envia('maeEncueAplicClienFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeEncueAplicClienRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeEncueAplicClienFrm.accion');
	var origenTmp = get('maeEncueAplicClienFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeEncueAplicClienBuildUpdateRecordString() != maeEncueAplicClienTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('maeEncueAplicClienFrm.performRequery', 'true');
		set('maeEncueAplicClienFrm.accion', 
			get('maeEncueAplicClienFrm.previousAction'));
		set('maeEncueAplicClienFrm.origen', 'menu');
		set('maeEncueAplicClienFrm.ON', 'MaeEncueAplicClienLPStartUp');
		set('maeEncueAplicClienFrm.conectorAction', 'MaeEncueAplicClienLPStartUp');
		maeEncueAplicClienFrm.oculto='N';
		envia('maeEncueAplicClienFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.maeEncueAplicClienListLayer.style.display='none';
	document.all.maeEncueAplicClienListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeEncueAplicClienListLayer.style.display='';
	document.all.maeEncueAplicClienListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda

	jsMaeEncueAplicClienClieOidClie = get('maeEncueAplicClienFrm.clieOidClie')[0];





	jsMaeEncueAplicClienEnseOidEncu = get('maeEncueAplicClienFrm.enseOidEncu')[0];





	jsMaeEncueAplicClienReenOidResp = get('maeEncueAplicClienFrm.reenOidResp')[0];






	var parametros = "";
	parametros += jsMaeEncueAplicClienClieOidClie + "|";



	parametros += jsMaeEncueAplicClienEnseOidEncu + "|";



	parametros += jsMaeEncueAplicClienReenOidResp + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeEncueAplicClienBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeEncueAplicClienReenOidResp + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeEncueAplicClienFrm.accion'), 
		get('maeEncueAplicClienFrm.origen'));
	
	jsMaeEncueAplicClienId = get('maeEncueAplicClienFrm.id').toString();
	jsMaeEncueAplicClienClieOidClie = get('maeEncueAplicClienFrm.clieOidClie')[0];
	jsMaeEncueAplicClienEnseOidEncu = get('maeEncueAplicClienFrm.enseOidEncu')[0];
	jsMaeEncueAplicClienReenOidResp = get('maeEncueAplicClienFrm.reenOidResp')[0];

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeEncueAplicClienFrm.accion'), 
		get('maeEncueAplicClienFrm.origen'));


	set('maeEncueAplicClienFrm.id', jsMaeEncueAplicClienId);
	set('maeEncueAplicClienFrm.clieOidClie', [jsMaeEncueAplicClienClieOidClie]);
	set('maeEncueAplicClienFrm.enseOidEncu', [jsMaeEncueAplicClienEnseOidEncu]);
	set('maeEncueAplicClienFrm.reenOidResp', [jsMaeEncueAplicClienReenOidResp]);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeEncueAplicClienFrm.errCodigo', errorCode);
	set('maeEncueAplicClienFrm.errDescripcion', description);
	set('maeEncueAplicClienFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	

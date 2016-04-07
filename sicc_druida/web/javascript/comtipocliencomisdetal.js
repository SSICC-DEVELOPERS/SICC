

/*
    INDRA/CAR/mmg
    $Id: comtipocliencomisdetal.js,v 1.1 2009/12/03 19:01:42 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsComTipoClienComisDetalId = "";
var jsComTipoClienComisDetalTcccOidTipoClieComiCabe = "";
var jsComTipoClienComisDetalClasOidClas = "";
var jsComTipoClienComisDetalDescripcion = "";

//Variables de paginacion, 
var comTipoClienComisDetalPageCount = 1;

//Varible de columna que representa el campo de choice
var comTipoClienComisDetalChoiceColumn = 2;

//Flag de siguiente pagina;
var comTipoClienComisDetalMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var comTipoClienComisDetalTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 189;
var sizeFormView = 175;
var sizeFormUpdate = 175;

//Ultima busqueda realizada
var comTipoClienComisDetalLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("comTipoClienComisDetal","tcccOidTipoClieComiCabe", false);','focalizaComboDependence("comTipoClienComisDetal","tcccOidTipoClieComiCabe", false);','focalizaComboDependence("comTipoClienComisDetal","tcccOidTipoClieComiCabe", false);','focalizaComboDependence("comTipoClienComisDetal","tcccOidTipoClieComiCabe", true);','focalizaComboDependence("comTipoClienComisDetal","tcccOidTipoClieComiCabe", true);','focalizaComboDependence("comTipoClienComisDetal","tcccOidTipoClieComiCabe", true);'],[3,'focalizaComboDependence("comTipoClienComisDetal","clasOidClas", false);','focalizaComboDependence("comTipoClienComisDetal","clasOidClas", false);','focalizaComboDependence("comTipoClienComisDetal","clasOidClas", false);','focalizaComboDependence("comTipoClienComisDetal","clasOidClas", true);','focalizaComboDependence("comTipoClienComisDetal","clasOidClas", true);','focalizaComboDependence("comTipoClienComisDetal","clasOidClas", true);'],[4,'focaliza("comTipoClienComisDetalFrm.Descripcion");','focaliza("comTipoClienComisDetalFrm.Descripcion");','focaliza("comTipoClienComisDetalFrm.Descripcion");','focaliza("comTipoClienComisDetalFrm.Descripcion");','focaliza("comTipoClienComisDetalFrm.Descripcion");','focaliza("comTipoClienComisDetalFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("comTipoClienComisDetalFrm.Descripcion");','focaliza("comTipoClienComisDetalFrm.Descripcion");','focaliza("comTipoClienComisDetalFrm.Descripcion");','focaliza("comTipoClienComisDetalFrm.Descripcion");','focaliza("comTipoClienComisDetalFrm.Descripcion");','focaliza("comTipoClienComisDetalFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var tcccOidTipoClieComiCabeDependeceMap = new Vector();
tcccOidTipoClieComiCabeDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tcccOidTipoClieComiCabeDependeceMap.agregar(['tcccOidTipoClieComiCabe', padresTmp, '', 'ComTipoClienComisCabec']);
var clasOidClasDependeceMap = new Vector();
clasOidClasDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clasOidClasDependeceMap.agregar(['clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', padresTmp, 'clasOidClas_tcclOidTipoClas_sbtiOidSubtClie', 'MaeTipoClien']);
padresTmp =  new Vector();
padresTmp.cargar(['clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie'])
clasOidClasDependeceMap.agregar(['clasOidClas_tcclOidTipoClas_sbtiOidSubtClie', padresTmp, 'clasOidClas_tcclOidTipoClas', 'MaeSubtiClien']);
padresTmp =  new Vector();
padresTmp.cargar(['clasOidClas_tcclOidTipoClas_sbtiOidSubtClie'])
clasOidClasDependeceMap.agregar(['clasOidClas_tcclOidTipoClas', padresTmp, 'clasOidClas', 'MaeTipoClasiClien']);
padresTmp =  new Vector();
padresTmp.cargar(['clasOidClas_tcclOidTipoClas'])
clasOidClasDependeceMap.agregar(['clasOidClas', padresTmp, '', 'MaeClasi']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
comTipoClienComisDetalLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var comTipoClienComisDetalTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function comTipoClienComisDetalInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('comTipoClienComisDetalFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('comTipoClienComisDetalFrm.accion')){
		case "query": comTipoClienComisDetalQueryInitComponents(); break;
		case "view": comTipoClienComisDetalViewInitComponents(); break;
		case "create": comTipoClienComisDetalCreateInitComponents(); break;
		case "update": comTipoClienComisDetalUpdateInitComponents(); break;
		case "remove": comTipoClienComisDetalRemoveInitComponents(); break;
		case "lov": comTipoClienComisDetalLovInitComponents(); break;
	}
	//alert('accion :' + get('comTipoClienComisDetalFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('comTipoClienComisDetalFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('comTipoClienComisDetal')) comTipoClienComisDetalCmdRequery();
}

function comTipoClienComisDetalQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('comTipoClienComisDetalFrm', true);	
}

function comTipoClienComisDetalViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('comTipoClienComisDetalFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('comTipoClienComisDetalFrm', true);
}

function comTipoClienComisDetalCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('comTipoClienComisDetalFrm.tcccOidTipoClieComiCabe','S', GestionarMensaje('ComTipoClienComisDetal.tcccOidTipoClieComiCabe.requiered.message'));
	
	setMV('comTipoClienComisDetalFrm.clasOidClas','S', GestionarMensaje('ComTipoClienComisDetal.clasOidClas.requiered.message'));
	
	setMV('comTipoClienComisDetalFrm.Descripcion','S', GestionarMensaje('ComTipoClienComisDetal.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('comTipoClienComisDetalFrm', true);
}

function comTipoClienComisDetalUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('comTipoClienComisDetalFrm.origen') == "pagina"){
		loadLocalizationWidget('comTipoClienComisDetalFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		comTipoClienComisDetalTmpUpdateValues = comTipoClienComisDetalBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('comTipoClienComisDetalFrm.tcccOidTipoClieComiCabe','S', GestionarMensaje('ComTipoClienComisDetal.tcccOidTipoClieComiCabe.requiered.message'));
		setMV('comTipoClienComisDetalFrm.clasOidClas','S', GestionarMensaje('ComTipoClienComisDetal.clasOidClas.requiered.message'));
		setMV('comTipoClienComisDetalFrm.Descripcion','S', GestionarMensaje('ComTipoClienComisDetal.Descripcion.requiered.message'));
		
			focusFirstFieldModify('comTipoClienComisDetalFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('comTipoClienComisDetalFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('comTipoClienComisDetalFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function comTipoClienComisDetalRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	comTipoClienComisDetalList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('comTipoClienComisDetalFrm', true);
}

function comTipoClienComisDetalLovInitComponents(){
	comTipoClienComisDetalLovReturnParameters = window.dialogArguments;
	
	focusFirstField('comTipoClienComisDetalFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function comTipoClienComisDetalSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('comTipoClienComisDetalFrm.' + campo, id);
	set('comTipoClienComisDetalFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function comTipoClienComisDetalLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	comTipoClienComisDetalLovReturnParameters.id = '';
	comTipoClienComisDetalLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function comTipoClienComisDetalLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(comTipoClienComisDetalList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = comTipoClienComisDetalList.codSeleccionados();
	var descripcion = comTipoClienComisDetalList.extraeDato(
		comTipoClienComisDetalList.codSeleccionados()[0], comTipoClienComisDetalChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	comTipoClienComisDetalLovReturnParameters.id = codigo;
	comTipoClienComisDetalLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function comTipoClienComisDetalCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('comTipoClienComisDetalFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('comTipoClienComisDetalFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "comTipoClienComisDetalList", "ComTipoClienComisDetalConectorTransactionQuery", 
		"result_ROWSET", parametros, "comTipoClienComisDetalPostQueryActions(datos);"]], "", "");	
}

function comTipoClienComisDetalCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('comTipoClienComisDetalFrm.lastQueryToSession'));
	var i =0;
	set('comTipoClienComisDetalFrm.tcccOidTipoClieComiCabe', [paramsRequery.ij(i++)]);
	
	set('comTipoClienComisDetalFrm.clasOidClas', [paramsRequery.ij(i++)]);
	
	set('comTipoClienComisDetalFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	comTipoClienComisDetalPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	comTipoClienComisDetalCmdQuery(comTipoClienComisDetalPageCount);
}

function comTipoClienComisDetalFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	comTipoClienComisDetalPageCount = 1;
	comTipoClienComisDetalCmdQuery(comTipoClienComisDetalPageCount);
}

function comTipoClienComisDetalPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != comTipoClienComisDetalLastQuery){
		comTipoClienComisDetalFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	comTipoClienComisDetalPageCount--;
	comTipoClienComisDetalCmdQuery(comTipoClienComisDetalPageCount);
}

function comTipoClienComisDetalNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != comTipoClienComisDetalLastQuery){
		comTipoClienComisDetalFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	comTipoClienComisDetalPageCount++;
	comTipoClienComisDetalCmdQuery(comTipoClienComisDetalPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function comTipoClienComisDetalPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('comTipoClienComisDetalListLayer', 'O');
		visibilidad('comTipoClienComisDetalListButtonsLayer', 'O');
		if(get('comTipoClienComisDetalFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	comTipoClienComisDetalLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:comTipoClienComisDetalViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, comTipoClienComisDetalChoiceColumn) + "</A>",
			i, comTipoClienComisDetalChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	comTipoClienComisDetalList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	comTipoClienComisDetalTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		comTipoClienComisDetalMorePagesFlag = true;
		comTipoClienComisDetalList.eliminar(mmgPageSize, 1);
	}else{
		comTipoClienComisDetalMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('comTipoClienComisDetalFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('comTipoClienComisDetalListLayer', 'V');
	visibilidad('comTipoClienComisDetalListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('comTipoClienComisDetalList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	comTipoClienComisDetalList.display();
	
	//Actualizamos el estado de los botones 
	if(comTipoClienComisDetalMorePagesFlag){
		set_estado_botonera('comTipoClienComisDetalPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('comTipoClienComisDetalPaginationButtonBar',
			3,"inactivo");
	}
	if(comTipoClienComisDetalPageCount > 1){
		set_estado_botonera('comTipoClienComisDetalPaginationButtonBar',
			2,"activo");
		set_estado_botonera('comTipoClienComisDetalPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('comTipoClienComisDetalPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('comTipoClienComisDetalPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function comTipoClienComisDetalUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(comTipoClienComisDetalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('comTipoClienComisDetalFrm.idSelection', comTipoClienComisDetalList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('comTipoClienComisDetalFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = comTipoClienComisDetalList.codSeleccionados()[0];
		parametros["previousAction"] = get('comTipoClienComisDetalFrm.accion');
		parametros["accion"] = get('comTipoClienComisDetalFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('ComTipoClienComisDetalLPStartUp', get('comTipoClienComisDetalFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) comTipoClienComisDetalCmdRequery();
	}
}

function comTipoClienComisDetalRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(comTipoClienComisDetalList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = comTipoClienComisDetalList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('comTipoClienComisDetalFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(comTipoClienComisDetalList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += comTipoClienComisDetalTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('comTipoClienComisDetalFrm.timestamp', timestamps);


	comTipoClienComisDetalFrm.oculto='S';
	envia('comTipoClienComisDetalFrm');
	comTipoClienComisDetalFrm.oculto='N';
}

function comTipoClienComisDetalViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(comTipoClienComisDetalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	comTipoClienComisDetalViewDetail(comTipoClienComisDetalList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function comTipoClienComisDetalViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('comTipoClienComisDetalFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('ComTipoClienComisDetalLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('comTipoClienComisDetalFrm', 
		'Descripcion', 1,
		get('comTipoClienComisDetalFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('comTipoClienComisDetalFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('comTipoClienComisDetalFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('ComTipoClienComisDetal.Descripcion.requiered.message'));
		focaliza('comTipoClienComisDetalFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		comTipoClienComisDetalFrm.oculto='S';
		envia('comTipoClienComisDetalFrm');
		comTipoClienComisDetalFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('comTipoClienComisDetalFrm.tcccOidTipoClieComiCabe').toString() == ''){
		set('comTipoClienComisDetalFrm.tcccOidTipoClieComiCabe', []);
		mmgResetCombosOnCascade('tcccOidTipoClieComiCabe', 'tcccOidTipoClieComiCabe', 'comTipoClienComisDetal');
		
	}
	if(get('comTipoClienComisDetalFrm.clasOidClas').toString() == ''){
		set('comTipoClienComisDetalFrm.clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', []);
		mmgResetCombosOnCascade('clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', 'clasOidClas', 'comTipoClienComisDetal');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	comTipoClienComisDetalRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('comTipoClienComisDetalFrm.accion');
	var origenTmp = get('comTipoClienComisDetalFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(comTipoClienComisDetalBuildUpdateRecordString() != comTipoClienComisDetalTmpUpdateValues){
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
	document.all.comTipoClienComisDetalListLayer.style.display='none';
	document.all.comTipoClienComisDetalListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.comTipoClienComisDetalListLayer.style.display='';
	document.all.comTipoClienComisDetalListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsComTipoClienComisDetalTcccOidTipoClieComiCabe = get('comTipoClienComisDetalFrm.tcccOidTipoClieComiCabe')[0];
	jsComTipoClienComisDetalClasOidClas = get('comTipoClienComisDetalFrm.clasOidClas')[0];
	jsComTipoClienComisDetalDescripcion = get('comTipoClienComisDetalFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsComTipoClienComisDetalTcccOidTipoClieComiCabe + "|";
	parametros += jsComTipoClienComisDetalClasOidClas + "|";
	parametros += jsComTipoClienComisDetalDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function comTipoClienComisDetalBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsComTipoClienComisDetalTcccOidTipoClieComiCabe + "|";
	parametros += jsComTipoClienComisDetalClasOidClas + "|";
	parametros += jsComTipoClienComisDetalDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('comTipoClienComisDetalFrm.accion'), 
		get('comTipoClienComisDetalFrm.origen'));
	
	jsComTipoClienComisDetalId = get('comTipoClienComisDetalFrm.id').toString();
	jsComTipoClienComisDetalTcccOidTipoClieComiCabe = get('comTipoClienComisDetalFrm.tcccOidTipoClieComiCabe')[0];
	jsComTipoClienComisDetalClasOidClas = get('comTipoClienComisDetalFrm.clasOidClas')[0];
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsComTipoClienComisDetalDescripcion = buildLocalizedString('comTipoClienComisDetalFrm', 1);
	}else{
		jsComTipoClienComisDetalDescripcion = get('comTipoClienComisDetalFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('comTipoClienComisDetalFrm.accion'), 
		get('comTipoClienComisDetalFrm.origen'));


	set('comTipoClienComisDetalFrm.id', jsComTipoClienComisDetalId);
	set('comTipoClienComisDetalFrm.tcccOidTipoClieComiCabe', [jsComTipoClienComisDetalTcccOidTipoClieComiCabe]);
	set('comTipoClienComisDetalFrm.clasOidClas', [jsComTipoClienComisDetalClasOidClas]);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('comTipoClienComisDetalFrm', 1,  jsComTipoClienComisDetalDescripcion)
		loadLocalizationWidget('comTipoClienComisDetalFrm', 'Descripcion', 1);
	}else{
		set('comTipoClienComisDetalFrm.Descripcion', jsComTipoClienComisDetalDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsComTipoClienComisDetalTcccOidTipoClieComiCabe = '';
	jsComTipoClienComisDetalClasOidClas = '';
	jsComTipoClienComisDetalDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('comTipoClienComisDetalFrm.errCodigo', errorCode);
	set('comTipoClienComisDetalFrm.errDescripcion', description);
	set('comTipoClienComisDetalFrm.errSeverity', severity);
	fMostrarMensajeError();
}

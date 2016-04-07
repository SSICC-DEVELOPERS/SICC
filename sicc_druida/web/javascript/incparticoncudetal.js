

/*
    INDRA/CAR/mmg
    $Id: incparticoncudetal.js,v 1.1 2009/12/03 19:01:55 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsIncPartiConcuDetalId = "";
var jsIncPartiConcuDetalPaciOidPartConcCabe = "";
var jsIncPartiConcuDetalTiclOidTipoClie = "";
var jsIncPartiConcuDetalSbtiOidSubtClie = "";
var jsIncPartiConcuDetalTcclOidTipoClas = "";
var jsIncPartiConcuDetalClasOidClas = "";

//Variables de paginacion, 
var incPartiConcuDetalPageCount = 1;

//Varible de columna que representa el campo de choice
var incPartiConcuDetalChoiceColumn = 5;

//Flag de siguiente pagina;
var incPartiConcuDetalMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var incPartiConcuDetalTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 273;
var sizeFormView = 255;
var sizeFormUpdate = 255;

//Ultima busqueda realizada
var incPartiConcuDetalLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("incPartiConcuDetal","paciOidPartConcCabe", false);','focalizaComboDependence("incPartiConcuDetal","paciOidPartConcCabe", false);','focalizaComboDependence("incPartiConcuDetal","paciOidPartConcCabe", false);','focalizaComboDependence("incPartiConcuDetal","paciOidPartConcCabe", true);','focalizaComboDependence("incPartiConcuDetal","paciOidPartConcCabe", true);','focalizaComboDependence("incPartiConcuDetal","paciOidPartConcCabe", true);'],[3,'focalizaComboDependence("incPartiConcuDetal","ticlOidTipoClie", false);','focalizaComboDependence("incPartiConcuDetal","ticlOidTipoClie", false);','focalizaComboDependence("incPartiConcuDetal","ticlOidTipoClie", false);','focalizaComboDependence("incPartiConcuDetal","ticlOidTipoClie", true);','focalizaComboDependence("incPartiConcuDetal","ticlOidTipoClie", true);','focalizaComboDependence("incPartiConcuDetal","ticlOidTipoClie", true);'],[4,'focalizaComboDependence("incPartiConcuDetal","sbtiOidSubtClie", false);','focalizaComboDependence("incPartiConcuDetal","sbtiOidSubtClie", false);','focalizaComboDependence("incPartiConcuDetal","sbtiOidSubtClie", false);','focalizaComboDependence("incPartiConcuDetal","sbtiOidSubtClie", true);','focalizaComboDependence("incPartiConcuDetal","sbtiOidSubtClie", true);','focalizaComboDependence("incPartiConcuDetal","sbtiOidSubtClie", true);'],[5,'focalizaComboDependence("incPartiConcuDetal","tcclOidTipoClas", false);','focalizaComboDependence("incPartiConcuDetal","tcclOidTipoClas", false);','focalizaComboDependence("incPartiConcuDetal","tcclOidTipoClas", false);','focalizaComboDependence("incPartiConcuDetal","tcclOidTipoClas", true);','focalizaComboDependence("incPartiConcuDetal","tcclOidTipoClas", true);','focalizaComboDependence("incPartiConcuDetal","tcclOidTipoClas", true);'],[6,'focalizaComboDependence("incPartiConcuDetal","clasOidClas", false);','focalizaComboDependence("incPartiConcuDetal","clasOidClas", false);','focalizaComboDependence("incPartiConcuDetal","clasOidClas", false);','focalizaComboDependence("incPartiConcuDetal","clasOidClas", true);','focalizaComboDependence("incPartiConcuDetal","clasOidClas", true);','focalizaComboDependence("incPartiConcuDetal","clasOidClas", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar(]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paciOidPartConcCabeDependeceMap = new Vector();
paciOidPartConcCabeDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paciOidPartConcCabeDependeceMap.agregar(['paciOidPartConcCabe_diriOidDiri', padresTmp, 'paciOidPartConcCabe', 'IncDirig']);
padresTmp =  new Vector();
padresTmp.cargar(['paciOidPartConcCabe_diriOidDiri'])
paciOidPartConcCabeDependeceMap.agregar(['paciOidPartConcCabe', padresTmp, '', 'IncPartiConcuCabec']);
var ticlOidTipoClieDependeceMap = new Vector();
ticlOidTipoClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ticlOidTipoClieDependeceMap.agregar(['ticlOidTipoClie', padresTmp, '', 'MaeTipoClien']);
var sbtiOidSubtClieDependeceMap = new Vector();
sbtiOidSubtClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sbtiOidSubtClieDependeceMap.agregar(['sbtiOidSubtClie_ticlOidTipoClie', padresTmp, 'sbtiOidSubtClie', 'MaeTipoClien']);
padresTmp =  new Vector();
padresTmp.cargar(['sbtiOidSubtClie_ticlOidTipoClie'])
sbtiOidSubtClieDependeceMap.agregar(['sbtiOidSubtClie', padresTmp, '', 'MaeSubtiClien']);
var tcclOidTipoClasDependeceMap = new Vector();
tcclOidTipoClasDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tcclOidTipoClasDependeceMap.agregar(['tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', padresTmp, 'tcclOidTipoClas_sbtiOidSubtClie', 'MaeTipoClien']);
padresTmp =  new Vector();
padresTmp.cargar(['tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie'])
tcclOidTipoClasDependeceMap.agregar(['tcclOidTipoClas_sbtiOidSubtClie', padresTmp, 'tcclOidTipoClas', 'MaeSubtiClien']);
padresTmp =  new Vector();
padresTmp.cargar(['tcclOidTipoClas_sbtiOidSubtClie'])
tcclOidTipoClasDependeceMap.agregar(['tcclOidTipoClas', padresTmp, '', 'MaeTipoClasiClien']);
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
incPartiConcuDetalLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var incPartiConcuDetalTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function incPartiConcuDetalInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('incPartiConcuDetalFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('incPartiConcuDetalFrm.accion')){
		case "query": incPartiConcuDetalQueryInitComponents(); break;
		case "view": incPartiConcuDetalViewInitComponents(); break;
		case "create": incPartiConcuDetalCreateInitComponents(); break;
		case "update": incPartiConcuDetalUpdateInitComponents(); break;
		case "remove": incPartiConcuDetalRemoveInitComponents(); break;
		case "lov": incPartiConcuDetalLovInitComponents(); break;
	}
	//alert('accion :' + get('incPartiConcuDetalFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('incPartiConcuDetalFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('incPartiConcuDetal')) incPartiConcuDetalCmdRequery();
}

function incPartiConcuDetalQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	focusFirstField('incPartiConcuDetalFrm', true);	
}

function incPartiConcuDetalViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('incPartiConcuDetalFrm', true);
}

function incPartiConcuDetalCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('incPartiConcuDetalFrm.paciOidPartConcCabe','S', GestionarMensaje('IncPartiConcuDetal.paciOidPartConcCabe.requiered.message'));
	
	setMV('incPartiConcuDetalFrm.ticlOidTipoClie','S', GestionarMensaje('IncPartiConcuDetal.ticlOidTipoClie.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('incPartiConcuDetalFrm', true);
}

function incPartiConcuDetalUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('incPartiConcuDetalFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		incPartiConcuDetalTmpUpdateValues = incPartiConcuDetalBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('incPartiConcuDetalFrm.paciOidPartConcCabe','S', GestionarMensaje('IncPartiConcuDetal.paciOidPartConcCabe.requiered.message'));
		setMV('incPartiConcuDetalFrm.ticlOidTipoClie','S', GestionarMensaje('IncPartiConcuDetal.ticlOidTipoClie.requiered.message'));
		
			focusFirstFieldModify('incPartiConcuDetalFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		focusFirstField('incPartiConcuDetalFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('incPartiConcuDetalFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function incPartiConcuDetalRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	incPartiConcuDetalList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('incPartiConcuDetalFrm', true);
}

function incPartiConcuDetalLovInitComponents(){
	incPartiConcuDetalLovReturnParameters = window.dialogArguments;
	
	focusFirstField('incPartiConcuDetalFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad








//Función que permite cargar los datos de un elemento de lov seleccionado
function incPartiConcuDetalSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('incPartiConcuDetalFrm.' + campo, id);
	set('incPartiConcuDetalFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function incPartiConcuDetalLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	incPartiConcuDetalLovReturnParameters.id = '';
	incPartiConcuDetalLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function incPartiConcuDetalLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(incPartiConcuDetalList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = incPartiConcuDetalList.codSeleccionados();
	var descripcion = incPartiConcuDetalList.extraeDato(
		incPartiConcuDetalList.codSeleccionados()[0], incPartiConcuDetalChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	incPartiConcuDetalLovReturnParameters.id = codigo;
	incPartiConcuDetalLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function incPartiConcuDetalCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('incPartiConcuDetalFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('incPartiConcuDetalFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "incPartiConcuDetalList", "IncPartiConcuDetalConectorTransactionQuery", 
		"result_ROWSET", parametros, "incPartiConcuDetalPostQueryActions(datos);"]], "", "");	
}

function incPartiConcuDetalCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('incPartiConcuDetalFrm.lastQueryToSession'));
	var i =0;
	set('incPartiConcuDetalFrm.paciOidPartConcCabe', [paramsRequery.ij(i++)]);
	
	set('incPartiConcuDetalFrm.ticlOidTipoClie', [paramsRequery.ij(i++)]);
	
	set('incPartiConcuDetalFrm.sbtiOidSubtClie', [paramsRequery.ij(i++)]);
	
	set('incPartiConcuDetalFrm.tcclOidTipoClas', [paramsRequery.ij(i++)]);
	
	set('incPartiConcuDetalFrm.clasOidClas', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	incPartiConcuDetalPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	incPartiConcuDetalCmdQuery(incPartiConcuDetalPageCount);
}

function incPartiConcuDetalFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	incPartiConcuDetalPageCount = 1;
	incPartiConcuDetalCmdQuery(incPartiConcuDetalPageCount);
}

function incPartiConcuDetalPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != incPartiConcuDetalLastQuery){
		incPartiConcuDetalFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	incPartiConcuDetalPageCount--;
	incPartiConcuDetalCmdQuery(incPartiConcuDetalPageCount);
}

function incPartiConcuDetalNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != incPartiConcuDetalLastQuery){
		incPartiConcuDetalFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	incPartiConcuDetalPageCount++;
	incPartiConcuDetalCmdQuery(incPartiConcuDetalPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function incPartiConcuDetalPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('incPartiConcuDetalListLayer', 'O');
		visibilidad('incPartiConcuDetalListButtonsLayer', 'O');
		if(get('incPartiConcuDetalFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	incPartiConcuDetalLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:incPartiConcuDetalViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, incPartiConcuDetalChoiceColumn) + "</A>",
			i, incPartiConcuDetalChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	incPartiConcuDetalList.setDatos(datosTmp.filtrar([0,1,2,3,4,5],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	incPartiConcuDetalTimeStamps = datosTmp.filtrar([6],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		incPartiConcuDetalMorePagesFlag = true;
		incPartiConcuDetalList.eliminar(mmgPageSize, 1);
	}else{
		incPartiConcuDetalMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('incPartiConcuDetalFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('incPartiConcuDetalListLayer', 'V');
	visibilidad('incPartiConcuDetalListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('incPartiConcuDetalList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	incPartiConcuDetalList.display();
	
	//Actualizamos el estado de los botones 
	if(incPartiConcuDetalMorePagesFlag){
		set_estado_botonera('incPartiConcuDetalPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('incPartiConcuDetalPaginationButtonBar',
			3,"inactivo");
	}
	if(incPartiConcuDetalPageCount > 1){
		set_estado_botonera('incPartiConcuDetalPaginationButtonBar',
			2,"activo");
		set_estado_botonera('incPartiConcuDetalPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('incPartiConcuDetalPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('incPartiConcuDetalPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function incPartiConcuDetalUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(incPartiConcuDetalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('incPartiConcuDetalFrm.idSelection', incPartiConcuDetalList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('incPartiConcuDetalFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = incPartiConcuDetalList.codSeleccionados()[0];
		parametros["previousAction"] = get('incPartiConcuDetalFrm.accion');
		parametros["accion"] = get('incPartiConcuDetalFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('IncPartiConcuDetalLPStartUp', get('incPartiConcuDetalFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) incPartiConcuDetalCmdRequery();
	}
}

function incPartiConcuDetalRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(incPartiConcuDetalList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = incPartiConcuDetalList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('incPartiConcuDetalFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(incPartiConcuDetalList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += incPartiConcuDetalTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('incPartiConcuDetalFrm.timestamp', timestamps);


	incPartiConcuDetalFrm.oculto='S';
	envia('incPartiConcuDetalFrm');
	incPartiConcuDetalFrm.oculto='N';
}

function incPartiConcuDetalViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(incPartiConcuDetalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	incPartiConcuDetalViewDetail(incPartiConcuDetalList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function incPartiConcuDetalViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('incPartiConcuDetalFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('IncPartiConcuDetalLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('incPartiConcuDetalFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
		
	
	if(validacion){
		incPartiConcuDetalFrm.oculto='S';
		envia('incPartiConcuDetalFrm');
		incPartiConcuDetalFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('incPartiConcuDetalFrm.paciOidPartConcCabe').toString() == ''){
		set('incPartiConcuDetalFrm.paciOidPartConcCabe_diriOidDiri', []);
		mmgResetCombosOnCascade('paciOidPartConcCabe_diriOidDiri', 'paciOidPartConcCabe', 'incPartiConcuDetal');
		
	}
	if(get('incPartiConcuDetalFrm.ticlOidTipoClie').toString() == ''){
		set('incPartiConcuDetalFrm.ticlOidTipoClie', []);
		mmgResetCombosOnCascade('ticlOidTipoClie', 'ticlOidTipoClie', 'incPartiConcuDetal');
		
	}
	if(get('incPartiConcuDetalFrm.sbtiOidSubtClie').toString() == ''){
		set('incPartiConcuDetalFrm.sbtiOidSubtClie_ticlOidTipoClie', []);
		mmgResetCombosOnCascade('sbtiOidSubtClie_ticlOidTipoClie', 'sbtiOidSubtClie', 'incPartiConcuDetal');
		
	}
	if(get('incPartiConcuDetalFrm.tcclOidTipoClas').toString() == ''){
		set('incPartiConcuDetalFrm.tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', []);
		mmgResetCombosOnCascade('tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', 'tcclOidTipoClas', 'incPartiConcuDetal');
		
	}
	if(get('incPartiConcuDetalFrm.clasOidClas').toString() == ''){
		set('incPartiConcuDetalFrm.clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', []);
		mmgResetCombosOnCascade('clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', 'clasOidClas', 'incPartiConcuDetal');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	incPartiConcuDetalRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('incPartiConcuDetalFrm.accion');
	var origenTmp = get('incPartiConcuDetalFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(incPartiConcuDetalBuildUpdateRecordString() != incPartiConcuDetalTmpUpdateValues){
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
	document.all.incPartiConcuDetalListLayer.style.display='none';
	document.all.incPartiConcuDetalListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.incPartiConcuDetalListLayer.style.display='';
	document.all.incPartiConcuDetalListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsIncPartiConcuDetalPaciOidPartConcCabe = get('incPartiConcuDetalFrm.paciOidPartConcCabe')[0];
	jsIncPartiConcuDetalTiclOidTipoClie = get('incPartiConcuDetalFrm.ticlOidTipoClie')[0];
	jsIncPartiConcuDetalSbtiOidSubtClie = get('incPartiConcuDetalFrm.sbtiOidSubtClie')[0];
	jsIncPartiConcuDetalTcclOidTipoClas = get('incPartiConcuDetalFrm.tcclOidTipoClas')[0];
	jsIncPartiConcuDetalClasOidClas = get('incPartiConcuDetalFrm.clasOidClas')[0];
	
	
	var parametros = "";
	parametros += jsIncPartiConcuDetalPaciOidPartConcCabe + "|";
	parametros += jsIncPartiConcuDetalTiclOidTipoClie + "|";
	parametros += jsIncPartiConcuDetalSbtiOidSubtClie + "|";
	parametros += jsIncPartiConcuDetalTcclOidTipoClas + "|";
	parametros += jsIncPartiConcuDetalClasOidClas + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function incPartiConcuDetalBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsIncPartiConcuDetalPaciOidPartConcCabe + "|";
	parametros += jsIncPartiConcuDetalTiclOidTipoClie + "|";
	parametros += jsIncPartiConcuDetalSbtiOidSubtClie + "|";
	parametros += jsIncPartiConcuDetalTcclOidTipoClas + "|";
	parametros += jsIncPartiConcuDetalClasOidClas + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('incPartiConcuDetalFrm.accion'), 
		get('incPartiConcuDetalFrm.origen'));
	
	jsIncPartiConcuDetalId = get('incPartiConcuDetalFrm.id').toString();
	jsIncPartiConcuDetalPaciOidPartConcCabe = get('incPartiConcuDetalFrm.paciOidPartConcCabe')[0];
	jsIncPartiConcuDetalTiclOidTipoClie = get('incPartiConcuDetalFrm.ticlOidTipoClie')[0];
	jsIncPartiConcuDetalSbtiOidSubtClie = get('incPartiConcuDetalFrm.sbtiOidSubtClie')[0];
	jsIncPartiConcuDetalTcclOidTipoClas = get('incPartiConcuDetalFrm.tcclOidTipoClas')[0];
	jsIncPartiConcuDetalClasOidClas = get('incPartiConcuDetalFrm.clasOidClas')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('incPartiConcuDetalFrm.accion'), 
		get('incPartiConcuDetalFrm.origen'));


	set('incPartiConcuDetalFrm.id', jsIncPartiConcuDetalId);
	set('incPartiConcuDetalFrm.paciOidPartConcCabe', [jsIncPartiConcuDetalPaciOidPartConcCabe]);
	set('incPartiConcuDetalFrm.ticlOidTipoClie', [jsIncPartiConcuDetalTiclOidTipoClie]);
	set('incPartiConcuDetalFrm.sbtiOidSubtClie', [jsIncPartiConcuDetalSbtiOidSubtClie]);
	set('incPartiConcuDetalFrm.tcclOidTipoClas', [jsIncPartiConcuDetalTcclOidTipoClas]);
	set('incPartiConcuDetalFrm.clasOidClas', [jsIncPartiConcuDetalClasOidClas]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsIncPartiConcuDetalPaciOidPartConcCabe = '';
	jsIncPartiConcuDetalTiclOidTipoClie = '';
	jsIncPartiConcuDetalSbtiOidSubtClie = '';
	jsIncPartiConcuDetalTcclOidTipoClas = '';
	jsIncPartiConcuDetalClasOidClas = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('incPartiConcuDetalFrm.errCodigo', errorCode);
	set('incPartiConcuDetalFrm.errDescripcion', description);
	set('incPartiConcuDetalFrm.errSeverity', severity);
	fMostrarMensajeError();
}

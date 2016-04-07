

/*
    INDRA/CAR/mmg
    $Id: zonestadzona.js,v 1.1 2009/12/03 19:02:10 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonEstadZonaId = "";
var jsZonEstadZonaPaisOidPais = "";
var jsZonEstadZonaCodEstaZona = "";
var jsZonEstadZonaMarcOidMarc = "";
var jsZonEstadZonaDescripcion = "";
var jsZonEstadZonaIndInic = "";
var jsZonEstadZonaImpoVentMini = "";
var jsZonEstadZonaNumConsMin = "";
var jsZonEstadZonaNumPediZona = "";
var jsZonEstadZonaValoTiemMini = "";

//Variables de paginacion, 
var zonEstadZonaPageCount = 1;

//Varible de columna que representa el campo de choice
var zonEstadZonaChoiceColumn = 8;

//Flag de siguiente pagina;
var zonEstadZonaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonEstadZonaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 125;
var sizeFormUpdate = 125;

//Ultima busqueda realizada
var zonEstadZonaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("zonEstadZona","paisOidPais", false);','focalizaComboDependence("zonEstadZona","paisOidPais", false);','','focalizaComboDependence("zonEstadZona","paisOidPais", true);','focalizaComboDependence("zonEstadZona","paisOidPais", true);',''],[3,'focaliza("zonEstadZonaFrm.codEstaZona");','focaliza("zonEstadZonaFrm.codEstaZona");','focaliza("zonEstadZonaFrm.codEstaZona");','focaliza("zonEstadZonaFrm.codEstaZona");','focaliza("zonEstadZonaFrm.codEstaZona");','focaliza("zonEstadZonaFrm.codEstaZona");'],[4,'focalizaComboDependence("zonEstadZona","marcOidMarc", false);','focalizaComboDependence("zonEstadZona","marcOidMarc", false);','focalizaComboDependence("zonEstadZona","marcOidMarc", false);','focalizaComboDependence("zonEstadZona","marcOidMarc", true);','focalizaComboDependence("zonEstadZona","marcOidMarc", true);','focalizaComboDependence("zonEstadZona","marcOidMarc", true);'],[5,'focaliza("zonEstadZonaFrm.Descripcion");','focaliza("zonEstadZonaFrm.Descripcion");','focaliza("zonEstadZonaFrm.Descripcion");','focaliza("zonEstadZonaFrm.Descripcion");','focaliza("zonEstadZonaFrm.Descripcion");','focaliza("zonEstadZonaFrm.Descripcion");'],[6,'focaliza("zonEstadZonaFrm.indInic");','focaliza("zonEstadZonaFrm.indInic");','focaliza("zonEstadZonaFrm.indInic");','focaliza("zonEstadZonaFrm.indInic");','focaliza("zonEstadZonaFrm.indInic");','focaliza("zonEstadZonaFrm.indInic");'],[7,'focaliza("zonEstadZonaFrm.impoVentMini");','focaliza("zonEstadZonaFrm.impoVentMini");','focaliza("zonEstadZonaFrm.impoVentMini");','focaliza("zonEstadZonaFrm.impoVentMini");','focaliza("zonEstadZonaFrm.impoVentMini");','focaliza("zonEstadZonaFrm.impoVentMini");'],[8,'focaliza("zonEstadZonaFrm.numConsMin");','focaliza("zonEstadZonaFrm.numConsMin");','focaliza("zonEstadZonaFrm.numConsMin");','focaliza("zonEstadZonaFrm.numConsMin");','focaliza("zonEstadZonaFrm.numConsMin");','focaliza("zonEstadZonaFrm.numConsMin");'],[9,'focaliza("zonEstadZonaFrm.numPediZona");','focaliza("zonEstadZonaFrm.numPediZona");','focaliza("zonEstadZonaFrm.numPediZona");','focaliza("zonEstadZonaFrm.numPediZona");','focaliza("zonEstadZonaFrm.numPediZona");','focaliza("zonEstadZonaFrm.numPediZona");'],[10,'focaliza("zonEstadZonaFrm.valoTiemMini");','focaliza("zonEstadZonaFrm.valoTiemMini");','focaliza("zonEstadZonaFrm.valoTiemMini");','focaliza("zonEstadZonaFrm.valoTiemMini");','focaliza("zonEstadZonaFrm.valoTiemMini");','focaliza("zonEstadZonaFrm.valoTiemMini");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focalizaComboDependence("zonEstadZona","paisOidPais", false);','focalizaComboDependence("zonEstadZona","paisOidPais", false);','','focalizaComboDependence("zonEstadZona","paisOidPais", true);','focalizaComboDependence("zonEstadZona","paisOidPais", true);',''],[5,'focaliza("zonEstadZonaFrm.Descripcion");','focaliza("zonEstadZonaFrm.Descripcion");','focaliza("zonEstadZonaFrm.Descripcion");','focaliza("zonEstadZonaFrm.Descripcion");','focaliza("zonEstadZonaFrm.Descripcion");','focaliza("zonEstadZonaFrm.Descripcion");'],[6,'focaliza("zonEstadZonaFrm.indInic");','focaliza("zonEstadZonaFrm.indInic");','focaliza("zonEstadZonaFrm.indInic");','focaliza("zonEstadZonaFrm.indInic");','focaliza("zonEstadZonaFrm.indInic");','focaliza("zonEstadZonaFrm.indInic");'],[7,'focaliza("zonEstadZonaFrm.impoVentMini");','focaliza("zonEstadZonaFrm.impoVentMini");','focaliza("zonEstadZonaFrm.impoVentMini");','focaliza("zonEstadZonaFrm.impoVentMini");','focaliza("zonEstadZonaFrm.impoVentMini");','focaliza("zonEstadZonaFrm.impoVentMini");'],[8,'focaliza("zonEstadZonaFrm.numConsMin");','focaliza("zonEstadZonaFrm.numConsMin");','focaliza("zonEstadZonaFrm.numConsMin");','focaliza("zonEstadZonaFrm.numConsMin");','focaliza("zonEstadZonaFrm.numConsMin");','focaliza("zonEstadZonaFrm.numConsMin");'],[9,'focaliza("zonEstadZonaFrm.numPediZona");','focaliza("zonEstadZonaFrm.numPediZona");','focaliza("zonEstadZonaFrm.numPediZona");','focaliza("zonEstadZonaFrm.numPediZona");','focaliza("zonEstadZonaFrm.numPediZona");','focaliza("zonEstadZonaFrm.numPediZona");'],[10,'focaliza("zonEstadZonaFrm.valoTiemMini");','focaliza("zonEstadZonaFrm.valoTiemMini");','focaliza("zonEstadZonaFrm.valoTiemMini");','focaliza("zonEstadZonaFrm.valoTiemMini");','focaliza("zonEstadZonaFrm.valoTiemMini");','focaliza("zonEstadZonaFrm.valoTiemMini");']]);

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
var marcOidMarcDependeceMap = new Vector();
marcOidMarcDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
marcOidMarcDependeceMap.agregar(['marcOidMarc', padresTmp, '', 'SegMarca']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
zonEstadZonaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonEstadZonaTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function zonEstadZonaInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonEstadZonaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonEstadZonaFrm.accion')){
		case "query": zonEstadZonaQueryInitComponents(); break;
		case "view": zonEstadZonaViewInitComponents(); break;
		case "create": zonEstadZonaCreateInitComponents(); break;
		case "update": zonEstadZonaUpdateInitComponents(); break;
		case "remove": zonEstadZonaRemoveInitComponents(); break;
		case "lov": zonEstadZonaLovInitComponents(); break;
	}
	//alert('accion :' + get('zonEstadZonaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('zonEstadZonaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonEstadZona')) zonEstadZonaCmdRequery();
}

function zonEstadZonaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	focusFirstField('zonEstadZonaFrm', true);	
}

function zonEstadZonaViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('zonEstadZonaFrm', 'Descripcion', 1);
	
		
	//Establecemos el valor de los radiobuttons
		set('zonEstadZonaFrm.indInic', get('zonEstadZonaFrm.indInicCheckValue'));
		
	focusFirstField('zonEstadZonaFrm', true);
}

function zonEstadZonaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonEstadZonaFrm.paisOidPais','S', GestionarMensaje('ZonEstadZona.paisOidPais.requiered.message'));
	
	setMV('zonEstadZonaFrm.codEstaZona','S', GestionarMensaje('ZonEstadZona.codEstaZona.requiered.message'));
	
	setMV('zonEstadZonaFrm.marcOidMarc','S', GestionarMensaje('ZonEstadZona.marcOidMarc.requiered.message'));
	
	setMV('zonEstadZonaFrm.Descripcion','S', GestionarMensaje('ZonEstadZona.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('zonEstadZonaFrm', true);
}

function zonEstadZonaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonEstadZonaFrm.origen') == "pagina"){
		loadLocalizationWidget('zonEstadZonaFrm', 'Descripcion', 1);
		

		//Establecemos el valor de los radiobuttons
			set('zonEstadZonaFrm.indInic', get('zonEstadZonaFrm.indInicCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		zonEstadZonaTmpUpdateValues = zonEstadZonaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonEstadZonaFrm.codEstaZona','S', GestionarMensaje('ZonEstadZona.codEstaZona.requiered.message'));
		setMV('zonEstadZonaFrm.marcOidMarc','S', GestionarMensaje('ZonEstadZona.marcOidMarc.requiered.message'));
		setMV('zonEstadZonaFrm.Descripcion','S', GestionarMensaje('ZonEstadZona.Descripcion.requiered.message'));
		
			focusFirstFieldModify('zonEstadZonaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		focusFirstField('zonEstadZonaFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonEstadZonaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonEstadZonaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonEstadZonaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('zonEstadZonaFrm', true);
}

function zonEstadZonaLovInitComponents(){
	zonEstadZonaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('zonEstadZonaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad












//Función que permite cargar los datos de un elemento de lov seleccionado
function zonEstadZonaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonEstadZonaFrm.' + campo, id);
	set('zonEstadZonaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonEstadZonaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonEstadZonaLovReturnParameters.id = '';
	zonEstadZonaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonEstadZonaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonEstadZonaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonEstadZonaList.codSeleccionados();
	var descripcion = zonEstadZonaList.extraeDato(
		zonEstadZonaList.codSeleccionados()[0], zonEstadZonaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonEstadZonaLovReturnParameters.id = codigo;
	zonEstadZonaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonEstadZonaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonEstadZonaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonEstadZonaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonEstadZonaList", "ZonEstadZonaConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonEstadZonaPostQueryActions(datos);"]], "", "");	
}

function zonEstadZonaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonEstadZonaFrm.lastQueryToSession'));
	var i =0;
	set('zonEstadZonaFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('zonEstadZonaFrm.codEstaZona', paramsRequery.ij(i++));
	
	set('zonEstadZonaFrm.marcOidMarc', [paramsRequery.ij(i++)]);
	
	set('zonEstadZonaFrm.Descripcion', paramsRequery.ij(i++));
	
	set('zonEstadZonaFrm.indInic', paramsRequery.ij(i++));
	
	set('zonEstadZonaFrm.impoVentMini', paramsRequery.ij(i++));
	
	set('zonEstadZonaFrm.numConsMin', paramsRequery.ij(i++));
	
	set('zonEstadZonaFrm.numPediZona', paramsRequery.ij(i++));
	
	set('zonEstadZonaFrm.valoTiemMini', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	zonEstadZonaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonEstadZonaCmdQuery(zonEstadZonaPageCount);
}

function zonEstadZonaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonEstadZonaPageCount = 1;
	zonEstadZonaCmdQuery(zonEstadZonaPageCount);
}

function zonEstadZonaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonEstadZonaLastQuery){
		zonEstadZonaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonEstadZonaPageCount--;
	zonEstadZonaCmdQuery(zonEstadZonaPageCount);
}

function zonEstadZonaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonEstadZonaLastQuery){
		zonEstadZonaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonEstadZonaPageCount++;
	zonEstadZonaCmdQuery(zonEstadZonaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonEstadZonaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonEstadZonaListLayer', 'O');
		visibilidad('zonEstadZonaListButtonsLayer', 'O');
		if(get('zonEstadZonaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonEstadZonaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 4)){
			case '1': datosTmp.ij2(GestionarMensaje('ZonEstadZona.indInic.1.value'), i, 4); break;
			case '0': datosTmp.ij2(GestionarMensaje('ZonEstadZona.indInic.0.value'), i, 4); break;
			default: datosTmp .ij2('', i, 4);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonEstadZonaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonEstadZonaChoiceColumn) + "</A>",
			i, zonEstadZonaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonEstadZonaList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonEstadZonaTimeStamps = datosTmp.filtrar([9],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonEstadZonaMorePagesFlag = true;
		zonEstadZonaList.eliminar(mmgPageSize, 1);
	}else{
		zonEstadZonaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonEstadZonaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonEstadZonaListLayer', 'V');
	visibilidad('zonEstadZonaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonEstadZonaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonEstadZonaList.display();
	
	//Actualizamos el estado de los botones 
	if(zonEstadZonaMorePagesFlag){
		set_estado_botonera('zonEstadZonaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonEstadZonaPaginationButtonBar',
			3,"inactivo");
	}
	if(zonEstadZonaPageCount > 1){
		set_estado_botonera('zonEstadZonaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonEstadZonaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonEstadZonaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonEstadZonaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonEstadZonaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonEstadZonaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonEstadZonaFrm.idSelection', zonEstadZonaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonEstadZonaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = zonEstadZonaList.codSeleccionados()[0];
		parametros["previousAction"] = get('zonEstadZonaFrm.accion');
		parametros["accion"] = get('zonEstadZonaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('ZonEstadZonaLPStartUp', get('zonEstadZonaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) zonEstadZonaCmdRequery();
	}
}

function zonEstadZonaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonEstadZonaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonEstadZonaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonEstadZonaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonEstadZonaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonEstadZonaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonEstadZonaFrm.timestamp', timestamps);


	zonEstadZonaFrm.oculto='S';
	envia('zonEstadZonaFrm');
	zonEstadZonaFrm.oculto='N';
}

function zonEstadZonaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonEstadZonaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	zonEstadZonaViewDetail(zonEstadZonaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonEstadZonaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonEstadZonaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('ZonEstadZonaLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	setDefaultLanguageValue('zonEstadZonaFrm', 
		'Descripcion', 1,
		get('zonEstadZonaFrm.Descripcion'));	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('zonEstadZonaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	if(!hasDefaultLanguageValue('zonEstadZonaFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('ZonEstadZona.Descripcion.requiered.message'));
		focaliza('zonEstadZonaFrm.Descripcion');
		return;
	}	
	
	
	
	
	
	
		
	
	if(validacion){
		zonEstadZonaFrm.oculto='S';
		envia('zonEstadZonaFrm');
		zonEstadZonaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('zonEstadZonaFrm.paisOidPais').toString() == ''){
		set('zonEstadZonaFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'zonEstadZona');
		
	}
	if(get('zonEstadZonaFrm.marcOidMarc').toString() == ''){
		set('zonEstadZonaFrm.marcOidMarc', []);
		mmgResetCombosOnCascade('marcOidMarc', 'marcOidMarc', 'zonEstadZona');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonEstadZonaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonEstadZonaFrm.accion');
	var origenTmp = get('zonEstadZonaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonEstadZonaBuildUpdateRecordString() != zonEstadZonaTmpUpdateValues){
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
	document.all.zonEstadZonaListLayer.style.display='none';
	document.all.zonEstadZonaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonEstadZonaListLayer.style.display='';
	document.all.zonEstadZonaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonEstadZonaPaisOidPais = get('zonEstadZonaFrm.paisOidPais')[0];
	jsZonEstadZonaCodEstaZona = get('zonEstadZonaFrm.codEstaZona').toString();
	jsZonEstadZonaMarcOidMarc = get('zonEstadZonaFrm.marcOidMarc')[0];
	jsZonEstadZonaDescripcion = get('zonEstadZonaFrm.Descripcion').toString();
	jsZonEstadZonaIndInic = get('zonEstadZonaFrm.indInic');
	jsZonEstadZonaImpoVentMini = get('zonEstadZonaFrm.impoVentMini').toString();
	jsZonEstadZonaNumConsMin = get('zonEstadZonaFrm.numConsMin').toString();
	jsZonEstadZonaNumPediZona = get('zonEstadZonaFrm.numPediZona').toString();
	jsZonEstadZonaValoTiemMini = get('zonEstadZonaFrm.valoTiemMini').toString();
	
	
	var parametros = "";
	parametros += jsZonEstadZonaPaisOidPais + "|";
	parametros += jsZonEstadZonaCodEstaZona + "|";
	parametros += jsZonEstadZonaMarcOidMarc + "|";
	parametros += jsZonEstadZonaDescripcion + "|";
	parametros += jsZonEstadZonaIndInic + "|";
	parametros += jsZonEstadZonaImpoVentMini + "|";
	parametros += jsZonEstadZonaNumConsMin + "|";
	parametros += jsZonEstadZonaNumPediZona + "|";
	parametros += jsZonEstadZonaValoTiemMini + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonEstadZonaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonEstadZonaCodEstaZona + "|";
	parametros += jsZonEstadZonaMarcOidMarc + "|";
	parametros += jsZonEstadZonaDescripcion + "|";
	parametros += jsZonEstadZonaIndInic + "|";
	parametros += jsZonEstadZonaImpoVentMini + "|";
	parametros += jsZonEstadZonaNumConsMin + "|";
	parametros += jsZonEstadZonaNumPediZona + "|";
	parametros += jsZonEstadZonaValoTiemMini + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonEstadZonaFrm.accion'), 
		get('zonEstadZonaFrm.origen'));
	
	jsZonEstadZonaId = get('zonEstadZonaFrm.id').toString();
	jsZonEstadZonaPaisOidPais = get('zonEstadZonaFrm.paisOidPais')[0];
	jsZonEstadZonaCodEstaZona = get('zonEstadZonaFrm.codEstaZona').toString();
	jsZonEstadZonaMarcOidMarc = get('zonEstadZonaFrm.marcOidMarc')[0];
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsZonEstadZonaDescripcion = buildLocalizedString('zonEstadZonaFrm', 1);
	}else{
		jsZonEstadZonaDescripcion = get('zonEstadZonaFrm.Descripcion');
	}
	jsZonEstadZonaIndInic = get('zonEstadZonaFrm.indInic');
	jsZonEstadZonaImpoVentMini = get('zonEstadZonaFrm.impoVentMini').toString();
	jsZonEstadZonaNumConsMin = get('zonEstadZonaFrm.numConsMin').toString();
	jsZonEstadZonaNumPediZona = get('zonEstadZonaFrm.numPediZona').toString();
	jsZonEstadZonaValoTiemMini = get('zonEstadZonaFrm.valoTiemMini').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonEstadZonaFrm.accion'), 
		get('zonEstadZonaFrm.origen'));


	set('zonEstadZonaFrm.id', jsZonEstadZonaId);
	set('zonEstadZonaFrm.paisOidPais', [jsZonEstadZonaPaisOidPais]);
	set('zonEstadZonaFrm.codEstaZona', jsZonEstadZonaCodEstaZona);
	set('zonEstadZonaFrm.marcOidMarc', [jsZonEstadZonaMarcOidMarc]);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('zonEstadZonaFrm', 1,  jsZonEstadZonaDescripcion)
		loadLocalizationWidget('zonEstadZonaFrm', 'Descripcion', 1);
	}else{
		set('zonEstadZonaFrm.Descripcion', jsZonEstadZonaDescripcion);		
	}
	set('zonEstadZonaFrm.indInic', jsZonEstadZonaIndInic);
	set('zonEstadZonaFrm.impoVentMini', jsZonEstadZonaImpoVentMini);
	set('zonEstadZonaFrm.numConsMin', jsZonEstadZonaNumConsMin);
	set('zonEstadZonaFrm.numPediZona', jsZonEstadZonaNumPediZona);
	set('zonEstadZonaFrm.valoTiemMini', jsZonEstadZonaValoTiemMini);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsZonEstadZonaPaisOidPais = '';
	jsZonEstadZonaCodEstaZona = '';
	jsZonEstadZonaMarcOidMarc = '';
	jsZonEstadZonaDescripcion = '';
	jsZonEstadZonaIndInic = '';
	jsZonEstadZonaImpoVentMini = '';
	jsZonEstadZonaNumConsMin = '';
	jsZonEstadZonaNumPediZona = '';
	jsZonEstadZonaValoTiemMini = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonEstadZonaFrm.errCodigo', errorCode);
	set('zonEstadZonaFrm.errDescripcion', description);
	set('zonEstadZonaFrm.errSeverity', severity);
	fMostrarMensajeError();
}

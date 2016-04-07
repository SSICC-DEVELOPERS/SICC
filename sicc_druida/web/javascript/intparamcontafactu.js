

/*
    INDRA/CAR/mmg
    $Id: intparamcontafactu.js,v 1.1 2009/12/03 19:02:14 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsIntParamContaFactuId = "";
var jsIntParamContaFactuCodApun = "";
var jsIntParamContaFactuValTipoAsie = "";
var jsIntParamContaFactuValIdenCabeDeta = "";
var jsIntParamContaFactuValDesc = "";
var jsIntParamContaFactuValGrupArti = "";
var jsIntParamContaFactuMaprOidMarcProd = "";
var jsIntParamContaFactuNegoOidNego = "";
var jsIntParamContaFactuProdOidProd = "";
var jsIntParamContaFactuCucoOidCuenCont = "";
var jsIntParamContaFactuValIndiDebeHabe = "";
var jsIntParamContaFactuImcfOidImpoContFact = "";
var jsIntParamContaFactuPaisOidPais = "";

//Variables de paginacion, 
var intParamContaFactuPageCount = 1;

//Varible de columna que representa el campo de choice
var intParamContaFactuChoiceColumn = 11;

//Flag de siguiente pagina;
var intParamContaFactuMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var intParamContaFactuTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 525;
var sizeFormView = 531;
var sizeFormUpdate = 531;

//Ultima busqueda realizada
var intParamContaFactuLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("intParamContaFactuFrm.codApun");','focaliza("intParamContaFactuFrm.codApun");','focaliza("intParamContaFactuFrm.codApun");','focaliza("intParamContaFactuFrm.codApun");','focaliza("intParamContaFactuFrm.codApun");','focaliza("intParamContaFactuFrm.codApun");'],[3,'focaliza("intParamContaFactuFrm.valTipoAsie");','focaliza("intParamContaFactuFrm.valTipoAsie");','focaliza("intParamContaFactuFrm.valTipoAsie");','focaliza("intParamContaFactuFrm.valTipoAsie");','focaliza("intParamContaFactuFrm.valTipoAsie");','focaliza("intParamContaFactuFrm.valTipoAsie");'],[4,'focaliza("intParamContaFactuFrm.valIdenCabeDeta");','focaliza("intParamContaFactuFrm.valIdenCabeDeta");','focaliza("intParamContaFactuFrm.valIdenCabeDeta");','focaliza("intParamContaFactuFrm.valIdenCabeDeta");','focaliza("intParamContaFactuFrm.valIdenCabeDeta");','focaliza("intParamContaFactuFrm.valIdenCabeDeta");'],[5,'focaliza("intParamContaFactuFrm.valDesc");','focaliza("intParamContaFactuFrm.valDesc");','focaliza("intParamContaFactuFrm.valDesc");','focaliza("intParamContaFactuFrm.valDesc");','focaliza("intParamContaFactuFrm.valDesc");','focaliza("intParamContaFactuFrm.valDesc");'],[6,'focaliza("intParamContaFactuFrm.valGrupArti");','focaliza("intParamContaFactuFrm.valGrupArti");','focaliza("intParamContaFactuFrm.valGrupArti");','focaliza("intParamContaFactuFrm.valGrupArti");','focaliza("intParamContaFactuFrm.valGrupArti");','focaliza("intParamContaFactuFrm.valGrupArti");'],[7,'focalizaComboDependence("intParamContaFactu","maprOidMarcProd", false);','focalizaComboDependence("intParamContaFactu","maprOidMarcProd", false);','focalizaComboDependence("intParamContaFactu","maprOidMarcProd", false);','focalizaComboDependence("intParamContaFactu","maprOidMarcProd", true);','focalizaComboDependence("intParamContaFactu","maprOidMarcProd", true);','focalizaComboDependence("intParamContaFactu","maprOidMarcProd", true);'],[8,'focalizaComboDependence("intParamContaFactu","negoOidNego", false);','focalizaComboDependence("intParamContaFactu","negoOidNego", false);','focalizaComboDependence("intParamContaFactu","negoOidNego", false);','focalizaComboDependence("intParamContaFactu","negoOidNego", true);','focalizaComboDependence("intParamContaFactu","negoOidNego", true);','focalizaComboDependence("intParamContaFactu","negoOidNego", true);'],[9,'focaliza("intParamContaFactuFrm.prodOidProd");','focaliza("intParamContaFactuFrm.prodOidProd");','focaliza("intParamContaFactuFrm.prodOidProd");','focaliza("intParamContaFactuFrm.prodOidProd");','focaliza("intParamContaFactuFrm.prodOidProd");','focaliza("intParamContaFactuFrm.prodOidProd");'],[10,'focalizaComboDependence("intParamContaFactu","cucoOidCuenCont", false);','focalizaComboDependence("intParamContaFactu","cucoOidCuenCont", false);','focalizaComboDependence("intParamContaFactu","cucoOidCuenCont", false);','focalizaComboDependence("intParamContaFactu","cucoOidCuenCont", true);','focalizaComboDependence("intParamContaFactu","cucoOidCuenCont", true);','focalizaComboDependence("intParamContaFactu","cucoOidCuenCont", true);'],[11,'focaliza("intParamContaFactuFrm.valIndiDebeHabe");','focaliza("intParamContaFactuFrm.valIndiDebeHabe");','focaliza("intParamContaFactuFrm.valIndiDebeHabe");','focaliza("intParamContaFactuFrm.valIndiDebeHabe");','focaliza("intParamContaFactuFrm.valIndiDebeHabe");','focaliza("intParamContaFactuFrm.valIndiDebeHabe");'],[12,'focalizaComboDependence("intParamContaFactu","imcfOidImpoContFact", false);','focalizaComboDependence("intParamContaFactu","imcfOidImpoContFact", false);','focalizaComboDependence("intParamContaFactu","imcfOidImpoContFact", false);','focalizaComboDependence("intParamContaFactu","imcfOidImpoContFact", true);','focalizaComboDependence("intParamContaFactu","imcfOidImpoContFact", true);','focalizaComboDependence("intParamContaFactu","imcfOidImpoContFact", true);'],[13,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("intParamContaFactuFrm.valTipoAsie");','focaliza("intParamContaFactuFrm.valTipoAsie");','focaliza("intParamContaFactuFrm.valTipoAsie");','focaliza("intParamContaFactuFrm.valTipoAsie");','focaliza("intParamContaFactuFrm.valTipoAsie");','focaliza("intParamContaFactuFrm.valTipoAsie");'],[4,'focaliza("intParamContaFactuFrm.valIdenCabeDeta");','focaliza("intParamContaFactuFrm.valIdenCabeDeta");','focaliza("intParamContaFactuFrm.valIdenCabeDeta");','focaliza("intParamContaFactuFrm.valIdenCabeDeta");','focaliza("intParamContaFactuFrm.valIdenCabeDeta");','focaliza("intParamContaFactuFrm.valIdenCabeDeta");'],[5,'focaliza("intParamContaFactuFrm.valDesc");','focaliza("intParamContaFactuFrm.valDesc");','focaliza("intParamContaFactuFrm.valDesc");','focaliza("intParamContaFactuFrm.valDesc");','focaliza("intParamContaFactuFrm.valDesc");','focaliza("intParamContaFactuFrm.valDesc");'],[6,'focaliza("intParamContaFactuFrm.valGrupArti");','focaliza("intParamContaFactuFrm.valGrupArti");','focaliza("intParamContaFactuFrm.valGrupArti");','focaliza("intParamContaFactuFrm.valGrupArti");','focaliza("intParamContaFactuFrm.valGrupArti");','focaliza("intParamContaFactuFrm.valGrupArti");'],[7,'focalizaComboDependence("intParamContaFactu","maprOidMarcProd", false);','focalizaComboDependence("intParamContaFactu","maprOidMarcProd", false);','focalizaComboDependence("intParamContaFactu","maprOidMarcProd", false);','focalizaComboDependence("intParamContaFactu","maprOidMarcProd", true);','focalizaComboDependence("intParamContaFactu","maprOidMarcProd", true);','focalizaComboDependence("intParamContaFactu","maprOidMarcProd", true);'],[8,'focalizaComboDependence("intParamContaFactu","negoOidNego", false);','focalizaComboDependence("intParamContaFactu","negoOidNego", false);','focalizaComboDependence("intParamContaFactu","negoOidNego", false);','focalizaComboDependence("intParamContaFactu","negoOidNego", true);','focalizaComboDependence("intParamContaFactu","negoOidNego", true);','focalizaComboDependence("intParamContaFactu","negoOidNego", true);'],[9,'focaliza("intParamContaFactuFrm.prodOidProd");','focaliza("intParamContaFactuFrm.prodOidProd");','focaliza("intParamContaFactuFrm.prodOidProd");','focaliza("intParamContaFactuFrm.prodOidProd");','focaliza("intParamContaFactuFrm.prodOidProd");','focaliza("intParamContaFactuFrm.prodOidProd");'],[10,'focalizaComboDependence("intParamContaFactu","cucoOidCuenCont", false);','focalizaComboDependence("intParamContaFactu","cucoOidCuenCont", false);','focalizaComboDependence("intParamContaFactu","cucoOidCuenCont", false);','focalizaComboDependence("intParamContaFactu","cucoOidCuenCont", true);','focalizaComboDependence("intParamContaFactu","cucoOidCuenCont", true);','focalizaComboDependence("intParamContaFactu","cucoOidCuenCont", true);'],[11,'focaliza("intParamContaFactuFrm.valIndiDebeHabe");','focaliza("intParamContaFactuFrm.valIndiDebeHabe");','focaliza("intParamContaFactuFrm.valIndiDebeHabe");','focaliza("intParamContaFactuFrm.valIndiDebeHabe");','focaliza("intParamContaFactuFrm.valIndiDebeHabe");','focaliza("intParamContaFactuFrm.valIndiDebeHabe");'],[12,'focalizaComboDependence("intParamContaFactu","imcfOidImpoContFact", false);','focalizaComboDependence("intParamContaFactu","imcfOidImpoContFact", false);','focalizaComboDependence("intParamContaFactu","imcfOidImpoContFact", false);','focalizaComboDependence("intParamContaFactu","imcfOidImpoContFact", true);','focalizaComboDependence("intParamContaFactu","imcfOidImpoContFact", true);','focalizaComboDependence("intParamContaFactu","imcfOidImpoContFact", true);'],[13,'','','','','','']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var maprOidMarcProdDependeceMap = new Vector();
maprOidMarcProdDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
maprOidMarcProdDependeceMap.agregar(['maprOidMarcProd', padresTmp, '', 'SegMarcaProdu']);
var negoOidNegoDependeceMap = new Vector();
negoOidNegoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
negoOidNegoDependeceMap.agregar(['negoOidNego', padresTmp, '', 'MaeNegocView']);
var cucoOidCuenContDependeceMap = new Vector();
cucoOidCuenContDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
cucoOidCuenContDependeceMap.agregar(['cucoOidCuenCont', padresTmp, '', 'CccCuentContaView']);
var imcfOidImpoContFactDependeceMap = new Vector();
imcfOidImpoContFactDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
imcfOidImpoContFactDependeceMap.agregar(['imcfOidImpoContFact', padresTmp, '', 'IntImporContaFactu']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
intParamContaFactuLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var intParamContaFactuTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function intParamContaFactuInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('intParamContaFactuFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('intParamContaFactuFrm.accion')){
		case "query": intParamContaFactuQueryInitComponents(); break;
		case "view": intParamContaFactuViewInitComponents(); break;
		case "create": intParamContaFactuCreateInitComponents(); break;
		case "update": intParamContaFactuUpdateInitComponents(); break;
		case "remove": intParamContaFactuRemoveInitComponents(); break;
		case "lov": intParamContaFactuLovInitComponents(); break;
	}
	//alert('accion :' + get('intParamContaFactuFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('intParamContaFactuFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('intParamContaFactu')) intParamContaFactuCmdRequery();
}

function intParamContaFactuQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	focusFirstField('intParamContaFactuFrm', true);	
}

function intParamContaFactuViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('intParamContaFactuFrm', true);
}

function intParamContaFactuCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('intParamContaFactuFrm.codApun','S', GestionarMensaje('IntParamContaFactu.codApun.requiered.message'));
	
	setMV('intParamContaFactuFrm.valTipoAsie','S', GestionarMensaje('IntParamContaFactu.valTipoAsie.requiered.message'));
	
	setMV('intParamContaFactuFrm.valIdenCabeDeta','S', GestionarMensaje('IntParamContaFactu.valIdenCabeDeta.requiered.message'));
	
	setMV('intParamContaFactuFrm.valDesc','S', GestionarMensaje('IntParamContaFactu.valDesc.requiered.message'));
	
	setMV('intParamContaFactuFrm.prodOidProd','S', GestionarMensaje('IntParamContaFactu.prodOidProd.requiered.message'));
	
	setMV('intParamContaFactuFrm.cucoOidCuenCont','S', GestionarMensaje('IntParamContaFactu.cucoOidCuenCont.requiered.message'));
	
	setMV('intParamContaFactuFrm.valIndiDebeHabe','S', GestionarMensaje('IntParamContaFactu.valIndiDebeHabe.requiered.message'));
	
	setMV('intParamContaFactuFrm.imcfOidImpoContFact','S', GestionarMensaje('IntParamContaFactu.imcfOidImpoContFact.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('intParamContaFactuFrm', true);
}

function intParamContaFactuUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('intParamContaFactuFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		intParamContaFactuTmpUpdateValues = intParamContaFactuBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('intParamContaFactuFrm.codApun','S', GestionarMensaje('IntParamContaFactu.codApun.requiered.message'));
		setMV('intParamContaFactuFrm.valTipoAsie','S', GestionarMensaje('IntParamContaFactu.valTipoAsie.requiered.message'));
		setMV('intParamContaFactuFrm.valIdenCabeDeta','S', GestionarMensaje('IntParamContaFactu.valIdenCabeDeta.requiered.message'));
		setMV('intParamContaFactuFrm.valDesc','S', GestionarMensaje('IntParamContaFactu.valDesc.requiered.message'));
		setMV('intParamContaFactuFrm.prodOidProd','S', GestionarMensaje('IntParamContaFactu.prodOidProd.requiered.message'));
		setMV('intParamContaFactuFrm.cucoOidCuenCont','S', GestionarMensaje('IntParamContaFactu.cucoOidCuenCont.requiered.message'));
		setMV('intParamContaFactuFrm.valIndiDebeHabe','S', GestionarMensaje('IntParamContaFactu.valIndiDebeHabe.requiered.message'));
		setMV('intParamContaFactuFrm.imcfOidImpoContFact','S', GestionarMensaje('IntParamContaFactu.imcfOidImpoContFact.requiered.message'));
		
			focusFirstFieldModify('intParamContaFactuFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		focusFirstField('intParamContaFactuFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('intParamContaFactuFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function intParamContaFactuRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	intParamContaFactuList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('intParamContaFactuFrm', true);
}

function intParamContaFactuLovInitComponents(){
	intParamContaFactuLovReturnParameters = window.dialogArguments;
	
	focusFirstField('intParamContaFactuFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad















//Función que permite cargar los datos de un elemento de lov seleccionado
function intParamContaFactuSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('intParamContaFactuFrm.' + campo, id);
	set('intParamContaFactuFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function intParamContaFactuLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	intParamContaFactuLovReturnParameters.id = '';
	intParamContaFactuLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function intParamContaFactuLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(intParamContaFactuList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = intParamContaFactuList.codSeleccionados();
	var descripcion = intParamContaFactuList.extraeDato(
		intParamContaFactuList.codSeleccionados()[0], intParamContaFactuChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	intParamContaFactuLovReturnParameters.id = codigo;
	intParamContaFactuLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function intParamContaFactuCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('intParamContaFactuFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('intParamContaFactuFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "intParamContaFactuList", "IntParamContaFactuConectorTransactionQuery", 
		"result_ROWSET", parametros, "intParamContaFactuPostQueryActions(datos);"]], "", "");	
}

function intParamContaFactuCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('intParamContaFactuFrm.lastQueryToSession'));
	var i =0;
	set('intParamContaFactuFrm.codApun', paramsRequery.ij(i++));
	
	set('intParamContaFactuFrm.valTipoAsie', [paramsRequery.ij(i++)]);
	
	set('intParamContaFactuFrm.valIdenCabeDeta', [paramsRequery.ij(i++)]);
	
	set('intParamContaFactuFrm.valDesc', paramsRequery.ij(i++));
	
	set('intParamContaFactuFrm.valGrupArti', paramsRequery.ij(i++));
	
	set('intParamContaFactuFrm.maprOidMarcProd', [paramsRequery.ij(i++)]);
	
	set('intParamContaFactuFrm.negoOidNego', [paramsRequery.ij(i++)]);
	
	set('intParamContaFactuFrm.prodOidProd', paramsRequery.ij(i++));
	
	set('intParamContaFactuFrm.cucoOidCuenCont', [paramsRequery.ij(i++)]);
	
	set('intParamContaFactuFrm.valIndiDebeHabe', [paramsRequery.ij(i++)]);
	
	set('intParamContaFactuFrm.imcfOidImpoContFact', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	intParamContaFactuPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	intParamContaFactuCmdQuery(intParamContaFactuPageCount);
}

function intParamContaFactuFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	intParamContaFactuPageCount = 1;
	intParamContaFactuCmdQuery(intParamContaFactuPageCount);
}

function intParamContaFactuPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != intParamContaFactuLastQuery){
		intParamContaFactuFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	intParamContaFactuPageCount--;
	intParamContaFactuCmdQuery(intParamContaFactuPageCount);
}

function intParamContaFactuNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != intParamContaFactuLastQuery){
		intParamContaFactuFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	intParamContaFactuPageCount++;
	intParamContaFactuCmdQuery(intParamContaFactuPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function intParamContaFactuPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('intParamContaFactuListLayer', 'O');
		visibilidad('intParamContaFactuListButtonsLayer', 'O');
		if(get('intParamContaFactuFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	intParamContaFactuLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 2)){
			case 'VN': datosTmp.ij2(GestionarMensaje('IntParamContaFactu.valTipoAsie.VN.value'), i, 2); break;
			case 'AB': datosTmp.ij2(GestionarMensaje('IntParamContaFactu.valTipoAsie.AB.value'), i, 2); break;
			case 'TN': datosTmp.ij2(GestionarMensaje('IntParamContaFactu.valTipoAsie.TN.value'), i, 2); break;
			default: datosTmp .ij2('', i, 2);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 3)){
			case 'C': datosTmp.ij2(GestionarMensaje('IntParamContaFactu.valIdenCabeDeta.C.value'), i, 3); break;
			case 'D': datosTmp.ij2(GestionarMensaje('IntParamContaFactu.valIdenCabeDeta.D.value'), i, 3); break;
			default: datosTmp .ij2('', i, 3);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 10)){
			case 'D': datosTmp.ij2(GestionarMensaje('IntParamContaFactu.valIndiDebeHabe.D.value'), i, 10); break;
			case 'H': datosTmp.ij2(GestionarMensaje('IntParamContaFactu.valIndiDebeHabe.H.value'), i, 10); break;
			default: datosTmp .ij2('', i, 10);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:intParamContaFactuViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, intParamContaFactuChoiceColumn) + "</A>",
			i, intParamContaFactuChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	intParamContaFactuList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	intParamContaFactuTimeStamps = datosTmp.filtrar([12],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		intParamContaFactuMorePagesFlag = true;
		intParamContaFactuList.eliminar(mmgPageSize, 1);
	}else{
		intParamContaFactuMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('intParamContaFactuFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('intParamContaFactuListLayer', 'V');
	visibilidad('intParamContaFactuListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('intParamContaFactuList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	intParamContaFactuList.display();
	
	//Actualizamos el estado de los botones 
	if(intParamContaFactuMorePagesFlag){
		set_estado_botonera('intParamContaFactuPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('intParamContaFactuPaginationButtonBar',
			3,"inactivo");
	}
	if(intParamContaFactuPageCount > 1){
		set_estado_botonera('intParamContaFactuPaginationButtonBar',
			2,"activo");
		set_estado_botonera('intParamContaFactuPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('intParamContaFactuPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('intParamContaFactuPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function intParamContaFactuUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(intParamContaFactuList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('intParamContaFactuFrm.idSelection', intParamContaFactuList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('intParamContaFactuFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = intParamContaFactuList.codSeleccionados()[0];
		parametros["previousAction"] = get('intParamContaFactuFrm.accion');
		parametros["accion"] = get('intParamContaFactuFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('IntParamContaFactuLPStartUp', get('intParamContaFactuFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) intParamContaFactuCmdRequery();
	}
}

function intParamContaFactuRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(intParamContaFactuList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = intParamContaFactuList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('intParamContaFactuFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(intParamContaFactuList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += intParamContaFactuTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('intParamContaFactuFrm.timestamp', timestamps);


	intParamContaFactuFrm.oculto='S';
	envia('intParamContaFactuFrm');
	intParamContaFactuFrm.oculto='N';
}

function intParamContaFactuViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(intParamContaFactuList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	intParamContaFactuViewDetail(intParamContaFactuList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function intParamContaFactuViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('intParamContaFactuFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('IntParamContaFactuLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('intParamContaFactuFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		intParamContaFactuFrm.oculto='S';
		envia('intParamContaFactuFrm');
		intParamContaFactuFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('intParamContaFactuFrm.maprOidMarcProd').toString() == ''){
		set('intParamContaFactuFrm.maprOidMarcProd', []);
		mmgResetCombosOnCascade('maprOidMarcProd', 'maprOidMarcProd', 'intParamContaFactu');
		
	}
	if(get('intParamContaFactuFrm.negoOidNego').toString() == ''){
		set('intParamContaFactuFrm.negoOidNego', []);
		mmgResetCombosOnCascade('negoOidNego', 'negoOidNego', 'intParamContaFactu');
		
	}
	if(get('intParamContaFactuFrm.cucoOidCuenCont').toString() == ''){
		set('intParamContaFactuFrm.cucoOidCuenCont', []);
		mmgResetCombosOnCascade('cucoOidCuenCont', 'cucoOidCuenCont', 'intParamContaFactu');
		
	}
	if(get('intParamContaFactuFrm.imcfOidImpoContFact').toString() == ''){
		set('intParamContaFactuFrm.imcfOidImpoContFact', []);
		mmgResetCombosOnCascade('imcfOidImpoContFact', 'imcfOidImpoContFact', 'intParamContaFactu');
		
	}
	if(get('intParamContaFactuFrm.paisOidPais').toString() == ''){
		set('intParamContaFactuFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'intParamContaFactu');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	intParamContaFactuRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('intParamContaFactuFrm.accion');
	var origenTmp = get('intParamContaFactuFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(intParamContaFactuBuildUpdateRecordString() != intParamContaFactuTmpUpdateValues){
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
	document.all.intParamContaFactuListLayer.style.display='none';
	document.all.intParamContaFactuListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.intParamContaFactuListLayer.style.display='';
	document.all.intParamContaFactuListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsIntParamContaFactuCodApun = get('intParamContaFactuFrm.codApun').toString();
	jsIntParamContaFactuValTipoAsie = get('intParamContaFactuFrm.valTipoAsie')[0];
	jsIntParamContaFactuValIdenCabeDeta = get('intParamContaFactuFrm.valIdenCabeDeta')[0];
	jsIntParamContaFactuValDesc = get('intParamContaFactuFrm.valDesc').toString();
	jsIntParamContaFactuValGrupArti = get('intParamContaFactuFrm.valGrupArti').toString();
	jsIntParamContaFactuMaprOidMarcProd = get('intParamContaFactuFrm.maprOidMarcProd')[0];
	jsIntParamContaFactuNegoOidNego = get('intParamContaFactuFrm.negoOidNego')[0];
	jsIntParamContaFactuProdOidProd = get('intParamContaFactuFrm.prodOidProd').toString();
	jsIntParamContaFactuCucoOidCuenCont = get('intParamContaFactuFrm.cucoOidCuenCont')[0];
	jsIntParamContaFactuValIndiDebeHabe = get('intParamContaFactuFrm.valIndiDebeHabe')[0];
	jsIntParamContaFactuImcfOidImpoContFact = get('intParamContaFactuFrm.imcfOidImpoContFact')[0];
	
	
	var parametros = "";
	parametros += jsIntParamContaFactuCodApun + "|";
	parametros += jsIntParamContaFactuValTipoAsie + "|";
	parametros += jsIntParamContaFactuValIdenCabeDeta + "|";
	parametros += jsIntParamContaFactuValDesc + "|";
	parametros += jsIntParamContaFactuValGrupArti + "|";
	parametros += jsIntParamContaFactuMaprOidMarcProd + "|";
	parametros += jsIntParamContaFactuNegoOidNego + "|";
	parametros += jsIntParamContaFactuProdOidProd + "|";
	parametros += jsIntParamContaFactuCucoOidCuenCont + "|";
	parametros += jsIntParamContaFactuValIndiDebeHabe + "|";
	parametros += jsIntParamContaFactuImcfOidImpoContFact + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function intParamContaFactuBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsIntParamContaFactuCodApun + "|";
	parametros += jsIntParamContaFactuValTipoAsie + "|";
	parametros += jsIntParamContaFactuValIdenCabeDeta + "|";
	parametros += jsIntParamContaFactuValDesc + "|";
	parametros += jsIntParamContaFactuValGrupArti + "|";
	parametros += jsIntParamContaFactuMaprOidMarcProd + "|";
	parametros += jsIntParamContaFactuNegoOidNego + "|";
	parametros += jsIntParamContaFactuProdOidProd + "|";
	parametros += jsIntParamContaFactuCucoOidCuenCont + "|";
	parametros += jsIntParamContaFactuValIndiDebeHabe + "|";
	parametros += jsIntParamContaFactuImcfOidImpoContFact + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('intParamContaFactuFrm.accion'), 
		get('intParamContaFactuFrm.origen'));
	
	jsIntParamContaFactuId = get('intParamContaFactuFrm.id').toString();
	jsIntParamContaFactuCodApun = get('intParamContaFactuFrm.codApun').toString();
	jsIntParamContaFactuValTipoAsie = get('intParamContaFactuFrm.valTipoAsie')[0];
	jsIntParamContaFactuValIdenCabeDeta = get('intParamContaFactuFrm.valIdenCabeDeta')[0];
	jsIntParamContaFactuValDesc = get('intParamContaFactuFrm.valDesc').toString();
	jsIntParamContaFactuValGrupArti = get('intParamContaFactuFrm.valGrupArti').toString();
	jsIntParamContaFactuMaprOidMarcProd = get('intParamContaFactuFrm.maprOidMarcProd')[0];
	jsIntParamContaFactuNegoOidNego = get('intParamContaFactuFrm.negoOidNego')[0];
	jsIntParamContaFactuProdOidProd = get('intParamContaFactuFrm.prodOidProd').toString();
	jsIntParamContaFactuCucoOidCuenCont = get('intParamContaFactuFrm.cucoOidCuenCont')[0];
	jsIntParamContaFactuValIndiDebeHabe = get('intParamContaFactuFrm.valIndiDebeHabe')[0];
	jsIntParamContaFactuImcfOidImpoContFact = get('intParamContaFactuFrm.imcfOidImpoContFact')[0];
	jsIntParamContaFactuPaisOidPais = get('intParamContaFactuFrm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('intParamContaFactuFrm.accion'), 
		get('intParamContaFactuFrm.origen'));


	set('intParamContaFactuFrm.id', jsIntParamContaFactuId);
	set('intParamContaFactuFrm.codApun', jsIntParamContaFactuCodApun);
	set('intParamContaFactuFrm.valTipoAsie', [jsIntParamContaFactuValTipoAsie]);
	set('intParamContaFactuFrm.valIdenCabeDeta', [jsIntParamContaFactuValIdenCabeDeta]);
	set('intParamContaFactuFrm.valDesc', jsIntParamContaFactuValDesc);
	set('intParamContaFactuFrm.valGrupArti', jsIntParamContaFactuValGrupArti);
	set('intParamContaFactuFrm.maprOidMarcProd', [jsIntParamContaFactuMaprOidMarcProd]);
	set('intParamContaFactuFrm.negoOidNego', [jsIntParamContaFactuNegoOidNego]);
	set('intParamContaFactuFrm.prodOidProd', jsIntParamContaFactuProdOidProd);
	set('intParamContaFactuFrm.cucoOidCuenCont', [jsIntParamContaFactuCucoOidCuenCont]);
	set('intParamContaFactuFrm.valIndiDebeHabe', [jsIntParamContaFactuValIndiDebeHabe]);
	set('intParamContaFactuFrm.imcfOidImpoContFact', [jsIntParamContaFactuImcfOidImpoContFact]);
	set('intParamContaFactuFrm.paisOidPais', [jsIntParamContaFactuPaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsIntParamContaFactuCodApun = '';
	jsIntParamContaFactuValTipoAsie = '';
	jsIntParamContaFactuValIdenCabeDeta = '';
	jsIntParamContaFactuValDesc = '';
	jsIntParamContaFactuValGrupArti = '';
	jsIntParamContaFactuMaprOidMarcProd = '';
	jsIntParamContaFactuNegoOidNego = '';
	jsIntParamContaFactuProdOidProd = '';
	jsIntParamContaFactuCucoOidCuenCont = '';
	jsIntParamContaFactuValIndiDebeHabe = '';
	jsIntParamContaFactuImcfOidImpoContFact = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('intParamContaFactuFrm.errCodigo', errorCode);
	set('intParamContaFactuFrm.errDescripcion', description);
	set('intParamContaFactuFrm.errSeverity', severity);
	fMostrarMensajeError();
}

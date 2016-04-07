

/*
    INDRA/CAR/mmg
    $Id: cobusuaretapacobradetal.js,v 1.1 2009/12/03 19:01:42 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCobUsuarEtapaCobraDetalId = "";
var jsCobUsuarEtapaCobraDetalUeccOidUsuaEtapCobr = "";
var jsCobUsuarEtapaCobraDetalEdtcOidEtapDeudTipoCarg = "";
var jsCobUsuarEtapaCobraDetalZsgvOidSubgVent = "";
var jsCobUsuarEtapaCobraDetalZorgOidRegi = "";
var jsCobUsuarEtapaCobraDetalZzonOidZona = "";
var jsCobUsuarEtapaCobraDetalZsccOidSecc = "";
var jsCobUsuarEtapaCobraDetalTerrOidTerr = "";
var jsCobUsuarEtapaCobraDetalMelcOidMetoLiquCobr = "";
var jsCobUsuarEtapaCobraDetalEucoOidEstaUsuaEtapCobr = "";
var jsCobUsuarEtapaCobraDetalGacaOidGuioArguCabe = "";
var jsCobUsuarEtapaCobraDetalValObse = "";

//Variables de paginacion, 
var cobUsuarEtapaCobraDetalPageCount = 1;

//Varible de columna que representa el campo de choice
var cobUsuarEtapaCobraDetalChoiceColumn = 11;

//Flag de siguiente pagina;
var cobUsuarEtapaCobraDetalMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cobUsuarEtapaCobraDetalTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 357;
var sizeFormView = 511;
var sizeFormUpdate = 511;

//Ultima busqueda realizada
var cobUsuarEtapaCobraDetalLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("cobUsuarEtapaCobraDetal","ueccOidUsuaEtapCobr", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","ueccOidUsuaEtapCobr", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","ueccOidUsuaEtapCobr", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","ueccOidUsuaEtapCobr", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","ueccOidUsuaEtapCobr", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","ueccOidUsuaEtapCobr", true);'],[3,'focalizaComboDependence("cobUsuarEtapaCobraDetal","edtcOidEtapDeudTipoCarg", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","edtcOidEtapDeudTipoCarg", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","edtcOidEtapDeudTipoCarg", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","edtcOidEtapDeudTipoCarg", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","edtcOidEtapDeudTipoCarg", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","edtcOidEtapDeudTipoCarg", true);'],[4,'focalizaComboDependence("cobUsuarEtapaCobraDetal","zsgvOidSubgVent", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsgvOidSubgVent", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsgvOidSubgVent", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsgvOidSubgVent", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsgvOidSubgVent", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsgvOidSubgVent", true);'],[5,'focalizaComboDependence("cobUsuarEtapaCobraDetal","zorgOidRegi", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zorgOidRegi", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zorgOidRegi", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zorgOidRegi", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zorgOidRegi", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zorgOidRegi", true);'],[6,'focalizaComboDependence("cobUsuarEtapaCobraDetal","zzonOidZona", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zzonOidZona", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zzonOidZona", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zzonOidZona", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zzonOidZona", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zzonOidZona", true);'],[7,'focalizaComboDependence("cobUsuarEtapaCobraDetal","zsccOidSecc", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsccOidSecc", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsccOidSecc", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsccOidSecc", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsccOidSecc", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsccOidSecc", true);'],[8,'focalizaComboDependence("cobUsuarEtapaCobraDetal","terrOidTerr", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","terrOidTerr", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","terrOidTerr", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","terrOidTerr", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","terrOidTerr", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","terrOidTerr", true);'],[9,'','focalizaComboDependence("cobUsuarEtapaCobraDetal","melcOidMetoLiquCobr", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","melcOidMetoLiquCobr", false);','','focalizaComboDependence("cobUsuarEtapaCobraDetal","melcOidMetoLiquCobr", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","melcOidMetoLiquCobr", true);'],[10,'','focalizaComboDependence("cobUsuarEtapaCobraDetal","eucoOidEstaUsuaEtapCobr", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","eucoOidEstaUsuaEtapCobr", false);','','focalizaComboDependence("cobUsuarEtapaCobraDetal","eucoOidEstaUsuaEtapCobr", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","eucoOidEstaUsuaEtapCobr", true);'],[11,'','focalizaComboDependence("cobUsuarEtapaCobraDetal","gacaOidGuioArguCabe", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","gacaOidGuioArguCabe", false);','','focalizaComboDependence("cobUsuarEtapaCobraDetal","gacaOidGuioArguCabe", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","gacaOidGuioArguCabe", true);'],[12,'','focaliza("cobUsuarEtapaCobraDetalFrm.valObse");','focaliza("cobUsuarEtapaCobraDetalFrm.valObse");','','focaliza("cobUsuarEtapaCobraDetalFrm.valObse");','focaliza("cobUsuarEtapaCobraDetalFrm.valObse");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focalizaComboDependence("cobUsuarEtapaCobraDetal","zsgvOidSubgVent", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsgvOidSubgVent", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsgvOidSubgVent", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsgvOidSubgVent", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsgvOidSubgVent", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsgvOidSubgVent", true);'],[5,'focalizaComboDependence("cobUsuarEtapaCobraDetal","zorgOidRegi", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zorgOidRegi", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zorgOidRegi", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zorgOidRegi", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zorgOidRegi", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zorgOidRegi", true);'],[6,'focalizaComboDependence("cobUsuarEtapaCobraDetal","zzonOidZona", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zzonOidZona", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zzonOidZona", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zzonOidZona", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zzonOidZona", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zzonOidZona", true);'],[7,'focalizaComboDependence("cobUsuarEtapaCobraDetal","zsccOidSecc", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsccOidSecc", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsccOidSecc", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsccOidSecc", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsccOidSecc", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","zsccOidSecc", true);'],[8,'focalizaComboDependence("cobUsuarEtapaCobraDetal","terrOidTerr", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","terrOidTerr", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","terrOidTerr", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","terrOidTerr", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","terrOidTerr", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","terrOidTerr", true);'],[9,'','focalizaComboDependence("cobUsuarEtapaCobraDetal","melcOidMetoLiquCobr", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","melcOidMetoLiquCobr", false);','','focalizaComboDependence("cobUsuarEtapaCobraDetal","melcOidMetoLiquCobr", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","melcOidMetoLiquCobr", true);'],[10,'','focalizaComboDependence("cobUsuarEtapaCobraDetal","eucoOidEstaUsuaEtapCobr", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","eucoOidEstaUsuaEtapCobr", false);','','focalizaComboDependence("cobUsuarEtapaCobraDetal","eucoOidEstaUsuaEtapCobr", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","eucoOidEstaUsuaEtapCobr", true);'],[11,'','focalizaComboDependence("cobUsuarEtapaCobraDetal","gacaOidGuioArguCabe", false);','focalizaComboDependence("cobUsuarEtapaCobraDetal","gacaOidGuioArguCabe", false);','','focalizaComboDependence("cobUsuarEtapaCobraDetal","gacaOidGuioArguCabe", true);','focalizaComboDependence("cobUsuarEtapaCobraDetal","gacaOidGuioArguCabe", true);'],[12,'','focaliza("cobUsuarEtapaCobraDetalFrm.valObse");','focaliza("cobUsuarEtapaCobraDetalFrm.valObse");','','focaliza("cobUsuarEtapaCobraDetalFrm.valObse");','focaliza("cobUsuarEtapaCobraDetalFrm.valObse");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var ueccOidUsuaEtapCobrDependeceMap = new Vector();
ueccOidUsuaEtapCobrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ueccOidUsuaEtapCobrDependeceMap.agregar(['ueccOidUsuaEtapCobr', padresTmp, '', 'CobUsuarEtapaCobraCabec']);
var edtcOidEtapDeudTipoCargDependeceMap = new Vector();
edtcOidEtapDeudTipoCargDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
edtcOidEtapDeudTipoCargDependeceMap.agregar(['edtcOidEtapDeudTipoCarg', padresTmp, '', 'CobEtapaDeudaTipoCargo']);
var zsgvOidSubgVentDependeceMap = new Vector();
zsgvOidSubgVentDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zsgvOidSubgVentDependeceMap.agregar(['zsgvOidSubgVent', padresTmp, '', 'ZonSubGerenVentaView']);
var zorgOidRegiDependeceMap = new Vector();
zorgOidRegiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zorgOidRegiDependeceMap.agregar(['zorgOidRegi', padresTmp, '', 'ZonRegioView']);
var zzonOidZonaDependeceMap = new Vector();
zzonOidZonaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zzonOidZonaDependeceMap.agregar(['zzonOidZona', padresTmp, '', 'ZonZonaView']);
var zsccOidSeccDependeceMap = new Vector();
zsccOidSeccDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zsccOidSeccDependeceMap.agregar(['zsccOidSecc', padresTmp, '', 'ZonSecciView']);
var terrOidTerrDependeceMap = new Vector();
terrOidTerrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
terrOidTerrDependeceMap.agregar(['terrOidTerr', padresTmp, '', 'ZonTerriView']);
var melcOidMetoLiquCobrDependeceMap = new Vector();
melcOidMetoLiquCobrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
melcOidMetoLiquCobrDependeceMap.agregar(['melcOidMetoLiquCobr', padresTmp, '', 'CobMetodLiquiView']);
var eucoOidEstaUsuaEtapCobrDependeceMap = new Vector();
eucoOidEstaUsuaEtapCobrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
eucoOidEstaUsuaEtapCobrDependeceMap.agregar(['eucoOidEstaUsuaEtapCobr', padresTmp, '', 'CobEstadUsuarEtapaCobra']);
var gacaOidGuioArguCabeDependeceMap = new Vector();
gacaOidGuioArguCabeDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
gacaOidGuioArguCabeDependeceMap.agregar(['gacaOidGuioArguCabe', padresTmp, '', 'CobGuionArgumCabecView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
cobUsuarEtapaCobraDetalLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cobUsuarEtapaCobraDetalTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function cobUsuarEtapaCobraDetalInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cobUsuarEtapaCobraDetalFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cobUsuarEtapaCobraDetalFrm.accion')){
		case "query": cobUsuarEtapaCobraDetalQueryInitComponents(); break;
		case "view": cobUsuarEtapaCobraDetalViewInitComponents(); break;
		case "create": cobUsuarEtapaCobraDetalCreateInitComponents(); break;
		case "update": cobUsuarEtapaCobraDetalUpdateInitComponents(); break;
		case "remove": cobUsuarEtapaCobraDetalRemoveInitComponents(); break;
		case "lov": cobUsuarEtapaCobraDetalLovInitComponents(); break;
	}
	//alert('accion :' + get('cobUsuarEtapaCobraDetalFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cobUsuarEtapaCobraDetalFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cobUsuarEtapaCobraDetal')) cobUsuarEtapaCobraDetalCmdRequery();
}

function cobUsuarEtapaCobraDetalQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	focusFirstField('cobUsuarEtapaCobraDetalFrm', true);	
}

function cobUsuarEtapaCobraDetalViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('cobUsuarEtapaCobraDetalFrm', true);
}

function cobUsuarEtapaCobraDetalCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cobUsuarEtapaCobraDetalFrm.ueccOidUsuaEtapCobr','S', GestionarMensaje('CobUsuarEtapaCobraDetal.ueccOidUsuaEtapCobr.requiered.message'));
	
	setMV('cobUsuarEtapaCobraDetalFrm.edtcOidEtapDeudTipoCarg','S', GestionarMensaje('CobUsuarEtapaCobraDetal.edtcOidEtapDeudTipoCarg.requiered.message'));
	
	setMV('cobUsuarEtapaCobraDetalFrm.zsgvOidSubgVent','S', GestionarMensaje('CobUsuarEtapaCobraDetal.zsgvOidSubgVent.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cobUsuarEtapaCobraDetalFrm', true);
}

function cobUsuarEtapaCobraDetalUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cobUsuarEtapaCobraDetalFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		cobUsuarEtapaCobraDetalTmpUpdateValues = cobUsuarEtapaCobraDetalBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cobUsuarEtapaCobraDetalFrm.ueccOidUsuaEtapCobr','S', GestionarMensaje('CobUsuarEtapaCobraDetal.ueccOidUsuaEtapCobr.requiered.message'));
		setMV('cobUsuarEtapaCobraDetalFrm.edtcOidEtapDeudTipoCarg','S', GestionarMensaje('CobUsuarEtapaCobraDetal.edtcOidEtapDeudTipoCarg.requiered.message'));
		setMV('cobUsuarEtapaCobraDetalFrm.zsgvOidSubgVent','S', GestionarMensaje('CobUsuarEtapaCobraDetal.zsgvOidSubgVent.requiered.message'));
		
			focusFirstFieldModify('cobUsuarEtapaCobraDetalFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		focusFirstField('cobUsuarEtapaCobraDetalFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cobUsuarEtapaCobraDetalFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cobUsuarEtapaCobraDetalRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cobUsuarEtapaCobraDetalList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cobUsuarEtapaCobraDetalFrm', true);
}

function cobUsuarEtapaCobraDetalLovInitComponents(){
	cobUsuarEtapaCobraDetalLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cobUsuarEtapaCobraDetalFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad














//Función que permite cargar los datos de un elemento de lov seleccionado
function cobUsuarEtapaCobraDetalSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cobUsuarEtapaCobraDetalFrm.' + campo, id);
	set('cobUsuarEtapaCobraDetalFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cobUsuarEtapaCobraDetalLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cobUsuarEtapaCobraDetalLovReturnParameters.id = '';
	cobUsuarEtapaCobraDetalLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cobUsuarEtapaCobraDetalLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobUsuarEtapaCobraDetalList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cobUsuarEtapaCobraDetalList.codSeleccionados();
	var descripcion = cobUsuarEtapaCobraDetalList.extraeDato(
		cobUsuarEtapaCobraDetalList.codSeleccionados()[0], cobUsuarEtapaCobraDetalChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cobUsuarEtapaCobraDetalLovReturnParameters.id = codigo;
	cobUsuarEtapaCobraDetalLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cobUsuarEtapaCobraDetalCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cobUsuarEtapaCobraDetalFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cobUsuarEtapaCobraDetalFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cobUsuarEtapaCobraDetalList", "CobUsuarEtapaCobraDetalConectorTransactionQuery", 
		"result_ROWSET", parametros, "cobUsuarEtapaCobraDetalPostQueryActions(datos);"]], "", "");	
}

function cobUsuarEtapaCobraDetalCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cobUsuarEtapaCobraDetalFrm.lastQueryToSession'));
	var i =0;
	set('cobUsuarEtapaCobraDetalFrm.ueccOidUsuaEtapCobr', [paramsRequery.ij(i++)]);
	
	set('cobUsuarEtapaCobraDetalFrm.edtcOidEtapDeudTipoCarg', [paramsRequery.ij(i++)]);
	
	set('cobUsuarEtapaCobraDetalFrm.zsgvOidSubgVent', [paramsRequery.ij(i++)]);
	
	set('cobUsuarEtapaCobraDetalFrm.zorgOidRegi', [paramsRequery.ij(i++)]);
	
	set('cobUsuarEtapaCobraDetalFrm.zzonOidZona', [paramsRequery.ij(i++)]);
	
	set('cobUsuarEtapaCobraDetalFrm.zsccOidSecc', [paramsRequery.ij(i++)]);
	
	set('cobUsuarEtapaCobraDetalFrm.terrOidTerr', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	cobUsuarEtapaCobraDetalPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cobUsuarEtapaCobraDetalCmdQuery(cobUsuarEtapaCobraDetalPageCount);
}

function cobUsuarEtapaCobraDetalFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cobUsuarEtapaCobraDetalPageCount = 1;
	cobUsuarEtapaCobraDetalCmdQuery(cobUsuarEtapaCobraDetalPageCount);
}

function cobUsuarEtapaCobraDetalPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobUsuarEtapaCobraDetalLastQuery){
		cobUsuarEtapaCobraDetalFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cobUsuarEtapaCobraDetalPageCount--;
	cobUsuarEtapaCobraDetalCmdQuery(cobUsuarEtapaCobraDetalPageCount);
}

function cobUsuarEtapaCobraDetalNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobUsuarEtapaCobraDetalLastQuery){
		cobUsuarEtapaCobraDetalFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cobUsuarEtapaCobraDetalPageCount++;
	cobUsuarEtapaCobraDetalCmdQuery(cobUsuarEtapaCobraDetalPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cobUsuarEtapaCobraDetalPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cobUsuarEtapaCobraDetalListLayer', 'O');
		visibilidad('cobUsuarEtapaCobraDetalListButtonsLayer', 'O');
		if(get('cobUsuarEtapaCobraDetalFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cobUsuarEtapaCobraDetalLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cobUsuarEtapaCobraDetalViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cobUsuarEtapaCobraDetalChoiceColumn) + "</A>",
			i, cobUsuarEtapaCobraDetalChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cobUsuarEtapaCobraDetalList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cobUsuarEtapaCobraDetalTimeStamps = datosTmp.filtrar([12],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cobUsuarEtapaCobraDetalMorePagesFlag = true;
		cobUsuarEtapaCobraDetalList.eliminar(mmgPageSize, 1);
	}else{
		cobUsuarEtapaCobraDetalMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cobUsuarEtapaCobraDetalFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cobUsuarEtapaCobraDetalListLayer', 'V');
	visibilidad('cobUsuarEtapaCobraDetalListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cobUsuarEtapaCobraDetalList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cobUsuarEtapaCobraDetalList.display();
	
	//Actualizamos el estado de los botones 
	if(cobUsuarEtapaCobraDetalMorePagesFlag){
		set_estado_botonera('cobUsuarEtapaCobraDetalPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cobUsuarEtapaCobraDetalPaginationButtonBar',
			3,"inactivo");
	}
	if(cobUsuarEtapaCobraDetalPageCount > 1){
		set_estado_botonera('cobUsuarEtapaCobraDetalPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cobUsuarEtapaCobraDetalPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cobUsuarEtapaCobraDetalPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cobUsuarEtapaCobraDetalPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cobUsuarEtapaCobraDetalUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobUsuarEtapaCobraDetalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cobUsuarEtapaCobraDetalFrm.idSelection', cobUsuarEtapaCobraDetalList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cobUsuarEtapaCobraDetalFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cobUsuarEtapaCobraDetalList.codSeleccionados()[0];
		parametros["previousAction"] = get('cobUsuarEtapaCobraDetalFrm.accion');
		parametros["accion"] = get('cobUsuarEtapaCobraDetalFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CobUsuarEtapaCobraDetalLPStartUp', get('cobUsuarEtapaCobraDetalFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cobUsuarEtapaCobraDetalCmdRequery();
	}
}

function cobUsuarEtapaCobraDetalRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobUsuarEtapaCobraDetalList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cobUsuarEtapaCobraDetalList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cobUsuarEtapaCobraDetalFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cobUsuarEtapaCobraDetalList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cobUsuarEtapaCobraDetalTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cobUsuarEtapaCobraDetalFrm.timestamp', timestamps);


	cobUsuarEtapaCobraDetalFrm.oculto='S';
	envia('cobUsuarEtapaCobraDetalFrm');
	cobUsuarEtapaCobraDetalFrm.oculto='N';
}

function cobUsuarEtapaCobraDetalViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobUsuarEtapaCobraDetalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cobUsuarEtapaCobraDetalViewDetail(cobUsuarEtapaCobraDetalList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cobUsuarEtapaCobraDetalViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cobUsuarEtapaCobraDetalFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CobUsuarEtapaCobraDetalLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('cobUsuarEtapaCobraDetalFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		cobUsuarEtapaCobraDetalFrm.oculto='S';
		envia('cobUsuarEtapaCobraDetalFrm');
		cobUsuarEtapaCobraDetalFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cobUsuarEtapaCobraDetalFrm.ueccOidUsuaEtapCobr').toString() == ''){
		set('cobUsuarEtapaCobraDetalFrm.ueccOidUsuaEtapCobr', []);
		mmgResetCombosOnCascade('ueccOidUsuaEtapCobr', 'ueccOidUsuaEtapCobr', 'cobUsuarEtapaCobraDetal');
		
	}
	if(get('cobUsuarEtapaCobraDetalFrm.edtcOidEtapDeudTipoCarg').toString() == ''){
		set('cobUsuarEtapaCobraDetalFrm.edtcOidEtapDeudTipoCarg', []);
		mmgResetCombosOnCascade('edtcOidEtapDeudTipoCarg', 'edtcOidEtapDeudTipoCarg', 'cobUsuarEtapaCobraDetal');
		
	}
	if(get('cobUsuarEtapaCobraDetalFrm.zsgvOidSubgVent').toString() == ''){
		set('cobUsuarEtapaCobraDetalFrm.zsgvOidSubgVent', []);
		mmgResetCombosOnCascade('zsgvOidSubgVent', 'zsgvOidSubgVent', 'cobUsuarEtapaCobraDetal');
		
	}
	if(get('cobUsuarEtapaCobraDetalFrm.zorgOidRegi').toString() == ''){
		set('cobUsuarEtapaCobraDetalFrm.zorgOidRegi', []);
		mmgResetCombosOnCascade('zorgOidRegi', 'zorgOidRegi', 'cobUsuarEtapaCobraDetal');
		
	}
	if(get('cobUsuarEtapaCobraDetalFrm.zzonOidZona').toString() == ''){
		set('cobUsuarEtapaCobraDetalFrm.zzonOidZona', []);
		mmgResetCombosOnCascade('zzonOidZona', 'zzonOidZona', 'cobUsuarEtapaCobraDetal');
		
	}
	if(get('cobUsuarEtapaCobraDetalFrm.zsccOidSecc').toString() == ''){
		set('cobUsuarEtapaCobraDetalFrm.zsccOidSecc', []);
		mmgResetCombosOnCascade('zsccOidSecc', 'zsccOidSecc', 'cobUsuarEtapaCobraDetal');
		
	}
	if(get('cobUsuarEtapaCobraDetalFrm.terrOidTerr').toString() == ''){
		set('cobUsuarEtapaCobraDetalFrm.terrOidTerr', []);
		mmgResetCombosOnCascade('terrOidTerr', 'terrOidTerr', 'cobUsuarEtapaCobraDetal');
		
	}
	if(get('cobUsuarEtapaCobraDetalFrm.melcOidMetoLiquCobr').toString() == ''){
		set('cobUsuarEtapaCobraDetalFrm.melcOidMetoLiquCobr', []);
		mmgResetCombosOnCascade('melcOidMetoLiquCobr', 'melcOidMetoLiquCobr', 'cobUsuarEtapaCobraDetal');
		
	}
	if(get('cobUsuarEtapaCobraDetalFrm.eucoOidEstaUsuaEtapCobr').toString() == ''){
		set('cobUsuarEtapaCobraDetalFrm.eucoOidEstaUsuaEtapCobr', []);
		mmgResetCombosOnCascade('eucoOidEstaUsuaEtapCobr', 'eucoOidEstaUsuaEtapCobr', 'cobUsuarEtapaCobraDetal');
		
	}
	if(get('cobUsuarEtapaCobraDetalFrm.gacaOidGuioArguCabe').toString() == ''){
		set('cobUsuarEtapaCobraDetalFrm.gacaOidGuioArguCabe', []);
		mmgResetCombosOnCascade('gacaOidGuioArguCabe', 'gacaOidGuioArguCabe', 'cobUsuarEtapaCobraDetal');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cobUsuarEtapaCobraDetalRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cobUsuarEtapaCobraDetalFrm.accion');
	var origenTmp = get('cobUsuarEtapaCobraDetalFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cobUsuarEtapaCobraDetalBuildUpdateRecordString() != cobUsuarEtapaCobraDetalTmpUpdateValues){
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
	document.all.cobUsuarEtapaCobraDetalListLayer.style.display='none';
	document.all.cobUsuarEtapaCobraDetalListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cobUsuarEtapaCobraDetalListLayer.style.display='';
	document.all.cobUsuarEtapaCobraDetalListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCobUsuarEtapaCobraDetalUeccOidUsuaEtapCobr = get('cobUsuarEtapaCobraDetalFrm.ueccOidUsuaEtapCobr')[0];
	jsCobUsuarEtapaCobraDetalEdtcOidEtapDeudTipoCarg = get('cobUsuarEtapaCobraDetalFrm.edtcOidEtapDeudTipoCarg')[0];
	jsCobUsuarEtapaCobraDetalZsgvOidSubgVent = get('cobUsuarEtapaCobraDetalFrm.zsgvOidSubgVent')[0];
	jsCobUsuarEtapaCobraDetalZorgOidRegi = get('cobUsuarEtapaCobraDetalFrm.zorgOidRegi')[0];
	jsCobUsuarEtapaCobraDetalZzonOidZona = get('cobUsuarEtapaCobraDetalFrm.zzonOidZona')[0];
	jsCobUsuarEtapaCobraDetalZsccOidSecc = get('cobUsuarEtapaCobraDetalFrm.zsccOidSecc')[0];
	jsCobUsuarEtapaCobraDetalTerrOidTerr = get('cobUsuarEtapaCobraDetalFrm.terrOidTerr')[0];
	
	
	var parametros = "";
	parametros += jsCobUsuarEtapaCobraDetalUeccOidUsuaEtapCobr + "|";
	parametros += jsCobUsuarEtapaCobraDetalEdtcOidEtapDeudTipoCarg + "|";
	parametros += jsCobUsuarEtapaCobraDetalZsgvOidSubgVent + "|";
	parametros += jsCobUsuarEtapaCobraDetalZorgOidRegi + "|";
	parametros += jsCobUsuarEtapaCobraDetalZzonOidZona + "|";
	parametros += jsCobUsuarEtapaCobraDetalZsccOidSecc + "|";
	parametros += jsCobUsuarEtapaCobraDetalTerrOidTerr + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cobUsuarEtapaCobraDetalBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCobUsuarEtapaCobraDetalUeccOidUsuaEtapCobr + "|";
	parametros += jsCobUsuarEtapaCobraDetalEdtcOidEtapDeudTipoCarg + "|";
	parametros += jsCobUsuarEtapaCobraDetalZsgvOidSubgVent + "|";
	parametros += jsCobUsuarEtapaCobraDetalZorgOidRegi + "|";
	parametros += jsCobUsuarEtapaCobraDetalZzonOidZona + "|";
	parametros += jsCobUsuarEtapaCobraDetalZsccOidSecc + "|";
	parametros += jsCobUsuarEtapaCobraDetalTerrOidTerr + "|";
	parametros += jsCobUsuarEtapaCobraDetalMelcOidMetoLiquCobr + "|";
	parametros += jsCobUsuarEtapaCobraDetalEucoOidEstaUsuaEtapCobr + "|";
	parametros += jsCobUsuarEtapaCobraDetalGacaOidGuioArguCabe + "|";
	parametros += jsCobUsuarEtapaCobraDetalValObse + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobUsuarEtapaCobraDetalFrm.accion'), 
		get('cobUsuarEtapaCobraDetalFrm.origen'));
	
	jsCobUsuarEtapaCobraDetalId = get('cobUsuarEtapaCobraDetalFrm.id').toString();
	jsCobUsuarEtapaCobraDetalUeccOidUsuaEtapCobr = get('cobUsuarEtapaCobraDetalFrm.ueccOidUsuaEtapCobr')[0];
	jsCobUsuarEtapaCobraDetalEdtcOidEtapDeudTipoCarg = get('cobUsuarEtapaCobraDetalFrm.edtcOidEtapDeudTipoCarg')[0];
	jsCobUsuarEtapaCobraDetalZsgvOidSubgVent = get('cobUsuarEtapaCobraDetalFrm.zsgvOidSubgVent')[0];
	jsCobUsuarEtapaCobraDetalZorgOidRegi = get('cobUsuarEtapaCobraDetalFrm.zorgOidRegi')[0];
	jsCobUsuarEtapaCobraDetalZzonOidZona = get('cobUsuarEtapaCobraDetalFrm.zzonOidZona')[0];
	jsCobUsuarEtapaCobraDetalZsccOidSecc = get('cobUsuarEtapaCobraDetalFrm.zsccOidSecc')[0];
	jsCobUsuarEtapaCobraDetalTerrOidTerr = get('cobUsuarEtapaCobraDetalFrm.terrOidTerr')[0];
	jsCobUsuarEtapaCobraDetalMelcOidMetoLiquCobr = get('cobUsuarEtapaCobraDetalFrm.melcOidMetoLiquCobr')[0];
	jsCobUsuarEtapaCobraDetalEucoOidEstaUsuaEtapCobr = get('cobUsuarEtapaCobraDetalFrm.eucoOidEstaUsuaEtapCobr')[0];
	jsCobUsuarEtapaCobraDetalGacaOidGuioArguCabe = get('cobUsuarEtapaCobraDetalFrm.gacaOidGuioArguCabe')[0];
	jsCobUsuarEtapaCobraDetalValObse = get('cobUsuarEtapaCobraDetalFrm.valObse').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobUsuarEtapaCobraDetalFrm.accion'), 
		get('cobUsuarEtapaCobraDetalFrm.origen'));


	set('cobUsuarEtapaCobraDetalFrm.id', jsCobUsuarEtapaCobraDetalId);
	set('cobUsuarEtapaCobraDetalFrm.ueccOidUsuaEtapCobr', [jsCobUsuarEtapaCobraDetalUeccOidUsuaEtapCobr]);
	set('cobUsuarEtapaCobraDetalFrm.edtcOidEtapDeudTipoCarg', [jsCobUsuarEtapaCobraDetalEdtcOidEtapDeudTipoCarg]);
	set('cobUsuarEtapaCobraDetalFrm.zsgvOidSubgVent', [jsCobUsuarEtapaCobraDetalZsgvOidSubgVent]);
	set('cobUsuarEtapaCobraDetalFrm.zorgOidRegi', [jsCobUsuarEtapaCobraDetalZorgOidRegi]);
	set('cobUsuarEtapaCobraDetalFrm.zzonOidZona', [jsCobUsuarEtapaCobraDetalZzonOidZona]);
	set('cobUsuarEtapaCobraDetalFrm.zsccOidSecc', [jsCobUsuarEtapaCobraDetalZsccOidSecc]);
	set('cobUsuarEtapaCobraDetalFrm.terrOidTerr', [jsCobUsuarEtapaCobraDetalTerrOidTerr]);
	set('cobUsuarEtapaCobraDetalFrm.melcOidMetoLiquCobr', [jsCobUsuarEtapaCobraDetalMelcOidMetoLiquCobr]);
	set('cobUsuarEtapaCobraDetalFrm.eucoOidEstaUsuaEtapCobr', [jsCobUsuarEtapaCobraDetalEucoOidEstaUsuaEtapCobr]);
	set('cobUsuarEtapaCobraDetalFrm.gacaOidGuioArguCabe', [jsCobUsuarEtapaCobraDetalGacaOidGuioArguCabe]);
	set('cobUsuarEtapaCobraDetalFrm.valObse', jsCobUsuarEtapaCobraDetalValObse);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCobUsuarEtapaCobraDetalUeccOidUsuaEtapCobr = '';
	jsCobUsuarEtapaCobraDetalEdtcOidEtapDeudTipoCarg = '';
	jsCobUsuarEtapaCobraDetalZsgvOidSubgVent = '';
	jsCobUsuarEtapaCobraDetalZorgOidRegi = '';
	jsCobUsuarEtapaCobraDetalZzonOidZona = '';
	jsCobUsuarEtapaCobraDetalZsccOidSecc = '';
	jsCobUsuarEtapaCobraDetalTerrOidTerr = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cobUsuarEtapaCobraDetalFrm.errCodigo', errorCode);
	set('cobUsuarEtapaCobraDetalFrm.errDescripcion', description);
	set('cobUsuarEtapaCobraDetalFrm.errSeverity', severity);
	fMostrarMensajeError();
}



/*
    INDRA/CAR/mmg
    $Id: cobetapadeuda.js,v 1.1 2009/12/03 19:01:32 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCobEtapaDeudaId = "";
var jsCobEtapaDeudaCodEtapDeud = "";
var jsCobEtapaDeudaValDesc = "";
var jsCobEtapaDeudaIndExcl = "";
var jsCobEtapaDeudaValEdadInic = "";
var jsCobEtapaDeudaValEdadFina = "";
var jsCobEtapaDeudaIndTelf = "";
var jsCobEtapaDeudaImpDesd = "";
var jsCobEtapaDeudaImpHast = "";
var jsCobEtapaDeudaNumDiasGracCompPago = "";
var jsCobEtapaDeudaValPorcIncu = "";
var jsCobEtapaDeudaMensOidMens = "";
var jsCobEtapaDeudaMelcOidMetoLiquCobr = "";
var jsCobEtapaDeudaTbalOidTipoBala = "";
var jsCobEtapaDeudaGacaOidGuioArguCabe = "";
var jsCobEtapaDeudaPaisOidPais = "";
var jsCobEtapaDeudaOredOidEtapDeu1 = "";
var jsCobEtapaDeudaOredOidEtapDeu2 = "";
var jsCobEtapaDeudaOredOidEtapDeu3 = "";

//Variables de paginacion, 
var cobEtapaDeudaPageCount = 1;

//Varible de columna que representa el campo de choice
var cobEtapaDeudaChoiceColumn = 1;

//Flag de siguiente pagina;
var cobEtapaDeudaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cobEtapaDeudaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 231;
var sizeFormView = 791;
var sizeFormUpdate = 791;

//Ultima busqueda realizada
var cobEtapaDeudaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("cobEtapaDeudaFrm.codEtapDeud");','focaliza("cobEtapaDeudaFrm.codEtapDeud");','focaliza("cobEtapaDeudaFrm.codEtapDeud");','focaliza("cobEtapaDeudaFrm.codEtapDeud");','focaliza("cobEtapaDeudaFrm.codEtapDeud");','focaliza("cobEtapaDeudaFrm.codEtapDeud");'],[3,'focaliza("cobEtapaDeudaFrm.valDesc");','focaliza("cobEtapaDeudaFrm.valDesc");','focaliza("cobEtapaDeudaFrm.valDesc");','focaliza("cobEtapaDeudaFrm.valDesc");','focaliza("cobEtapaDeudaFrm.valDesc");','focaliza("cobEtapaDeudaFrm.valDesc");'],[4,'','focaliza("cobEtapaDeudaFrm.indExcl");','focaliza("cobEtapaDeudaFrm.indExcl");','','focaliza("cobEtapaDeudaFrm.indExcl");','focaliza("cobEtapaDeudaFrm.indExcl");'],[5,'focaliza("cobEtapaDeudaFrm.valEdadInic");','focaliza("cobEtapaDeudaFrm.valEdadInic");','focaliza("cobEtapaDeudaFrm.valEdadInic");','focaliza("cobEtapaDeudaFrm.valEdadInic");','focaliza("cobEtapaDeudaFrm.valEdadInic");','focaliza("cobEtapaDeudaFrm.valEdadInic");'],[6,'focaliza("cobEtapaDeudaFrm.valEdadFina");','focaliza("cobEtapaDeudaFrm.valEdadFina");','focaliza("cobEtapaDeudaFrm.valEdadFina");','focaliza("cobEtapaDeudaFrm.valEdadFina");','focaliza("cobEtapaDeudaFrm.valEdadFina");','focaliza("cobEtapaDeudaFrm.valEdadFina");'],[7,'','focaliza("cobEtapaDeudaFrm.indTelf");','focaliza("cobEtapaDeudaFrm.indTelf");','','focaliza("cobEtapaDeudaFrm.indTelf");','focaliza("cobEtapaDeudaFrm.indTelf");'],[8,'','focaliza("cobEtapaDeudaFrm.impDesd");','focaliza("cobEtapaDeudaFrm.impDesd");','','focaliza("cobEtapaDeudaFrm.impDesd");','focaliza("cobEtapaDeudaFrm.impDesd");'],[9,'','focaliza("cobEtapaDeudaFrm.impHast");','focaliza("cobEtapaDeudaFrm.impHast");','','focaliza("cobEtapaDeudaFrm.impHast");','focaliza("cobEtapaDeudaFrm.impHast");'],[10,'','focaliza("cobEtapaDeudaFrm.numDiasGracCompPago");','focaliza("cobEtapaDeudaFrm.numDiasGracCompPago");','','focaliza("cobEtapaDeudaFrm.numDiasGracCompPago");','focaliza("cobEtapaDeudaFrm.numDiasGracCompPago");'],[11,'','focaliza("cobEtapaDeudaFrm.valPorcIncu");','focaliza("cobEtapaDeudaFrm.valPorcIncu");','','focaliza("cobEtapaDeudaFrm.valPorcIncu");','focaliza("cobEtapaDeudaFrm.valPorcIncu");'],[12,'','focalizaComboDependence("cobEtapaDeuda","mensOidMens", false);','focalizaComboDependence("cobEtapaDeuda","mensOidMens", false);','','focalizaComboDependence("cobEtapaDeuda","mensOidMens", true);','focalizaComboDependence("cobEtapaDeuda","mensOidMens", true);'],[13,'','focalizaComboDependence("cobEtapaDeuda","melcOidMetoLiquCobr", false);','focalizaComboDependence("cobEtapaDeuda","melcOidMetoLiquCobr", false);','','focalizaComboDependence("cobEtapaDeuda","melcOidMetoLiquCobr", true);','focalizaComboDependence("cobEtapaDeuda","melcOidMetoLiquCobr", true);'],[14,'','focalizaComboDependence("cobEtapaDeuda","tbalOidTipoBala", false);','focalizaComboDependence("cobEtapaDeuda","tbalOidTipoBala", false);','','focalizaComboDependence("cobEtapaDeuda","tbalOidTipoBala", true);','focalizaComboDependence("cobEtapaDeuda","tbalOidTipoBala", true);'],[15,'','focalizaComboDependence("cobEtapaDeuda","gacaOidGuioArguCabe", false);','focalizaComboDependence("cobEtapaDeuda","gacaOidGuioArguCabe", false);','','focalizaComboDependence("cobEtapaDeuda","gacaOidGuioArguCabe", true);','focalizaComboDependence("cobEtapaDeuda","gacaOidGuioArguCabe", true);'],[16,'','','','','',''],[17,'','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu1", false);','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu1", false);','','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu1", true);','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu1", true);'],[18,'','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu2", false);','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu2", false);','','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu2", true);','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu2", true);'],[19,'','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu3", false);','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu3", false);','','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu3", true);','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu3", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("cobEtapaDeudaFrm.valDesc");','focaliza("cobEtapaDeudaFrm.valDesc");','focaliza("cobEtapaDeudaFrm.valDesc");','focaliza("cobEtapaDeudaFrm.valDesc");','focaliza("cobEtapaDeudaFrm.valDesc");','focaliza("cobEtapaDeudaFrm.valDesc");'],[4,'','focaliza("cobEtapaDeudaFrm.indExcl");','focaliza("cobEtapaDeudaFrm.indExcl");','','focaliza("cobEtapaDeudaFrm.indExcl");','focaliza("cobEtapaDeudaFrm.indExcl");'],[5,'focaliza("cobEtapaDeudaFrm.valEdadInic");','focaliza("cobEtapaDeudaFrm.valEdadInic");','focaliza("cobEtapaDeudaFrm.valEdadInic");','focaliza("cobEtapaDeudaFrm.valEdadInic");','focaliza("cobEtapaDeudaFrm.valEdadInic");','focaliza("cobEtapaDeudaFrm.valEdadInic");'],[6,'focaliza("cobEtapaDeudaFrm.valEdadFina");','focaliza("cobEtapaDeudaFrm.valEdadFina");','focaliza("cobEtapaDeudaFrm.valEdadFina");','focaliza("cobEtapaDeudaFrm.valEdadFina");','focaliza("cobEtapaDeudaFrm.valEdadFina");','focaliza("cobEtapaDeudaFrm.valEdadFina");'],[7,'','focaliza("cobEtapaDeudaFrm.indTelf");','focaliza("cobEtapaDeudaFrm.indTelf");','','focaliza("cobEtapaDeudaFrm.indTelf");','focaliza("cobEtapaDeudaFrm.indTelf");'],[8,'','focaliza("cobEtapaDeudaFrm.impDesd");','focaliza("cobEtapaDeudaFrm.impDesd");','','focaliza("cobEtapaDeudaFrm.impDesd");','focaliza("cobEtapaDeudaFrm.impDesd");'],[9,'','focaliza("cobEtapaDeudaFrm.impHast");','focaliza("cobEtapaDeudaFrm.impHast");','','focaliza("cobEtapaDeudaFrm.impHast");','focaliza("cobEtapaDeudaFrm.impHast");'],[10,'','focaliza("cobEtapaDeudaFrm.numDiasGracCompPago");','focaliza("cobEtapaDeudaFrm.numDiasGracCompPago");','','focaliza("cobEtapaDeudaFrm.numDiasGracCompPago");','focaliza("cobEtapaDeudaFrm.numDiasGracCompPago");'],[11,'','focaliza("cobEtapaDeudaFrm.valPorcIncu");','focaliza("cobEtapaDeudaFrm.valPorcIncu");','','focaliza("cobEtapaDeudaFrm.valPorcIncu");','focaliza("cobEtapaDeudaFrm.valPorcIncu");'],[12,'','focalizaComboDependence("cobEtapaDeuda","mensOidMens", false);','focalizaComboDependence("cobEtapaDeuda","mensOidMens", false);','','focalizaComboDependence("cobEtapaDeuda","mensOidMens", true);','focalizaComboDependence("cobEtapaDeuda","mensOidMens", true);'],[13,'','focalizaComboDependence("cobEtapaDeuda","melcOidMetoLiquCobr", false);','focalizaComboDependence("cobEtapaDeuda","melcOidMetoLiquCobr", false);','','focalizaComboDependence("cobEtapaDeuda","melcOidMetoLiquCobr", true);','focalizaComboDependence("cobEtapaDeuda","melcOidMetoLiquCobr", true);'],[14,'','focalizaComboDependence("cobEtapaDeuda","tbalOidTipoBala", false);','focalizaComboDependence("cobEtapaDeuda","tbalOidTipoBala", false);','','focalizaComboDependence("cobEtapaDeuda","tbalOidTipoBala", true);','focalizaComboDependence("cobEtapaDeuda","tbalOidTipoBala", true);'],[15,'','focalizaComboDependence("cobEtapaDeuda","gacaOidGuioArguCabe", false);','focalizaComboDependence("cobEtapaDeuda","gacaOidGuioArguCabe", false);','','focalizaComboDependence("cobEtapaDeuda","gacaOidGuioArguCabe", true);','focalizaComboDependence("cobEtapaDeuda","gacaOidGuioArguCabe", true);'],[16,'','','','','',''],[17,'','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu1", false);','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu1", false);','','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu1", true);','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu1", true);'],[18,'','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu2", false);','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu2", false);','','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu2", true);','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu2", true);'],[19,'','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu3", false);','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu3", false);','','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu3", true);','focalizaComboDependence("cobEtapaDeuda","oredOidEtapDeu3", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var mensOidMensDependeceMap = new Vector();
mensOidMensDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
mensOidMensDependeceMap.agregar(['mensOidMens', padresTmp, '', 'MsgMensa']);
var melcOidMetoLiquCobrDependeceMap = new Vector();
melcOidMetoLiquCobrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
melcOidMetoLiquCobrDependeceMap.agregar(['melcOidMetoLiquCobr', padresTmp, '', 'CobMetodLiquiView']);
var tbalOidTipoBalaDependeceMap = new Vector();
tbalOidTipoBalaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tbalOidTipoBalaDependeceMap.agregar(['tbalOidTipoBala', padresTmp, '', 'CobTipoBalan']);
var gacaOidGuioArguCabeDependeceMap = new Vector();
gacaOidGuioArguCabeDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
gacaOidGuioArguCabeDependeceMap.agregar(['gacaOidGuioArguCabe', padresTmp, '', 'CobGuionArgumCabecView']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);
var oredOidEtapDeu1DependeceMap = new Vector();
oredOidEtapDeu1DependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
oredOidEtapDeu1DependeceMap.agregar(['oredOidEtapDeu1', padresTmp, '', 'CobOrdenEtapaDeuda']);
var oredOidEtapDeu2DependeceMap = new Vector();
oredOidEtapDeu2DependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
oredOidEtapDeu2DependeceMap.agregar(['oredOidEtapDeu2', padresTmp, '', 'CobOrdenEtapaDeuda']);
var oredOidEtapDeu3DependeceMap = new Vector();
oredOidEtapDeu3DependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
oredOidEtapDeu3DependeceMap.agregar(['oredOidEtapDeu3', padresTmp, '', 'CobOrdenEtapaDeuda']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
cobEtapaDeudaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cobEtapaDeudaTmpUpdateValues;


		//funcion para valEdadFina y su validación con valEdadInic
		function validacionvalEdadFinavalEdadInic(){
			if ((get('cobEtapaDeudaFrm.valEdadFina','T').toString()=="") || 
			(get('cobEtapaDeudaFrm.valEdadInic','T').toString()==""))
				//en este caso no hay alguno de los valores introducidos y no se puede realizar la verificación.
				return 'OK';
			if (!(parseFloat(get('cobEtapaDeudaFrm.valEdadFina','T').toString())>=parseFloat(get('cobEtapaDeudaFrm.valEdadInic','T').toString()))) {
				//mensaje de error internacionalizable
				return GestionarMensaje("CobEtapaDeuda.valEdadFinavalEdadInic.message");
			}
			else
				return 'OK';
		}
		
		//funcion para impHast y su validación con impDesd
		function validacionimpHastimpDesd(){
			if ((get('cobEtapaDeudaFrm.impHast','T').toString()=="") || 
			(get('cobEtapaDeudaFrm.impDesd','T').toString()==""))
				//en este caso no hay alguno de los valores introducidos y no se puede realizar la verificación.
				return 'OK';
			if (!(parseFloat(get('cobEtapaDeudaFrm.impHast','T').toString())>=parseFloat(get('cobEtapaDeudaFrm.impDesd','T').toString()))) {
				//mensaje de error internacionalizable
				return GestionarMensaje("CobEtapaDeuda.impHastimpDesd.message");
			}
			else
				return 'OK';
		}
		

//Función ejecutada en el onload de la pagina
function cobEtapaDeudaInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cobEtapaDeudaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cobEtapaDeudaFrm.accion')){
		case "query": cobEtapaDeudaQueryInitComponents(); break;
		case "view": cobEtapaDeudaViewInitComponents(); break;
		case "create": cobEtapaDeudaCreateInitComponents(); break;
		case "update": cobEtapaDeudaUpdateInitComponents(); break;
		case "remove": cobEtapaDeudaRemoveInitComponents(); break;
		case "lov": cobEtapaDeudaLovInitComponents(); break;
	}
	//alert('accion :' + get('cobEtapaDeudaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cobEtapaDeudaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cobEtapaDeuda')) cobEtapaDeudaCmdRequery();
}

function cobEtapaDeudaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	focusFirstField('cobEtapaDeudaFrm', true);	
}

function cobEtapaDeudaViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	//Establecemos el valor de los radiobuttons
		set('cobEtapaDeudaFrm.indExcl', get('cobEtapaDeudaFrm.indExclCheckValue'));
		set('cobEtapaDeudaFrm.indTelf', get('cobEtapaDeudaFrm.indTelfCheckValue'));
		
	focusFirstField('cobEtapaDeudaFrm', true);
}

function cobEtapaDeudaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cobEtapaDeudaFrm.codEtapDeud','S', GestionarMensaje('CobEtapaDeuda.codEtapDeud.requiered.message'));
	
	setMV('cobEtapaDeudaFrm.valDesc','S', GestionarMensaje('CobEtapaDeuda.valDesc.requiered.message'));
	
	setMV('cobEtapaDeudaFrm.valEdadInic','S', GestionarMensaje('CobEtapaDeuda.valEdadInic.requiered.message'));
	
	setMV('cobEtapaDeudaFrm.valEdadFina','S', GestionarMensaje('CobEtapaDeuda.valEdadFina.requiered.message'));
	
	setMV('cobEtapaDeudaFrm.indTelf','S', GestionarMensaje('CobEtapaDeuda.indTelf.requiered.message'));
	
	setMV('cobEtapaDeudaFrm.impDesd','S', GestionarMensaje('CobEtapaDeuda.impDesd.requiered.message'));
	
	setMV('cobEtapaDeudaFrm.impHast','S', GestionarMensaje('CobEtapaDeuda.impHast.requiered.message'));
	
	setMV('cobEtapaDeudaFrm.numDiasGracCompPago','S', GestionarMensaje('CobEtapaDeuda.numDiasGracCompPago.requiered.message'));
	
	setMV('cobEtapaDeudaFrm.valPorcIncu','S', GestionarMensaje('CobEtapaDeuda.valPorcIncu.requiered.message'));
	
	setMV('cobEtapaDeudaFrm.oredOidEtapDeu1','S', GestionarMensaje('CobEtapaDeuda.oredOidEtapDeu1.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cobEtapaDeudaFrm', true);
}

function cobEtapaDeudaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cobEtapaDeudaFrm.origen') == "pagina"){
		

		//Establecemos el valor de los radiobuttons
			set('cobEtapaDeudaFrm.indExcl', get('cobEtapaDeudaFrm.indExclCheckValue'));
			set('cobEtapaDeudaFrm.indTelf', get('cobEtapaDeudaFrm.indTelfCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		cobEtapaDeudaTmpUpdateValues = cobEtapaDeudaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cobEtapaDeudaFrm.codEtapDeud','S', GestionarMensaje('CobEtapaDeuda.codEtapDeud.requiered.message'));
		setMV('cobEtapaDeudaFrm.valDesc','S', GestionarMensaje('CobEtapaDeuda.valDesc.requiered.message'));
		setMV('cobEtapaDeudaFrm.valEdadInic','S', GestionarMensaje('CobEtapaDeuda.valEdadInic.requiered.message'));
		setMV('cobEtapaDeudaFrm.valEdadFina','S', GestionarMensaje('CobEtapaDeuda.valEdadFina.requiered.message'));
		setMV('cobEtapaDeudaFrm.indTelf','S', GestionarMensaje('CobEtapaDeuda.indTelf.requiered.message'));
		setMV('cobEtapaDeudaFrm.impDesd','S', GestionarMensaje('CobEtapaDeuda.impDesd.requiered.message'));
		setMV('cobEtapaDeudaFrm.impHast','S', GestionarMensaje('CobEtapaDeuda.impHast.requiered.message'));
		setMV('cobEtapaDeudaFrm.numDiasGracCompPago','S', GestionarMensaje('CobEtapaDeuda.numDiasGracCompPago.requiered.message'));
		setMV('cobEtapaDeudaFrm.valPorcIncu','S', GestionarMensaje('CobEtapaDeuda.valPorcIncu.requiered.message'));
		setMV('cobEtapaDeudaFrm.oredOidEtapDeu1','S', GestionarMensaje('CobEtapaDeuda.oredOidEtapDeu1.requiered.message'));
		
			focusFirstFieldModify('cobEtapaDeudaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		focusFirstField('cobEtapaDeudaFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cobEtapaDeudaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cobEtapaDeudaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cobEtapaDeudaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cobEtapaDeudaFrm', true);
}

function cobEtapaDeudaLovInitComponents(){
	cobEtapaDeudaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cobEtapaDeudaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad





















//Función que permite cargar los datos de un elemento de lov seleccionado
function cobEtapaDeudaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cobEtapaDeudaFrm.' + campo, id);
	set('cobEtapaDeudaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cobEtapaDeudaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cobEtapaDeudaLovReturnParameters.id = '';
	cobEtapaDeudaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cobEtapaDeudaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobEtapaDeudaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cobEtapaDeudaList.codSeleccionados();
	var descripcion = cobEtapaDeudaList.extraeDato(
		cobEtapaDeudaList.codSeleccionados()[0], cobEtapaDeudaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cobEtapaDeudaLovReturnParameters.id = codigo;
	cobEtapaDeudaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cobEtapaDeudaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cobEtapaDeudaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cobEtapaDeudaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cobEtapaDeudaList", "CobEtapaDeudaConectorTransactionQuery", 
		"result_ROWSET", parametros, "cobEtapaDeudaPostQueryActions(datos);"]], "", "");	
}

function cobEtapaDeudaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cobEtapaDeudaFrm.lastQueryToSession'));
	var i =0;
	set('cobEtapaDeudaFrm.codEtapDeud', paramsRequery.ij(i++));
	
	set('cobEtapaDeudaFrm.valDesc', paramsRequery.ij(i++));
	
	set('cobEtapaDeudaFrm.valEdadInic', paramsRequery.ij(i++));
	
	set('cobEtapaDeudaFrm.valEdadFina', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	cobEtapaDeudaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cobEtapaDeudaCmdQuery(cobEtapaDeudaPageCount);
}

function cobEtapaDeudaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cobEtapaDeudaPageCount = 1;
	cobEtapaDeudaCmdQuery(cobEtapaDeudaPageCount);
}

function cobEtapaDeudaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobEtapaDeudaLastQuery){
		cobEtapaDeudaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cobEtapaDeudaPageCount--;
	cobEtapaDeudaCmdQuery(cobEtapaDeudaPageCount);
}

function cobEtapaDeudaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobEtapaDeudaLastQuery){
		cobEtapaDeudaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cobEtapaDeudaPageCount++;
	cobEtapaDeudaCmdQuery(cobEtapaDeudaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cobEtapaDeudaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cobEtapaDeudaListLayer', 'O');
		visibilidad('cobEtapaDeudaListButtonsLayer', 'O');
		if(get('cobEtapaDeudaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cobEtapaDeudaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cobEtapaDeudaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cobEtapaDeudaChoiceColumn) + "</A>",
			i, cobEtapaDeudaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cobEtapaDeudaList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cobEtapaDeudaTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cobEtapaDeudaMorePagesFlag = true;
		cobEtapaDeudaList.eliminar(mmgPageSize, 1);
	}else{
		cobEtapaDeudaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cobEtapaDeudaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cobEtapaDeudaListLayer', 'V');
	visibilidad('cobEtapaDeudaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cobEtapaDeudaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cobEtapaDeudaList.display();
	
	//Actualizamos el estado de los botones 
	if(cobEtapaDeudaMorePagesFlag){
		set_estado_botonera('cobEtapaDeudaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cobEtapaDeudaPaginationButtonBar',
			3,"inactivo");
	}
	if(cobEtapaDeudaPageCount > 1){
		set_estado_botonera('cobEtapaDeudaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cobEtapaDeudaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cobEtapaDeudaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cobEtapaDeudaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cobEtapaDeudaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobEtapaDeudaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cobEtapaDeudaFrm.idSelection', cobEtapaDeudaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cobEtapaDeudaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cobEtapaDeudaList.codSeleccionados()[0];
		parametros["previousAction"] = get('cobEtapaDeudaFrm.accion');
		parametros["accion"] = get('cobEtapaDeudaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CobEtapaDeudaLPStartUp', get('cobEtapaDeudaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cobEtapaDeudaCmdRequery();
	}
}

function cobEtapaDeudaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobEtapaDeudaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cobEtapaDeudaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cobEtapaDeudaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cobEtapaDeudaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cobEtapaDeudaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cobEtapaDeudaFrm.timestamp', timestamps);


	cobEtapaDeudaFrm.oculto='S';
	envia('cobEtapaDeudaFrm');
	cobEtapaDeudaFrm.oculto='N';
}

function cobEtapaDeudaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobEtapaDeudaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cobEtapaDeudaViewDetail(cobEtapaDeudaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cobEtapaDeudaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cobEtapaDeudaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CobEtapaDeudaLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('cobEtapaDeudaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		cobEtapaDeudaFrm.oculto='S';
		envia('cobEtapaDeudaFrm');
		cobEtapaDeudaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cobEtapaDeudaFrm.mensOidMens').toString() == ''){
		set('cobEtapaDeudaFrm.mensOidMens', []);
		mmgResetCombosOnCascade('mensOidMens', 'mensOidMens', 'cobEtapaDeuda');
		
	}
	if(get('cobEtapaDeudaFrm.melcOidMetoLiquCobr').toString() == ''){
		set('cobEtapaDeudaFrm.melcOidMetoLiquCobr', []);
		mmgResetCombosOnCascade('melcOidMetoLiquCobr', 'melcOidMetoLiquCobr', 'cobEtapaDeuda');
		
	}
	if(get('cobEtapaDeudaFrm.tbalOidTipoBala').toString() == ''){
		set('cobEtapaDeudaFrm.tbalOidTipoBala', []);
		mmgResetCombosOnCascade('tbalOidTipoBala', 'tbalOidTipoBala', 'cobEtapaDeuda');
		
	}
	if(get('cobEtapaDeudaFrm.gacaOidGuioArguCabe').toString() == ''){
		set('cobEtapaDeudaFrm.gacaOidGuioArguCabe', []);
		mmgResetCombosOnCascade('gacaOidGuioArguCabe', 'gacaOidGuioArguCabe', 'cobEtapaDeuda');
		
	}
	if(get('cobEtapaDeudaFrm.paisOidPais').toString() == ''){
		set('cobEtapaDeudaFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'cobEtapaDeuda');
		
	}
	if(get('cobEtapaDeudaFrm.oredOidEtapDeu1').toString() == ''){
		set('cobEtapaDeudaFrm.oredOidEtapDeu1', []);
		mmgResetCombosOnCascade('oredOidEtapDeu1', 'oredOidEtapDeu1', 'cobEtapaDeuda');
		
	}
	if(get('cobEtapaDeudaFrm.oredOidEtapDeu2').toString() == ''){
		set('cobEtapaDeudaFrm.oredOidEtapDeu2', []);
		mmgResetCombosOnCascade('oredOidEtapDeu2', 'oredOidEtapDeu2', 'cobEtapaDeuda');
		
	}
	if(get('cobEtapaDeudaFrm.oredOidEtapDeu3').toString() == ''){
		set('cobEtapaDeudaFrm.oredOidEtapDeu3', []);
		mmgResetCombosOnCascade('oredOidEtapDeu3', 'oredOidEtapDeu3', 'cobEtapaDeuda');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cobEtapaDeudaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cobEtapaDeudaFrm.accion');
	var origenTmp = get('cobEtapaDeudaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cobEtapaDeudaBuildUpdateRecordString() != cobEtapaDeudaTmpUpdateValues){
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
	document.all.cobEtapaDeudaListLayer.style.display='none';
	document.all.cobEtapaDeudaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cobEtapaDeudaListLayer.style.display='';
	document.all.cobEtapaDeudaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCobEtapaDeudaCodEtapDeud = get('cobEtapaDeudaFrm.codEtapDeud').toString();
	jsCobEtapaDeudaValDesc = get('cobEtapaDeudaFrm.valDesc').toString();
	jsCobEtapaDeudaValEdadInic = get('cobEtapaDeudaFrm.valEdadInic').toString();
	jsCobEtapaDeudaValEdadFina = get('cobEtapaDeudaFrm.valEdadFina').toString();
	
	
	var parametros = "";
	parametros += jsCobEtapaDeudaCodEtapDeud + "|";
	parametros += jsCobEtapaDeudaValDesc + "|";
	parametros += jsCobEtapaDeudaValEdadInic + "|";
	parametros += jsCobEtapaDeudaValEdadFina + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cobEtapaDeudaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCobEtapaDeudaCodEtapDeud + "|";
	parametros += jsCobEtapaDeudaValDesc + "|";
	parametros += jsCobEtapaDeudaIndExcl + "|";
	parametros += jsCobEtapaDeudaValEdadInic + "|";
	parametros += jsCobEtapaDeudaValEdadFina + "|";
	parametros += jsCobEtapaDeudaIndTelf + "|";
	parametros += jsCobEtapaDeudaImpDesd + "|";
	parametros += jsCobEtapaDeudaImpHast + "|";
	parametros += jsCobEtapaDeudaNumDiasGracCompPago + "|";
	parametros += jsCobEtapaDeudaValPorcIncu + "|";
	parametros += jsCobEtapaDeudaMensOidMens + "|";
	parametros += jsCobEtapaDeudaMelcOidMetoLiquCobr + "|";
	parametros += jsCobEtapaDeudaTbalOidTipoBala + "|";
	parametros += jsCobEtapaDeudaGacaOidGuioArguCabe + "|";
	parametros += jsCobEtapaDeudaOredOidEtapDeu1 + "|";
	parametros += jsCobEtapaDeudaOredOidEtapDeu2 + "|";
	parametros += jsCobEtapaDeudaOredOidEtapDeu3 + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobEtapaDeudaFrm.accion'), 
		get('cobEtapaDeudaFrm.origen'));
	
	jsCobEtapaDeudaId = get('cobEtapaDeudaFrm.id').toString();
	jsCobEtapaDeudaCodEtapDeud = get('cobEtapaDeudaFrm.codEtapDeud').toString();
	jsCobEtapaDeudaValDesc = get('cobEtapaDeudaFrm.valDesc').toString();
	jsCobEtapaDeudaIndExcl = get('cobEtapaDeudaFrm.indExcl');
	jsCobEtapaDeudaValEdadInic = get('cobEtapaDeudaFrm.valEdadInic').toString();
	jsCobEtapaDeudaValEdadFina = get('cobEtapaDeudaFrm.valEdadFina').toString();
	jsCobEtapaDeudaIndTelf = get('cobEtapaDeudaFrm.indTelf');
	jsCobEtapaDeudaImpDesd = get('cobEtapaDeudaFrm.impDesd').toString();
	jsCobEtapaDeudaImpHast = get('cobEtapaDeudaFrm.impHast').toString();
	jsCobEtapaDeudaNumDiasGracCompPago = get('cobEtapaDeudaFrm.numDiasGracCompPago').toString();
	jsCobEtapaDeudaValPorcIncu = get('cobEtapaDeudaFrm.valPorcIncu').toString();
	jsCobEtapaDeudaMensOidMens = get('cobEtapaDeudaFrm.mensOidMens')[0];
	jsCobEtapaDeudaMelcOidMetoLiquCobr = get('cobEtapaDeudaFrm.melcOidMetoLiquCobr')[0];
	jsCobEtapaDeudaTbalOidTipoBala = get('cobEtapaDeudaFrm.tbalOidTipoBala')[0];
	jsCobEtapaDeudaGacaOidGuioArguCabe = get('cobEtapaDeudaFrm.gacaOidGuioArguCabe')[0];
	jsCobEtapaDeudaPaisOidPais = get('cobEtapaDeudaFrm.paisOidPais')[0];
	jsCobEtapaDeudaOredOidEtapDeu1 = get('cobEtapaDeudaFrm.oredOidEtapDeu1')[0];
	jsCobEtapaDeudaOredOidEtapDeu2 = get('cobEtapaDeudaFrm.oredOidEtapDeu2')[0];
	jsCobEtapaDeudaOredOidEtapDeu3 = get('cobEtapaDeudaFrm.oredOidEtapDeu3')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobEtapaDeudaFrm.accion'), 
		get('cobEtapaDeudaFrm.origen'));


	set('cobEtapaDeudaFrm.id', jsCobEtapaDeudaId);
	set('cobEtapaDeudaFrm.codEtapDeud', jsCobEtapaDeudaCodEtapDeud);
	set('cobEtapaDeudaFrm.valDesc', jsCobEtapaDeudaValDesc);
	set('cobEtapaDeudaFrm.indExcl', jsCobEtapaDeudaIndExcl);
	set('cobEtapaDeudaFrm.valEdadInic', jsCobEtapaDeudaValEdadInic);
	set('cobEtapaDeudaFrm.valEdadFina', jsCobEtapaDeudaValEdadFina);
	set('cobEtapaDeudaFrm.indTelf', jsCobEtapaDeudaIndTelf);
	set('cobEtapaDeudaFrm.impDesd', jsCobEtapaDeudaImpDesd);
	set('cobEtapaDeudaFrm.impHast', jsCobEtapaDeudaImpHast);
	set('cobEtapaDeudaFrm.numDiasGracCompPago', jsCobEtapaDeudaNumDiasGracCompPago);
	set('cobEtapaDeudaFrm.valPorcIncu', jsCobEtapaDeudaValPorcIncu);
	set('cobEtapaDeudaFrm.mensOidMens', [jsCobEtapaDeudaMensOidMens]);
	set('cobEtapaDeudaFrm.melcOidMetoLiquCobr', [jsCobEtapaDeudaMelcOidMetoLiquCobr]);
	set('cobEtapaDeudaFrm.tbalOidTipoBala', [jsCobEtapaDeudaTbalOidTipoBala]);
	set('cobEtapaDeudaFrm.gacaOidGuioArguCabe', [jsCobEtapaDeudaGacaOidGuioArguCabe]);
	set('cobEtapaDeudaFrm.paisOidPais', [jsCobEtapaDeudaPaisOidPais]);
	set('cobEtapaDeudaFrm.oredOidEtapDeu1', [jsCobEtapaDeudaOredOidEtapDeu1]);
	set('cobEtapaDeudaFrm.oredOidEtapDeu2', [jsCobEtapaDeudaOredOidEtapDeu2]);
	set('cobEtapaDeudaFrm.oredOidEtapDeu3', [jsCobEtapaDeudaOredOidEtapDeu3]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCobEtapaDeudaCodEtapDeud = '';
	jsCobEtapaDeudaValDesc = '';
	jsCobEtapaDeudaValEdadInic = '';
	jsCobEtapaDeudaValEdadFina = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cobEtapaDeudaFrm.errCodigo', errorCode);
	set('cobEtapaDeudaFrm.errDescripcion', description);
	set('cobEtapaDeudaFrm.errSeverity', severity);
	fMostrarMensajeError();
}

window.seleccionadoArbol=-1;//IMPORTANTE
window.seleccionadoArbolEsPadre=false;//IMPORTANTE

function returnFalse() {
  return false;
 }

function miFuncionArbol(nombreArbol,opcion,abriendocerrando,padreseleccionando,soypadre){
  if (soypadre && !padreseleccionando) {
    return true;//Estoy abriendo un padre
  }
  
  var cod=eval(nombreArbol).E.ij(opcion,0)

  if (abriendocerrando==1)   {   //Seleccionando
    if (seleccionadoArbol!=-1)   {
      if (seleccionadoArbolEsPadre)   
         arbol('name1','O',seleccionadoArbol,1,"",true);
      else   
         arbol('name1','O',seleccionadoArbol,1);
      }
      seleccionadoArbol=opcion;
      seleccionadoArbolEsPadre=soypadre;
    }
    else      //Deseleccionando
      seleccionadoArbol=-1;
      return true; //IMPORTANTE
}

function getOidPadre(){
	var nivelPulsado = name1.entradas[seleccionadoArbol][0];
  var result =''; 
	var victor = nivelPulsado.split('.'); 
	if (victor.length>0) {
		result = victor [0];
	}
	else return '';

	for (i=1;i<victor.length -1;i++ )
    result  = result +'.'+victor[i];

  return arbolM(name1,'C?',result);//retiene el padre   
}

function verificaSeleccionado() {
  if (seleccionadoArbol != -1)  {
    set(getFormularioSICC()+'.seleccionado',name1.entradas[seleccionadoArbol][2]); // el codigo tiene el oid
    return true;
  }
  else {            
    set(getFormularioSICC()+'.seleccionado','-1'); //No selecciono nada  
	  return false;
  }
}

function toSeleccionado(){
  if(verificaSeleccionado()) {
    return true;
  }
  else {
    GestionarMensaje('97',null,null,null);            
	  return false;
  }
}

function funcionFinal () {
	return false;
}

function fInsertar(){
	if (toSeleccionado()) {
		var params = {seleccionado:""};
		params.seleccionado = get(getFormularioSICC()+".seleccionado");
		var wnd= mostrarModalSICC("LPElementoMenu","insertar" , params);
		if (wnd) {
			set(getFormularioSICC()+'.accion','');
			set(getFormularioSICC()+'.conectorAction','LPElementoMenu');
			enviaSICC(getFormularioSICC());			
		}
	}
	//enviaSICC(getFormularioSICC());
}//fInsertar


function fConsultar () {
	if (toSeleccionado()) {
    var params = new Object();
		params.oid = get(getFormularioSICC()+".seleccionado");
		var wnd = false;
    if (name1.entradas[seleccionadoArbol][3] != '/') {
			wnd = mostrarModalSICC('LPElementoMenu','consultar',params);
    }
    else {
      GestionarMensaje('1349',null,null,null);
    }
	}
}

function accionModificar (){
  if (toSeleccionado()) {
    var params = new Object();
		params.oid = get(getFormularioSICC()+".seleccionado");
    params.tieneHijos = tieneHijos();
    params.padre = getOidPadre();
		var wnd = false;
    if (name1.entradas[seleccionadoArbol][3] != '/') { 
			wnd = mostrarModalSICC('LPElementoMenu','modificar',params);
      if (wnd) {
        set(getFormularioSICC()+'.accion','');
        set(getFormularioSICC()+'.conectorAction','LPModificarMenu');
        enviaSICC(getFormularioSICC());			
      }
    }    
    else
      GestionarMensaje('1350',null,null,null);		
	}
	
	/*if (toSeleccionado()) {
		var nombreArbol = get(getFormularioSICC()+'.nombreArbol');			
		var params = {oid:"",padre:"",nivel_padre:""};
		params.oid = get(getFormularioSICC()+".seleccionado");
		params.padre = get(getFormularioSICC()+".padre");
		params.nivel_padre = get(getFormularioSICC()+".nivel_padre"); 
		params.nivel_pulsado = get(getFormularioSICC()+".nivel_pulsado");		
		params.tieneHijos = ( 'P'==arbolM(nombreArbol,'t?',get(getFormularioSICC()+".nivel_pulsado")));
		var wnd = false;
		if (params.nivel_pulsado != params.nivel_padre)
			wnd = mostrarModalSICC('LPElementoMenu', 'modificar', params);	//y la accion "modificar"
		if (wnd) {
			set(getFormularioSICC()+'.accion','');
			set(getFormularioSICC()+'.conectorAction','LPModificarMenu');
			enviaSICC(getFormularioSICC());			
		}
	}*/
}

function recargarPagina (){	
//Este metodo se llamara desde el subsistema de eliminación para indicar que se ha completado la operación 
//Enviamos la página con accion = "" e indicando que estamos en el caso de uso de eliminar
	param = {CasoUso:"eliminar"};

	set(getFormularioSICC()+'.accion','');
	set(getFormularioSICC()+'.CasoUso','eliminar');

/**/	enviaSICC(getFormularioSICC());
}

function fBorrar(){
	accionEliminar();
}

function tieneHijos() {
  var nivel_pulsado= name1.entradas[seleccionadoArbol][0];
  return 'P'==arbolM(name1,'t?',nivel_pulsado);
}

function accionEliminar (){  
	if (toSeleccionado()) {
    var res = tieneHijos(); 
    if(res) {
      GestionarMensaje('1111',null,null,null);
    }		
		else {
			//Creamos un objeto Javascript y el asignamos un atributo "recargar"que vale "recargarPagina" 
			paginado = {recargar:""};
			paginado.recargar  = recargarPagina;

			//Llamamos a eliminarFilas pasandole un array con el oid del elemento seleccionado,
			var	oids = new Array(1);
			oids [0]=get(getFormularioSICC()+'.seleccionado');
			eliminarFilas(oids, "MENEliminaElementoMenu", paginado);
		}
	}
	//como idBusiness MENEliminaElementoMenu y como parametro paginado le pasamos el objeto que hemos creado. 
}

function focoBotonInsertar() {
  focalizaBotonHTML('botonContenido','btnInsertar');
}

function focoBotonModificar() {
  focalizaBotonHTML('botonContenido','btnModificar');
}

function focoBotonConsultar() {
  focalizaBotonHTML('botonContenido','btnConsultar');
}

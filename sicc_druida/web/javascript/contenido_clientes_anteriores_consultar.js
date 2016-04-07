var formName ="frmClientesAnteriores";


    function onLoadPag()   {
          configurarMenuSecundario("frmClientesAnteriores");
          DrdEnsanchaConMargenDcho('listado1',12);
         
          ocultaCapas();

          eval (ON_RSZ);  

          focaliza('frmClientesAnteriores.cbPaisNuevo');
   }

  	function ocultaCapas(){
	    document.all["Cplistado1"].style.visibility='hidden';
	    document.all["CpLin1listado1"].style.visibility='hidden';
	    document.all["CpLin2listado1"].style.visibility='hidden';
	    document.all["CpLin3listado1"].style.visibility='hidden';
	    document.all["CpLin4listado1"].style.visibility='hidden';
	    document.all["primera1Div"].style.visibility='hidden';
	    document.all["ret1Div"].style.visibility='hidden';
	    document.all["ava1Div"].style.visibility='hidden';
	    document.all["separaDiv"].style.visibility='hidden';
      document.all["btnDetalleDiv"].style.visibility='hidden';
      document.all["btnModificarDiv"].style.visibility='hidden';
      document.all["btnEliminarDiv"].style.visibility='hidden';

	}
  
  function muestraCapas(){
		document.all["Cplistado1"].style.visibility='';
		document.all["CpLin1listado1"].style.visibility='';
		document.all["CpLin2listado1"].style.visibility='';
		document.all["CpLin3listado1"].style.visibility='';
		document.all["CpLin4listado1"].style.visibility='';
		document.all["primera1Div"].style.visibility='';
		document.all["ret1Div"].style.visibility='';
		document.all["ava1Div"].style.visibility='';
		document.all["separaDiv"].style.visibility='';
		
	}
  
  	function ocultarLista() {
          document.all["Cplistado1"].style.visibility='hidden';
          document.all["CpLin1listado1"].style.visibility='hidden';
          document.all["CpLin2listado1"].style.visibility='hidden';
          document.all["CpLin3listado1"].style.visibility='hidden';
          document.all["CpLin4listado1"].style.visibility='hidden';
          document.all["primera1Div"].style.visibility='hidden';
          document.all["ret1Div"].style.visibility='hidden';
          document.all["ava1Div"].style.visibility='hidden';
          document.all["separaDiv"].style.visibility='hidden';
  
          document.all["btnDetalleDiv"].style.visibility='hidden';
          document.all["btnModificarDiv"].style.visibility='hidden';          
          document.all["btnEliminarDiv"].style.visibility='hidden';

          eval (ON_RSZ);
	}



function seleccionarClienteContactado() 
{
	var obj = new Object();
	var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
	if(whnd==null){
		////alert("result == null");
	}else{

		var oidclie = whnd[0];
    var cod = whnd[1];

		set("frmClientesAnteriores.txtClienteNuevo", cod);
    set("frmClientesAnteriores.hoidCliente", oidclie);
    
	}
}


function clienteContactadoOnBlur () {

	var longiCod = get(formName + ".hidlongClienteNuevo");
	var elTexto= get(formName + ".txtClienteNuevo");
	if(elTexto.length!=0){
	
		var faltantes = longiCod -  elTexto.length;
		var resultCod=new String("");
		if(faltantes > 0){
			for(var t = 0 ; t<faltantes; t++){
				resultCod = resultCod + "0";
			}
		}
		resultCod = resultCod + elTexto;
		set(formName + ".txtClienteNuevo", resultCod);
	}
}



function cargarArray(){
  
      var arrDatos = new Array();
      var i=0;
      
      arrDatos[i] = new Array('oidIdioma',get('frmClientesAnteriores.hIdioma'));
      /*arrDatos[i] = new Array('oidIdioma',"1");      */
      i++;
	  
      if (get('frmClientesAnteriores.hoidCliente')!=''){
          arrDatos[i] = new Array('oidCliente',get('frmClientesAnteriores.hoidCliente'));
          i++;
      }
      if (get('frmClientesAnteriores.cbPaisNuevo')!=''){
            arrDatos[i] = new Array('oidPaiscmb',get('frmClientesAnteriores.cbPaisNuevo'));
            i++;
      }
      if (get('frmClientesAnteriores.txtClienteNuevo')!=''){
            arrDatos[i] = new Array('codigoClienteNuevo',get('frmClientesAnteriores.txtClienteNuevo'));
            i++;
      }
      if (get('frmClientesAnteriores.txtClienteAntiguo')!=''){
            arrDatos[i] = new Array('codigoClienteAntiguo',get('frmClientesAnteriores.txtClienteAntiguo'));
            i++;
      }
      if (get('frmClientesAnteriores.txtSistemaProcedencia')!=''){
            arrDatos[i] = new Array('sistemaProcedencia',get('frmClientesAnteriores.txtSistemaProcedencia'));
            i++;
      }  
      
 return arrDatos;
}
  
function muestraLista(ultima, rowset) {
    var tamano = rowset.length;
		/*cambiarListadoValores(rowset);*/
		if (tamano > 0) {
           visualizarLista();
           return true;
    } else {

           ocultarLista();
           return false;

           // No se ha encontrado ningún elemento con los criterios especificados

           focaliza("frmClientesAnteriores.txtClienteNuevo");           
		}
 
}
  
function visualizarLista() {
        DrdEnsanchaConMargenDcho('listado1',12);

        document.all["Cplistado1"].style.visibility='';
        document.all["CpLin1listado1"].style.visibility='';
        document.all["CpLin2listado1"].style.visibility='';
        document.all["CpLin3listado1"].style.visibility='';
        document.all["CpLin4listado1"].style.visibility='';

        document.all["primera1Div"].style.visibility='';
        document.all["ret1Div"].style.visibility='';
        document.all["ava1Div"].style.visibility='';
        document.all["separaDiv"].style.visibility='';
        
        
    		if (get('frmClientesAnteriores.opcionMenu')=='ConsultarCodigoAnterior'){ // Para ver detalle
             document.all["btnModificarDiv"].style.visibility='hidden';
             document.all["btnDetalleDiv"].style.visibility='visible';             
       }

        if (get('frmClientesAnteriores.opcionMenu')=='ModificarCodigoAnterior'){ // Para modificar
           document.all["btnModificarDiv"].style.visibility='visible';
           document.all["btnDetalleDiv"].style.visibility='hidden';
   	       document.all["btnEliminarDiv"].style.visibility='hidden';
        }

    		if (get('frmClientesAnteriores.opcionMenu')=='EliminarCodigoAnterior'){ // Para ver detalle
            document.all["btnModificarDiv"].style.visibility='hidden';
            document.all["btnDetalleDiv"].style.visibility='visible';
            document.all["btnEliminarDiv"].style.visibility='hidden';
			btnProxy(4,1);

        }

        eval (ON_RSZ);
}
 
  
function fBorrar(){
	accionEliminar();
}
  
function accionEliminar() {

      var seleccionados = listado1.codSeleccionados();      
      var oids =  new Array();
      var cantSeleccionados = seleccionados.length;
            
      if (cantSeleccionados == 0){
          GestionarMensaje("4", null, null, null);      
          return;
      }
      
      for (var i = 0; i < seleccionados.length; i++)
      {               
         oids[i] = listado1.extraeDato(seleccionados[i], 6); 
      }
      
      if (cantSeleccionados > 0) {
          eliminarFilas(oids, "MAEEliminarCodigosAnteriores", mipgndo);
          /*listado1.eliminarSelecc();*/
      }  
}
  
  	function accionbuscar(){
		
          configurarPaginado(	mipgndo,
                        "MAEBuscarCodigosAnterioresCliente",
                        "ConectorBuscarCodigosAnterioresCliente",
                        "es.indra.sicc.dtos.mae.DTODataCodigoAnterior",
                        cargarArray()
                      );    
    }
  
  
    function accionModificar() {

      var codigos = new Array();
      
      codigos = listado1.codSeleccionados();
      
      var cant = codigos.length;
      
      var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);

      if (cant == 1) {
      
          var obj = new Object();
          for (var i = 0; i < codigos.length; i++)
          {               
               obj.CLIENTENUEVO = listado1.extraeDato(codigos[i], 1); 
               obj.CLIENTEANTI = listado1.extraeDato(codigos[i], 2); 
               obj.SISTEMA = listado1.extraeDato(codigos[i], 3); 
               obj.PAIS_OID_PAIS = listado1.extraeDato(codigos[i], 4); 
               obj.OID_CLIE = listado1.extraeDato(codigos[i], 5); 
               obj.OID_CODI_CLIE_ANTE = listado1.extraeDato(codigos[i], 6); 
          }
                  
          obj.opcionMenu = get('frmClientesAnteriores.opcionMenu');
          var salida = mostrarModalSICC('LPMantenimientoCodigosAnteriores',"modificar",obj,750,350);
                    
          if (salida == "modificar"){            
            mipgndo.recargar();          
          }          
      } else    {
          GestionarMensaje('50');
      }
  }
  
    function accionDetalle() {
      var codigos = new Array();
      
      codigos = listado1.codSeleccionados();
      
      var cant = codigos.length;
      
      var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);

      if (cant == 1) {
      
          var obj = new Object();
          for (var i = 0; i < codigos.length; i++)
          {               
               obj.CLIENTENUEVO = listado1.extraeDato(codigos[i], 1); 
               obj.CLIENTEANTI = listado1.extraeDato(codigos[i], 2); 
               obj.SISTEMA = listado1.extraeDato(codigos[i], 3); 
               obj.PAIS_OID_PAIS = listado1.extraeDato(codigos[i], 4); 
               obj.OID_CLIE = listado1.extraeDato(codigos[i], 5); 
               obj.OID_CODI_CLIE_ANTE = listado1.extraeDato(codigos[i], 6); 
          }
          obj.opcionMenu = get('frmClientesAnteriores.opcionMenu');
          mostrarModalSICC('LPMantenimientoCodigosAnteriores',"detalle",obj,750,350);
      } else    {
          GestionarMensaje('50');
      }
  }
  

function onshTab_PaisNuevo(){
    
     if(document.all["Cplistado1"].style.visibility == 'hidden') {
          focalizaBotonHTML('botonContenido','btnBuscar');          
     } else {
       if(get('frmClientesAnteriores.opcionMenu') == "ConsultarCodigoAnterior")     
          focalizaBotonHTML('botonContenido','btnDetalle');
     else
          focalizaBotonHTML('botonContenido','btnModificar');
     }
}

function onshTab_Buscar(){
   
   if(document.all["Cplistado1"].style.visibility == 'hidden') {
        focaliza('frmClientesAnteriores.txtSistemaProcedencia');
   }
}

function onTab_Buscar(){
   
   if(document.all["Cplistado1"].style.visibility == 'hidden') {
        focaliza('frmClientesAnteriores.cbPaisNuevo');
   } else {
     if(get('frmClientesAnteriores.opcionMenu').toString() == "ConsultarCodigoAnterior")     	
        focalizaBotonHTML('botonContenido','btnDetalle');     
	 else
        focalizaBotonHTML('botonContenido','btnModificar');
   }
}

function onTab_Modificar(){
       focaliza('frmClientesAnteriores.cbPaisNuevo');
}

function onshTab_Modificar(){
      focalizaBotonHTML('botonContenido','btnBuscar');
}

function onTab_Detalle(){
       focaliza('frmClientesAnteriores.cbPaisNuevo');  
}

function onshTab_Detalle(){
      focalizaBotonHTML('botonContenido','btnBuscar');
}

function onTab_Eliminar(){
       focaliza('frmClientesAnteriores.cbPaisNuevo');  
}

function onshTab_Eliminar(){
      focalizaBotonHTML('botonContenido','btnBuscar');
}

function fLimpiar() {
    set('frmClientesAnteriores.cbPaisNuevo', '');
	set('frmClientesAnteriores.txtClienteNuevo', '');
    set('frmClientesAnteriores.txtClienteAntiguo', '');
    set('frmClientesAnteriores.txtSistemaProcedencia', '');
    
    set('frmClientesAnteriores.hoidCliente', '');
    set('frmClientesAnteriores.codigoNuevo', '');
    set('frmClientesAnteriores.codigoAntiguo', '');
    set('frmClientesAnteriores.sistemaProcedencia', '');

	focaliza('frmClientesAnteriores.cbPaisNuevo');
}

//----------------------------------------------------------------------------//
/*
function codigoNuevoOnChange() {
	set('frmClientesAnteriores.hoidCliente','');
}
*/

function onchange_codCliente(){

	if (get("frmClientesAnteriores.txtClienteNuevo") != ""){
		campo = validarLongCodCliente(get("frmClientesAnteriores.txtClienteNuevo"));      
		set("frmClientesAnteriores.txtClienteNuevo", campo); 
	}  
}

function onchange_codClienteAnt(){
	if(get("frmClientesAnteriores.txtClienteAntiguo") != ""){
		campo = validarLongCodCliente(get("frmClientesAnteriores.txtClienteAntiguo"));                  
	}  
}
function validarLongCodCliente(codCliente) {
	var longiCod = get('frmClientesAnteriores.hLongitudCodCliente');
	var faltantes = longiCod -  codCliente.length;
	var resultCod = new String("");
	if(faltantes > 0){
		for(var t = 0 ; t<faltantes; t++){
			resultCod = resultCod + "0";
		}
		resultCod = resultCod + codCliente;
		return resultCod;
	}
	return codCliente;
}

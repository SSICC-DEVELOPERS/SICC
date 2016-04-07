function fLimpiar() {
  var arr = new Array();
  set("frmFormulario.txtDescripcionEstado", "");
  set("frmFormulario.txtCodEstado", "");    
  focaliza("frmFormulario.txtCodEstado"); 
}
function busca_modi()
{  
  var can = listado1.codigos();
  
  if (can.length>0)
  { 
    if (get('frmFormulario.casoDeUso')=='modificar')
    {
      focalizaBotonHTML('botonContenido','Modificar');
      
    }
    if (get('frmFormulario.casoDeUso')=='consultar')
    {
      focalizaBotonHTML('botonContenido','Detalle');  
    }
    if (get('frmFormulario.casoDeUso')=='eliminar')
    { 
      focaliza('frmFormulario.txtCodEstado');
    }
  }
  else
  {
    focaliza('frmFormulario.txtCodEstado');
  }
}


function volver_tct()
{  
  var can = listado1.codigos();
  
  if (can.length>0)
  {
    if (get('frmFormulario.casoDeUso')=='modificar')
    {
      focalizaBotonHTML('botonContenido','Modificar');
    }
    if (get('frmFormulario.casoDeUso')=='consultar')
    {
      focalizaBotonHTML('botonContenido','Detalle');  
    }
     if (get('frmFormulario.casoDeUso')=='eliminar')
    {
      focalizaBotonHTML('botonContenido','btnBuscar')
    }
  }
  else
  {
    focalizaBotonHTML('botonContenido','btnBuscar')
  }
}




      function validarAlfanumericoConEspeciales(valor) 
            {

    
      var permitidos = "0123456789";
                              var c;
                              
                              for(var i=0; i<valor.length; i++) 
                              {
                                                   c = valor.charAt(i);
                                                   if (permitidos.indexOf(c) == -1 ) 
                                                             return false;
                              }
                              return true;
             }

function fBorrar()   {
   
      if (listado1.numSelecc()>=1) { 
         eliminarFilas(listado1.codSeleccionados(),"MAVEliminarEstadosMAV", mipgndo);
	     ocultaCapas();
      } else {
		 var wnd = GestionarMensaje("2523", null, null, null);
                  
      }

} 
            


function detalle()
{
                  
             
           if (listado1.numSelecc()== 1) 
                  { 
             set('frmFormulario.conectorAction','LPMantenimientoEstadosMAV');
             set('frmFormulario.accion','detalle');
             set('frmFormulario.detalle',listado1.codSeleccionados());
             var obj = new Object();
             obj.casoDeUso='consultar';
             obj.accion='detalle';
             obj.detalle=listado1.codSeleccionados();

             mostrarModalSICC('LPMantenimientoEstadosMAV','detalle',obj,496,380);
             
           }  
           else
           {
             var wnd = GestionarMensaje("2557", null, null, null);
             set('frmFormulario.conectorAction','LPMantenimientoEstadosMAV');
             set('frmFormulario.accion','consultar');
           }
           
      
}


function modificar()
{
                  
             
           if (listado1.numSelecc()== 1) 
                  { 
             set('frmFormulario.conectorAction','LPMantenimientoEstadosMAV');
             set('frmFormulario.accion','detalle');
             set('frmFormulario.detalle',listado1.codSeleccionados());
             var obj = new Object();
             obj.casoDeUso='modificar';
             obj.accion='detalle';
             obj.detalle=listado1.codSeleccionados();

             mostrarModalSICC('LPMantenimientoEstadosMAV','detalle',obj,496,380);
             buscar();
             //enviaSICC('frmFormulario');
           }  
           else
           {
              var wnd = GestionarMensaje("2525", null, null, null);       
             set('frmFormulario.conectorAction','LPMantenimientoEstadosMAV');
             set('frmFormulario.accion','consultar');
           }
           
      
}



  function buscar(){

  var codigos = listado1.codigos();
  var longitud = codigos.length;
  btnProxy(4,0);
  if (get('frmFormulario.txtCodEstado') !="")
  { 
    if (!( validarAlfanumericoConEspeciales(get('frmFormulario.txtCodEstado'))))
    {
      
      var wnd = GestionarMensaje("2560", null, null, null);
      focaliza('frmFormulario.txtCodEstado');
      return
    }
  }
  for(var i=0;i<longitud;i++) 
  {
    listado1.deselecciona(i);    
   }
    if (get('frmFormulario.casoDeUso')=='modificar'){
         listado1.maxSel=1;
     
        document.all["DetalleDiv"].style.visibility='hidden';
        document.all["ModificarDiv"].style.visibility='visible';
    }
    document.all["Cplistado1"].style.visibility='visible';
    document.all["CpLin1listado1"].style.visibility='visible';
    document.all["CpLin2listado1"].style.visibility='visible';
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';
    document.all["separaDiv"].style.visibility='visible';
    document.all["primera1Div"].style.visibility='visible';
    document.all["ret1Div"].style.visibility='visible';
    document.all["ava1Div"].style.visibility='visible';
    
     if (get('frmFormulario.casoDeUso')=='consultar'){
      listado1.maxSel=1;
     
    document.all["DetalleDiv"].style.visibility='visible';
    document.all["ModificarDiv"].style.visibility='hidden';
         }
         var arrDatos = new Array();
         arrDatos = armarArray();
         //configurarPaginadoExt(mipgndo,"MAVBuscarEstadosMAV","ConectorBuscarEstadosMAV","es.indra.sicc.dtos.mav.DTOEBuscarEstadosMAV",arrDatos,0,20);
         configurarPaginado(mipgndo,"MAVBuscarEstadosMAV","ConectorBuscarEstadosMAV","es.indra.sicc.dtos.mav.DTOEBuscarEstadosMAV",arrDatos);
  
  
  }

  function armarArray(){
      var arrDatos = new Array();
      var i=0;
      
      if (get('frmFormulario.txtCodEstado')!='')
      {
            arrDatos[i] = new Array('oidEstadoMAV',get('frmFormulario.txtCodEstado'));
            i++;
      }
      if (get('frmFormulario.txtDescripcionEstado')!=''){
            arrDatos[i] = new Array('descripcion',get('frmFormulario.txtDescripcionEstado'));
            i++
      
      }
     
      arrDatos[i] = new Array('oidIdioma',get('frmFormulario.idioma'));  


      return arrDatos;
  }

  
  function onLoadPag()   {
    configurarMenuSecundario("frmFormulario");
    mostrarCodigoError();
    focaliza("frmFormulario.txtCodEstado");  
    fLimpiar();
    if (get("frmFormulario.casoDeUso")=='eliminar')
    {
      btnProxy(4,0);
    }
    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["DetalleDiv"].style.visibility='hidden';
    document.all["ModificarDiv"].style.visibility='hidden';
    eval (ON_RSZ);  
    
    
   }

/*---------------------------------------------------------------------------*/

function ocultaCapas(){
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["DetalleDiv"].style.visibility='hidden';
    document.all["ModificarDiv"].style.visibility='hidden';
    eval (ON_RSZ);  
}


function muestraCapas(){
    document.all["Cplistado1"].style.visibility='visible';
    document.all["CpLin1listado1"].style.visibility='visible';
    document.all["CpLin2listado1"].style.visibility='visible';
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';
    document.all["separaDiv"].style.visibility='visible';
    document.all["primera1Div"].style.visibility='visible';
    document.all["ret1Div"].style.visibility='visible';
    document.all["ava1Div"].style.visibility='visible';
    //document.all["DetalleDiv"].style.visibility='visible';
    //document.all["ModificarDiv"].style.visibility='visible';
    
}



function muestraLista( ultima, rowset, error){
		  var tamano = rowset.length;
		  if (tamano > 0) {
			  var casoDeUso = get("frmFormulario.casoDeUso");
			  if (casoDeUso == 'consultar') {
				  document.all["DetalleDiv"].style.visibility='';          
				  document.all["ModificarDiv"].style.visibility='hidden';
			  } else {
				  if (casoDeUso == 'modificar') {
					 document.all["DetalleDiv"].style.visibility='hidden';           
					 document.all["ModificarDiv"].style.visibility='';
				  } else if( casoDeUso == 'eliminar' ) {
					 btnProxy(4,1);
					 document.all["DetalleDiv"].style.visibility='hidden';         
					 document.all["ModificarDiv"].style.visibility='hidden';
				  }else {
					 document.all["DetalleDiv"].style.visibility='hidden';           
					 document.all["ModificarDiv"].style.visibility='hidden';
				  }
			  }
			  muestraCapas();
			  eval (ON_RSZ);
			  focaliza("frmFormulario.txtCodEstado"); 
			  return true;
		  } else {
			 ocultaCapas();
			 btnProxy(4,0);
			 eval (ON_RSZ);                    
			 focaliza("frmFormulario.txtCodEstado");
			 cdos_mostrarAlert(error);
			 return false;
		  }
}

/*-----------------------------------------------------------------------------------------------------*/
   
   function mostrarCodigoError()
  {
    var vErrCodigo = get('frmFormulario.errCodigo');
    var vErrDescrip = get('frmFormulario.errDescripcion');
    if (get('frmFormulario.errDescripcion')!='')
    {
      var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);
    }
    
  }

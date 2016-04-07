/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

/*
  Sistema:           Belcorp
  Modulo:            SEG
  Submódulo:         Seguridad
  Componente:        JS
  Fecha:             30/10/2003
  Observaciones:     
  @version           
  @autor             Viviana Bongiovanni
 */

/*$Id: contenido_niveles_socioeconomicos_eliminar.js,v 1.1 2009/12/03 19:01:32 pecbazalar Exp $*/

	var varNoLimpiarSICC = true;
    var arrayBelcorp = new Array();
    var arrayPersona;
	var arraySelec;	
    function cargarMiBarra(){
        configurarMenuSecundario('frmEliminarNiveles'); 
        iSeleccionado = new Array(); 
        iSeleccionado[0] =get('frmEliminarNiveles.hidPais');
        //setTimeout( 'set(\'frmEliminarNiveles.comboPais\',iSeleccionado)',100);
        set('frmEliminarNiveles.comboPais',iSeleccionado);
        cargaComboNSEBelcorp();
        //mostrarPantallaExito(); 
        mostrarCodigoError();
        focaliza('frmEliminarNiveles.comboPais');     
    }
	
	function mostrarPantallaExito(){
		if(get('frmEliminarNiveles.exito')=='S'){
			var casodeuso  = get('frmEliminarNiveles.CasoDeUso');
			//var wnd= fMostrarMensajeExito(casodeuso);
			set('frmEliminarNiveles.conectorAction', 'LPEliminarAsociacionNiveles');
			set('frmEliminarNiveles.accion', '');
			set('frmEliminarNiveles.CasoDeUso','eliminar');
			enviaSICC('frmEliminarNiveles');
		}
	}

	function mostrarCodigoError(){
		 var vErrCodigo  = get('frmEliminarNiveles.errCodigo');
		 var vErrDescrip = get('frmEliminarNiveles.errDescripcion');
		  if (get('frmEliminarNiveles.errDescripcion')!=''){				
				var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip); 
			} 
	}

	//cargo el combo NSEBelcorp y NSEPais con datos relacionados al primer registro del combo NSEBelcorp
	function cargaComboNSEBelcorp(){
		var long = lstAsociaciones.datos.longitud;
		var existeB = 'SI';	
		var x = 0;
		if (lstAsociaciones.datos.longitud>0){
			for(var i=0; i<lstAsociaciones.datos.longitud ; i++){					
				existeB = existe(0, lstAsociaciones.datos.ij(i,2));
				if (existeB=='NO') {
						arrayBelcorp[x] = [ lstAsociaciones.datos.ij(i,0)+'--'+lstAsociaciones.datos.ij(i,2)+'--'+lstAsociaciones.datos.ij(i,4), lstAsociaciones.datos.ij(i,3) ];

						x++;
						
					}							
				
			}//FIN FOR
		
			set_combo('frmEliminarNiveles.comboNSEBelcorp', arrayBelcorp);
		
			cargaRelacionNSEPais(0);
		}
	}

	//actualiza el combo de NSEPais
	function cargaRelacionNSEPais(dato){
		arrayPersona = new Array();
		
		if(dato==0){
			var claveNSEBelc = arrayBelcorp[0][0].split("--");
		}
		else 
		{
			var claveNSEBelc = get('frmEliminarNiveles.comboNSEBelcorp');
      
      if (claveNSEBelc != '')
		   claveNSEBelc =	claveNSEBelc[0].split("--");
		}

		var y = 0;
		for(var i=0; i<lstAsociaciones.datos.longitud ; i++){
			if(claveNSEBelc[1]==lstAsociaciones.datos.ij(i,2)){
				existeP = existe(1, lstAsociaciones.datos.ij(i,4));	
				if (existeP=='NO') {
					if(lstAsociaciones.datos.ij(i,5)!=''){
					arrayPersona[y]= [ lstAsociaciones.datos.ij(i,0)+'--'+ lstAsociaciones.datos.ij(i,2)+'--'+ lstAsociaciones.datos.ij(i,4), lstAsociaciones.datos.ij(i,5) ];
				
					}
					 else{
					 arrayPersona[y]= null;
					 }
				
					y++;	
				}
			}
		}
   
		
		set_combo('frmEliminarNiveles.comboNSEPais', arrayPersona);
    var valoresSetear = new Array();
    var j=0;

    if(arrayPersona!='') {
      for(var i=0; i<arrayPersona.length; i++) {
        valoresSetear[j] = arrayPersona[i][0];
        j++;
      }
    }    
    set('frmEliminarNiveles.comboNSEPais', valoresSetear);
	}

	//verifica que el dato no exista en el arrray
	function existe(num, dato){
		var estado ='NO';
		if(num=='0')
		{
			if ( parseInt(arrayBelcorp.length) >0 ){
				for( i=0; i<arrayBelcorp.length; i++){
					var datoArray = arrayBelcorp[i][0].split("--");
					if( datoArray[1] == dato ){
						estado='SI';
						break;
					}
				}
			}

			return estado;
		}
		else if(num=='1'){

			if ( parseInt(arrayPersona.length) >0 ){
				for( i=0; i<arrayPersona.length; i++){
					var datoArray = arrayPersona[i][0].split("--");
					if( datoArray[2] == dato ){
						estado='SI';
						break;
					}
				}
			}
			return estado;
		}
		else {
			return null;
		}
	}//fin funcion

	
	function BuscarAsociacion(){
		set('frmEliminarNiveles.hidPais',get('frmEliminarNiveles.comboPais'));
		set('frmEliminarNiveles.accion','BuscarAsociacion');			
		if(get('frmEliminarNiveles.CasoDeUso') == 'eliminar'){
			set('frmEliminarNiveles.conectorAction','LPEliminarAsociacionNiveles');
		}
		else{
			set('frmEliminarNiveles.conectorAction','LPConsultarNivelesSocioeconomicos');
		}
		enviarFormulario();	
	}

	function fBorrar(){
			if (sicc_validaciones_generales()){ 
				var bandera= 0;
				arraySelec = new Array();
				set('frmEliminarNiveles.hidPais',get('frmEliminarNiveles.comboPais'));
				set('frmEliminarNiveles.elementosSeleccionados', get('frmEliminarNiveles.comboNSEPais') );
			
				set('frmEliminarNiveles.accion','eliminar');
				set('frmEliminarNiveles.conectorAction','LPEliminarAsociacionNiveles');
				eval('frmEliminarNiveles').oculto = 'S';
				enviaSICC('frmEliminarNiveles', '', '', 'N'); 
			}

	}
	  
	  
	  
	  
	
   

	

	function enviarFormulario(){
    setMV('frmEliminarNiveles.comboNSEBelcorp','N');
    setMV('frmEliminarNiveles.comboNSEPais','N');
		enviaSICC('frmEliminarNiveles');
	  }
	

	function fLimpiar(){
      eval('frmEliminarNiveles').oculto = 'N';
      set('frmEliminarNiveles.hidPais',get('frmEliminarNiveles.comboPais'));
	  set('frmEliminarNiveles.elementosSeleccionados', get('frmEliminarNiveles.comboNSEPais'));
 	  
	  set('frmEliminarNiveles.accion','');

		if  (get('frmEliminarNiveles.CasoDeUso') == 'eliminar'){
			set('frmEliminarNiveles.conectorAction','LPEliminarAsociacionNiveles');
		}else
		{
			set('frmEliminarNiveles.conectorAction','LPConsultarNivelesSocioeconomicos');
		}
		
		enviarFormulario();
	}


    function focalizaComponenteLargo() {  
        document.selection.empty();
        focaliza('frmEliminarNiveles.comboPais');       
    }


    function focalizaComponenteCorto() {  
        document.selection.empty();
        if (get_visibilidad('capaResultado')) {
            focaliza('frmEliminarNiveles.comboNSEBelcorp');       
        } else {
            focaliza('frmEliminarNiveles.comboPais');       
        }
    }


    function focalizaComponenteCortoShift() {    
        document.selection.empty();
        if (get_visibilidad('capaResultado')) {
            focaliza('frmEliminarNiveles.comboNSEPais');
        } else {
            //focalizar el boton, esperando que los muchachos de druida lo hagan.
            //focaliza('frmEliminarNiveles.btnModificar','');
            document.all.btnModificar.focus();
        }
    }


function elimineOk(p1){

  //aca recibo el pais del cual cabo de eliminar una asociacion.
  //cargo de nuevo para verioficar eliminacion, mediante
  eval('frmEliminarNiveles').oculto = 'N';
  BuscarAsociacion();

}

function noPersistio(){
  eval('frmEliminarNiveles').oculto = 'N';
  focaliza('frmEliminarNiveles.comboPais');
}

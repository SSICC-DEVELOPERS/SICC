
	var varNoLimpiarSICC = true;
      
	function onLoadPag()   
	{
		configurarMenuSecundario('frmFormulario');

        fMostrarMensajeError();

		inicializaPantalla();	

	}

	
    function inicializaPantalla(){  
	   if(get('frmFormulario.casoDeUso')=='inserta'){
			accion('frmFormulario.cbSubTipoCliente', '.disabled=true');
			accion('frmFormulario.cbTipoClasificacion', '.disabled=true');
			accion('frmFormulario.cbClasificacion', '.disabled=true');
			accion('frmFormulario.rbRegion', '.checked=true');
			onClickRegion();
			focaliza("frmFormulario.cbTipoSolicitud");

	   }else if(get('frmFormulario.accion')=='detalle'){

			iSeleccionado = new Array(); 
			iSeleccionado[0] = get('frmFormulario.hcbTipoSolicitud');

            set('frmFormulario.cbTipoSolicitud', iSeleccionado);
			accion('frmFormulario.cbTipoSolicitud', '.disabled=true');

			asignar([['LISTA','', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', formarCadenaDT('PEDObtieneTipoClienteTipoSolicitud', 'es.indra.sicc.util.DTOOID',[[ "oid", get('frmFormulario.cbTipoSolicitud') ]]),'cargaTipoCliente(datos);']] );

	        accion('frmFormulario.txtNivel1', '.disabled=true');
			accion('frmFormulario.txtNivel2', '.disabled=true');
			accion('frmFormulario.txtNivel3', '.disabled=true');
			accion('frmFormulario.txtRecargo', '.disabled=true');
			accion('frmFormulario.txtMontoMinimoNominal', '.disabled=true');
    		iRegion = new Array();
			iRegion[0] = get('frmFormulario.hRegion');
			iZona = new Array();
			iZona[0] =get('frmFormulario.hZona');
            set('frmFormulario.cbRegion', iRegion);
			if(get('frmFormulario.hZona')!=''){
				iZona[0] =get('frmFormulario.hZona')+"x"+get('frmFormulario.hRegion');
			}else{
				iZona[0] ="";
			}
			set('frmFormulario.cbZona', iZona);
			accion('frmFormulario.cbRegion', '.disabled=true');
			accion('frmFormulario.cbZona', '.disabled=true');	
			accion('frmFormulario.rbRegion', '.checked=false');
			accion('frmFormulario.rbZona', '.checked=false');
			accion('frmFormulario.rbRegion', '.disabled=true');
			accion('frmFormulario.rbZona', '.disabled=true');

	   } else if(get('frmFormulario.accion')=='modificar'){

			iSeleccionado = new Array(); 
			iSeleccionado[0] = get('frmFormulario.hcbTipoSolicitud');

            set('frmFormulario.cbTipoSolicitud', iSeleccionado);
			accion('frmFormulario.cbTipoSolicitud', '.disabled=true');
    		iRegion = new Array();
			iRegion[0] = get('frmFormulario.hRegion');
			iZona = new Array();
			if(get('frmFormulario.hZona')!=''){
				iZona[0] =get('frmFormulario.hZona')+"x"+get('frmFormulario.hRegion');
			}else{
				iZona[0] ="";
			}
            set('frmFormulario.cbRegion', iRegion);
			set('frmFormulario.cbZona', iZona);
			accion('frmFormulario.cbRegion', '.disabled=true');
			accion('frmFormulario.cbZona', '.disabled=true');	
			accion('frmFormulario.rbRegion', '.checked=false');
			accion('frmFormulario.rbZona', '.checked=false');
			accion('frmFormulario.rbRegion', '.disabled=true');
			accion('frmFormulario.rbZona', '.disabled=true');

			asignar([['LISTA','', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', formarCadenaDT('PEDObtieneTipoClienteTipoSolicitud', 'es.indra.sicc.util.DTOOID',[[ "oid", get('frmFormulario.cbTipoSolicitud') ]]),'cargaTipoCliente(datos);']] );
	   }
	}


    function cargaTipoCliente(datos){  

		txt_to('lblTipoClienteXX', datos[0][1]);
		set('frmFormulario.hcbTipoCliente', datos[0][0]);

		recargaCombo('frmFormulario.cbSubTipoCliente', 'MAEobtenerSubtipos', 'es.indra.sicc.util.DTOOID', makeParameter('oid',datos[0][0]), 'cargaSubTipoCliente(datos);' );
	}

	

	function cargaSubTipoCliente(datos){  

		set_combo('frmFormulario.cbSubTipoCliente', agregarBlanco(datos));

		iSeleccionado = new Array(); 
		iSeleccionado[0] = get('frmFormulario.hDcbSubTipoCliente');

		set('frmFormulario.cbSubTipoCliente', iSeleccionado);

		if(get('frmFormulario.accion')=='detalle'){
			accion('frmFormulario.cbSubTipoCliente', '.disabled=true');
		}

		if((get('frmFormulario.hDcbTipoClasificacion')!='') || (get('frmFormulario.hDcbTipoClasificacion')=='' && get('frmFormulario.accion')=='modificar' )){

			recargaCombo('frmFormulario.cbTipoClasificacion', 'MAEobtenerTipoClasificacion', 'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbSubTipoCliente')), 'cargaTipoClasificacion(datos);' );
				
		} else{
			set_combo('frmFormulario.cbTipoClasificacion', arrayVacio());
			set_combo('frmFormulario.cbClasificacion', arrayVacio() );

			accion('frmFormulario.cbTipoClasificacion', '.disabled=true');
			accion('frmFormulario.cbClasificacion', '.disabled=true');

            if(get('frmFormulario.accion')=='modificar'){
				focaliza("frmFormulario.txtNivel1");
			}
		}

	 }

	 function cargaTipoClasificacion(datos){  

		set_combo('frmFormulario.cbTipoClasificacion', agregarBlanco(datos));

		iSeleccionado = new Array(); 
		iSeleccionado[0] = get('frmFormulario.hDcbTipoClasificacion');

		set('frmFormulario.cbTipoClasificacion', iSeleccionado);

		if(get('frmFormulario.accion')=='detalle'){
			accion('frmFormulario.cbTipoClasificacion', '.disabled=true');
		}

		if(get('frmFormulario.hDcbClasificacion')!='' || (get('frmFormulario.hDcbTipoClasificacion')!='' &&  get('frmFormulario.accion')=='modificar')){

			recargaCombo('frmFormulario.cbClasificacion', 'MAEobtenerClasificacionesPorTipo', 'es.indra.sicc.util.DTOOID', makeParameter('oid', get('frmFormulario.cbTipoClasificacion')), 'cargaClasificacion(datos);' ); 
			
		} else{
			set_combo('frmFormulario.cbClasificacion', arrayVacio() );
			accion('frmFormulario.cbClasificacion', '.disabled=true');

			if(get('frmFormulario.accion')=='modificar'){
				focaliza("frmFormulario.txtNivel1");
			}
		}

	}


	function cargaClasificacion(datos){  

		set_combo('frmFormulario.cbClasificacion', agregarBlanco(datos));

		iSeleccionado = new Array(); 
		iSeleccionado[0] = get('frmFormulario.hDcbClasificacion');

		set('frmFormulario.cbClasificacion', iSeleccionado);

		if(get('frmFormulario.accion')=='detalle'){
			accion('frmFormulario.cbClasificacion', '.disabled=true');
		} else {
			focaliza("frmFormulario.txtNivel1");
		}

	}



    function onChangeTipoSolicitud(){  
		
		document.selection.empty();

		if(get('frmFormulario.cbTipoSolicitud')!=''){
			asignar([['LISTA','', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', formarCadenaDT('PEDObtieneTipoClienteTipoSolicitud', 'es.indra.sicc.util.DTOOID',[[ "oid", get('frmFormulario.cbTipoSolicitud') ]]),'recargarSubTipos(datos);']] );
			/*var arr = new Array();
			arr[arr.length] = ['oidPais', get('frmFormulario.hPais')];			
            arr[arr.length]	= new Array('oidIdioma', get('frmFormulario.hIdioma') );
			recargaCombo('frmFormulario.cbRegion', 'ZONObtenerRegionesPorPais', 'es.indra.sicc.util.DTOOID', arr );
     		arr = new Array();
			arr[arr.length] = ['oidPais', get('frmFormulario.hPais')];
            arr[arr.length]	= new Array('oidIdioma', get('frmFormulario.hIdioma') );
			//arr[arr.length] = ['oidMarca', oidMarca]
			//arr[arr.length] = ['oidCanal', oidCanal]
			recargaCombo('frmFormulario.cbZona', 'ZONObtenerZonasPorRegiones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arr );*/

		} else {
		    txt_to('lblTipoClienteXX', '');
			set('frmFormulario.hcbTipoCliente', '');
			set_combo('frmFormulario.cbSubTipoCliente', arrayVacio() );
			set_combo('frmFormulario.cbTipoClasificacion', arrayVacio());
			set_combo('frmFormulario.cbClasificacion', arrayVacio());
			set_combo('frmFormulario.cbRegion', arrayVacio());
			set_combo('frmFormulario.cbZona', arrayVacio());
			
			accion('frmFormulario.cbSubTipoCliente', '.disabled=true');
			accion('frmFormulario.cbTipoClasificacion', '.disabled=true');
			accion('frmFormulario.cbClasificacion', '.disabled=true');
		}
        
	 }

     function recargarSubTipos(datos){        
        txt_to('lblTipoClienteXX', datos[0][1]);
		set('frmFormulario.hcbTipoCliente', datos[0][0]);

        recargaCombo('frmFormulario.cbSubTipoCliente', 'MAEobtenerSubtipos', 'es.indra.sicc.util.DTOOID', makeParameter('oid',datos[0][0]) );
       
		accion('frmFormulario.cbSubTipoCliente', '.disabled=false');
		
		set_combo('frmFormulario.cbTipoClasificacion', arrayVacio() );		
		set_combo('frmFormulario.cbClasificacion', arrayVacio());
		

		accion('frmFormulario.cbTipoClasificacion', '.disabled=true');
		accion('frmFormulario.cbClasificacion', '.disabled=true');

      }


      function makeParameter(nombre, oid){
              var array = new Array();
              var i=0;
              array[i] = new Array('oidPais', get('frmFormulario.hPais') );
              i++;
              array[i] = new Array('oidIdioma', get('frmFormulario.hIdioma') );
              i++;
			  if(oid!=null){
		          array[i] = new Array(nombre,oid);              
			  }
              return array;
     }

     function onChangeSubtipoCliente(){

	    document.selection.empty();
                                                      
		if(get('frmFormulario.cbSubTipoCliente')!=''){
			recargaCombo('frmFormulario.cbTipoClasificacion', 'MAEobtenerTipoClasificacion', 'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbSubTipoCliente') ) );

			accion('frmFormulario.cbTipoClasificacion', '.disabled=false');

		} else{			
			set_combo('frmFormulario.cbTipoClasificacion', arrayVacio());
			set_combo('frmFormulario.cbClasificacion', arrayVacio() );

			accion('frmFormulario.cbTipoClasificacion', '.disabled=true');
			accion('frmFormulario.cbClasificacion', '.disabled=true');
		}
     }

     function onChangeTipoClasificacion(){
		
		document.selection.empty();

		if(get('frmFormulario.cbTipoClasificacion')!=''){
			recargaCombo('frmFormulario.cbClasificacion', 'MAEobtenerClasificacionesPorTipo', 'es.indra.sicc.util.DTOOID', makeParameter('oid', get('frmFormulario.cbTipoClasificacion') )); 

			accion('frmFormulario.cbClasificacion', '.disabled=false');

		} else{
			set_combo('frmFormulario.cbClasificacion', arrayVacio());
			accion('frmFormulario.cbClasificacion', '.disabled=true');
		}
     }


     function fGuardar(){ 
		
	/*	if(get('frmFormulario.hZona')=='S'){
			var arra = get('frmFormulario.cbZona');

			var oidsRegion = new Array();
			for(var i=0; i< arra.length; i++){		
				 oidsRegion[i] = arra[i].split('x')[1];
			}
			set('frmFormulario.cbRegion',oidsRegion);
		}*/


		if(sicc_validaciones_generales("gGuardar")){
		   // Validaciones de niveles
		   nivel1 = get('frmFormulario.txtNivel1');
		   nivel2 = get('frmFormulario.txtNivel2');
		   nivel3 = get('frmFormulario.txtNivel3');

		   formatoDef = get('frmFormulario.hFormatoDef');

		   if(numeroDeFormatoSICC(nivel1, formatoDef) > numeroDeFormatoSICC(nivel2, formatoDef)){
		      GestionarMensaje('1365');
		      focaliza("frmFormulario.txtNivel2");
		      return;
		   }

		   if(numeroDeFormatoSICC(nivel2, formatoDef) > numeroDeFormatoSICC(nivel3, formatoDef)){
		      GestionarMensaje('1366');
		      focaliza("frmFormulario.txtNivel3");
		      return;
		   }

		   set('frmFormulario.conectorAction', 'LPMantieneMontoMinimo');
		   set('frmFormulario.accion', 'guardar');
		   enviaSICC('frmFormulario');
		
		}
     }
     

    function fLimpiar(){
		if(get('frmFormulario.casoDeUso')=='inserta'){
			set('frmFormulario.cbTipoSolicitud',new Array(''));
			txt_to('lblTipoClienteXX','');        
			set('frmFormulario.txtNivel1','');
			set('frmFormulario.txtNivel2','');
			set('frmFormulario.txtNivel3','');
			set('frmFormulario.txtRecargo','');
			set('frmFormulario.txtMontoMinimoNominal','');        
			set_combo('frmFormulario.cbSubTipoCliente', arrayVacio());
			set_combo('frmFormulario.cbTipoClasificacion', arrayVacio());
			set_combo('frmFormulario.cbClasificacion',arrayVacio());

			accion('frmFormulario.cbSubTipoCliente', '.disabled=true');
			accion('frmFormulario.cbTipoClasificacion', '.disabled=true');
			accion('frmFormulario.cbClasificacion', '.disabled=true');

			focaliza("frmFormulario.cbTipoSolicitud");

			set('frmFormulario.cbRegion', '');
			set('frmFormulario.hZona', '');
			set('frmFormulario.hRegion', 'S');
			accion('frmFormulario.rbZona', '.checked=false');
			set('frmFormulario.cbZona', '');	
			accion('frmFormulario.cbZona', '.disabled=true');	
			accion('frmFormulario.cbRegion', '.disabled=false');

		}else if(get('frmFormulario.casoDeUso')=='modifica'){

			set('frmFormulario.txtNivel1',get('frmFormulario.hTxtNivel1'));
			set('frmFormulario.txtNivel2',get('frmFormulario.hTxtNivel2'));
			set('frmFormulario.txtNivel3',get('frmFormulario.hTxtNivel3'));
			set('frmFormulario.txtRecargo',get('frmFormulario.hTxtRecargo'));
			set('frmFormulario.txtMontoMinimoNominal',get('frmFormulario.hTxtMontoMinimoNominal'));

            accion('frmFormulario.cbTipoClasificacion', '.disabled=false');
			accion('frmFormulario.cbClasificacion', '.disabled=false');

			asignar([['LISTA','', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', formarCadenaDT('PEDObtieneTipoClienteTipoSolicitud', 'es.indra.sicc.util.DTOOID',[[ "oid", get('frmFormulario.cbTipoSolicitud') ]]),'cargaTipoCliente(datos);']] );
		}
     }

  
    function fBorrar(){
         if(!listado1.numSelecc() == 0){		
            listado1.eliminarSelecc();        
         }else{
            GestionarMensaje('8');
         }   
    }     

	function focalizaTab(campo){  

		if(campo==1){
			if( cbSubTipoCliente.disabled == false )
				focaliza("frmFormulario.cbSubTipoCliente");
			else
				focoPrimerCampo();
		} else if(campo==2){
			if( cbTipoClasificacion.disabled == false )
				focaliza("frmFormulario.cbTipoClasificacion");
			else
				focoPrimerCampo();
		}else if(campo==3){
			if( cbClasificacion.disabled == false )
				focaliza("frmFormulario.cbClasificacion");
			else
				focoPrimerCampo();
		}else if(campo==4){
			focoPrimerCampo();
		}
   }


   function focoPrimerCampo(){  
		if(get('frmFormulario.casoDeUso')=='inserta'){
			focaliza("frmFormulario.cbTipoSolicitud");
		}else if(get('frmFormulario.casoDeUso')=='modifica'){
			focaliza("frmFormulario.txtNivel1");
		}
    }


	function focalizaShTab(campo){  
		if(campo==1){
			if( cbClasificacion.disabled == false ){
				focaliza("frmFormulario.cbClasificacion");
			}else if( cbTipoClasificacion.disabled == false ){
				focaliza("frmFormulario.cbTipoClasificacion");
			}else if( cbSubTipoCliente.disabled == false ){
				focaliza("frmFormulario.cbSubTipoCliente");
			}else{
				focaliza("frmFormulario.txtMontoMinimoNominal");
			}
		}if(campo==2){
			if(get('frmFormulario.casoDeUso')=='inserta'){
				focaliza("frmFormulario.cbTipoSolicitud");
			}else if(get('frmFormulario.casoDeUso')=='modifica'){
				focalizaShTab(1);
			}
		}
    }


	function errorAlGuardar(){  
	    if(get('frmFormulario.casoDeUso')=='inserta'){
			focaliza("frmFormulario.cbTipoSolicitud");
		}else if(get('frmFormulario.casoDeUso')=='modifica'){
			focaliza("frmFormulario.txtNivel1");
		}
	}

	function fVolver(){	
		window.close();
	}

	function cerrarVentana(){
		window.returnValue = true;
	}


	function agregarBlanco(datos){  
	    datosBlanco = new Array();

		datosBlanco[0]= new Array("","");

		for(var i=0; i< datos.length; i++){		
              datosBlanco[i+1] = new Array(datos[i][0], datos[i][1]);
             
		}

		//alert(datosBlanco);
		return datosBlanco;
	}

	function arrayVacio(){  
		var array = new Array();             
        array[0] = new Array('','');

		return array;
	}

	function onClickRegion(){
    	set('frmFormulario.cbRegion', '');
		set('frmFormulario.hZona', '');
		set('frmFormulario.hRegion', 'S');
		accion('frmFormulario.rbZona', '.checked=false');
		set('frmFormulario.cbZona', '');	
		accion('frmFormulario.cbZona', '.disabled=true');	
		accion('frmFormulario.cbRegion', '.disabled=false');
	}

	function onClickZona(){
		accion('frmFormulario.rbRegion', '.checked=false');
		set('frmFormulario.hZona', 'S');
		set('frmFormulario.hRegion', '');
		set('frmFormulario.cbRegion', '');
		accion('frmFormulario.cbRegion', '.disabled=true');
		accion('frmFormulario.cbZona', '.disabled=false');	
	}

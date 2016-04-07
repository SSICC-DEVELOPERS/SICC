      function onLoadPag()   
      {
          configurarMenuSecundario("frmFormulario");

          //btnProxy(5,"0");
          /*
          if (get('frmFormulario.errDescripcion')!='') {
             var wnd = fMostrarMensajeError(get('frmFormulario.errCodigo'), get('frmFormulario.errDescripcion'));
          }*/
          
          
          set('frmFormulario.txtDescripcion', get('frmFormulario.descripcionH'));            
          focaliza("frmFormulario.txtDescripcion");          
          /*if(get('frmFormulario.casoDeUso')=='EnviarConsultoras'){
            
            //alert(get('frmGenerarFichero.labelLote'));
            txt_to('lblLote',get('frmFormulario.loteH'));            
            
          }*/
          		           
      }
      
      
      
      function fGuardar(){
      
          if (sicc_validaciones_generales()){            

            var lot = get("frmFormulario.loteH");
            
            set("frmFormulario.observacionesH", get("frmFormulario.areatxtObservaciones"));
            set("frmFormulario.descripcionH", get("frmFormulario.txtDescripcion"));
            set("frmFormulario.loteH", lot)
            set('frmFormulario.accion','Guardar');
            set("frmFormulario.conectorAction", "LPNDG");
            enviaSICC('frmFormulario');          
		  }
	  }
		
	  function tab() {
      focaliza('frmGenerarFichero.txtDescripcion');
	  }
      

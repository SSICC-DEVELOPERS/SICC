 function fGuardar(){
		    if(!sicc_validaciones_generales()){
			         return false;
			}
            eval('frmFormulario').oculto = 'S';
            set('frmFormulario.conectorAction', 'LPCentrosServicios');
            set('frmFormulario.accion', 'guardar')
		    enviaSICC('frmFormulario');
 } 

  function onLoadPag(){
				  configurarMenuSecundario("frmFormulario"); 
                  fMostrarMensajeError();
                  
				  if(get('frmFormulario.accion') != "modificar centro") {
						  focaliza("frmFormulario.txtCodCentroServ");
				  } else{
				          focaliza("frmFormulario.txtDescripcion");

						  set("frmFormulario.codCentroServicio",get('frmFormulario.txtCodCentroServ'));
						  set("frmFormulario.desCentroServicio",get('frmFormulario.txtDescripcion'));
						  set("frmFormulario.obsCentroServicio",get('frmFormulario.areatxtObservaciones'))

						  var objCmb = document.getElementById('txtCodCentroServ');				
                          objCmb.disabled = true;
				  }
                  
  }

  function reInicio() {
         eval("frmFormulario").oculto= "N";
         fLimpiar();
  }

  function fLimpiar(){
		  set('frmFormulario.txtCodCentroServ',"");
		  set('frmFormulario.txtDescripcion',"");
		  set('frmFormulario.areatxtObservaciones',"");
		  focaliza("frmFormulario.txtCodCentroServ");
  }

  function fErrorAlGuardarI() {
         focaliza("frmFormulario.txtCodCentroServ");
  }

  function fErrorAlGuardarM() {
         focaliza("frmFormulario.txtDescripcion");
  }


  function focaliza1() {
		var objCmb = document.getElementById('txtCodCentroServ');				
		if (objCmb.disabled == true) {
			focaliza('frmFormulario.areatxtObservaciones');	
		} else {
			focaliza('frmFormulario.txtCodCentroServ');
		}
  }

  function focaliza2() {
		var objCmb = document.getElementById('txtCodCentroServ');				
		if (objCmb.disabled == true) {
			focaliza('frmFormulario.txtDescripcion');	
		} else {
			focaliza('frmFormulario.txtCodCentroServ');
		}
  }

 function reModifica() {
    eval("frmFormulario").oculto= "N";
    window.close();
 }

  function fVolver(){ 
		window.close();  
  }


function LoadBar(){
        configurarMenuSecundario("frmEstrategia");
        focaliza('frmEstrategia.cbEstrategia','');
        fMostrarMensajeError();
    }        
        
    function fGuardar() {
        if (sicc_validaciones_generales()) {
        set('frmEstrategia.hdescripcion',get('frmEstrategia.cbEstrategia','T'));
        set('frmEstrategia.oidEstrategia',get('frmEstrategia.cbEstrategia','V'));
        set('frmEstrategia.accion','Guardar');
        enviaSICC('frmEstrategia');
        }
    }  
	
	function focoEstrategia(){
		focaliza("formulario.cbEstrategia");
	}
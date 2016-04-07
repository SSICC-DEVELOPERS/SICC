/*
    $Id: cabecera_matriz_modificar.js,v 1.1 2009/12/03 19:02:08 pecbazalar Exp $
*/

var formName = 'frmFormulario.';
var formNameSinPunto = 'frmFormulario';
//var varNoLimpiarSICC = true;

function fGuardar(){
    if (sicc_validaciones_generales()){
        alert("1");
        set("frmFormulario.varCanal",marca);  
        set("frmFormulario.varMarca",canal);	
        set("frmFormulario.varPeriodo",periodo);
        set("frmFormulario.varNumeroPedidosEstimados",numeroPedidos);
        set("frmFormulario.varUnidadesEstimadas",unidadesEstimadas);
        set("frmFormulario.varClientesEstimados",clientesEstimados);			
        set("frmFormulario.varValorEstimado",valorEstimado); 		 
        set("frmFormulario.varTipoCambio",tipoCambio);		
					
        set("frmFormulario.accion", "Guardar");
        set("frmFormulario.conectorAction", "LPModificarCabeceraMF");		
  	 
        enviaSICC("frmFormulario");
	}else{
  alert("2");}
}

function inicializar(){
	configurarMenuSecundario(getFormularioSICC());

	set( 'frmFormulario.hNumeroPedidosEstimados', get('frmFormulario.NumeroPedidosEstimados') );
	set( 'frmFormulario.hUnidadesEstimadas', get('frmFormulario.UnidadesEstimadas') );
	set( 'frmFormulario.hClientesEstimados', get('frmFormulario.ClientesEstimados') );
	set( 'frmFormulario.hValorEstimado', get('frmFormulario.ValorEstimado') );
	set( 'frmFormulario.hTipoCambio', get('frmFormulario.TipoCambio') );

	fMostrarMensajeError();
}

function fLimpiar(){    
    /*set('frmFormulario.NumeroPedidosEstimados', get('frmFormulario.hNumeroPedidosEstimados'));     
    set(getFormularioSICC()+".UnidadesEstimadas", get('frmFormulario.hUnidadesEstimadas' ));
    set(getFormularioSICC()+".ClientesEstimados", get('frmFormulario.hClientesEstimados'));
	  set(getFormularioSICC()+".ValorEstimado", get('frmFormulario.hValorEstimado'));
	  set(getFormularioSICC()+".TipoCambio", get('frmFormulario.hTipoCambio'));*/
	  focaliza(getFormularioSICC()+".NumeroPedidosEstimados");
}

function seleccionarMatriz(){
    set("frmFormulario.accion", "");
    if (get("frmFormulario.nombreLogicas") == "LPModificarCabeceraMF"){
        set("frmFormulario.conectorAction", "LPModificarCabeceraMF");		
  	}else{
        set("frmFormulario.conectorAction", "LPConsultarCabeceraMF");
    }
		enviaSICC("frmFormulario");
}

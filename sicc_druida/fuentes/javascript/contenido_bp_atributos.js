
var capaMostrada;
// ----------------------------------------------------------------------------------------------
function init()
{
		configurarMenuSecundario("frmAtributos");
		fMostrarMensajeError();
		//alert("Disparo el onload xxxx");
		seteaPantalla();

		focaliza("frmAtributos.textNUnidClienteRepartir", "");

		// Agregado por ssantana, 15/6/2005
		// Inc. 19100. 
//		var cumpleanyosI18N = GestionarMensaje("1272", null, null, null);
		//txt_to("lblCumpleanyos", cumpleanyosI18N);



		// Realiza recarga de campos (si corresponde)
		//alert("AAAAAAA");
	
        // [1] Agregado por Rafael Romero / SiCC 20070189 - 24/04/2007
        var estadoProceso = get('frmAtributos.varEstadoProceso');
        if(estadoProceso == "4"){
            var subcriterio = get("frmAtributos.varSubcriterio");
            accion("frmAtributos.textNUnidClienteRepartir" , ".disabled=true");
            accion("frmAtributos.cbAtributoEvaluar" , ".disabled=true");
            switch ( parseInt(subcriterio, 10) )
            {
            case 1: // Capa Todos.
                break;
            case 2: // Cumpleaños
                accion("frmAtributos.textNAniversario" , ".disabled=true");
                break; 
            case 3: // Aniversario (Idem Cumpleaños)
                accion("frmAtributos.textNAniversario" , ".disabled=true");
                document.all["btnAceptar"].disabled=true;
                break;
            case 4: // Edad
                accion("frmAtributos.textEdadDesde" , ".disabled=true");
                accion("frmAtributos.textEdadHasta" , ".disabled=true");
                document.all["btnAceptar"].disabled=true;
                break;
            case 5: // Pedido Supera Monto
                accion("frmAtributos.textMonto1" , ".disabled=true");
                accion("frmAtributos.cbPeriodoDesde1" , ".disabled=true");
                accion("frmAtributos.cbPeriodoHasta1" , ".disabled=true");
                document.all["btnAceptar"].disabled=true;
                break;
            case 6: // Pedido Supera Monto Marca
                accion("frmAtributos.textMonto2" , ".disabled=true");
                accion("frmAtributos.cbPeriodoDesde2" , ".disabled=true");
                accion("frmAtributos.cbPeriodoHasta2" , ".disabled=true");
                accion("frmAtributos.cbMarca" , ".disabled=true");
                document.all["btnAceptar"].disabled=true;
                break;
            case 7: // Pedido Supera Monto Unidad Negocio
                accion("frmAtributos.textMonto3" , ".disabled=true");
                accion("frmAtributos.cbPeriodoDesde3" , ".disabled=true");
                accion("frmAtributos.cbPeriodoHasta3" , ".disabled=true");
                accion("frmAtributos.cbUnidNegocio" , ".disabled=true");
                document.all["btnAceptar"].disabled=true;
                break;
            case 8: // Pedido Supera Monto Negocio
                accion("frmAtributos.textMonto4" , ".disabled=true");
                accion("frmAtributos.cbPeriodoDesde4" , ".disabled=true");
                accion("frmAtributos.cbPeriodoHasta4" , ".disabled=true");
                accion("frmAtributos.cbNegocio" , ".disabled=true");
                document.all["btnAceptar"].disabled=true;
                break;
            case 9: // Pedido Supera Monto Catalogo
                accion("frmAtributos.textMonto5" , ".disabled=true");
                accion("frmAtributos.cbPeriodoDesde5" , ".disabled=true");
                accion("frmAtributos.cbPeriodoHasta5" , ".disabled=true");
                accion("frmAtributos.cbCatalogo" , ".disabled=true");
                document.all["btnAceptar"].disabled=true;
                break;            
            case 23: // Pedido NO Supera Monto
	        	accion("frmAtributos.textMonto23" , ".disabled=true");
	        	accion("frmAtributos.cbPeriodoDesde23" , ".disabled=true");
	        	accion("frmAtributos.cbPeriodoHasta23" , ".disabled=true");
	        	document.all["btnAceptar"].disabled=true;
	        	break;
		    case 24: // Pedido NO Supera Monto Marca
		        accion("frmAtributos.textMonto24" , ".disabled=true");
		        accion("frmAtributos.cbPeriodoDesde24" , ".disabled=true");
		        accion("frmAtributos.cbPeriodoHasta24" , ".disabled=true");
		        accion("frmAtributos.cbMarca2" , ".disabled=true");
		        document.all["btnAceptar"].disabled=true;
		        break;
		    case 25: // Pedido NO Supera Monto Unidad Negocio
		        accion("frmAtributos.textMonto25" , ".disabled=true");
		        accion("frmAtributos.cbPeriodoDesde25" , ".disabled=true");
		        accion("frmAtributos.cbPeriodoHasta25" , ".disabled=true");
		        accion("frmAtributos.cbUnidNegocio2" , ".disabled=true");
		        document.all["btnAceptar"].disabled=true;
		        break;
		    case 26: // Pedido NO Supera Monto Negocio
		        accion("frmAtributos.textMonto26" , ".disabled=true");
		        accion("frmAtributos.cbPeriodoDesde26" , ".disabled=true");
		        accion("frmAtributos.cbPeriodoHasta26" , ".disabled=true");
		        accion("frmAtributos.cbNegocio2" , ".disabled=true");
		        document.all["btnAceptar"].disabled=true;
		        break;
		    case 27: // Pedido NO Supera Monto Catalogo
		        accion("frmAtributos.textMonto27" , ".disabled=true");
		        accion("frmAtributos.cbPeriodoDesde27" , ".disabled=true");
		        accion("frmAtributos.cbPeriodoHasta27" , ".disabled=true");
		        accion("frmAtributos.cbCatalogo2" , ".disabled=true");
		        document.all["btnAceptar"].disabled=true;
		        break;
				
			// sapaza -- PER-SiCC-2010-0628 -- 20/10/2010				
		    case 28: // DuplaCyzone
		        accion("frmAtributos.cbPeriodoDesde7" , ".disabled=true");
		        accion("frmAtributos.cbPeriodoHasta7" , ".disabled=true");
		        document.all["btnAceptar"].disabled=true;
		        break;	      
					      
            }
                                               
        }
        // Fin agregado [1]
    
    
		return;

}

// ----------------------------------------------------------------------------------------------
function procesaAtributo()
{
		// Se llama cuando se hace click en el botón "Aceptar". Si el Atributo elegido anteriormente es "Todos" o "Cumpleaños",
		// simula un click en "Continuar"
		var codAtributo = get("frmAtributos.cbAtributoEvaluar");
		//set("frmAtributos.varSubcriterio", codAtributo);	

		switch ( parseInt(codAtributo, 10) )
		{
			case 1:  // Capa Todos
			case 2:  // Cumpleaños 
						 // Inc. 19100, 22/06/2005 - No se muestra ninguna capa para "Cumpleaños". Se comporta como el "Todos"
				continuar(); 
		}
}

// --------------------------------------------------------------------------------------------------------------------------------------
function continuar() 
{
		// Continuar - Valida la selección actual y retornar los valores seleccionados a la ventana que llamó a la modal. 

		//var subCriterio = get("frmAtributos.varSubcriterio");
		var subCriterio = get("frmAtributos.cbAtributoEvaluar");
		var array = new Array();
		
		var aniversario = "";
		var edadDesde = "";
		var edadHasta = "";
		var monto = "";
		var periodoDesde = "";
		var periodoHasta = "";
		var marca = "";
		var catalogo = "";
		var uNegocio = "";
		var negocio = "";

		if ( !sicc_validaciones_generales('g1') )
			return;

		array[0] = subCriterio;
		array[1] = get("frmAtributos.textNUnidClienteRepartir");

		switch ( parseInt(subCriterio, 10) )
		{
			case 1:  // Todos

				array[2] = "";
				array[3] = "";
				array[4] = "";
				array[5] = "";
				array[6] = "";
				array[7] = "";
				array[8] = "";
				array[9] = "";
				array[10] = "";
				array[11] = ""
				//alert("array: " + array);
				break;

			case 2: // Cumpleaños. 
				// ssantana, Modificado por inc. 19100, 22/6/2005 - No se retorna nada para cumpleaños
				/*aniversario = get("frmAtributos.textNAniversario");

				if ( !sicc_validaciones_generales("textNAniversario") )
					return;
				array[2] = aniversario;*/
				array[2] = "";
				break;

			case 3: // Aniversario
				aniversario = get("frmAtributos.textNAniversario");

				if ( !sicc_validaciones_generales("textNAniversario") )
					return;

				array[2] = aniversario;
				break;

			case 4: // Edad
				edadDesde = get("frmAtributos.textEdadDesde");
				edadHasta = get("frmAtributos.textEdadHasta");

				if ( !sicc_validaciones_generales("textEdadDesde") )
					return;

				if ( !sicc_validaciones_generales("textEdadHasta") )
					return;

				if ( parseInt(edadDesde,10) > parseInt(edadHasta,10) )
				{
					GestionarMensaje("1489", null, null, null);
					focaliza("frmAtributos.textEdadDesde", "");
					return;
				}


				array[2] = edadDesde;
				array[3] = edadHasta;
				break;

			case 5:  // Pedido Supera Monto

				monto = get("frmAtributos.textMonto1");
				periodoDesde = get("frmAtributos.cbPeriodoDesde1");
				periodoHasta =  get("frmAtributos.cbPeriodoHasta1");

				if ( !sicc_validaciones_generales("textMonto1") )
					return;

				if ( !sicc_validaciones_generales("capaPedidoSuperaMonto") )
					return;

				array[2] = monto;
				array[3] = periodoDesde;
				array[4] = periodoHasta;
				//alert("array: " + array);
				break;

			case 6: // Pedido Supera Monto Marca
				monto = get("frmAtributos.textMonto2");
				marca = get("frmAtributos.cbMarca");
				periodoDesde = get("frmAtributos.cbPeriodoDesde2");
				periodoHasta = get("frmAtributos.cbPeriodoHasta2");

				if ( !sicc_validaciones_generales("textMonto2") )
					return;

				if (periodoDesde != "")
				{
						if ( !sicc_validaciones_generales("capaPedidoSuperaMontoMarca") )
							return;
				}

				array[2] = monto;
				array[3] = marca;
				array[4] = periodoDesde;
				array[5] = periodoHasta;
				break;

			case 7: // Pedido Supera Monto Unidad Negocio
				monto = get("frmAtributos.textMonto3");
				uNegocio = get("frmAtributos.cbUnidNegocio");
				periodoDesde = get("frmAtributos.cbPeriodoDesde3");
				periodoHasta = get("frmAtributos.cbPeriodoHasta3");

				if ( !sicc_validaciones_generales("textMonto3") )
					return;
				
				if (periodoDesde != "")
				{
						if ( !sicc_validaciones_generales("capaPedidoSuperaUnidadNegocio") )
							return;
				}

				array[2] = monto;
				array[3] = uNegocio;
				array[4] = periodoDesde; 
				array[5] = periodoHasta;
				break;

			case 8: // Pedido Supera Monto Negocio
				monto = get("frmAtributos.textMonto4");
				negocio	= get("frmAtributos.cbNegocio");
				periodoDesde = get("frmAtributos.cbPeriodoDesde4");
				periodoHasta = get("frmAtributos.cbPeriodoHasta4");

				if ( !sicc_validaciones_generales("textMonto4") )
					return;

				if (periodoDesde != "")
				{
						if ( !sicc_validaciones_generales("capaPedidoSuperaMontoNegocio") )
							return;
				}

				array[2] = monto;
				array[3] = negocio;
				array[4] = periodoDesde; 
				array[5] = periodoHasta;
				break;

			case 9: // Pedido Supera Monto Catalogo
				monto = get("frmAtributos.textMonto5");
				catalogo = get("frmAtributos.cbCatalogo");
				periodoDesde = get("frmAtributos.cbPeriodoDesde5");
				periodoHasta = get("frmAtributos.cbPeriodoHasta5");

				if ( !sicc_validaciones_generales("textMonto5") )
					return;

				if (periodoDesde != "")
				{
						if ( !sicc_validaciones_generales("capaPedidoSuperaMontoCatalogo") )
							return;
				}

				array[2] = monto;
				array[3] = catalogo;
				array[4] = periodoDesde; 
				array[5] = periodoHasta;
				break;
				
			 case 23:  // Pedido NO Supera Monto

				monto = get("frmAtributos.textMonto23");
				periodoDesde = get("frmAtributos.cbPeriodoDesde23");
				periodoHasta =  get("frmAtributos.cbPeriodoHasta23");

				if ( !sicc_validaciones_generales("textMonto23") )
					return;

				if ( !sicc_validaciones_generales("capaPedidoNOSuperaMonto") )
					return;

				array[2] = monto;
				array[3] = periodoDesde;
				array[4] = periodoHasta;
				
				break;

			case 24: // Pedido NO Supera Monto Marca
				monto = get("frmAtributos.textMonto24");
				marca = get("frmAtributos.cbMarca2");
				periodoDesde = get("frmAtributos.cbPeriodoDesde24");
				periodoHasta = get("frmAtributos.cbPeriodoHasta24");

				if ( !sicc_validaciones_generales("textMonto24") )
					return;

				if (periodoDesde != "")
				{
						if ( !sicc_validaciones_generales("capaPedidoNOSuperaMontoMarca") )
							return;
				}

				array[2] = monto;
				array[3] = marca;
				array[4] = periodoDesde;
				array[5] = periodoHasta;
				//alert("array: " + array);
				break;

			case 25: // Pedido Supera Monto Unidad Negocio
				monto = get("frmAtributos.textMonto25");
				uNegocio = get("frmAtributos.cbUnidNegocio2");
				periodoDesde = get("frmAtributos.cbPeriodoDesde25");
				periodoHasta = get("frmAtributos.cbPeriodoHasta25");

				if ( !sicc_validaciones_generales("textMonto25") )
					return;
				
				if (periodoDesde != "")
				{
						if ( !sicc_validaciones_generales("capaPedidoNOSuperaUnidadNegocio") )
							return;
				}

				array[2] = monto;
				array[3] = uNegocio;
				array[4] = periodoDesde; 
				array[5] = periodoHasta;
				break;

			case 26: // Pedido Supera Monto Negocio
				monto = get("frmAtributos.textMonto26");
				negocio	= get("frmAtributos.cbNegocio2");
				periodoDesde = get("frmAtributos.cbPeriodoDesde26");
				periodoHasta = get("frmAtributos.cbPeriodoHasta26");

				if ( !sicc_validaciones_generales("textMonto26") )
					return;

				if (periodoDesde != "")
				{
						if ( !sicc_validaciones_generales("capaPedidoNOSuperaMontoNegocio") )
							return;
				}

				array[2] = monto;
				array[3] = negocio;
				array[4] = periodoDesde; 
				array[5] = periodoHasta;
				break;

			case 27: // Pedido Supera Monto Catalogo
				monto = get("frmAtributos.textMonto27");
				catalogo = get("frmAtributos.cbCatalogo2");
				periodoDesde = get("frmAtributos.cbPeriodoDesde27");
				periodoHasta = get("frmAtributos.cbPeriodoHasta27");

				if ( !sicc_validaciones_generales("textMonto27") )
					return;

				if (periodoDesde != "")
				{
						if ( !sicc_validaciones_generales("capaPedidoNOSuperaMontoCatalogo") )
							return;
				}

				array[2] = monto;
				array[3] = catalogo;
				array[4] = periodoDesde; 
				array[5] = periodoHasta;
				break;	

			case 28: // Dupla Cyzone
				periodoDesde = get("frmAtributos.cbPeriodoDesde7");
				periodoHasta = get("frmAtributos.cbPeriodoHasta7");

				if ( !sicc_validaciones_generales("capaDuplaCyzone") )
					return;


				array[2] = periodoDesde; 
				array[3] = periodoHasta;
				break;	
		
		}

		returnValue = array;

		close();

}

// --------------------------------------------------------------------------------------------------------------------------------------
function validaCampos()
{
	// Valida que Numero de Unidades no este vacío, sea numérico  y sea mayor que cero.
	var valido = true;

	var numUnidades = get("frmAtributos.textNUnidClienteRepartir");
	if ( numUnidades == "" )
	{
		GestionarMensaje("1283");
		//alert("El campo Numero de Unidades es obligatorio");
		focaliza("frmAtributos.textNUnidClienteRepartir", "");
		valido = false;
	}

	var validoNumerico = validarCaracteres(numUnidades);

	if ( valido && !validoNumerico)
	{
		GestionarMensaje("1284");
		//alert("El campo Numero de Unidades solo puede contener valores numéricos");
		focaliza("frmAtributos.textNUnidClienteRepartir", "");
		valido = false;
	}

	if ( valido && (parseInt(numUnidades, 10) == 0) )
	{
		GestionarMensaje("1285");
		//alert("El valor del campo Numero de Unidades debe ser mayor que cero");
		focaliza("frmAtributos.textNUnidClienteRepartir", "");
		valido = false;

	}

	return valido;

}

// --------------------------------------------------------------------------------------------------------------------------------------
function validarCaracteres(valor) 
{
	var c;
	var permitidos = "0123456789";
	for(var i=0; i<valor.length; i++) 
	{
			c = valor.charAt(i);
			if (permitidos.indexOf(c) == -1 ) 
				return false;
	}
	return true;
}

// --------------------------------------------------------------------------------------------------------------------------------------
function validaPeriodos(comboDesde, comboHasta)
{

	var valido = true;

	if ( comboDesde == "")	
	{
		if ( comboHasta != "")		
		{
			GestionarMensaje("1286");
			valido = false;
		}
	}
	return valido;
}

// -------------------------------------------------------------------------------------------------------
function fVolver()
{
		window.close();
}

// -------------------------------------------------------------------------------------------------------
function fLimpiar()
{
	seteaPantalla();
	focaliza("frmAtributos.textNUnidClienteRepartir", "");
}

// -------------------------------------------------------------------------------------------------------
function seteaPantalla()
{
		var numUnidadesCliente = get("frmAtributos.varNumUnidadesCliente");
		set("frmAtributos.textNUnidClienteRepartir", numUnidadesCliente);

		var subcriterio = get("frmAtributos.varSubcriterio");
		set("frmAtributos.cbAtributoEvaluar", new Array(subcriterio) );

		var numAniversario = get("frmAtributos.varNumeroAniversario");
		var edadDesde = get("frmAtributos.varEdadDesde");
		var edadHasta = get("frmAtributos.varEdadHasta");
		var monto = get("frmAtributos.varMonto");
		var periodoDesde = get("frmAtributos.varPeriodoDesde");
		var periodoHasta = get("frmAtributos.varPeriodoHasta");
		var marca = get("frmAtributos.varMarcaCriterio");
		var catalogo = get("frmAtributos.varCatalogo");
		var unidadNegocio = get("frmAtributos.varUnidadNegocio");
		var negocio = get("frmAtributos.varNegocio");

		//alert('seteaPantalla subcriterio '+ subcriterio + 'marca ' + marca );
		switch ( parseInt(subcriterio, 10) )
		{
		case 1: // Capa Todos.
/*			set("frmAtributos.textNAniversario6", numAniversario);
			set("frmAtributos.textEdadDesde6", edadDesde );	 
			set("frmAtributos.textEdadHasta6", edadHasta );
			set("frmAtributos.textMonto6", monto);
			set("frmAtributos.cbPeriodoDesde6", new Array(periodoDesde) );
			set("frmAtributos.cbPeriodoHasta6", new Array(periodoHasta) );
			set("frmAtributos.cbMarca6", new Array(marca) );
			set("frmAtributos.cbCatalogo6", new Array(catalogo) );
			set("frmAtributos.cbUnidNegocio6", new Array(unidadNegocio) );
			set("frmAtributos.cbNegocio6", new Array(negocio) ); */ 
			break;
		case 2: // Cumpleaños
			set("frmAtributos.textNAniversario", numAniversario);
			break; 
		case 3: // Aniversario (Idem Cumpleaños)
			set("frmAtributos.textNAniversario", numAniversario);
			break;
		case 4: // Edad
			set("frmAtributos.textEdadDesde", edadDesde );
			set("frmAtributos.textEdadHasta", edadHasta );
			break;
		case 5: // Pedido Supera Monto
			set("frmAtributos.textMonto1", monto);
			set("frmAtributos.cbPeriodoDesde1", new Array(periodoDesde) );
			set("frmAtributos.cbPeriodoHasta1", new Array(periodoHasta) );
			break;
		case 6: // Pedido Supera Monto Marca
			set("frmAtributos.textMonto2", monto);
			set("frmAtributos.cbPeriodoDesde2", new Array(periodoDesde) );
			set("frmAtributos.cbPeriodoHasta2", new Array(periodoHasta) );
			set("frmAtributos.cbMarca", new Array(marca) );
			break;
		case 7: // Pedido Supera Monto Unidad Negocio
			set("frmAtributos.textMonto3", monto);
			set("frmAtributos.cbPeriodoDesde3", new Array(periodoDesde) );
			set("frmAtributos.cbPeriodoHasta3", new Array(periodoHasta) );
			set("frmAtributos.cbUnidNegocio", new Array(unidadNegocio) );
			break;
		case 8: // Pedido Supera Monto Negocio
			set("frmAtributos.textMonto4", monto);
			set("frmAtributos.cbPeriodoDesde4", new Array(periodoDesde) );
			set("frmAtributos.cbPeriodoHasta4", new Array(periodoHasta) );	 
			set("frmAtributos.cbNegocio", new Array(negocio) );
			break;
		case 9: // Pedido Supera Monto Catalogo
			set("frmAtributos.textMonto5", monto);
			set("frmAtributos.cbPeriodoDesde5", new Array(periodoDesde) );
			set("frmAtributos.cbPeriodoHasta5", new Array(periodoHasta) );
			set("frmAtributos.cbCatalogo", new Array(catalogo) );
			break;
		case 23: // Pedido NO Supera Monto
			set("frmAtributos.textMonto23", monto);
			set("frmAtributos.cbPeriodoDesde23", new Array(periodoDesde) );
			set("frmAtributos.cbPeriodoHasta23", new Array(periodoHasta) );
			break;
		case 24: // Pedido NO Supera Monto Marca
			set("frmAtributos.textMonto24", monto);
			set("frmAtributos.cbPeriodoDesde24", new Array(periodoDesde) );
			set("frmAtributos.cbPeriodoHasta24", new Array(periodoHasta) );
			set("frmAtributos.cbMarca2", new Array(marca) );
			break;
		case 25: // Pedido NO Supera Monto Unidad Negocio
			set("frmAtributos.textMonto25", monto);
			set("frmAtributos.cbPeriodoDesde25", new Array(periodoDesde) );
			set("frmAtributos.cbPeriodoHasta25", new Array(periodoHasta) );
			set("frmAtributos.cbUnidNegocio2", new Array(unidadNegocio) );
			break;
		case 26: // Pedido NO Supera Monto Negocio
			set("frmAtributos.textMonto26", monto);
			set("frmAtributos.cbPeriodoDesde26", new Array(periodoDesde) );
			set("frmAtributos.cbPeriodoHasta26", new Array(periodoHasta) );	 
			set("frmAtributos.cbNegocio2", new Array(negocio) );
			break;
		case 27: // Pedido NO Supera Monto Catalogo
			set("frmAtributos.textMonto27", monto);
			set("frmAtributos.cbPeriodoDesde27", new Array(periodoDesde) );
			set("frmAtributos.cbPeriodoHasta27", new Array(periodoHasta) );
			set("frmAtributos.cbCatalogo2", new Array(catalogo) );
			break;
			
		// sapaza -- PER-SiCC-2010-0628 -- 20/10/2010	
		case 28: // DuplaCyzone
			set("frmAtributos.cbPeriodoDesde7", new Array(periodoDesde) );
			set("frmAtributos.cbPeriodoHasta7", new Array(periodoHasta) );
			break;		
					
		}
		
		// Modific. x ssantana,  1/12/2004, Inc. 11065
/*		if ( subcriterio != 1)  // Subcriterio = "todos"
		{*/
			// Si subcriterio es "TODOS" entonces no llama a esta funcion, ya que cierra la pantalla de ser así.
		changeAtributo();
			//procesaAtributo("S");
//		}



}

// -------------------------------------------------------------------------------------------------------------------------------------------
function tabAceptar()
{
	if ( capaMostrada == "")
	{
		focaliza("frmAtributos.textNUnidClienteRepartir", "");
	} else
	{
		switch ( parseInt(capaMostrada,10) )
		{
		case 1: // Capa Todos.
			focaliza("frmAtributos.textNAniversario6", "");
			break;
		case 2: // Cumpleaños
			focaliza("frmAtributos.textNAniversario", "");
			break; 
		case 3: // Aniversario (Idem Cumpleaños)
			focaliza("frmAtributos.textNAniversario", "");
			break;
		case 4: // Edad
			focaliza("frmAtributos.textEdadDesde", "");
			break;
		case 5: // Pedido Supera Monto
			focaliza("frmAtributos.textMonto1", "");
			break;
		case 6: // Pedido Supera Monto Marca
			focaliza("frmAtributos.textMonto2", "");
			break;
		case 7: // Pedido Supera Monto Unidad Negocio
			focaliza("frmAtributos.textMonto3", "");
			break;
		case 8: // Pedido Supera Monto Negocio
			focaliza("frmAtributos.textMonto4", "");
			break;
		case 9: // Pedido Supera Monto Catalogo
			focaliza("frmAtributos.textMonto5", "");
			break;
		case 23: // Pedido NO Supera Monto
			focaliza("frmAtributos.textMonto23", "");
			break;
		case 24: // Pedido NO Supera Monto Marca
			focaliza("frmAtributos.textMonto24", "");
			break;
		case 25: // Pedido NO Supera Monto Unidad Negocio
			focaliza("frmAtributos.textMonto25", "");
			break;
		case 26: // Pedido NO Supera Monto Negocio
			focaliza("frmAtributos.textMonto26", "");
			break;
		case 27: // Pedido NO Supera Monto Catalogo
			focaliza("frmAtributos.textMonto27", "");
			break;
							
		case 28: // DuplaCyzone
			focaliza("frmAtributos.cbPeriodoDesde7", "");
			break;				
		
		}
	}

}

// -------------------------------------------------------------------------------------------------------------------------------------------
function shTab()
{
	// ************************************************************************
	// Se invoca al hacer onshtab en el CTexto Numero de Unidades
	// ************************************************************************

	document.selection.empty();
	if ( capaMostrada == "")
	{
		// Focaliza el control sobre el boton Aceptar.
		focalizaBotonHTML("botonContenido", "btnAceptar");
	} else
	{
		switch ( parseInt(capaMostrada,10) )
		{
			case 1: // Capa Todos.
				focalizaBotonHTML("botonContenido", "btnContinuar1");
				break;
			case 2: // Cumpleaños
				focalizaBotonHTML("botonContenido", "btnContinuar");
				break; 
			case 3: // Aniversario (Idem Cumpleaños)
				focalizaBotonHTML("botonContenido", "btnContinuar");
				break;
			case 4: // Edad
				focalizaBotonHTML("botonContenido", "btnContinuar2");
				break;
			case 5: // Pedido Supera Monto
				focalizaBotonHTML("botonContenido", "btnContinuar3");
				break;
			case 6: // Pedido Supera Monto Marca
				focalizaBotonHTML("botonContenido", "btnContinuar4");
				break;
			case 7: // Pedido Supera Monto Unidad Negocio
				focalizaBotonHTML("botonContenido", "btnContinuar5");
				break;
			case 8: // Pedido Supera Monto Negocio
				focalizaBotonHTML("botonContenido", "btnContinuar6");
				break;
			case 9: // Pedido Supera Monto Catalogo
				focalizaBotonHTML("botonContenido", "btnContinuar7");
				break;
			case 23: // Pedido NO Supera Monto
				focalizaBotonHTML("botonContenido", "btnContinuar23");
				break;
			case 24: // Pedido NO Supera Monto Marca
					focalizaBotonHTML("botonContenido", "btnContinuar24");
					break;
			case 25: // Pedido NO Supera Monto Unidad Negocio
					focalizaBotonHTML("botonContenido", "btnContinuar25");
					break;
			case 26: // Pedido NO Supera Monto Negocio
					focalizaBotonHTML("botonContenido", "btnContinuar26");
					break;
			case 27: // Pedido NO Supera Monto Catalogo
					focalizaBotonHTML("botonContenido", "btnContinuar27");
					break;					
		}
		
	}

}

// -------------------------------------------------------------------------------------------------------------------------------------------
function changeAtributo()
{
	// Se dispara al hacer Onchange en el Combo de Atributos
	var aceptar = GestionarMensaje("1291");
	var continuar = GestionarMensaje("1292");
    //alert('changeAtributo');
	var atributo = get("frmAtributos.cbAtributoEvaluar");
	switch ( parseInt(atributo, 10) )
	{
		case 1: // Todos
		case 2: // Cumpleaños.
			document.getElementById("capaAniversario").style.visibility = "hidden";
			document.getElementById("capaEdad").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("btnAceptar").value = continuar;
			//
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("capaDuplaCyzone").style.visibility = "hidden";			
			break;
		case 3:  // Aniversario
			document.getElementById("capaAniversario").style.visibility = "visible";
			document.getElementById("capaEdad").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("btnAceptar").value = aceptar;
			//
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("capaDuplaCyzone").style.visibility = "hidden";			
			break;
		case 4:  // Edad
			document.getElementById("capaAniversario").style.visibility = "hidden";
			document.getElementById("capaEdad").style.visibility = "visible";
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("btnAceptar").value = aceptar;
			//
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("capaDuplaCyzone").style.visibility = "hidden";			
			break;
		case 5:  // Pedido Supera Monto
			document.getElementById("capaAniversario").style.visibility = "hidden";
			document.getElementById("capaEdad").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "visible";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "hidden";
			//
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("btnAceptar").value = aceptar;
			document.getElementById("capaDuplaCyzone").style.visibility = "hidden";			
			break;
		case 6:  // Pedido Supera Monto Marca
			document.getElementById("capaAniversario").style.visibility = "hidden";
			document.getElementById("capaEdad").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "visible";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("btnAceptar").value = aceptar;
			//
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("capaDuplaCyzone").style.visibility = "hidden";						
			break;
		case 7:  // Pedido Supera Monto Unidad Negocio
			document.getElementById("capaAniversario").style.visibility = "hidden";
			document.getElementById("capaEdad").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "visible";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("btnAceptar").value = aceptar;
			//			
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("capaDuplaCyzone").style.visibility = "hidden";						
			break;
		case 8:  // Pedido Supera Monto Negocio
			document.getElementById("capaAniversario").style.visibility = "hidden";
			document.getElementById("capaEdad").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "visible";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("btnAceptar").value = aceptar;
			//
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("capaDuplaCyzone").style.visibility = "hidden";						
			break;
		case 9:  // Pedido Supera Monto Catalogo
			document.getElementById("capaAniversario").style.visibility = "hidden";
			document.getElementById("capaEdad").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "visible";
			document.getElementById("btnAceptar").value = aceptar;
			//
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("capaDuplaCyzone").style.visibility = "hidden";			
			break;
		case 23:  // Pedido NO supera monto
			document.getElementById("capaAniversario").style.visibility = "hidden";
			document.getElementById("capaEdad").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "visible";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("btnAceptar").value = aceptar;
			//
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("capaDuplaCyzone").style.visibility = "hidden";			
			break;
		case 24:  // Pedido NO supera monto en marca
			document.getElementById("capaAniversario").style.visibility = "hidden";
			document.getElementById("capaEdad").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "visible";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("btnAceptar").value = aceptar;
			//
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("capaDuplaCyzone").style.visibility = "hidden";						
			break;
		case 25:  // Pedido NO supera monto en unidad de negocio
			document.getElementById("capaAniversario").style.visibility = "hidden";
			document.getElementById("capaEdad").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "visible";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("btnAceptar").value = aceptar;
			//
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("capaDuplaCyzone").style.visibility = "hidden";			
			break;
		case 26:  // Pedido NO supera monto en negocio
			document.getElementById("capaAniversario").style.visibility = "hidden";
			document.getElementById("capaEdad").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "visible";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("btnAceptar").value = aceptar;
			//
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("capaDuplaCyzone").style.visibility = "hidden";
			break;
		case 27:  // Pedido NO supera monto en catálogo
			document.getElementById("capaAniversario").style.visibility = "hidden";
			document.getElementById("capaEdad").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "visible";
			document.getElementById("btnAceptar").value = aceptar;
			//
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("capaDuplaCyzone").style.visibility = "hidden";	
			break;
			
		case 28:  // DuplaCyzone
			document.getElementById("capaAniversario").style.visibility = "hidden";
			document.getElementById("capaEdad").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("btnAceptar").value = aceptar;
			//
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "hidden";			
			document.getElementById("capaDuplaCyzone").style.visibility = "visible";
			break;			
						
	    default:
	 		document.getElementById("capaAniversario").style.visibility = "hidden";
			document.getElementById("capaEdad").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMonto").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoMarca").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoUnidNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoNegocio").style.visibility = "hidden";
			document.getElementById("capaPedidoNOSuperaMontoCatalogo").style.visibility = "hidden";
			document.getElementById("btnAceptar").value = aceptar;
			break;
			
	}	

}
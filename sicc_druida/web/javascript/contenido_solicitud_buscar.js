function onLoadPag(){ 
      focaliza('formulario.txtNumeroSolicitud')
   		ocultarLista();
      configurarMenuSecundario("formulario");
      fMostrarMensajeError();
      DrdEnsanchaConMargenDcho('listado1',12);
      eval (ON_RSZ);  
      
      if(get('formulario.obli')=='S')
        sicc_cambiar_estado("cbTipoSolicitud",true);
   
	  /* Agregado ssantana, 24/03/2006 
	     Si operacion es "modificar" deshabilita combo "Grupo Procesos"
		 y selecciona primer elemento (GP1)
	  */
	  var operacion = get("formulario.operacion");
	  if (operacion == "modificar") {
		 var gp1 = get("formulario.constanteGP1");
		 set("formulario.cbGrupoProcesos", new Array(gp1) );
		 accion("formulario.cbGrupoProcesos", ".disabled=true");
	  }

	  /* Fin Agregado ssantana, 24/03/2006 */
		
      /*DrdEnsanchaConMargenDcho('listado1',12); 
      document.all["Cplistado1"].style.visibility=''; 
      document.all["CpLin1listado1"].style.visibility='';  
      document.all["CpLin2listado1"].style.visibility=''; 
      document.all["CpLin3listado1"].style.visibility='';
      document.all["CpLin4listado1"].style.visibility='';  
      document.all["primera1Div"].style.visibility=''; 
      document.all["ret1Div"].style.visibility='';
      document.all["ava1Div"].style.visibility='';  
      document.all["separaDiv"].style.visibility=''; 
      eval (ON_RSZ);   */
         
    }
    
    function ocultarLista() {
        document.all["Cplistado1"].style.visibility='hidden'; 
        document.all["CpLin1listado1"].style.visibility='hidden';
        document.all["CpLin2listado1"].style.visibility='hidden' ;
        document.all["CpLin3listado1"].style.visibility='hidden' ;
        document.all["CpLin4listado1"].style.visibility='hidden';
        document.all["primera1Div"].style.visibility='hidden'; 
        document.all["ret1Div"].style.visibility='hidden'; 
        document.all["ava1Div"].style.visibility='hidden';   
        document.all["separaDiv"].style.visibility='hidden';
        document.all["ConsultarDiv"].style.visibility='hidden';
        document.all["ModificarDiv"].style.visibility='hidden';        
    }

      function mostrarLista() {
        document.all["Cplistado1"].style.visibility='visible'; 
        document.all["CpLin1listado1"].style.visibility='visible';
        document.all["CpLin2listado1"].style.visibility='visible' ;
        document.all["CpLin3listado1"].style.visibility='visible' ;
        document.all["CpLin4listado1"].style.visibility='visible';
        document.all["primera1Div"].style.visibility='visible'; 
        document.all["ret1Div"].style.visibility='visible'; 
        document.all["ava1Div"].style.visibility='visible';   
        document.all["separaDiv"].style.visibility='visible';
		 if (get('formulario.operacion')=='modificar'){
				document.all["ModificarDiv"].style.visibility='visible';
				document.all["ConsultarDiv"].style.visibility='hidden';
		} else if (get('formulario.operacion') == 'consultar') {
				document.all["ModificarDiv"].style.visibility='hidden';
				document.all["ConsultarDiv"].style.visibility='visible';
		}
    }

    function canalOnChange() {
    	var arra = new Array();
	    arra[0] = ["oidPais",get('formulario.oidPais')];
	    arra[1] = ["oidIdioma",get('formulario.oidIdioma')];      
			arra[2] = ["oid",get('formulario.cbCanal')];
      recargaCombo("formulario.cbAcceso","SEGObtieneAccesosPorCanal","es.indra.sicc.util.DTOOID",arra);
    }
    
    function accesoOnChange() {
    	var arra = new Array();
	    arra[0] = ["oidPais",get('formulario.oidPais')];
	    arra[1] = ["oidIdioma",get('formulario.oidIdioma')];      
			arra[2] = ["oid",get('formulario.cbAcceso')];
      recargaCombo("formulario.cbSubacceso","SegObtenerSubaccesosPorAcceso","es.indra.sicc.util.DTOOID",arra);
    }   
    
    function marcaCanalOnChange() {
         set_combo('formulario.cbPeriodo', new Array(new Array("","")));
         if (get('formulario.cbMarca') != '' &&  get('formulario.cbCanal') != ''){
             	var arra = new Array();
              arra[0] = ["oidPais",get('formulario.oidPais')];
              arra[1] = ["oidIdioma",get('formulario.oidIdioma')];      
              arra[2] = ["marca",get('formulario.cbMarca')];
              arra[3] = ["canal",get('formulario.cbCanal')];              
              recargaCombo("formulario.cbPeriodo","PRECargarPeriodos","es.indra.sicc.dtos.cra.DTOPeriodo",arra);
         }
    }

    function marcaOnChange() {
        marcaCanalOnChange();
    }
    
    function grupoProcesosOnChange() {
    	var arra = new Array();
	    arra[0] = ["oidPais",get('formulario.oidPais')];
	    arra[1] = ["oidIdioma",get('formulario.oidIdioma')];      
			arra[2] = ["oid",get('formulario.cbGrupoProcesos')];
      recargaCombo("formulario.cbProcesoValidacion","PEDconsultaCodigosProcesos","es.indra.sicc.util.DTOOID",arra);      
    }
    
    function accionBuscarCliente(){
       var obj = new Object();
       obj.hidOidDescuento = get('formulario.hidOidDescuento');
       var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
       if(whnd!=null){
              var cod = whnd[1];
              set("formulario.txtCodigoCliente", cod);
       }    
    }
    
    function accionBuscarReceptorFactura(){
       var obj = new Object();
       obj.hidOidDescuento = get('formulario.hidOidDescuento');
       var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
       if(whnd!=null){
              var cod = whnd[1];
              set("formulario.txtReceptorFactura", cod);
       }    
    }
    
    function accionBuscarPagadorFactura(){
       var obj = new Object();
       obj.hidOidDescuento = get('formulario.hidOidDescuento');
       var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
       if(whnd!=null){
              var cod = whnd[1];
              set("formulario.txtPagadorFactura", cod);
       }    
    }


function validarFecha(){
  
  var fechaIniPV = get("formulario.txtFechaDocumentoDesde");
  
  var fechaFinPV = get("formulario.txtFechaDocumentoHasta");
  
  if(fechaIniPV != '' && fechaFinPV != ''){
         
          var errorLevel = EsFechaValida( fechaIniPV, fechaFinPV, "formulario", "S");
          if ( errorLevel == 3){
             GestionarMensaje("1191");
             focaliza('formulario.txtFechaDocumentoDesde');
             return false;
          } 
    }
  return true;    
  }  
  
  
 
function validarPagar(){
  
  var desde = get("formulario.txtTotalPagarDesde");
  var hasta = get("formulario.txtTotalPagarHasta");
  if(desde != '' && hasta != ''){
          if ( parseInt(hasta, 10) < parseInt(desde, 10) ){
             GestionarMensaje("1471");
             focaliza('formulario.txtTotalPagarDesde');
             return false;
          } 
    }
  return true;    
  }   
  
    function accionBuscar() {
		// Método modificado por ssantana, 15/4/2005
		// para que muestre correctamente los mensajes de error de cada nivel de validación. 
		// (Inc. pruebas BELC300016138)

        if (validaCantidadCriterios()) {
            if (validarFecha()) {        
                if (validarPagar()) {      
                    if(sicc_validaciones_generales()) {      


						//configurarPaginado(mipgndo,"PEDBuscarSolicitud","ConectorBuscarSolicitud","es.indra.sicc.dtos.ped.DTOBuscarSolicitud", armarArray(),"redirijoBuscarSolicitud(rowset, ultima, error)");
						configurarPaginado(mipgndo,"PEDBuscarSolicitud","ConectorBuscarSolicitud","es.indra.sicc.dtos.ped.DTOBuscarSolicitud", armarArray());

					} // End if sicc_validaciones_generales();
                } // End if validarPagar();
            } // End if validarFecha();
        } else {
            GestionarMensaje("UIPED030");
   	    } // End if validaCantidadCriterios();
    }

	function redirijoBuscarSolicitud(rowset, ultima, error)
	{

		listado1.setDatos(rowset)  
		if(rowset.length==0 || (error != null && error!="")){
			ocultarLista();
			return false;
		}
		//scs, se agrega por inc.:  22011
		if( get("formulario.hidOperacion") == "modificar")
		{
			if (especifico4Valores())
			{
				if (rowset.length == 1)
				{
                    
                    for ( i=0; i<rowset.length; i++)
                    {
                        listado1.selecciona(i);                                  
                    }   

			        var codigos = new Array();
			        codigos = listado1.codSeleccionados();
			        var cant = codigos.length;
			        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
			        set("formulario.hidOid", codigos[0]);
      
		            var obj = new Object();
		            obj.hidOid=codigos[0];
		            var salida = mostrarModalSICC('LPBuscarSolicitud',"modificarSolicitud",obj);
					return false;
	
					//accionModificar();
					/*if (rowset.length > 0)
					{
						return true;
					} else {
						return false;
					}
					if (error!="")
					{
						return false;
					}*/

				}
				mostrarLista();
				return true;
			}
			mostrarLista()
			return true;
		}
		mostrarLista()
		return true;
	}
    
	function especifico4Valores(){
		var resu = false;
        if(get("formulario.cbCanal")!="" && get("formulario.cbCanal")!=null){
	       if(get("formulario.cbAcceso")!="" && get("formulario.cbAcceso")!=null){
	          if(get("formulario.cbSubacceso")!="" && get("formulario.cbSubacceso")!=null){
		         if(get("formulario.txtNumeroSolicitud")!="" && get("formulario.txtNumeroSolicitud")!=null){
					 resu = true;
		         }
  	          }
           }
        }
		return resu;
	}
    
    function armarArray(){
      var arra = new Array();
      var pos = 0;
      
       if(get("formulario.txtNumeroSolicitud")!="" && get("formulario.txtNumeroSolicitud")!=null){
			  	arra[pos] = ["numeroSolicitud",get('formulario.txtNumeroSolicitud')];
          pos++;
       }
       if(get("formulario.cbCanal")!="" && get("formulario.cbCanal")!=null){
			  	arra[pos] = ["canal",get('formulario.cbCanal')];
          pos++;
       }
       if(get("formulario.cbAcceso")!="" && get("formulario.cbAcceso")!=null){
			  	arra[pos] = ["acceso",get('formulario.cbAcceso')];
          pos++;
       }
       if(get("formulario.cbSubacceso")!="" && get("formulario.cbSubacceso")!=null){
			  	arra[pos] = ["subacceso",get('formulario.cbSubacceso')];
          pos++;
       }
       if(get("formulario.cbTipoSolicitud")!="" && get("formulario.cbTipoSolicitud")!=null){
			  	arra[pos] = ["tipoSolicitud",get('formulario.cbTipoSolicitud')];
          pos++;
       }       
       if(get("formulario.txtCodigoCliente")!="" && get("formulario.txtCodigoCliente")!=null){
			  	arra[pos] = ["cliente",get('formulario.txtCodigoCliente')];
          pos++;
       }
       if(get("formulario.txtReceptorFactura")!="" && get("formulario.txtReceptorFactura")!=null){
			  	arra[pos] = ["receptor",get('formulario.txtReceptorFactura')];
          pos++;
       }
       if(get("formulario.txtPagadorFactura")!="" && get("formulario.txtPagadorFactura")!=null){
			  	arra[pos] = ["pagador",get('formulario.txtPagadorFactura')];
          pos++;
       }
       if(get("formulario.cbGrupoProcesos")!="" && get("formulario.cbGrupoProcesos")!=null){
			  	arra[pos] = ["grupoProcesos",get('formulario.cbGrupoProcesos')];
          pos++;
       }
       if(get("formulario.cbProcesoValidacion")!="" && get("formulario.cbProcesoValidacion")!=null){
			  	arra[pos] = ["proceso",get('formulario.cbProcesoValidacion')];
          pos++;
       }       
       if(get("formulario.cbMarca")!="" && get("formulario.cbMarca")!=null){
			  	arra[pos] = ["marca",get('formulario.cbMarca')];
          pos++;
       }
       if(get("formulario.cbPeriodo")!="" && get("formulario.cbPeriodo")!=null){
			  	arra[pos] = ["periodo",get('formulario.cbPeriodo')];
          pos++;
       }
       if(get("formulario.txtFechaDocumentoDesde")!="" && get("formulario.txtFechaDocumentoDesde")!=null){
			  	arra[pos] = ["fechaDesde",get('formulario.txtFechaDocumentoDesde')];
          pos++;
       }
       if(get("formulario.txtFechaDocumentoHasta")!="" && get("formulario.txtFechaDocumentoHasta")!=null){
			  	arra[pos] = ["fechaHasta",get('formulario.txtFechaDocumentoHasta')];
          pos++;
       }
       if(get("formulario.cbEstadoSolicitud")!="" && get("formulario.cbEstadoSolicitud")!=null){
			  	arra[pos] = ["estado",get('formulario.cbEstadoSolicitud')];
          pos++;
       }
       if(get("formulario.txtTotalPagarDesde")!="" && get("formulario.txtTotalPagarDesde")!=null){
			  	arra[pos] = ["totalPagarDesde",get('formulario.txtTotalPagarDesde')];
          pos++;
       }
       if(get("formulario.txtTotalPagarHasta")!="" && get("formulario.txtTotalPagarHasta")!=null){
			  	arra[pos] = ["totalPagarHasta",get('formulario.txtTotalPagarHasta')];
          pos++;
       }
       if (get('formulario.operacion')=='modificar'){
				arra[pos] = ["operacion","M"];
				pos++;
	   } else if (get('formulario.operacion') == 'consultar') {
				arra[pos] = ["operacion","C"];
				pos++;
	   }  
	    if (get("formulario.oidPais")!="" && get('formulario.oidPais')!=null){
				arra[pos] = ["oidPais",get('formulario.oidPais')];
				pos++;
	   }
	     if (get("formulario.oidIdioma")!="" && get('formulario.oidIdioma')!=null){
				arra[pos] = ["oidIdioma",get('formulario.oidIdioma')];
				pos++;
	   }
       if(get("formulario.indModificacion")!="" && get("formulario.indModificacion")!=null){
          if(get("formulario.indModificacion")=="true")
            arra[pos] = ["indModificacion","true"];
          else arra[pos] = ["indModificacion","false"];
       }              
       
      return arra;
    }

    function validaCantidadCriterios(){
        var num = 0;
        
        if(get("formulario.txtNumeroSolicitud")!="" && get("formulario.txtNumeroSolicitud")!=null)
            num++;
        if(get("formulario.cbCanal")!="" && get("formulario.cbCanal")!=null)
            num++;
        if(get("formulario.cbAcceso")!="" && get("formulario.cbAcceso")!=null)
            num++;
        if(get("formulario.cbSubacceso")!="" && get("formulario.cbSubacceso")!=null)
            num++;
        if(get("formulario.cbTipoSolicitud")!="" && get("formulario.cbTipoSolicitud")!=null)        
            num++;
        if(get("formulario.txtCodigoCliente")!="" && get("formulario.txtCodigoCliente")!=null)
            num++;
        if(get("formulario.txtReceptorFactura")!="" && get("formulario.txtReceptorFactura")!=null)
            num++;
        if(get("formulario.txtPagadorFactura")!="" && get("formulario.txtPagadorFactura")!=null)
            num++;
        if(get("formulario.cbGrupoProcesos")!="" && get("formulario.cbGrupoProcesos")!=null)
            num++;
        if(get("formulario.cbProcesoValidacion")!="" && get("formulario.cbProcesoValidacion")!=null)
            num++;
        if(get("formulario.cbMarca")!="" && get("formulario.cbMarca")!=null)
            num++;
        if(get("formulario.cbPeriodo")!="" && get("formulario.cbPeriodo")!=null)
            num++;
        if(get("formulario.txtFechaDocumentoDesde")!="" && get("formulario.txtFechaDocumentoDesde")!=null)
            num++;
        if(get("formulario.txtFechaDocumentoHasta")!="" && get("formulario.txtFechaDocumentoHasta")!=null)
            num++;
        if(get("formulario.cbEstadoSolicitud")!="" && get("formulario.cbEstadoSolicitud")!=null)
            num++;
        if(get("formulario.txtTotalPagarDesde")!="" && get("formulario.txtTotalPagarDesde")!=null)        
            num++;
        if(get("formulario.txtTotalPagarHasta")!="" && get("formulario.txtTotalPagarHasta")!=null)                
            num++;
            
        if(num < 3)
          return false;
        else return true;  
    }
    
    function accionConsultar(){
        var codigos = new Array();
        codigos = listado1.codSeleccionados();
        var cant = codigos.length;
        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
        set("formulario.hidOid", codigos[0]);
      
        if (cant == 1)	{
            var obj = new Object();
            obj.hidOid=codigos[0];
            mostrarModalSICC('LPBuscarSolicitud',"consultarSolicitud",obj,750,350);
        }	else	GestionarMensaje('50');    
    }
    
    function accionModificar(){
        var codigos = new Array();
        codigos = listado1.codSeleccionados();
        var cant = codigos.length;
        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
        set("formulario.hidOid", codigos[0]);
      
        if (cant == 1){
            var obj = new Object();
            obj.hidOid=codigos[0];
            var salida = mostrarModalSICC('LPBuscarSolicitud',"modificarSolicitud",obj);
            
			/* No realizaremos 'accionBuscar()' cuando se vuelve de editar registro
			   unico pues sino vuelve a abrir la modal */
			if(listado1.datos.length != 1 ) {
				accionBuscar();
			}

        } else	GestionarMensaje('50');    
    }
    
	function prueba(ultima, rowset, error){
		var tamano = rowset.length;
    
		// Agregado @eiraola para INC. DBLG400000775 = BELC300022012
		if(validarCriterioByPassLista() && (tamano == 1)) {
			/* Método modificado por eiraola, 12/01/2006 (INC DBLG400000775 = BELC300022012)
               para que redirija directamente al elemento buscado
               sin pasar por la selección en la lista cuando es
               único el elemento (de acuerdo al criterio predeterminado) */

			var obj = new Object();
			obj.hidOid = rowset[0][0];  // Del primer registro [0] el primer campo [0] es el oid

			if (get('formulario.operacion') == 'modificar') {
				var salida = mostrarModalSICC('LPBuscarSolicitud',"modificarSolicitud",obj);
		        accionBuscar();
			}
			if (get('formulario.operacion') == 'consultar') {
				mostrarModalSICC('LPBuscarSolicitud',"consultarSolicitud",obj,750,350);
			}

			return true;
		} // End if validarCriterioByPassLista() && (tamano == 1);
		// fin Agregado @eiraola

		if (tamano > 0) {
		 document.all["Cplistado1"].style.visibility='';
		 document.all["CpLin1listado1"].style.visibility='';
		 document.all["CpLin2listado1"].style.visibility='';
		 document.all["CpLin3listado1"].style.visibility='';
		 document.all["CpLin4listado1"].style.visibility='';
		 document.all["primera1Div"].style.visibility='';
		 document.all["ret1Div"].style.visibility='';
		 document.all["ava1Div"].style.visibility='';
		 document.all["separaDiv"].style.visibility='';
		document.all["ConsultarDiv"].style.visibility='visible';
		 eval (ON_RSZ);
		 //set('formulario.operacion','modificar')
		//alert(get('formulario.operacion'));
		 if (get('formulario.operacion')=='modificar'){
		    document.all["ModificarDiv"].style.visibility='visible';
	       document.all["ConsultarDiv"].style.visibility='hidden';
			 }

		 return true;
		}  else {
		 document.all["Cplistado1"].style.visibility='hidden';
		 document.all["CpLin1listado1"].style.visibility='hidden';
		 document.all["CpLin2listado1"].style.visibility='hidden';
		 document.all["CpLin3listado1"].style.visibility='hidden';
		 document.all["CpLin4listado1"].style.visibility='hidden';
		 document.all["primera1Div"].style.visibility='hidden';
		 document.all["ret1Div"].style.visibility='hidden';
		 document.all["ava1Div"].style.visibility='hidden';
     document.all["separaDiv"].style.visibility='hidden';
     document.all["ConsultarDiv"].style.visibility='hidden';
     document.all["ModificarDiv"].style.visibility='hidden';     
						
		  focaliza('formulario.txtNumeroSolicitud','');
		  cdos_mostrarAlert(error);
		  return false;
		}
  } 
  
  function checkTable(){
		if(document.all["Cplistado1"].style.visibility == 'hidden') {
		  focalizaBotonHTML('botonContenido','btnBuscar');
		} else {
		 if(get('formulario.operacion') == "consultar")     
			focalizaBotonHTML('botonContenido','Consultar');
		 else
			focalizaBotonHTML('botonContenido','Modificar');
		}
	}


	function checkTable2(){
		if(document.all["Cplistado1"].style.visibility == 'hidden') {
		  focaliza('formulario.txtNumeroSolicitud');
		} else {
		 if(get('formulario.operacion') == "consultar" )     
			focalizaBotonHTML('botonContenido','Consultar');
		 else
			focalizaBotonHTML('botonContenido','Modificar');
		}
	}

	/*
	Funcion que indica si el usuario ingreso el criterio: 
	[Nro.Solicitud + Canal + Acceso + Subacceso]
	que le permitirá recuperar un único registro (o datos inexistentes)
	Devuelve 'true' si especificó este conjunto de criterios, y
	'false' si falta alguno de los criterios indicados.

	Autor: Emilio Iraola
	Fecha: 12/01/2006
	Motivo: Creado como parte de corrección de INC. DBLG400000775 = BELC300022012
	*/
	function validarCriterioByPassLista() {
		var num = 0;
        
        if(get("formulario.txtNumeroSolicitud")!="" && get("formulario.txtNumeroSolicitud")!=null) {
            num++;
        }
        if(get("formulario.cbCanal")!="" && get("formulario.cbCanal")!=null) {
            num++;
        }
        if(get("formulario.cbAcceso")!="" && get("formulario.cbAcceso")!=null) {
            num++;
        }
        if(get("formulario.cbSubacceso")!="" && get("formulario.cbSubacceso")!=null) {
            num++;
        }

        if(num == 4) {
            return true;
        }
        else {
            return false; 
        }
	}


	/*
	 * dmorello, 11/05/2006
	 * Esta función rellena con ceros el código de cliente del campo cuyo nombre recibe como parámetro.
	   mdolce 14/12/2006 El valor de la cantidad de ceros NO VA HARDCODEADO, se configura en la BBDD.
	 */
	function rellenaCeros(nombreCTexto) {
		var codigo = get("formulario." + nombreCTexto);
		var longitud = get('formulario.hLongCliente')
		if (codigo != '') {
			while (codigo.length < longitud) {
				codigo = '0' + codigo;
			}
			set("formulario." + nombreCTexto, codigo);
 	    }
	}
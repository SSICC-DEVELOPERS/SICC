    var formName = "formulario";
    var arrLimpia = new Array();
    var varNoLimpiarSICC = true;
	 var arrComboAcceso;
	 var arrComboSubacceso ;

    function onLoadPag(){

		if (get('formulario.hModificable') == "no") {

			fMostrarMensajeError();
			window.returnValue = null; // Para que no actualice el LISTADO si no se 'guardó' correctamente.
			window.close();

		} else {
        
			DrdEnsanchaConMargenDcho('listado1',12);
			document.all["Cplistado1"].style.visibility='';
			document.all["CpLin1listado1"].style.visibility='';
			document.all["CpLin2listado1"].style.visibility='';
			document.all["CpLin3listado1"].style.visibility='';
			document.all["CpLin4listado1"].style.visibility='';
			document.all["separaDiv"].style.visibility='hidden';
			document.all["primera1Div"].style.visibility='hidden';
			document.all["ret1Div"].style.visibility='hidden';
			document.all["ava1Div"].style.visibility='hidden';
			document.all["btnSiguienteDiv"].style.visibility='';
			eval (ON_RSZ);  
				
			configurarMenuSecundario('formulario');

			txt_to('lbldtPais',get('formulario.hidDescripcionPais'));
			txt_to('lbldtNumDescuento',get('formulario.hidNumDescuento'));
			
			guardoConExito();
			
			document.getElementById("InsertarP1").style.backgroundColor = "#496A9A";
			document.getElementById("InsertarP1").style.color = "#FFFFFF";

			fMostrarMensajeError();
			
			//Incidencia 6285
			//Si (casodeuso = "insertar") entonces
			//-> Mostrar el atributo "activo" deschequeado y deshabilitado
			//Si no Si (casodeuso = "modificar") entonces
			//-> Mostrar el atributo "activo" con el valor recuperado y habilitado para ser modificado
			//Fin Si

			ColocarValoresDeLaMatrizDeDescuento();
			verifObligatoriedad();
			if (get('formulario.hidCasoDeUso') =='insertar' ){
				// Genera la Lista sin indicar Activo
				listado1.actualizaDat();
				var datosLista = listado1.datos;
				var parametros = new Array();
		
				for (var i = 0; i < datosLista.length; i++)
				{
					//if (datosLista[i][0] != 5) (ahora se muestra en la insercion el "Activo")
					parametros[parametros.length] = datosLista[i];
				}
				
				if (get('formulario.hVuelveErrPest')=='S'){    
					seteaValores();
				}
				marcaValoresDeParametro();
				//set("formulario.hidActiva", "N"); (ahora se muestra en la insercion el "Activo")
				listado1.setDatos(parametros);

			}

			if ( get('formulario.hidCasoDeUso')=='consultar' || get('formulario.hidCasoDeUso')=='modificar' ){                  
						 seteaValores();
						 marcaValoresDeParametro();
						if ( get('formulario.hidCasoDeUso')=='consultar'){     
								 resguardarValoresCombo();
								 deshabilitarEnConsulta();
						}//else 
				  }
				
			if ( get('formulario.hidCasoDeUso')=='modificar'){
			
				//Mostrar página "contenido_datos_generales_descuento_crear" con todos los controles deshabilitados y con el botón "siguiente" deshabilitado
					if (get('formulario.hidVigenciaDescuento')=='C')
					{
						deshabilitarEnConsulta();
						deshabilitarHabilitarBoton("botonContenido","btnSiguiente", "D");
						btnProxy(5, '0'); //limpiar
						btnProxy(1, '0');	//guardar
					}
					else if (get('formulario.hidVigenciaDescuento')=='V')
					{
						deshabilitarEnDescuentoVigente();
						deshabilitarHabilitarBoton("botonContenido","btnSiguiente", "D");

						var listadoDatos = listado1.datos;

						var cantCodigos = listado1.codigos().length;                   
						
						listado1.actualizaDat();                    
						var nuevos_datos = new Array();
						listado1.setDatos(nuevos_datos);
						var datos;                    

						for ( var i = 0; i < cantCodigos; i++) 
						{
							switch ( parseInt(listadoDatos[i][0], 10) )
							{
								case 5:
									datos = listadoDatos[i][0] + "|" + listadoDatos[i][1] + "|" +  listadoDatos[i][2];                                    
									insertaParametros(datos);
									break;
								case 29:
									datos = listadoDatos[i][0] + "|" + listadoDatos[i][1] + "|" +  listadoDatos[i][2];
									insertaParametros(datos);
									break;
								case 30:
									datos = listadoDatos[i][0] + "|" + listadoDatos[i][1] + "|" +  listadoDatos[i][2];
									insertaParametros(datos);
									break;
							}//switch
						} //for						  
						btnProxy(1, '1');	//guardar
					}
				}


		  if ( get('formulario.hidCasoDeUso')=='modificar') {
			  if (get('formulario.hidVigenciaDescuento')=='V')
				  focaliza("formulario.cbVigenciaPeriodoHasta");
			  else
				  if (get('formulario.hidVigenciaDescuento')=='F')
					  focaliza("formulario.txtNombreDescuento");
		  } else {
			  if ( get('formulario.hidCasoDeUso')=='insertar')
				  focaliza("formulario.txtNombreDescuento");
			  else                    
				  if ( get('formulario.hidCasoDeUso')=='consultar')
						  focalizaBotonHTML('botonContenido','btnSiguiente');
		  }
				
			  tomarDatosPagina();
		}
   }
   
	function resguardarValoresCombo(){
				arrComboAcceso= get("formulario.cbAcceso") ;
				arrComboSubacceso= get('formulario.cbSubacceso') ;
				
	}

	function seteaValores() {
		marcaSeleccionDelUsuario('formulario.cbMarca', get("formulario.hidOidMarca"));
        marcaSeleccionDelUsuario('formulario.cbCanal', get("formulario.hidOidCanal"));
        canalOnChange();
			var selac = get("formulario.hidAccesos");
			selac = selac.split(",");
			
		  set("formulario.cbAcceso",selac);
        buscoAcceso();
			var selsub = get("formulario.hidSubAccesos");
			selsub = selsub.split(",");
		  set("formulario.cbSubacceso",selsub);
	}

  function deshabilitarEnConsulta() { 
      listado1.tiposCol[1][6]=true; 
      listado1.actualizaDat();
      listado1.repinta();         	
		  accion("formulario.txtNombreDescuento",".disabled=true");
		  accion("formulario.cbMarca",".disabled=true");
		  accion("formulario.cbCanal",".disabled=true");
		  //accion("formulario.cbAcceso",".readonly=true");
		  //accion("formulario.cbSubacceso",".readonly=true");
		  accion("formulario.cbVigenciaPeriodoDesde",".disabled=true");
		  accion("formulario.cbVigenciaPeriodoHasta",".disabled=true");		  
  } 

  function navegaPestaniasDetalle(pestanya) {    
        
      if (recogerInformacion() == true){  
        set('formulario.conectorAction', 'LPMantenimientoDTODG');
        set('formulario.accion', 'siguiente');

        var estadoDescuento = get('formulario.hidVigenciaDescuento');
        var casoUso = get("formulario.hidCasoDeUso");

        if (casoUso == "modificar" && (estadoDescuento == "C" || estadoDescuento == "V" ))
          return;

        var pestActual = get("formulario.hidPestanya"); // Obtiene el numero de pestanya donde se está parado.
         
        // Solo se navega si la pestanya destino no es la misma que la que se está parado.
        if  ( parseInt(pestActual, 10) != parseInt(pestanya,10) ) {
            if(pestanya == 1) {
                set("formulario.hidPestanya", "1");
                if(casoUso != "consultar") {
                  eval('formulario').oculto="S";     
                }                   
                enviaSICC('formulario');  
            }
        }
      }  
   }

   function accionSiguiente() {
        
        if (validarFacturasOCCC() == true) {
            if (recogerInformacion() == true){
                set('formulario.conectorAction', 'LPMantenimientoDTODG');            
                set('formulario.accion', 'siguiente');
                                  
                enviaSICC('formulario');                
           }
        }
    }

    function recogerInformacion() {
        if (validarControles()) {
            set('formulario.hidDescripcion',get('formulario.txtNombreDescuento'));
            set('formulario.hidOidMarca',get('formulario.cbMarca','V'));
            set('formulario.hidOidCanal',get('formulario.cbCanal','V'));

            var vAcccesos = getComboSeleccionado('formulario.cbAcceso');
				
            if (vAcccesos != '')
                set('formulario.hidAccesos', vAcccesos);

            var vSubacccesos = getComboSeleccionado('formulario.cbSubacceso');
            if (vSubacccesos != '')
                set('formulario.hidSubAccesos', vSubacccesos);

            set('formulario.hidOidPeriodoDesde',get('formulario.cbVigenciaPeriodoDesde','V'));
            set('formulario.hidOidPeriodoHasta',get('formulario.cbVigenciaPeriodoHasta','V'));

            //Tomar valores de la lista editable
            var listadoDatos = listado1.datos;
            var cantCodigos = listado1.codigos().length;

            listado1.actualizaDat();
            var listadoDatos = listado1.datos;
            var cantCodigos = listado1.codigos().length;
				
            listado1.actualizaDat();
				
            for ( var i = 0; i < cantCodigos; i++) {
                switch ( parseInt(listadoDatos[i][0], 10) ) {
                    case 28:
                        set('formulario.hidDescuentoAcumulativo',   listadoDatos[i][2]);
								break;
                    case 2:
                        set('formulario.hidCulminacion',    listadoDatos[i][2]);
								break;            
                    case 27:
                        set('formulario.hidControlDevoluciones',    listadoDatos[i][2]);
                        break;
                    case 32:    
                        set('formulario.hidControlAnulaciones', listadoDatos[i][2]);                    
								break;
                    case 31:
                        set('formulario.hidCdomunicacionAParticipantes',    listadoDatos[i][2]);
								break;            
                    case 5:
                        set('formulario.hidActiva', listadoDatos[i][2]);
								break;
                    case 26:
                        set('formulario.hidMorosidad',  listadoDatos[i][2]);
								break;
                    case 29:
                        set('formulario.hidAfectaAFacturas',    listadoDatos[i][2]);
								break;
                    case 30:
                        set('formulario.hidAfectaACuentasCorrientes',   listadoDatos[i][2]);
								break;
                }
            }
            return true;
        }
        else
            return false
    }

    function accionGuardar() {
        
        if (validarFacturasOCCC() == true) {
            if (recogerInformacion()== true) {
                set('formulario.conectorAction', 'LPMantenimientoDTODG');            
                set('formulario.accion', 'siguiente');
                eval('formulario').oculto="S"; 
                enviaSICC('formulario');
            }
        }
    }

    function marcaOnChange() {
    
				if (get('formulario.cbMarca','V') != '' &&  get('formulario.cbCanal','V') != '')	{
					 recargaCombo(formName + ".cbVigenciaPeriodoDesde","CRAObtenerPeriodos","es.indra.sicc.dtos.cra.DTOPeriodo",makeParametersMarcaOnChange(),"marcaMarca(datos)");
					 recargaCombo(formName + ".cbVigenciaPeriodoHasta","CRAObtenerPeriodos","es.indra.sicc.dtos.cra.DTOPeriodo",makeParametersMarcaOnChange(),"marcaCanal(datos)");      
				}
    
	 }

    function makeParametersMarcaOnChange() {
        var parametros = new Array([],[],[]);

        parametros[0][0] = 'pais';
        parametros[0][1] = get('formulario.oidPais');        

        parametros[1][0] = 'marca';
        parametros[1][1]= get('formulario.cbMarca','V');

        parametros[2][0] = 'canal';
        parametros[2][1]= get('formulario.cbCanal','V');

        return parametros;    
    }

    function marcaMarca(datos) {
        var pd = get("formulario.selPD");
        
        var datosNuevo = new Array();
        datosNuevo[0] = ["",""];

        for (var i = 0; i < datos.length; i++ )
            datosNuevo[i+1]  = datos[i];

        set_combo("formulario.cbVigenciaPeriodoDesde", datosNuevo);
        //marcaCombo("cbVigenciaPeriodoDesde", new Array(pd) );        
        set("formulario.cbVigenciaPeriodoDesde", new Array(pd));     
        arrLimpia[7] = get("formulario.cbVigenciaPeriodoDesde");
    }

    function marcaCanal(datos) {
        var ph = get("formulario.selPH");    

        var datosNuevo = new Array();
        datosNuevo[0] = ["",""];

        for (var i = 0; i < datos.length; i++ )
            datosNuevo[i+1]  = datos[i];

        set_combo("formulario.cbVigenciaPeriodoHasta", datosNuevo);
        //marcaCombo("cbVigenciaPeriodoHasta", new Array(ph) );
        set("formulario.cbVigenciaPeriodoHasta", new Array(ph));    
        arrLimpia[8] = get("formulario.cbVigenciaPeriodoHasta");
    }

    function canalOnChange() {
        if (get('formulario.cbCanal','V') != '' ){
            buscoCanal();
            marcaOnChange();
        } else {
            var datosNuevo = new Array();
            datosNuevo[0] = ["",""];    
            set_combo("formulario.cbVigenciaPeriodoDesde", datosNuevo);
            set_combo("formulario.cbVigenciaPeriodoHasta", datosNuevo);
            set_combo("formulario.cbAcceso", datosNuevo);
            set_combo("formulario.cbSubacceso", datosNuevo);
        }
   }

   function accesoOnChange() {
      
	     if ( get('formulario.hidCasoDeUso')!='consultar' ){
			 focaliza("formulario.cbSubacceso");
			  buscoAcceso();	
		  } else{
		  	  set('formulario.cbAcceso', arrComboAcceso	);	
		  }
		 
   }

	function subaccesoOnChange(){
		  if ( get('formulario.hidCasoDeUso')=='consultar' ){
			 set('formulario.cbSubacceso', arrComboSubacceso	);		
		  }
	}
   
	function fGuardar() {
        
        if (validarFacturasOCCC() == true) {
            if (recogerInformacion()== true) {
                set('formulario.conectorAction', 'LPMantenimientoDTODG');            
                set('formulario.accion', 'guardar');                
                enviaSICC('formulario');
            }
        }
   }

	 function	tomarDatosPagina() {
			arrLimpia[0] = get("formulario.hidDescripcionPais");
			arrLimpia[1] = get("formulario.hidNumDescuento");
			arrLimpia[2] = get("formulario.txtNombreDescuento");
			arrLimpia[3] = get("formulario.cbMarca");
			arrLimpia[4] = get("formulario.cbCanal");
			arrLimpia[5] = get("formulario.cbAcceso");
			arrLimpia[6] = get("formulario.cbSubacceso");
	 }

   function fLimpiar() {
   
        if ( get('formulario.hidCasoDeUso')!='consultar') {        
            if( ( get('formulario.hidCasoDeUso')=='modificar') || 
                (get('formulario.hidCasoDeUso')=='insertar')) {
                if (get('formulario.hidVigenciaDescuento')=='V') {
                    set("formulario.cbVigenciaPeriodoHasta",arrLimpia[8]);
                    focaliza("formulario.cbVigenciaPeriodoHasta");                    
                } else {
                    set("formulario.txtNombreDescuento",arrLimpia[2]);
                    set("formulario.cbMarca",arrLimpia[3]);
                    set("formulario.cbCanal",arrLimpia[4]);
                    limpiaCombos();
                    marcaValoresDeParametro();
                    focaliza("formulario.txtNombreDescuento");
                }
            } else focaliza("formulario.txtNombreDescuento");
        }
    }

    function limpiaCombos() {
        var datosNuevo = new Array();
        datosNuevo[0] = ["",""];    
        set_combo("formulario.cbVigenciaPeriodoDesde", datosNuevo);
        set_combo("formulario.cbVigenciaPeriodoHasta", datosNuevo);
        
        if (get('formulario.hidCasoDeUso') =='modificar' ){
        
        } else {
            set_combo("formulario.cbAcceso", datosNuevo);
            set_combo("formulario.cbSubacceso", datosNuevo);        
        }
    }

    function ColocarValoresDeLaMatrizDeDescuento() {

        if (get('formulario.ModificableMarca') == 'N')
            accion('formulario.cbMarca','.disabled=true');
    
        if (get('formulario.ModificableCanal') == 'N')
            accion('formulario.cbCanal','.disabled=true');
      
        if (get('formulario.VisibleAcceso') == 'N') {
            document.getElementById("lblAcceso").style.visibility='hidden';        
            document.getElementById("cbAcceso").style.visibility='hidden';        
        }    
        if (get('formulario.ModificableAcceso') == 'N')
            accion('formulario.cbAcceso','.disabled=true');
    
        if (get('formulario.VisibleSubacceso') == 'N') {
            document.getElementById("lblSubacceso").style.visibility='hidden';        
            document.getElementById("cbSubacceso").style.visibility='hidden';        
        }
        if (get('formulario.ModificableSubacceso') == 'N')
            accion('formulario.cbSubacceso','.disabled=true');
    
        if (get('formulario.VisiblePeriodoInicial') == 'N'){
            document.getElementById("lblVigenciaPeriodoDesde").style.visibility='hidden';        
            document.getElementById("cbVigenciaPeriodoDesde").style.visibility='hidden';        
        }    
        if (get('formulario.ModificablePeriodoInicial') == 'N')
            accion('formulario.cbVigenciaPeriodoDesde','.disabled=true');		
    
        if (get('formulario.VisiblePeriodoFinal') == 'N') {
            document.getElementById("lblVigenciaPeriodoHasta").style.visibility='hidden';        
            document.getElementById("cbVigenciaPeriodoHasta").style.visibility='hidden';        
        }    
        if (get('formulario.ModificablePeriodoFinal') == 'N')
            accion('formulario.cbVigenciaPeriodoHasta','.disabled=true');
    
        if (get('formulario.hidCasoDeUso')=='insertar') {
            canalOnChange();
        }

        //------------------------- Poniendo valores en la lista -------------  
        
        var posDtoAcum                      = '0';
        var posCulminacion                  = '1';
        var posControlDevoluciones          = '2';
        var posControlAnulaciones           = '3';
        var posCdomunicacionAParticipantes  = '4';
        var posActiva                       = '5';
        var posMorosidad                    = '6';
        var posAfectaAFacturas              = '7';
        var posAfectaACtCte                 = '8';

        var listaValoresVisibles = new Array();
        listado1.actualizaDat();
        var listadoDatos = listado1.datos;
        var indic = 0;        
        listado1.actualizaDat();
        var datos;

        var nuevos_datos = new Array();
        listado1.setDatos(nuevos_datos);
            
        if (get('formulario.VisibleControlDesc') == 'S') {
            datos = listadoDatos[posDtoAcum][0] + "|" + listadoDatos[posDtoAcum][1] + "|" +  listadoDatos[posDtoAcum][2];
            insertaParametros(datos);
        }

        if (get('formulario.VisibleIndicador') == 'S') {            
            datos = listadoDatos[posCulminacion][0] + "|" + listadoDatos[posCulminacion][1] + "|" +  listadoDatos[posCulminacion][2];
            insertaParametros(datos);
        }

        if (get('formulario.VisibleControlDA') == 'S'){
            datos = listadoDatos[posControlDevoluciones][0] + "|" + listadoDatos[posControlDevoluciones][1] + "|" +  listadoDatos[posControlDevoluciones][2];
            insertaParametros(datos);
            datos = listadoDatos[posControlAnulaciones][0] + "|" + listadoDatos[posControlAnulaciones][1] + "|" +  listadoDatos[posControlAnulaciones][2];
            insertaParametros(datos);
        }	

      	if (get('formulario.VisibleComunicacion') == 'S'){
            datos = listadoDatos[posCdomunicacionAParticipantes][0] + "|" + listadoDatos[posCdomunicacionAParticipantes][1] + "|" +  listadoDatos[posCdomunicacionAParticipantes][2];
            insertaParametros(datos);
        }

        datos = listadoDatos[posActiva][0] + "|" + listadoDatos[posActiva][1] + "|" +  listadoDatos[posActiva][2];
        insertaParametros(datos);

        if (get('formulario.VisibleControlMorosidad') == 'S'){
           datos = listadoDatos[posMorosidad][0] + "|" + listadoDatos[posMorosidad][1] + "|" +  listadoDatos[posMorosidad][2];
           insertaParametros(datos);
        }	
		
        if (get('formulario.VisibleAfectaFactura') == 'S'){
            datos = listadoDatos[posAfectaAFacturas][0] + "|" + listadoDatos[posAfectaAFacturas][1] + "|" +  listadoDatos[posAfectaAFacturas][2];
            insertaParametros(datos);
        }
	
        if (get('formulario.VisibleAfectaCC') == 'S'){
            datos = listadoDatos[posAfectaACtCte][0] + "|" + listadoDatos[posAfectaACtCte][1] + "|" +  listadoDatos[posAfectaACtCte][2];
            insertaParametros(datos);
        }        
    }

    function insertaParametros(datos) {
        var newRow = new Array();
        newRow = datos.split("|");
        listado1.insertar(newRow);
    }

    function marcaValoresDeParametro() {
        listado1.actualizaDat();
        var listadoDatos = listado1.datos;
        
        var cantCodigos = listado1.codigos().length;
        for (var i = 0; i < cantCodigos; i++) {        
            switch (parseInt(listadoDatos[i][0], 10)) {
                case 28:
                    if (get('formulario.hidDescuentoAcumulativo') =='S')
                        listadoDatos[i][2] = "S";
                    else  listadoDatos[i][2] = "N";
                    break;
                case 2:
                    if (get('formulario.hidCulminacion') =='S')
                        listadoDatos[i][2] = "S";
                    else listadoDatos[i][2] = "N";
                    break;            
                case 27:
                    if (get('formulario.hidControlDevoluciones') =='S')
                        listadoDatos[i][2] = "S";
                    else listadoDatos[i][2] = "N";
                    break;
                case 32:    
                    if (get('formulario.hidControlAnulaciones') =='S')
                        listadoDatos[i][2] = "S";
                    else listadoDatos[i][2] = "N";                    
                    break;
                case 31:
                    if (get('formulario.hidCdomunicacionAParticipantes') =='S')
                        listadoDatos[i][2] = "S";
                    else listadoDatos[i][2] = "N";
                    break;            
                case 5:
                    if (get('formulario.hidActiva') =='S')
                        listadoDatos[i][2] = "S";
                    else listadoDatos[i][2] = "N";
                    break;
                case 26:
                        if (get('formulario.hidMorosidad') =='S')
                            listadoDatos[i][2] = "S";
                        else listadoDatos[i][2] = "N";
                    break;
                case 29:
                    if (get('formulario.hidAfectaAFacturas') =='S')
                         listadoDatos[i][2] = "S";
                    else listadoDatos[i][2] = "N";
                    break;
                case 30:
                    if (get('formulario.hidAfectaACuentasCorrientes') =='S')
                         listadoDatos[i][2] = "S";
                    else listadoDatos[i][2] = "N";
                    break;
            }
        }
        listado1.setDatos(listadoDatos);
    }

    function verifObligatoriedad(){             
        if (get('formulario.ObligatorioAcceso') == 'S')
            sicc_cambiar_estado("cbAcceso",true);                
        if (get('formulario.ObligatorioSubacceso') == 'S')
            sicc_cambiar_estado("cbSubacceso",true);                
        if (get('formulario.ObligatorioPeriodoInicial') == 'S')
            sicc_cambiar_estado("cbVigenciaPeriodoDesde",true);                
        if (get('formulario.ObligatorioPeriodoFinal') == 'S')
            sicc_cambiar_estado("cbVigenciaPeriodoHasta",true);                
    }
    
    function validarControles() {
        if(sicc_validaciones_generales("g1")) {		
            var vAcc = get( 'formulario.cbAcceso');
            var nMaxAcc = get('formulario.txtNmaximoAcceso');
            if(nMaxAcc!=""){
              if ( vAcc.length > nMaxAcc){
                 GestionarMensaje(1263,'Accesos', get('formulario.txtNmaximoAcceso'));
                 return false;
              }
            }
          
            var vSubacc = get( 'formulario.cbSubacceso');
            var nMaxSubac = get('formulario.txtNmaximoSubacceso');
            if (nMaxSubac!=""){
              if ( vSubacc.length > nMaxSubac ){
                 GestionarMensaje(1263,'Subccesos', get('formulario.txtNmaximoSubacceso'));
                 return false;
              }
            }
            return true;
        } else return false;
    }

    function buscoAcceso() {

        var combo = get("formulario.cbAcceso");
        var id = get("formulario.SubaccesoOid");
        var desc = get("formulario.SubaccesoDesc");
        var padre = get("formulario.SubaccesoOidPadre");
        
        if (combo !="") {
          if (combo.length == 1) {
            id = id.split(",");
            desc = desc.split(",");
            padre = padre.split(",");
            var largo = padre.length;
            var opciones = new Array();
                    opciones[0] = ["",""];
            var j = 1;
            var i = 0;
            for(i=0; i < largo; i++) {  //padre            
                if(padre[i] == combo) {
                  opciones[j] = [id[i], desc[i]];
                  j++;
                }
            }
         }
    
         if (combo.length > 1) {
            id = id.split(",");
            desc = desc.split(",");
            padre = padre.split(",");
            var largo = padre.length;
            var opciones = new Array();
                    opciones[0] = ["",""];
            var j = 1;
            var i = 0;
            var c = 0;
            for(c=0;c<combo.length;c++) {  //combo            
              for(i=0; i < largo; i++) {  //padre              
                if(padre[i] == combo[c]) {
                  opciones[j] = [id[i], desc[i]];
                  j++;
                }
              }
            }
         }		
         if (opciones.length >0)
             set_combo("formulario.cbSubacceso", opciones);
      } else {
          opciones = new Array();
          opciones[0] = ["", ""];
          set_combo("formulario.cbSubacceso", opciones);
      }
	}

  function buscoCanal()	{
      var combo = get("formulario.cbCanal");
      var id = get("formulario.accesoOid");
      var desc = get("formulario.accesoDesc");
      var padre = get("formulario.accesoOidPadre");
          
      if (combo !="") {
          if (combo.length == 1) {
            id = id.split(",");
            desc = desc.split(",");
            padre = padre.split(",");
            var largo = padre.length;
            var opciones = new Array();
            var j = 1;
            var i = 0;
            opciones[0] = ["", ""];				
            for(i=0; i < largo; i++) {  //padre          
                if(padre[i] == combo) {              
                  opciones[j] = [id[i], desc[i]];
                  j++;
                }
            }
         }
    
         if (combo.length > 1) {
            id = id.split(",");
            desc = desc.split(",");
            padre = padre.split(",");
            var largo = padre.length;
            var opciones = new Array();
            var j = 1;
            var i = 0;
            var c = 0;
            opciones[0] = ["", ""];
            for(c=0;c<combo.length;c++){  //combo          
              for(i=0; i < largo; i++){  //padre            
                if(padre[i] == combo[c]) {
                  opciones[j] = [id[i], desc[i]];
                  j++;
                }
              }
            }
         }		
         if (opciones.length >0)
             set_combo("formulario.cbAcceso", opciones);		      
      } else {
        opciones = new Array();
        opciones[0] = ["", ""];
        set_combo("formulario.cbAcceso", opciones);
        buscoAcceso();
        set_combo("formulario.cbAcceso", opciones);
      }
	}

  /*#############  Métodos para manejar la lista con checks  ###############*/
  function focalizaListaTab(FILAEVENTO) {
      if(FILAEVENTO == (listado1.datos.length - 1)) {
          setTimeout("focalizaBotonHTML('botonContenido','btnSiguiente')",10);
      }
  }

  function focalizaListaShTab(FILAEVENTO) {
      if(FILAEVENTO == 0) {
          setTimeout("focaliza('formulario.cbVigenciaPeriodoHasta','')",10); 
          focaliza('formulario.cbVigenciaPeriodoDesde','');
      }
  }

  function checkEntrada() {
      document.selection.empty();
      var nombrelistado = "listado1";
      var nombreCheckBox = "ckValor";
      var indiceFila = 0;

      eval(nombrelistado+".preparaCamposDR()");
      focaliza('frm'+nombrelistado+'.'+nombreCheckBox+'_'+indiceFila,'');
  }
    
  function inicioOnChange(filaCambiada) {     
        //Este evento se dispara cuando cambia uno de los
        //check de la columna "Valor" de la tabla.
        var vIndicaAfectaFacturas;
        var vIndicaAfectaCtaCte;
        
        listado1.actualizaDat();
        var listadoDatos = listado1.datos;
        var cantCodigos = listado1.codigos().length;
        
        for ( var i = 0; i < cantCodigos; i++) {
                switch ( parseInt(listadoDatos[i][0], 10) ) {
                    case 29:
                            vIndicaAfectaFacturas = listadoDatos[i][2];
                            break;
                    case 30:
                            vIndicaAfectaCtaCte = listadoDatos[i][2];
                            break;
                }
        }
        
        if ( listadoDatos[filaCambiada][0] == '29' || listadoDatos[filaCambiada][0] == '30' ) {
            if ( listadoDatos[filaCambiada][0] == '29' && vIndicaAfectaCtaCte == "S") {
                 GestionarMensaje("1203");
                 listadoDatos[filaCambiada][2] = "N";
            }

            if ( listadoDatos[filaCambiada][0] == '30' && vIndicaAfectaFacturas == "S") {
                 GestionarMensaje("1203");
                 listadoDatos[filaCambiada][2] = "N";
            }

            listado1.setDatos(listadoDatos);
        }
    }

	function accionExitosa() {
      if (get('formulario.hidCasoDeUso') != 'modificar') {
        eval('formulario').oculto="N"; 
        set("formulario.conectorAction","LPMantenimientoAlcanceTipoCliente");
        set("formulario.accion","");
        set("formulario.casoDeUso","modificar");
        enviaSICC("formulario");
      }          
      //--Faltaba agregar?
      if (get('formulario.hidCasoDeUso') == 'modificar') {
        eval('formulario').oculto="N"; 
        set("formulario.conectorAction","LPMantenimientoAlcanceTipoCliente");
        set("formulario.accion","");
        set("formulario.casoDeUso","modificar");
        enviaSICC("formulario");
      }        
  }

  function accionError() {
      fMostrarMensajeError();
  }

  function fVolver() {
      if (get('formulario.hidCasoDeUso') == "consultar" || get('formulario.hidCasoDeUso') == "modificar") {
          window.close();
      } else { 
         set("formulario.conectorAction","LPMantenimientoDTO");
         set("formulario.casoDeUso",get("formulario.hidCasoDeUso"));        
         set("formulario.accion","volver");
         eval('formulario').oculto="N";             
         enviaSICC("formulario");
      }
  }

  function deshabilitarEnDescuentoVigente() {
        accion("formulario.txtNombreDescuento",".disabled=true");
        accion("formulario.cbMarca",".disabled=true");
        accion("formulario.cbCanal",".disabled=true");
        accion("formulario.cbAcceso",".disabled=true");
        accion("formulario.cbSubacceso",".disabled=true");
        accion("formulario.cbVigenciaPeriodoDesde",".disabled=true");
        btnProxy(1,0);
  }
    
  function validarFacturasOCCC() {
        var vIndicaAfectaFacturas;
        var vIndicaAfectaCtaCte;
        
        listado1.actualizaDat();
        var listadoDatos = listado1.datos;
        var cantCodigos = listado1.codigos().length;
        
        for ( var i = 0; i < cantCodigos; i++) {
            switch ( parseInt(listadoDatos[i][0], 10) ) {
                case 29:
                    vIndicaAfectaFacturas = listadoDatos[i][2];
                    break;
                case 30:
                    vIndicaAfectaCtaCte = listadoDatos[i][2];
                    break;
            }
        }

        if (vIndicaAfectaFacturas == vIndicaAfectaCtaCte ) {
            GestionarMensaje('UIDTO0007');
            return false;
        } else return true;
  }

  function onTabSiguiente() {
      if (get('formulario.hidCasoDeUso')!='consultar')
          focaliza('formulario.txtNombreDescuento')
  }
    
  function onShTabSiguiente() {
      if (get('formulario.hidCasoDeUso')=='consultar') {
          focalizaBotonHTML_XY('btnSiguiente');
      } else {
          checkEntrada();
      }
  }
    
  function onClickPestanya(valor) {
  
      if (validarFacturasOCCC() == true) { // además deben validarse todos los campos obligatorios 
          set('formulario.idPestanyaDest', valor);
          if (get('formulario.hidCasoDeUso')!="consultar") { // Si en un "insertar" o un "modificar" debe almacenarse los datos                         
              if (valor != "0") {//!=pestanyaDatosGenerales
                  // Sólo llamamos a la LP para almacenar en el "dtoDescuento" los datos de la pestaña,
                  // si el identificador de la pestaña actual es distinto de la variable idPestanyaDest 
                  // (identificador de la pestaña que se ha pulsado) 
                  if (recogerInformacion()== true) {
                    set('formulario.conectorAction', 'LPMantenimientoDTODG');            
                    set('formulario.accion', 'almacenar');
                    //eval('formulario').oculto="S"; 
                    enviaSICC('formulario');         
                  }
              }// Fin Si pestanyaDatosGenerales != idPestanyaDest 
              
          } else { // Si casodeuso == "consultar", solo debe redirigirse a otra pestaña               
              if (recogerInformacion()== true) {
                set('formulario.conectorAction', 'LPMantenimientoDTODG');            
                set('formulario.accion', 'redirigir');
                //eval('formulario').oculto="S"; 
                enviaSICC('formulario');         
              }              
          } // Fin si 
      } // Fin (validarFacturasOCCC() = true)
  }

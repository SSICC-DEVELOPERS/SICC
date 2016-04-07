//array de elementos que pueden tener el foco con TAB/SHTAB
var elementos = new Array('cbMarca', 'cbCanal','cbPeriodo', 'cbGrupoZ', 'cbZonaReferencia', 'cbZonasRegenerar');
var zonas = new Object();

	function onLoadPag(){  
		configurarMenuSecundario('formulario');    
		focaliza('formulario.cbMarca');
		opcionMenu = get('formulario.opcionMenu');
		eval (ON_RSZ); 
		fMostrarMensajeError();
	}

    function onChangeCbMarca(){
    	GestionarComboPeriodoGrupoZ();
    }

    function onChangeCanal(){
    	GestionarComboPeriodoGrupoZ();
    }

    function onChangeGrupoZ(){
    	GestionarCombosZonas();
    }
	
    function onChangeZonaRef(){
		var sel = new Array();
		sel[0]='';
		set_combo('formulario.cbZonasRegenerar', zonas, sel);
    	del_combo('formulario.cbZonasRegenerar','V', get('formulario.cbZonaReferencia'));

	}

    function GestionarComboPeriodoGrupoZ() {
        if( get('formulario.cbMarca')=='' || get('formulario.cbCanal')=='' ){
			deshabilitarCombosZonas();
			deshabilitarCombosPeriodoGrupoZ();
		}else{
            accion('formulario.cbPeriodo', '.disabled=false');
            accion('formulario.cbGrupoZ', '.disabled=false');
			set_combo('formulario.cbPeriodo', arrayVacio());
            set_combo('formulario.cbGrupoZ', arrayVacio());
            recargaComboPeriodoGruposZonas();
        }
    }

    function GestionarCombosZonas() {
        if( get('formulario.cbGrupoZ')==''){
			deshabilitarCombosZonas();
        }else{
            accion('formulario.cbZonaReferencia', '.disabled=false');
            accion('formulario.cbZonasRegenerar', '.disabled=false');
            set_combo('formulario.cbZonaReferencia', '');
            set_combo('formulario.cbZonasRegenerar', '');
            recargaCombosZonas();
        }
    }

    function arrayVacio(){
    	var array = new Array();
    	array[0] = new Array('','');
    	return array;
    }

    function recargaComboPeriodoGruposZonas(){
    	recargaCombo('formulario.cbPeriodo', 'CRAObtenerPeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArrayDTOPeriodo(), 'marcaCbPeriodo(datos)');
    	recargaCombo('formulario.cbGrupoZ', 'CRAObtenerGruposZonas', 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArrayDTOPeriodo(), 'marcaCbGrupoZonas(datos)');
    }

    function recargaCombosZonas(){
    	recargaCombo('formulario.cbZonaReferencia', 'CRAObtenerZonas', 'es.indra.sicc.util.DTOOID', armarArrayDTOOid(), 'marcaCbsZonas(datos)');
    }

    function marcaCbPeriodo(datos){
    	    var sel = new Array();
            sel[0]='';
            set_combo('formulario.cbPeriodo',datos, sel);
    }

    function marcaCbGrupoZonas(datos){
    	    var sel = new Array();
			sel[0]='';
            set_combo('formulario.cbGrupoZ',datos, sel);
    }

    function marcaCbsZonas(datos){
			zonas = datos;
			var sel = new Array();
			sel[0]='';
            set_combo('formulario.cbZonaReferencia',datos, sel);
            set_combo('formulario.cbZonasRegenerar',datos, sel);
    }

    function armarArrayDTOOid(){
        var grupo = get('formulario.cbGrupoZ');
        var index = 0;
        var array = new Array();    
        array[index] = ["oid", grupo];

		return array;
    }

    function armarArrayDTOPeriodo(){
        var marca = get('formulario.cbMarca');
        var canal = get('formulario.cbCanal');
        var array = new Array();
        var index = 0;
    
        if( marca != null && marca[0] != null && marca[0] != '' ){
            array[index] = new Array('marca', marca[0]);
            index++;
        }
    
        if( canal != null && canal[0] != null && canal[0] != '' ){
            array[index] = new Array('canal', canal[0]);
            index++;
        }
    
        var pais = get("formulario.pais");
        array[index] = ["pais", pais];

        var idioma = get('formulario.idioma');
        array[index+1] = ["oidIdioma", idioma];

		return array;
    }

	function tab(elemento){
				try{
						 for(i=0; i < elementos.length; i++){
								  if( elementos[i] == elemento ){
											if( i == elementos.length - 1 )   i = 0;
											else   i++;
											document.selection.empty();
											focaliza('formulario.' + elementos[i]);	
											return;
									}
						 }
					 }
				catch(e){
						 tab(elementos[i]);
				}
	}

	function shtab(elemento){
				try{
						 for(i=elementos.length - 1; i >= 0 ; i--){
								  if( elementos[i] == elemento ){
											if( i == 0 ) i = elementos.length - 1;
											else i--;
											document.selection.empty();
											focaliza('formulario.' + elementos[i]);
											return;
								  }
						 }
				}catch(e){
						 shtab(elementos[i]);
				}
	}


   function terminar(){
		GestionarMensaje("CRA003.2", null ,null, null);
		fLimpiar();
		//No Genera Cronogramas. Porque la zona elegida a copiar no tiene nada.
   }


   function generar(hayQueBorrar){
		eval('formulario').oculto = "S";
		set('formulario.conectorAction','LPGenerarCronogramaporZonas'); 
		set('formulario.hayQueBorrar', hayQueBorrar);
		set('formulario.accion','generar');
		enviaSICC('formulario');
   }


	function hayQueBorrar(){
		aux = GestionarMensaje("CRA003", null ,null, null);
		if (aux) {
			generar('true');
		} else {
			//No Genera Cronogramas. Porque se selecciono Cancelar.
		    fLimpiar();
		}
	}


	function validarGeneracion(){
		if(sicc_validaciones_generales('grupo1')){
			 eval('formulario').oculto = "S";
			 set('formulario.conectorAction','LPGenerarCronogramaporZonas'); 
			 set('formulario.accion','validar');
			 enviaSICC('formulario');
		}
	}

          
		function fLimpiar(){
			deshabilitarCombosZonas();
			deshabilitarCombosPeriodoGrupoZ();
			set('formulario.cbMarca', '');
			set('formulario.cbCanal', '');
			focaliza('formulario.cbMarca');
		}

		function deshabilitarCombosZonas() {
			set_combo('formulario.cbZonaReferencia', '');
			set_combo('formulario.cbZonasRegenerar', '');
            accion('formulario.cbZonaReferencia', '.disabled=true');
            accion('formulario.cbZonasRegenerar', '.disabled=true');
		}

		function deshabilitarCombosPeriodoGrupoZ() {
            set_combo('formulario.cbPeriodo', arrayVacio());
            set_combo('formulario.cbGrupoZ', arrayVacio());
			accion('formulario.cbPeriodo', '.disabled=true');
            accion('formulario.cbGrupoZ', '.disabled=true');
		}


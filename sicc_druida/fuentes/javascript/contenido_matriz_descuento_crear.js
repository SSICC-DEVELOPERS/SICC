	function mostrarCodigoError(){           
                    var vErrCodigo = get('formulario.errCodigo');
                    var vErrDescrip = get('formulario.errDescripcion');
                    
                    if (get('formulario.errDescripcion')!='')
                        var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);
   } 
    // Persistencia para el Limpiar

    var arrNCheck = new Array();
    var arrNCombo = new Array();
    var arrNText = new Array();

    var arrCombos = new Array();
	var arrC = new Array();
    var observaciones = '';
    var activa = '' ;
        
    function loadOnInitComponent(){
        // Algunas cosas que no guardo;
    
        var arrN = new Array();
        arrN.length = d3_componentes.length;
        arrNCheck.length = d3_componentes.length;
        arrNCombo.length = d3_componentes.length;
        arrNText.length = d3_componentes.length;
        var ich = 0;
        var ico = 0;
        var ict = 0;
		var i = 0;
    
        for(var j = 0 ; j < d3_componentes.length ; j++) {
            var tipo = d3_componentes[j][0];
            var nombre = d3_componentes[j][1];
            if(tipo == 'CHECKBOX') {
                arrNCheck[ich] =  get(nombre);
                ich++;
            }
            if(tipo == 'CTEXTO') {
                arrNText[ict] =  get(nombre);
                ict++;
            }
            if(tipo == 'COMBO') {
                /*arrNCombo[ico] =  get(nombre);
                arrCombos[ico] = nombre;
				ico++;*/
 				arrC[i] = [nombre];
				i++;
				arrC[i] = [get(nombre)];
				i++;
				arrC[i] = [get(nombre,'T')];
				i++;
            }
        }
    }

    function restoreComponent(){
        var ich = 0;
        var ico = 0;
        var ict = 0;
        
        for(var j = 0 ; j < d3_componentes.length ; j++) {
            var tipo = d3_componentes[j][0];

            var nombre = d3_componentes[j][1];
            if(tipo == 'CHECKBOX') {
               set(nombre,  arrNCheck[ich] );
                ich++;
            }
            if(tipo == 'CTEXTO') {
                if(arrNText[ict] != undefined){    
                    set(nombre,  arrNText[ict] );
                }
                ict++;
            }
            if(tipo == 'COMBO') {
                set(nombre,  arrNCombo[ico] );
                ico++;
            }
        }
     }

	function fLimpiar(){
		var caso = get('formulario.casoDeUso');
		 if (caso != 'modificar'){
            restoreComponent();      
			set("formulario.txtDescripcion","");
			set("formulario.atxtObservaciones","");
			var arrCheck = document.all["rbMatrizActiva"];
			for(var i=0; i< arrCheck.length; i++){
				if(arrCheck[i].type && arrCheck[i].type.toUpperCase() == "RADIO")
					document.all["rbMatrizActiva"][i].checked = false;
			}
   		    restauraCombos();
		}else{
		  restoreComponent();
		  restauraCombos();
		}
        //restauro los controles que estan habilitados
        verParametros();
		// Recupero valores que el loadOnInitComponent no trajo
		set("formulario.atxtObservaciones", observaciones);
		set('formulario.rbMatrizActiva', activa);
        foco(1);
	}

    function getArray2d(valores , nombres ){
        var arrr = new Array();
        var nom = nombres.split(',');
        var val = valores.split(',');
        for(var i = 0 ; i < nom.length ; i++) {
            arrr[i] = new Array(val[i], nom[i]);
        }
        return arrr;
    }

	function restauraCombos(){
	    //alert(arrC);
		for (i = 0; i < arrC.length; i++) {
			var nom = arrC[i];
			i++;
			var oids = new String(arrC[i]);
			i++;
			var desc = new String(arrC[i]);
			//if(oids.length > 1){
			var aoids = oids.split(",");
			var adesc = desc.split(",");
			//}
			set(nom,aoids);

			if(nom == "formulario.cbValoresPosiblesCanal")	buscoCanal();
			if(nom == "formulario.cbValoresPosiblesAcceso") 	buscoAcceso();
			if(nom == "formulario.cbValoresPosiblesTipoCliente") buscoTipoCliente();										
			if(nom == "formulario.cbValoresPosiblesSubtipoCliente") buscoSubtiposClientes();	
			if(nom == "formulario.cbValoresPosiblesTipoClasificacion") buscoTiposClasificacion();

			var ar = new Array();
			for (j = 0; j < aoids.length; j++) {
				ar[j] = [aoids[j], adesc[j]]
			}
			i++;
			var def = arrC[i];
			i++;
			if ((nom != "formulario.cbValoresPosiblesAlcanceAdministrativoDescuento")&&(nom != "formulario.cbValoresPosiblesControlMorosidad")&&
				(nom != "formulario.cbValoresPosiblesControlDevolucionesAnulaciones")&&(nom != "formulario.cbValoresPosiblesControlDescuentoAcumulativo")&&
				(nom != "formulario.cbValoresPosiblesAfectaFacturas")&&(nom != "formulario.cbValoresPosiblesAfectaCuentaCorriente")&&
				(nom != "formulario.cbValoresPosiblesComunicacionParticipantes")&&(nom != "formulario.cbValoresPosiblesIndicadorCulminacion")){
					set_combo(def,ar,arrC[i]);
					i++;
			}else{
					i++;
					if (arrC[i] == "Si"){ 	set_combo(def,ar,new Array("1"));}
					else	if (arrC[i] == "No"){	set_combo(def,ar,new Array("0"));}
					else	if (arrC[i] == "Nacional"){	set_combo(def,ar,new Array("1"));}
					else	if (arrC[i] == "No nacional"){	set_combo(def,ar,new Array("2"));}
			}
		}
	}

	function onLoadPage(){
    
    configurarMenuSecundario("formulario");
   	var caso = get('formulario.casoDeUso');
    varNoLimpiarSICC = true;      
    
    //alert("caso de uso: " + caso);
    
    if (caso=='modificar'){
    
      //alert("entro por modificar");
      
      if(get('formulario.radio')=='S') 
        set('formulario.rbMatrizActiva','S');
      else 
        set('formulario.rbMatrizActiva','N');
      
      cargarSeleccionados();
      
      set("formulario.dMarca",get("formulario.cbValoresPosiblesMarca","T"));
      set("formulario.dCanal",get("formulario.cbValoresPosiblesCanal","T"));
      set("formulario.dAcceso",get("formulario.cbValoresPosiblesAcceso","T"));
      set("formulario.dSubcceso",get("formulario.cbValoresPosiblesSubacceso","T"));
      set("formulario.dTiposClientes",get("formulario.cbValoresPosiblesTipoCliente","T"));
      set("formulario.dSubtiposClientes",get("formulario.cbValoresPosiblesSubtipoCliente","T"));
      set("formulario.dTiposClasificacion",get("formulario.cbValoresPosiblesTipoClasificacion","T"));
      set("formulario.dClasificacion",get("formulario.cbValoresPosiblesClasificacion","T"));
      set("formulario.dAlcance",get("formulario.cbValoresPosiblesAlcanceAdministrativoDescuento","T"));
      set("formulario.dControlMorosidad",get("formulario.cbValoresPosiblesControlMorosidad","T"));
      set("formulario.dControlDA",get("formulario.cbValoresPosiblesControlDevolucionesAnulaciones","T"));
      set("formulario.dControlDesc",get("formulario.cbValoresPosiblesControlDescuentoAcumulativo","T"));
      set("formulario.dAfectaFactura",get("formulario.cbValoresPosiblesAfectaFacturas","T"));
      set("formulario.dAfectaCC",get("formulario.cbValoresPosiblesAfectaCuentaCorriente","T"));
      set("formulario.dComunicacion",get("formulario.cbValoresPosiblesComunicacionParticipantes","T"));
      set("formulario.dIndicadorCulminacion",get("formulario.cbValoresPosiblesIndicadorCulminacion","T"));
        //for (var i=0; i < 30; i++){
                  for (var i=0; i < 32; i++){
            cambiaObli(i);
        }
		}
    
		if (caso=='detalle'){
    
        //alert("entro por detalle");
        
        if(get('formulario.radio')=="S") 
						 set('formulario.rbMatrizActiva','S');
				else set('formulario.rbMatrizActiva','N');
          
        cargarSeleccionados();
        deshabilitaCampos();
    }
		
    mostrarCodigoError();
		verParametros();
		if ((caso!='detalle')&&(caso!='modificar')){
			//alert("entro por !=detalle y !=modificar");
      selectAll();
			selectAllDefecto();
		}
    
		 // Recupero valores que el loadOnInitComponent no trajo
	    observaciones = get("formulario.atxtObservaciones");
	    activa = get('formulario.rbMatrizActiva');
        // persiste los campos para en limpiar los recupera
        loadOnInitComponent();

        document.getElementById("capa1").style.visibility='visible';

        if(caso!='detalle')
        {
            foco(1);
        }
	
  }
  
        
  function selectAllDefecto(){
			var def = new Array();
			def = ["Marca","Canal","Acceso","Subacceso","TipoCliente","SubtipoCliente","TipoClasificacion",
		"Clasificacion","AlcanceAdministrativoDescuento","ControlMorosidad","ControlDevolucionesAnulaciones","ControlDescuentoAcumulativo",
			"AfectaFacturas","AfectaCuentaCorriente","ComunicacionParticipantes","IndicadorCulminacion"];

        for(var j = 0 ; j < d3_componentes.length ; j++) {
            var tipo = d3_componentes[j][0];
            var nombre = d3_componentes[j][1];
            if(tipo == 'COMBO') {
					var nom = new Array();
					nom = armaCombo(get(nombre),get(nombre,'T'));
					for (var x=0; x< def.length; x++){
							var nbre = "formulario.cbValoresPosibles"+def[x];
							if(nombre == nbre){
								set_combo("formulario.cbValoresDefecto"+def[x], nom);								
							}
					}
            }
        }
	  }

	 function armaCombo(oid,desc){
		var aOid = new String(oid);
		var aDesc = new String(desc);		 
		aOid = aOid.split(",");
		aDesc = aDesc.split(",");		 
		 var sel = new Array();	
		 var j = 0;
	 	 for(var i=0; i< aOid.length; i++){
		 	 sel[j]	= [aOid[i],aDesc[i]];
			 j++;
		 }
	   return sel;
	 }

	function selectAll() {
		var nom = new Array();
		nom = ["Marca","Canal","Acceso","Subacceso","TipoCliente","SubtipoCliente","TipoClasificacion",
		"Clasificacion","AlcanceAdministrativoDescuento","ControlMorosidad","ControlDevolucionesAnulaciones","ControlDescuentoAcumulativo",
			"AfectaFacturas","AfectaCuentaCorriente","ComunicacionParticipantes","IndicadorCulminacion"];

		for (i = 0; i < nom.length; i++) {
		  var comb = "formulario.cbValoresPosibles" + nom[i]
	      select_combo(comb);		 
		  if(comb == "formulario.cbValoresPosiblesCanal")	buscoCanal();
		  if(comb == "formulario.cbValoresPosiblesAcceso") 	buscoAcceso();
		  if(comb == "formulario.cbValoresPosiblesTipoCliente") buscoTipoCliente();										
		  if(comb == "formulario.cbValoresPosiblesSubtipoCliente") buscoSubtiposClientes();	
	 	  if(comb == "formulario.cbValoresPosiblesTipoClasificacion") buscoTiposClasificacion();
		}
	}

	function cargarSeleccionados(){
		var nom = new Array();
		nom = ["Marca","Canal","Acceso","Subacceso","TipoCliente","SubtipoCliente","TipoClasificacion",
		"Clasificacion","AlcanceAdministrativoDescuento","ControlMorosidad","ControlDevolucionesAnulaciones","ControlDescuentoAcumulativo",
			"AfectaFacturas","AfectaCuentaCorriente","ComunicacionParticipantes","IndicadorCulminacion"];
		
		var caso = get('formulario.casoDeUso');
    
    for(var i=0; i <= 7; i++){
			var nombre = ("formulario.sel" + nom[i]);
			if(get(nombre)!= ""){
					var arr = get(nombre);
					//if (arr.length >1)
							arr = arr.split(",");
					var comb = ("formulario.cbValoresPosibles"+nom[i]);
					set(comb, arr);
          
          if (caso=='modificar'){
            for(var j=0; j < arr.length; j++){
                if(comb == "formulario.cbValoresPosiblesCanal")	buscoCanal();
                if(comb == "formulario.cbValoresPosiblesAcceso") 	buscoAcceso();
                if(comb == "formulario.cbValoresPosiblesTipoCliente") buscoTipoCliente();										
                if(comb == "formulario.cbValoresPosiblesSubtipoCliente") buscoSubtiposClientes();	
                if(comb == "formulario.cbValoresPosiblesTipoClasificacion") buscoTiposClasificacion();
            }
          }
      
      }
		}
    
    //alert("valores recibidos desde la lp: " + get("formulario.selAlcanceAdministrativoDescuento"));
    
    if(get("formulario.sel" + nom[8])!=""){
      var nac = get("formulario.sel" + nom[8]);
      if(nac.length >1)
        nac = nac.split(",");
        var ar2 = new Array();
        var z=0;
        for(var p = 0; p< nac.length; p++){
          if(nac[p]=="Nacional"){
            //alert("entro por nacional");
            ar2[z] = [1];
            z++;
          }else{
            if(nac[p]=="No nacional"){
              //alert("entro por no nacional");
              ar2[z] = [2];
              z++;
            }
          }
        }
        
        set("formulario.cbValoresPosiblesAlcanceAdministrativoDescuento",ar2);
        
    }
    
    
    for(var x=9; x < 16; x++){
			var nombre = ("formulario.sel" + nom[x]);
      //alert("valores recibidos desde la lp: " + get(nombre));
      if(get(nombre)!= ""){
			  var arr = get(nombre);
			  if (arr.length >1)
					arr = arr.split(",");
				var ar2 = new Array();
				var z=0;
				for(var p = 0; p< arr.length; p++){
						if(arr[p]=="true"){
							//alert("entro por true");
              ar2[z] = [1];
							z++;
							}
							else{
              //alert("entro por false");
              ar2[z] = [0];
							z++;
							}
				}
				var comb = ("formulario.cbValoresPosibles"+nom[x]);
			   set(comb,ar2);
			}
		}
	}
	
	function	 deshabilitaCampos(){
				var td2 = document.all.tags("INPUT");
				for(var i=0;i<td2.length;i++){
					// recorro todos los inputs	y los deshabilito
					td2.item(i).disabled=true;
				} 
				var arr = new Array();
				arr = ["Marca","Canal","Acceso","Subacceso","TipoCliente","SubtipoCliente","TipoClasificacion","Clasificacion",
					"AlcanceAdministrativoDescuento","ControlMorosidad","ControlDevolucionesAnulaciones","ControlDescuentoAcumulativo",
					"AfectaFacturas","AfectaCuentaCorriente","ComunicacionParticipantes","IndicadorCulminacion"];
				for (j = 0; j < arr.length; j++) {
				    accion("formulario.cbValoresDefecto"+arr[j],".disabled=true");
				}
				/*var com2 = document.all.tags("SELECT");
				for(var j=0;j<com2.length;j++){
					// recorro todos los combos	y los deshabilito	
					com2.item(j).disabled=true;
				} */
				accion("formulario.atxtObservaciones",".disabled=true");
	}

	function fGuardar()	{
		if(!sicc_validaciones_generales('camposOpcionales')) {
			return;
	    }	
		set("formulario.vdAlcanceAdministrativoDescuento",get("formulario.cbValoresDefectoAlcanceAdministrativoDescuento","T"));
		set("formulario.vdControlMorosidad",get("formulario.cbValoresDefectoControlMorosidad","T"));
		set("formulario.vdControlDevolucionesAnulaciones",get("formulario.cbValoresDefectoControlDevolucionesAnulaciones","T"));
		set("formulario.vdControlDescuentoAcumulativo",get("formulario.cbValoresDefectoControlDescuentoAcumulativo","T"));
		set("formulario.vdAfectaFacturas",get("formulario.cbValoresDefectoAfectaFacturas","T"));
		set("formulario.vdAfectaCuentaCorriente",get("formulario.cbValoresDefectoAfectaCuentaCorriente","T"));
		set("formulario.vdComunicacionParticipantes",get("formulario.cbValoresDefectoComunicacionParticipantes","T"));
		set("formulario.vdIndicadorCulminacion",get("formulario.cbValoresDefectoIndicadorCulminacion","T"));
		var ok = validacion();
		if (ok == true){
			var aFactura = get("formulario.cbValoresPosiblesAfectaFacturas");
			var aCC = get("formulario.cbValoresPosiblesAfectaCuentaCorriente");
            var band = true;
            
            if (aFactura.length<2 && aCC.length <2)
            {
                for(var i = 0; i< aFactura.length; i++){
                    if (aFactura[i] ==1){
                        for(var j = 0; j< aFactura.length; j++){
                            if (aCC[j] ==1){
                                var valor = GestionarMensaje('1203',null,null,null);						
                                focaliza("formulario.cbValoresPosiblesAfectaCuentaCorriente");
                                band = false;
                                break;
                            }
                        }
                    }
                }
            }
			if(band==true){
					if(get("formulario.hidOidMatriz")=="")	
                            set("formulario.accion", "guardar");
				     else		
                            set("formulario.accion", "guardarModificacion");
					set('formulario.conectorAction','LPMantenimientoMatrizDescuentos');
					enviaSICC("formulario",null,null,"N");
				}
		}
	}

	function validacion(){
		var ok = false;
        var nom = new Array();
		var grupo = new Array();
		grupo = ["grupo1","grupo2","grupo3","grupo4","grupo5","grupo6"];
		for(var j=0; j < 6; j++){
			if(!sicc_validaciones_generales(grupo[j]))
					return false;
		}	
	   nom = ["Marca","Acceso","Subacceso","TipoCliente","PorcentajeAdicionalLineaCarrera",
				"AlcanceAdministrativoDescuento","ControlMorosidad","ControlDevolucionesAnulaciones","ControlDescuentoAcumulativo",
			   "AfectaFacturas","AfectaCuentaCorriente","ComunicacionParticipantes","IndicadorCulminacion"];
        for(var i = 0; i < nom.length ; i++){
				if(get("formulario.ckModificable"+nom[i])=="N"){
						if(get("formulario.cbValoresDefecto"+nom[i])==""){
                            if(nom[i]=="PorcentajeAdicionalLineaCarrera"){
                                if(get("formulario.cbValoresDefectoClasificacion")==""){
									GestionarMensaje('1202',"Clasificacion",null,null);
									focaliza("formulario.ckModificable"+nom[i]);
									return false;
								} else {
									ok = true;
								}
							}
							else{
								GestionarMensaje('1202',nom[i],null,null);
								focaliza("formulario.ckModificable"+nom[i]);
								return false;
								}
							
						}
				      else	ok = true;
			   }
				else ok = true;
        }    
		  return ok;
    }

	function actualizaPadre(){
		var obj = new Object();
		obj.hidDesc=get("formulario.hidDesc");
		obj.hidMat=get("formulario.hidMat");
		window.returnValue = obj;
	}

	function change()
	{
    	var elCombo= window.event.srcElement;
        
		var opciones = new Array();
		var j = 1;
		opciones[0] = ["",""];
		for(var f=0;f < elCombo.options.length;f++){
			if(elCombo.options[f].selected){
				var oidAAgregar = elCombo.options[f].value;
				var desc = elCombo.options[f].text;
				opciones[j] = [oidAAgregar, desc];
				j++;
			}
		}
		return opciones;
	}

function marcasOnChange(){
	
  if(get("formulario.casoDeUso")!='detalle'){
	set("formulario.dMarca",get("formulario.cbValoresPosiblesMarca","T"));
	var opciones = change();
	if (opciones.length >0)
						set_combo("formulario.cbValoresDefectoMarca", opciones);	
	}
}
function canalesOnChange(){
		if(get("formulario.casoDeUso")!='detalle'){
      set("formulario.dCanal",get("formulario.cbValoresPosiblesCanal","T"));
		buscoCanal();
		var opciones = change();
				set_combo("formulario.cbValoresDefectoCanal", opciones);	
		}
   }

   function accesosOnChange(){
	   	if(get("formulario.casoDeUso")!='detalle'){
      set("formulario.dAcceso",get("formulario.cbValoresPosiblesAcceso","T"));
		buscoAcceso();
		var opciones = change();
		if (opciones.length >0)
					set_combo("formulario.cbValoresDefectoAcceso", opciones);	
		}
   }
  
	 function subAccesosOnChange(){
		 	if(get("formulario.casoDeUso")!='detalle'){
		   set("formulario.dSubcceso",get("formulario.cbValoresPosiblesSubacceso","T"));
			var opciones = change();
			if (opciones.length >0)
							set_combo("formulario.cbValoresDefectoSubacceso", opciones);	
			}
	}

   function tipoClienteOnChange(){
	if(get("formulario.casoDeUso")!='detalle'){
	  set("formulario.dTiposClientes",get("formulario.cbValoresPosiblesTipoCliente","T"));
		buscoTipoCliente();
		focaliza("formulario.cbValoresPosiblesSubtipoCliente");
		var opciones = change();
       if (opciones.length >0)
					set_combo("formulario.cbValoresDefectoTipoCliente", opciones);	
	}
	}

   function subtipoClienteOnChange()	{
	   	if(get("formulario.casoDeUso")!='detalle'){
      set("formulario.dSubtiposClientes",get("formulario.cbValoresPosiblesSubtipoCliente","T"));
		buscoSubtiposClientes();
		focaliza("formulario.cbValoresPosiblesTipoClasificacion");	
		var opciones = change();
       if (opciones.length >0)
					set_combo("formulario.cbValoresDefectoSubtipoCliente", opciones);	
		}
	}

   function tipoClasificacionOnChange()	{
	   	if(get("formulario.casoDeUso")!='detalle'){
      set("formulario.dTiposClasificacion",get("formulario.cbValoresPosiblesTipoClasificacion","T"));
		buscoTiposClasificacion();
		focaliza("formulario.cbValoresPosiblesClasificacion");
		var opciones = change();
      if (opciones.length >0)
					set_combo("formulario.cbValoresDefectoTipoClasificacion", opciones);	
		}
	}

	function clasificacionOnChange(){
			if(get("formulario.casoDeUso")!='detalle'){
	  set("formulario.dClasificacion",get("formulario.cbValoresPosiblesClasificacion","T"));
		var opciones = change();
       if (opciones.length >0)
					set_combo("formulario.cbValoresDefectoClasificacion", opciones);	
			}
	}

  	function alcanceOnChange(){
			if(get("formulario.casoDeUso")!='detalle'){
      set("formulario.dAlcance",get("formulario.cbValoresPosiblesAlcanceAdministrativoDescuento","T"));
		var opciones = change();
     if (opciones.length >0)
					set_combo("formulario.cbValoresDefectoAlcanceAdministrativoDescuento", opciones);	
	set("formulario.vdAlcance",get("formulario.cbValoresDefectoAlcanceAdministrativoDescuento","T"));
			}
	}

	function controlMorosidadOnChange(){
			if(get("formulario.casoDeUso")!='detalle'){
      set("formulario.dControlMorosidad",get("formulario.cbValoresPosiblesControlMorosidad","T"));
	var opciones = change();
   if (opciones.length >0)
					set_combo("formulario.cbValoresDefectoControlMorosidad", opciones);	
	set("formulario.vdControlMorosidad",get("formulario.cbValoresDefectoControlMorosidad","T"));
			}
	}

	function controlDAOnChange(){
			if(get("formulario.casoDeUso")!='detalle'){
      set("formulario.dControlDA",get("formulario.cbValoresPosiblesControlDevolucionesAnulaciones","T"));
	var opciones = change();
    if (opciones.length >0)
					set_combo("formulario.cbValoresDefectoControlDevolucionesAnulaciones", opciones);	
		set("formulario.vdControlDevolucionesAnulaciones",get("formulario.cbValoresDefectoControlDevolucionesAnulaciones","T"));
			}
	}

	function controlDescOnChange(){
			if(get("formulario.casoDeUso")!='detalle'){
      set("formulario.dControlDesc",get("formulario.cbValoresPosiblesControlDescuentoAcumulativo","T"));
	var opciones = change();
	if (opciones.length >0)
					set_combo("formulario.cbValoresDefectoControlDescuentoAcumulativo", opciones);	
		set("formulario.vdControlDescuentoAcumulativo",get("formulario.cbValoresDefectoControlDescuentoAcumulativo","T"));
			}
	}

	function afectaFacturasOnChange(){
			if(get("formulario.casoDeUso")!='detalle'){
      set("formulario.dAfectaFactura",get("formulario.cbValoresPosibleAfectaFacturas","T"));
	var opciones = change();
	if (opciones.length >0)
					set_combo("formulario.cbValoresDefectoAfectaFacturas", opciones);	
		set("formulario.vdAfectaFacturas",get("formulario.cbValoresDefectoAfectaFacturas","T"));
			}
	}

	function afectaCCOnChange(){
			if(get("formulario.casoDeUso")!='detalle'){
      set("formulario.dAfectaCC",get("formulario.cbValoresPosiblesAfectaCuentaCorriente","T"));
	var opciones = change();
	if (opciones.length >0)
					set_combo("formulario.cbValoresDefectoAfectaCuentaCorriente", opciones);	
		set("formulario.vdAfectaCuentaCorriente",get("formulario.cbValoresDefectoAfectaCuentaCorriente","T"));
			}
	}

	function comunicacionOnChange(){
			if(get("formulario.casoDeUso")!='detalle'){
      set("formulario.dComunicacion",get("formulario.cbValoresPosiblesComunicacionParticipantes","T"));
	var opciones = change();
	if (opciones.length >0)
					set_combo("formulario.cbValoresDefectoComunicacionParticipantes", opciones);	
		set("formulario.vdComunicacionParticipantes",get("formulario.cbValoresDefectoComunicacionParticipantes","T"));
			}
	}

	function indicadorOnChange(){
			if(get("formulario.casoDeUso")!='detalle'){
      set("formulario.dIndicadorCulminacion",get("formulario.cbValoresPosiblesIndicadorCulminacion","T"));
	  var opciones = change();
	  if (opciones.length >0)
					set_combo("formulario.cbValoresDefectoIndicadorCulminacion", opciones);	
		set("formulario.vdIndicadorCulminacion",get("formulario.cbValoresDefectoIndicadorCulminacion","T"));
			}
	}

	function buscoCanal(){
		var combo = get("formulario.cbValoresPosiblesCanal");
		var id = get("formulario.accesoOid");
		var desc = get("formulario.accesoDesc");
		var padre = get("formulario.accesoOidPadre");
		if (combo !=""){
			if (combo.length == 1){
				id = id.split(",");
				desc = desc.split(",");
				padre = padre.split(",");
				var largo = padre.length;
				var opciones = new Array();
				var j = 1;
				var i = 0;
				opciones[0] = ["", ""];				
				for(i=0; i < largo; i++)  //padre
				{
						if(padre[i] == combo){
							opciones[j] = [id[i], desc[i]];
							j++;
					   }
				}
			}

			if (combo.length > 1)
			{
				id = id.split(",");
				desc = desc.split(",");
				padre = padre.split(",");
				var largo = padre.length;
				var opciones = new Array();
				var j = 1;
				var i = 0;
				var c = 0;
				opciones[0] = ["", ""];
				for(c=0;c<combo.length;c++)  //combo
				{
					for(i=0; i < largo; i++)  //padre
					{
						if(padre[i] == combo[c])
						{
							opciones[j] = [id[i], desc[i]];
							j++;
						}
					}
				}
			}		
				if (opciones.length >0){
          //alert(opciones);
					set_combo("formulario.cbValoresPosiblesAcceso", opciones);		
					select_combo("formulario.cbValoresPosiblesAcceso");
					if (get('formulario.casoDeUso')!='modificar') 
						selectAllDefecto();
				}
		
		}
		else
		{
			opciones = new Array();
			opciones[0] = ["", ""];
			set_combo("formulario.cbValoresPosiblesAcceso", opciones);
			buscoAcceso();
			set_combo("formulario.cbValoresDefectoAcceso", opciones);
		}
	}

	function buscoAcceso()
	{
		var combo = get("formulario.cbValoresPosiblesAcceso");
		var id = get("formulario.SubaccesoOid");
		var desc = get("formulario.SubaccesoDesc");
		var padre = get("formulario.SubaccesoOidPadre");
		if (combo !="") 
		{
			if (combo.length == 1)
			{
				id = id.split(",");
				desc = desc.split(",");
				padre = padre.split(",");
				var largo = padre.length;
				var opciones = new Array();
				var j = 1;
				var i = 0;
				opciones[0] = ["", ""];
				for(i=0; i < largo; i++)  //padre
				{
						if(padre[i] == combo)
						{
							opciones[j] = [id[i], desc[i]];
							j++;
					   }
				}
			}

			if (combo.length > 1)
			{
				id = id.split(",");
				desc = desc.split(",");
				padre = padre.split(",");
				var largo = padre.length;
				var opciones = new Array();
				var j = 1;
				var i = 0;
				var c = 0;
				opciones[0] = ["", ""];
				for(c=0;c<combo.length;c++)  //combo
				{
					for(i=0; i < largo; i++)  //padre
					{
						if(padre[i] == combo[c])
						{
							opciones[j] = [id[i], desc[i]];
							j++;
						}
					}
				}
			}		
				if (opciones.length >0){
					set_combo("formulario.cbValoresPosiblesSubacceso", opciones);		
					select_combo("formulario.cbValoresPosiblesSubacceso");
					if (get('formulario.casoDeUso')!='modificar') 
						selectAllDefecto();
				}
		
		}
		else
		{
			opciones = new Array();
			opciones[0] = ["", ""];
			set_combo("formulario.cbValoresPosiblesSubacceso", opciones);
			set_combo("formulario.cbValoresDefectoSubacceso", opciones);
		}
	}

	function buscoTipoCliente()
	{
		var combo = get("formulario.cbValoresPosiblesTipoCliente");
		var id = get("formulario.SubtipoClienteOid");
		var desc = get("formulario.SubtipoClienteDesc");
		var padre = get("formulario.SubtipoClienteOidPadre");
		if (combo !="") 
		{
			if (combo.length == 1)
			{
				id = id.split(",");
				desc = desc.split(",");
				padre = padre.split(",");
				var largo = padre.length;
				var opciones = new Array();
				var j = 1;
				var i = 0;
				opciones[0] = ["", ""];
				for(i=0; i < largo; i++)  //padre
				{
						if(padre[i] == combo)
						{
							opciones[j] = [id[i], desc[i]];
							j++;
					   }
				}
			}

			if (combo.length > 1)
			{
				id = id.split(",");
				desc = desc.split(",");
				padre = padre.split(",");
				var largo = padre.length;
				var opciones = new Array();
				var j = 1;
				var i = 0;
				var c = 0;
				opciones[0] = ["", ""];
				for(c=0;c<combo.length;c++)  //combo
				{
					for(i=0; i < largo; i++)  //padre
					{
						if(padre[i] == combo[c])
						{
							opciones[j] = [id[i], desc[i]];
							j++;
						}
					}
				}
			}		
				if (opciones.length >0){
					set_combo("formulario.cbValoresPosiblesSubtipoCliente", opciones);		
					select_combo("formulario.cbValoresPosiblesSubtipoCliente");
					if (get('formulario.casoDeUso')!='modificar') 
						selectAllDefecto();
				}
		
		}
		else
		{
			opciones = new Array();
			opciones[0] = ["", ""];
			set_combo("formulario.cbValoresPosiblesSubtipoCliente", opciones);
			buscoSubtiposClientes();
			set_combo("formulario.cbValoresDefectoSubtipoCliente", opciones);
		}
	}

	function buscoSubtiposClientes()
	{
		var combo = get("formulario.cbValoresPosiblesSubtipoCliente");
		var id = get("formulario.TipoClasificacionOid");
		var desc = get("formulario.TipoClasificacionDesc");
		var padre = get("formulario.TipoClasificacionOidPadre");
		if (combo !="") 
		{
			if (combo.length == 1)
			{
				id = id.split(",");
				desc = desc.split(",");
				padre = padre.split(",");
				var largo = padre.length;
				var opciones = new Array();
				var j = 1;
				var i = 0;
				opciones[0] = ["", ""];
				for(i=0; i < largo; i++)  //padre
				{
						if(padre[i] == combo)
						{
							opciones[j] = [id[i], desc[i]];
							j++;
					   }
				}
			}

			if (combo.length > 1)
			{
				id = id.split(",");
				desc = desc.split(",");
				padre = padre.split(",");
				var largo = padre.length;
				var opciones = new Array();
				var j = 1;
				var i = 0;
				var c = 0;
				opciones[0] = ["", ""];
				for(c=0;c<combo.length;c++)  //combo
				{
					for(i=0; i < largo; i++)  //padre
					{
						if(padre[i] == combo[c])
						{
							opciones[j] = [id[i], desc[i]];
							j++;
						}
					}
				}
			}		
				if (opciones.length >0){
					set_combo("formulario.cbValoresPosiblesTipoClasificacion", opciones);		
					select_combo("formulario.cbValoresPosiblesTipoClasificacion");
					if (get('formulario.casoDeUso')!='modificar') 
						selectAllDefecto();
				}
		
		}
		else
		{
			opciones = new Array();
			opciones[0] = ["", ""];
			set_combo("formulario.cbValoresPosiblesTipoClasificacion", opciones);
			buscoTiposClasificacion();
			set_combo("formulario.cbValoresDefectoTipoClasificacion", opciones);
		}
	}

	function buscoTiposClasificacion()
	{
		var combo = get("formulario.cbValoresPosiblesTipoClasificacion");
		var id = get("formulario.ClasificacionOid");
		var desc = get("formulario.ClasificacionDesc");
		var padre = get("formulario.ClasificacionOidPadre");
		if (combo !="") 
		{
			if (combo.length == 1)
			{
				id = id.split(",");
				desc = desc.split(",");
				padre = padre.split(",");
				var largo = padre.length;
				var opciones = new Array();
				var j = 1;
				var i = 0;
				opciones[0] = ["", ""];
				for(i=0; i < largo; i++)  //padre
				{
						if(padre[i] == combo)
						{
							opciones[j] = [id[i], desc[i]];
							j++;
					   }
				}
			}

			if (combo.length > 1)
			{
				id = id.split(",");
				desc = desc.split(",");
				padre = padre.split(",");
				var largo = padre.length;
				var opciones = new Array();
				var j = 1;
				var i = 0;
				var c = 0;
				opciones[0] = ["", ""];
				for(c=0;c<combo.length;c++)  //combo
				{
					for(i=0; i < largo; i++)  //padre
					{
						if(padre[i] == combo[c])
						{
							opciones[j] = [id[i], desc[i]];
							j++;
						}
					}
				}
			}		
				if (opciones.length >0){
					set_combo("formulario.cbValoresPosiblesClasificacion", opciones);		
					select_combo("formulario.cbValoresPosiblesClasificacion");
					if (get('formulario.casoDeUso')!='modificar') 
						selectAllDefecto();
				}
		
		}
		else{
			opciones = new Array();
			opciones[0] = ["", ""];
			set_combo("formulario.cbValoresPosiblesClasificacion", opciones);
			set_combo("formulario.cbValoresDefectoClasificacion", opciones);
		}
	}


	function verParametros(){
			var nom = new Array();
		   nom = ["IndicadorCulminacion","Marca","Canal","Acceso","Subacceso",	"VigenciaPeriodoInicial","VigenciaPeriodoFinal","TipoCliente","PorcentajeAdicionalLineaCarrera","DescuentosCliente",
						"AlcanceAdministrativoDescuento","PorcentajeAdicionalAlcanceAdministrativo",	"BaseCalculoDescuentoMarca","BaseCalculoDescuentoUnidadNegocio",
						"BaseCalculoDescuentoNegocio","BaseCalculoDescuentoSupergenerico","BaseCalculoDescuentoGenerico","BaseCalculoDescuentoProducto",
						"BaseAplicacionDescuentoMarca","BaseAplicacionDescuentoUnidadNegocio","BaseAplicacionDescuentoNegocio","BaseAplicacionDescuentoSupergenerico",
						"BaseAplicacionDescuentoGenerico",	"BaseAplicacionDescuentoProducto",	"ControlMorosidad","ControlDevolucionesAnulaciones",
						"ControlDescuentoAcumulativo","AfectaFacturas","AfectaCuentaCorriente","ComunicacionParticipantes"];
			var parametros = get("formulario.parametros");
			parametros = parametros.split(",");
			var j = 0;
			for(var i=4; i < parametros.length; i++){
				var h = i + 1;
				if(parametros[h]==1){
				    var visible = 'formulario.ckVisible'+nom[j];
					var obligatorio = 'formulario.ckObligatorio'+nom[j];
					accion(visible,'.disabled=true');
					accion(obligatorio,'.disabled=true');
				}
                else
                {
                    var visible = 'formulario.ckVisible'+nom[j];
					var obligatorio = 'formulario.ckObligatorio'+nom[j];
					accion(visible,'.disabled=false');
					accion(obligatorio,'.disabled=false');
                }
                
				j++;
				i++;					
			} 
	}

	function cambiaNumax(indice){
			var nom = new Array();
		   nom = ["Acceso","Subacceso","TipoCliente"];
			if(get("formulario.ckModificable"+nom[indice])=="S"){
				if(nom[indice]=="Acceso")		accion('formulario.txtNumMaxValores'+nom[indice],'.disabled=false');
					else	accion('formulario.txtNumMax'+nom[indice],'.disabled=false');
			}else	if(get("formulario.ckModificable"+nom[indice])=="N"){
							//set("formulario.ckModificable"+nom[indice],new Array(""));
						if(nom[indice]=="Acceso")		accion('formulario.txtNumMaxValores'+nom[indice],'.disabled=true');
							else accion('formulario.txtNumMax'+nom[indice],'.disabled=true');
						}
	}

	function cambiaObli(indice){
	var nom = new Array();
	 nom = ["IndicadorCulminacion","Marca","Canal","Acceso","Subacceso",	"VigenciaPeriodoInicial","VigenciaPeriodoFinal","TipoCliente","PorcentajeAdicionalLineaCarrera","DescuentosCliente",
						"AlcanceAdministrativoDescuento","PorcentajeAdicionalAlcanceAdministrativo",	"BaseCalculoDescuentoMarca","BaseCalculoDescuentoUnidadNegocio",
						"BaseCalculoDescuentoNegocio","BaseCalculoDescuentoSupergenerico","BaseCalculoDescuentoGenerico","BaseCalculoDescuentoProducto",
						"BaseAplicacionDescuentoMarca","BaseAplicacionDescuentoUnidadNegocio","BaseAplicacionDescuentoNegocio","BaseAplicacionDescuentoSupergenerico",
						"BaseAplicacionDescuentoGenerico",	"BaseAplicacionDescuentoProducto",	"ControlMorosidad","ControlDevolucionesAnulaciones",
						"ControlDescuentoAcumulativo","AfectaFacturas","AfectaCuentaCorriente","ComunicacionParticipantes"];
    if (indice == 0)
    {
        //alert('Cambiando formulario.ckVisible' +nom[indice]);
        //alert ( get("formulario.ckVisible"+nom[indice]) );
    }
	if(get("formulario.ckVisible"+nom[indice])=="S"){
				accion('formulario.ckObligatorio'+nom[indice],'.disabled=false');
				if(nom[indice]=="Acceso")
  					 sicc_cambiar_estado("cbValoresPosiblesAcceso",true);
				if(nom[indice]=="Subacceso")
					sicc_cambiar_estado("cbValoresPosiblesSubacceso",true);
				if(nom[indice]=="PorcentajeAdicionalLineaCarrera"){
					sicc_cambiar_estado("cbValoresPosiblesTipoClasificacion",true);
					sicc_cambiar_estado("cbValoresPosiblesClasificacion",true);
 				 }
			}else	if(get("formulario.ckVisible"+nom[indice])=="N"){
							accion('formulario.ckObligatorio'+nom[indice],'.disabled=true');
							if(nom[indice]=="Acceso")
								 sicc_cambiar_estado("cbValoresPosiblesAcceso",false);
							if(nom[indice]=="Subacceso")
								sicc_cambiar_estado("cbValoresPosiblesSubacceso",false);
							if(nom[indice]=="PorcentajeAdicionalLineaCarrera"){
								sicc_cambiar_estado("cbValoresPosiblesTipoClasificacion",false);
								sicc_cambiar_estado("cbValoresPosiblesClasificacion",false);
							 }
						}
	}

	function foco(indice){
		if(indice==1){
			focaliza("formulario.txtDescripcion");
		}else if(indice==2){
			focaliza("formulario.cbValoresDefectoIndicadorCulminacion");		
		}
	
	}

	function fVolver(){
			window.close()
	}

	function onLoadPag() {
		configurarMenuSecundario('formulario');
		setearValoresCamposPantalla();
		onChangeComunicacionProcesoAutomatico();
		onChangeComunicacionProcesoManual();
  
	  focaliza("formulario.ckComunicacionProcesoAutomatico");
		var opcionMenu = get("formulario.opcionMenu");
    
		if(opcionMenu=="Consultar Concurso") {
			document.getElementById("ckComunicacionProcesoAutomatico").disabled = true;
			document.getElementById("txtMensajesProcesoAutomatico").disabled = true;
			document.getElementById("ckComunicacionProcesoManual").disabled = true;
			document.getElementById("txtMensajesProcesoManual").disabled = true;
    
			//--Se agrega la deshabilitacion de los botones del menu secundario
		    //--Paola Cabrera  
    
		    btnProxy(1, 0);
  		    btnProxy(2, 1);
            btnProxy(3, 0);
			btnProxy(5, 0);
  			btnProxy(7, 0);
            btnProxy(8, 0);
            btnProxy(9, 0);    
		}
		else if(opcionMenu=="Modificar Concurso") {
			btnProxy(2,'1');
			btnProxy(3,'0');
			btnProxy(7,'0');
			btnProxy(8,'0');
			btnProxy(9,'0');
		}
		else {
			focoCheckAutomatico();
		}
	    finCargaPagina = true;
	}

	function fVolver() {
	window.close();
}

	function setearValoresCamposPantalla() {
		var ckProcesoAutomatico = get("formulario.hckComunicacionProcesoAutomatico");
		var ckProcesoManual = get("formulario.hckComunicacionProcesoManual");
		var txtAutomatico = get("formulario.htxtMensajesProcesoAutomatico");
		var txtManual = get("formulario.htxtMensajesProcesoManual");
		var oidDespachoPremios = get("formulario.oidDespachoPremios");

		set("formulario.ckComunicacionProcesoAutomatico", ckProcesoAutomatico);
		set("formulario.ckComunicacionProcesoManual", ckProcesoManual);
		set("formulario.txtMensajesProcesoAutomatico", txtAutomatico);
		set("formulario.txtMensajesProcesoManual", txtManual);
		set("formulario.oidDespachoPremios", oidDespachoPremios);
	}

	function focoCheckAutomatico() {
		focaliza('formulario.ckComunicacionProcesoAutomatico');    
	}

	function focoCheckManual() {
		focaliza('formulario.ckComunicacionProcesoManual');    
	}

	function focoMensajeManual() {
		focaliza('formulario.txtMensajesProcesoManual');    
	}

	function onShTabCkProcesoAutomatico() {
		if(document.getElementById("txtMensajesProcesoManual").disabled == true) {
			focoCheckManual();
		}else {
			focoMensajeManual();
		}
	}

	function onTabCkProcesoManual() {
		if(document.getElementById("txtMensajesProcesoManual").disabled == true) {
			focoCheckAutomatico();
		}else {
			focoMensajeManual();
		}
	}

	function tomarValoresCamposPantalla() {
		var datosObligatorios = comprobarDatosObligatorios();
		var opcionMenu = get("formulario.opcionMenu");

		set("formulario.datosObligatorios", datosObligatorios);
		set("formulario.opcionMenu", opcionMenu);
		set("formulario.hckComunicacionProcesoAutomatico", get("formulario.ckComunicacionProcesoAutomatico"));
	    set("formulario.hckComunicacionProcesoManual", get("formulario.ckComunicacionProcesoManual"));
	    set("formulario.htxtMensajesProcesoAutomatico", get("formulario.txtMensajesProcesoAutomatico"));
	    set("formulario.htxtMensajesProcesoManual", get("formulario.txtMensajesProcesoManual"));
	    set("formulario.oidDespachoPremios", get("formulario.oidDespachoPremios"));
	}

	function fGuardar(){
		tomarValoresCamposPantalla();
		eval("formulario").oculto= "S";	
		set("formulario.conectorAction","LPMantenerDespachoPremios");
	    set("formulario.accion","guardar");        
        enviaSICC('formulario', '', '', 'N');
    }

    function fLimpiar(){
	    onLoadPag();
    }

    function comprobarDatosObligatorios(){
	    return true;
    }

    function onClickPestanyaPaginaDespacho(valor, form, nombreLP) {
    	tomarValoresCamposPantalla();	
	    onClickPestanyaHabilitada(valor, form, nombreLP);
    }

    function onChangeComunicacionProcesoAutomatico() {
	    var valor = get("formulario.ckComunicacionProcesoAutomatico");
 	    if(valor == "S") {
		    document.getElementById("txtMensajesProcesoAutomatico").disabled = false;
	    }else {
   		    set("formulario.txtMensajesProcesoAutomatico", "");
		    document.getElementById("txtMensajesProcesoAutomatico").disabled = true;
	    }
    }

    function onChangeComunicacionProcesoManual() {
	    var valor = get("formulario.ckComunicacionProcesoManual");
	    if(valor == "S") {
  		    document.getElementById("txtMensajesProcesoManual").disabled = false;
	    }else {
    		set("formulario.txtMensajesProcesoManual", "");
		    document.getElementById("txtMensajesProcesoManual").disabled = true;
	    }
    }

    function arrayComponentes(){
        var arr = new Array();               
        arr[arr.length]= new Array("ckComunicacionProcesoAutomatico","");
        arr[arr.length]= new Array("txtMensajesProcesoAutomatico","");              
        arr[arr.length]= new Array("ckComunicacionProcesoManual","");
        arr[arr.length]= new Array("txtMensajesProcesoManual","");
        return arr;
    }

    function tabGenerico(nombreComp, tipotab){       
        var arr = arrayComponentes();
        var tabular = false;
        var nombreFormulario = getFormularioSICC();
        var j = 0;
        var k = arr.length;

        if (tipotab != "sh") {
            j = j-1;                
            k = k-1;
        }

		while(j<k){
	        var t;
		    if(tipotab == "sh"){
			    k--;
				t = k;
	        } else{
		        j++;
			    t = j;                  
	        }
		    var nombre = arr[t][0];
			var tipo = arr[t][1];
	        if (tabular==false){
		        if (nombreComp==nombre){
			        tabular=true;
				        if (tipotab == "sh"){
					        if (k==0) k= arr.length;
						} else {
							    if ((j+1)==arr.length)  j = -1;
	                    }
		        }                
	        } else {
		        try {
			        var name = nombreFormulario+"."+nombre;
				    if (tipo=="BOTONXY"){
					    focalizaBotonHTML_XY(nombre);
	                } else if (tipo=="BOTON") {
		                focalizaBotonHTML("botonContenido",nombre)
			        } else {
				        focaliza(name);
					}
	                return;
		        } catch (e) {
			    }
	        }
	    }
    } 
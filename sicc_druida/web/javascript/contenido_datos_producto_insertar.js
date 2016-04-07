// funciones privadas

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Para tenerlo en un solo lado 
	function getFirstField(){
		return "frmContenido.txtTextoBreve";
	}
	
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	function getLastField(){
		return "frmContenido.cbCicloVida";
	}


//------------Agregado por gpons, 22/08/2005--Incidencia BELC300023949-----------------------
    function cbTipoOfertaOnChange(){
      set('frmContenido.ocbCondicionPromo',get('frmContenido.cbCondicionPromo'));
      set('frmContenido.ocbCicloVida',get('frmContenido.cbCicloVida'));
      set('frmContenido.ocbTipoOferta',get('frmContenido.cbTipoOferta'));
      set('frmContenido.ocbProgramaFidelizacion',get('frmContenido.cbProgramaFidelizacion'));
      set('frmContenido.ocbVariante',get('frmContenido.cbVariante'));
      
      set('frmContenido.accion', 'recargaIndicadores');    
      enviaSICC('frmContenido');
    }
    

//-----------Agregado by enozigli, 25/10/2005, club priviledges-------------------------------------- 
    function onChangeVariante(){
        oidVariante = get('frmContenido.cbVariante','V');
        var indpuntos;
        
        for(var k=0;k<lstVariantes.datos.longitud;k++) {
          if (lstVariantes.datos.ij(k,0) == oidVariante){                           
              indpuntos = lstVariantes.datos.ij(k,2);
          }
        }
        if (indpuntos=='1'){
          accion('frmContenido.txtPuntoFijo','.disabled=false');
          set("frmContenido.obligaPuntoFijo","true");
        }else{
          set('frmContenido.txtPuntoFijo','');
          accion('frmContenido.txtPuntoFijo','.disabled=true');
          set("frmContenido.obligaPuntoFijo","false");
        }
    } 

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  function onLoadPag()   {
  	  configurarMenuSecundario("frmContenido");	
	  gestionarRButtons();
	  
	  eval (ON_RSZ);  
	  posicionaCombo();
    
    // Agregado por SICC20070316 - Rafael Romero - 20/07/2007
    if(get('frmContenido.htipoOperacion') != 'consulta'){
        goToFirstField();
    }
    
	  accion('frmContenido.txtCodProducto','.disabled=true');
	  cambiaSINO();

	  // Agregado by ssantana, 11/10/2005, GCC-PRE-001		
	  this.manejaHabilitacionCampos();
	  // Fin Agregado by ssantana, 11/10/2005, GCC-PRE-001
	  // Agregado by enozigli, 25/10/2005, club priviledges
      onChangeVariante();   
    // fin Agregado by enozigli, 25/10/2005, club priviledges
  }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  function fLimpiar() {
      cambiaSINO();
      posicionaCombo();
      focaliza('frmContenido.txtTextoBreve');
  }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    function cambiaSINO(){
    var si = GestionarMensaje('MMGGlobal.checkbox.yes.message');
    var no = GestionarMensaje('MMGGlobal.checkbox.no.message');


      if(get("frmContenido.comis") == 1){
        txt_to('lblComisionableX',si);
      }else{
         txt_to('lblComisionableX',no);   
      }

       if(get("frmContenido.punta") == '1'){
         txt_to('lblPuntajeX',si);
      }else{
         txt_to('lblPuntajeX',no);   
      }

       if(get("frmContenido.estad") == '1'){
         txt_to('lblEstadisticableX',si);
      }else{
         txt_to('lblEstadisticableX',no);   
      }

      if(get("frmContenido.mmini") == '1'){
         txt_to('lblMontoMinimoX',si);
      }else{
         txt_to('lblMontoMinimoX',no);   
      }

      if(get("frmContenido.amesc") == '1'){
         txt_to('lblAportaMontoX',si);
      }else{
         txt_to('lblAportaMontoX',no);   
      }
             

    }  

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------  
  function gestionarRButtons(){  
      set("frmContenido.ckDigitable",get("frmContenido.digitable"));	
      set("frmContenido.ckImprimible",get("frmContenido.imprimible"));
      if (get('frmContenido.enableimprimible')=='true'){
          document.all.ckImprimible[0].disabled=false;                           
      } else {
          document.all.ckImprimible[0].disabled=true;          
      }
      if (get('frmContenido.enabledigitable')=='true'){
          document.all.ckDigitable[0].disabled=false;          
      } else {
          document.all.ckDigitable[0].disabled=true;          
      }      
  }
  
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  function fGuardar(){
	guardar();
  }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  function posicionaCombo(){
		var array = new Array();
		array[0]=get("frmContenido.ocbTipoOferta");
		set('frmContenido.cbTipoOferta',array);
		array = new Array();
		array[0]=get("frmContenido.ocbCondicionPromo");
		set('frmContenido.cbCondicionPromo',array);
		array = new Array();
		array[0]=get("frmContenido.ocbCicloVida");
		set('frmContenido.cbCicloVida',array);		
		array = new Array();
		array[0]=get("frmContenido.ocbProgramaFidelizacion");
		set('frmContenido.cbProgramaFidelizacion',array);		
		array = new Array();
		array[0]=get("frmContenido.ocbVariante");
		set('frmContenido.cbVariante',array);		    
  }


// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	function fValidarFloat(valor, ent, dec, boleano, min, max, obligatorio){
		/* 
	Parametros:
				-Valor: el valor a validar
				-ent: cantidad de la parte entera
				-dec : cantidad de la parte decimal
				-boleano : el booleano de validaFloat
				-min: rango minimo
				-max: rango maximo
				-obligatorio: si el campo viene ""

			Returns:
				OK Si se pasa la validacion
				Formato del numero incorrecto si no pasa
		*/
		if ( (obligatorio) && (fTrim(valor)=="")){
			return GestionarMensaje("9");
		}

	/*	if (fTrim(valor)==""){
			return 'OK';
		}
    */

		var x,y;
		x =  ValidaFloat(valor, ent, dec, boleano );
		if (x!='OK'){
			return x;
		}

		y =  ValidaRango(parseInt(valor), min, max);
		if (y!='OK'){
			return y;
		}

		//return x==y?x:GestionarMensaje("000000000000002") ;
		return 'OK'
	  }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  function guardar(){
      if(!sicc_validaciones_generales("gral")){
	      return false;
      }  
      if (get("frmContenido.cbProgramaFidelizacion")!=''){
        if(!sicc_validaciones_generales("priviledges")){
          return false;
        }
      }

      if (get("frmContenido.obligaPuntoFijo")=="true"){
          if(!sicc_validaciones_generales("priviledges2")){
            return false;
          }        
      }
      
 	   var precPos = numeroDeFormatoSICC(get('frmContenido.txtPrecioPos'), get('frmContenido.txtPrecioPos'));
      var precCata = numeroDeFormatoSICC(get("frmContenido.txtPrecioCat"), get("frmContenido.txtPrecioCat"));    

      if (precCata>precPos) {
			 //En este caso muestro mensaje.
			 var res = GestionarMensaje('1289');       
			 if (res==false) return false;
      }

		// Agregado por ssantana, 5/10/2005 - Cambio GCC-PRE-001
		// Se obtiene si los sig. controles están habilitados o no, para su posterior uso en la LP
		var oPrecioPos = document.getElementById("txtPrecioPos");  
		var oCosteEstandar = document.getElementById("txtCosteEstandar");  
		var oCentro = document.getElementById("txtCentro");

		var precioPosicionamientoEnable = oPrecioPos.disabled;
		var costeEstandarEnable = oCosteEstandar.disabled;
		var centroDisabled = oCentro.disabled;

		//alert("precioPosicionamientoEnable: " + precioPosicionamientoEnable);
		//alert("costeEstandarEnable: " + costeEstandarEnable);
		//alert("centroDisabled: " + centroDisabled);

		set("frmContenido.precioPosicionamientoDisabled", precioPosicionamientoEnable);
		set("frmContenido.costeEstandarDisabled", costeEstandarEnable);
		set("frmContenido.centroDisabled", centroDisabled);
		// Fin agregado por ssantana, 5/10/2005 - Cambio GCC-PRE-001

      set('frmContenido.cbTipoOfertaDesc',get('frmContenido.cbTipoOferta','T'));
      set('frmContenido.cbCicloVidaDesc',get('frmContenido.cbCicloVida','T'));
		set('frmContenido.accion','Guardar');
		enviaSICC('frmContenido');
	
  }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function mostrarMensajeNumerico(campo){
      var msg = sicc_obtenerDescripcion(campo);
   	focaliza("frmContenido."+campo);
		cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  "\""+msg+"\""));
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function goToFirstField(){
	focaliza(getFirstField() ,'');
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function toButton(){
  //nombre="btnAnadir" ID="botonContenido"
  focalizaBotonHTML("botonContenido","btnAnadir");
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function goToLastField(){
	focaliza(getLastField() ,'');
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Agregada por ssantana, 11/10/2005, GCC-PRE-001
function manejaHabilitacionCampos() {

	var indicadorDeshabilitacion = get('frmContenido.hidDeshabilitarTrioCampos');
	var objPrecioPos = document.getElementById('txtPrecioPos');
	var objCosteEstandar = document.getElementById('txtCosteEstandar');
	var objCentro = document.getElementById('txtCentro');
  
  var objCatal = document.getElementById('txtCatalogo');
  objCatal.disabled = true;


	if ( indicadorDeshabilitacion == 'true') {
		 // Deshabilita los campos 
		 objPrecioPos.disabled = true;
	 	 objCosteEstandar.disabled = true;
	 	 objCentro.disabled = true;
 	 } else {
		 // Habilita los campos. Innecesaria, pero se deja para claridad de código.
		 objPrecioPos.disabled = false;
	 	 objCosteEstandar.disabled = false;
	 	 objCentro.disabled = false;
	 }

    //enoziglia habilitacion prog fide
	var indicadorHabProgFide = get('frmContenido.hFideHabilita');
	var objProgFide = document.getElementById('cbProgramaFidelizacion');
	var objVaria = document.getElementById('cbVariante');
	var objPuntoFijo = document.getElementById('txtPuntoFijo');
  
	if ( indicadorHabProgFide == 'N') {
		 // Deshabilita los campos 
		 objProgFide.disabled = true;
	 	 objVaria.disabled = true;
	 	 objPuntoFijo.disabled = true;
 	 } else {
		 // Habilita los campos. Innecesaria, pero se deja para claridad de código.
		 objProgFide.disabled = false;
	 	 objVaria.disabled = false;
	 	 objPuntoFijo.disabled = false;
	 }
     
     // Agregado por SICC20070316 - Rafael Romero - 20/07/2007
     var tipoOperacion = get('frmContenido.htipoOperacion');
     if(tipoOperacion == 'consulta'){
        document.all["btnAnadir"].style.visibility='hidden';
        accion('frmContenido.txtCodProducto','.disabled=true');
        accion('frmContenido.txtTextoBreve','.disabled=true');
        accion('frmContenido.txtCatalogo','.disabled=true');
        accion('frmContenido.txtFactorRepeticion','.disabled=true');
        accion('frmContenido.ckDigitable','.disabled=true');
        accion('frmContenido.ckImprimible','.disabled=true');
        accion('frmContenido.txtPrecioCat','.disabled=true');
        accion('frmContenido.txtPrecioPos','.disabled=true');
        accion('frmContenido.txtCosteEstandar','.disabled=true');
        accion('frmContenido.txtUniEstimadas2','.disabled=true');
        accion('frmContenido.txtVentaNetaEstimada','.disabled=true');
        accion('frmContenido.txtNPagCatalogo','.disabled=true');
        accion('frmContenido.txtPosPagina','.disabled=true');
        accion('frmContenido.cbCondicionPromo','.disabled=true');
        accion('frmContenido.cbTipoOferta','.disabled=true');
        accion('frmContenido.cbCicloVida','.disabled=true');
        accion('frmContenido.txtCentro','.disabled=true');
        accion('frmContenido.cbProgramaFidelizacion','.disabled=true');
        accion('frmContenido.cbVariante','.disabled=true');
        accion('frmContenido.txtPuntoFijo','.disabled=true');
        btnProxy(1,0);
        btnProxy(2,1);
        btnProxy(3,0);
        btnProxy(5,0);
        btnProxy(7,0);
        btnProxy(8,0);
        btnProxy(9,0);
     }
     // Fin agregado SICC20070316
     
}

// Agregado por SICC20070316 - Rafael Romero - 20/07/2007
function fVolver(){
    window.close();
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionCargarRangosPrecios() {

		var parametros = new Object();  
		var dtoOferta = new Object();
		parametros.dtoOferta = dtoOferta;

		var an = screen.availWidth;
		var al = screen.availHeight;

		var res = mostrarModalSICC("LPDatosProducto", "precios", parametros, an, al);

		goToFirstField();
}
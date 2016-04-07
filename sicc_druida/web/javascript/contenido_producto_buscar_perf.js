// Variable global no muy feliz que dice si buscaste en el maestro de mat.
// alert("antes de mmat");
 var mmat = false;
// alert("despues de mmat " + mmat );
 var flag2 = false;

 var parametros;

function muestraLista( ultima, rowset, error){
    var tamano = rowset.length;
    if (tamano > 0) {
      ocultaTodo("resultado");
      muestraTodo("maestro");
	  eval (ON_RSZ);
	  focaliza("frmContenido.txtCodSAP"); 
	  return true;
    } else {
	  focaliza("frmContenido.txtCodSAP");
	  ocultaTodo();
	  return false;
    }
}



function ocultaTodo(capas){
        // visualizarDisplay2lavenganza('none');        
        if (capas=="resultado"){
          ocultarResultado();          
        } else 
          if (capas=="maestro"){
            ocultarMaestro();
          } else {
            ocultarResultado();
            ocultarMaestro();
          }
        ocultarSeleccion();         
}

function muestraTodo(capas){
        // visualizarDisplay2lavenganza('block');
        if (capas=="resultado"){
          mostrarResultado();          
        } else 
          if (capas=="maestro"){
            mostrarMaestro();
          } else {
            mostrarResultado();
            mostrarMaestro();
          }       
        mostrarSeleccion();
         
}
// Esta funcion es llamada cuando no encuentra productos estimados de venta y tiene que buscar en Maestro de materiales
// Por tanto carga los valores en listado3
    function prueba(error, ultima, rowset){
        var tamano = rowset.length;
        flag2= true;
         
        if (tamano == 0) {
            var seekMore = GestionarMensaje("PRE0023");
            if(seekMore == true){
                mmat = true;
                var cabecera = 'Cód. producto|Descripción|Precio catálogo|Precio Pos|Costo Estandard|Atributo 1|Atributo2|Atributo3|';
                modificaEncabezados(cabecera, listado2);
                modificaEncabezados(cabecera, listado3);
                //document.all["capaResultado"].style.visibility='hidden';
                //document.all["capaMaestro"].style.visibility='visible';
                listado2.alternaVerColumna(8,null,true);
                listado2.alternaVerColumna(9,null,true);
                listado1.alternaVerColumna(6,null,true);
                listado3.alternaVerColumna(8,null,true);
                listado3.alternaVerColumna(9,null,false);
                // Se buscara en Maestro de Materiales 	
                //alert("hi");
                configurarPaginado(mipgndo3,"PREBuscarProductosMaestro",
                                    "ConectorBuscarProductos2",
                                    "es.indra.sicc.dtos.pre.DTOEBuscarProductos",
                                    armaArray());
            }else{
                ocultaTodo();
		    }
            return false;
        }
        else{
            ocultaTodo("maestro");
            muestraTodo("resultado");
        }
        //document.all["capaResultado"].style.visibility='visible';
        //document.all["capaMaestro"].style.visibility='hidden';
        //document.all["capaTitulo2"].style.visibility='hidden';
        //document.all["capaTitulo"].style.visibility='visible';
        return true;
    }
    
    function onLoadPag()   {
        configurarMenuSecundario("frmContenido"); 
		
		parametros = window.dialogArguments.parametros;
		dtoOferta = window.dialogArguments.parametros.dtoOferta;

		eval("cbLineaProducto.disabled=true");
		eval("cbGenerico.disabled=true");
		eval("cbSupergenerico.disabled=true");		
		
        DrdEnsanchaConMargenDcho('listado1',12);
        DrdEnsanchaConMargenDcho('listado2',12);
        DrdEnsanchaConMargenDcho('listado3',12);
        //eval (ON_RSZ);  
        
        // cambio SiCC 20070317 - Rafael Romero - 26/07/2007
        set('frmContenido.cbCatalogo',[get('frmContenido.oidCatalogo')])
        // fin cambio SiCC 20070317
        
        ocultaTodo();
		
		window.setTimeout("alternaVerAsync()", 200);
      
        //  document.getElementById("lista").style.top = "0px"
        //  document.getElementById("lista").style.left = "0px"
           
        focaliza('frmContenido.txtCodSAP'); 
    }
	
	function alternaVerAsync(){
        // Oculta las columnas que estan en el conector que no se deberian mostrar.        
        listado1.alternaVerColumna(9,null,true);
        listado1.alternaVerColumna(10,null,true);
        listado1.alternaVerColumna(11,null,true);
        listado1.alternaVerColumna(12,null,true);
        listado1.alternaVerColumna(13,null,true);
        listado1.alternaVerColumna(14,null,true);
        listado1.alternaVerColumna(15,null,true);
        listado1.alternaVerColumna(16,null,true);
        listado1.alternaVerColumna(17,null,true);
        listado1.alternaVerColumna(18,null,true);
        listado1.alternaVerColumna(19,null,true);
        listado1.alternaVerColumna(20,null,true);
        listado1.alternaVerColumna(21,null,true);         
        listado1.alternaVerColumna(22,null,true);	  
        listado1.alternaVerColumna(23,null,true);	  
        listado1.alternaVerColumna(23,null,false);	 

        // Oculta las columnas que estan en el conector que no se deberian mostrar.
        //listado3.alternaVerColumna(9,null);
        listado2.alternaVerColumna(9,null,true);
        listado2.alternaVerColumna(10,null,true);
        listado2.alternaVerColumna(11,null,true);
        listado2.alternaVerColumna(12,null,true);
        listado2.alternaVerColumna(13,null,true);
        listado2.alternaVerColumna(14,null,true);
        listado2.alternaVerColumna(15,null,true);
        listado2.alternaVerColumna(16,null,true);
        listado2.alternaVerColumna(17,null,true);
        listado2.alternaVerColumna(18,null,true);
        listado2.alternaVerColumna(19,null,true);
        listado2.alternaVerColumna(20,null,true);
        listado2.alternaVerColumna(21,null,true);
        listado2.alternaVerColumna(22,null,true);
        listado2.alternaVerColumna(23,null,true);
        listado2.alternaVerColumna(24,null,false);
	}
	

    function cargarDatos(){        
        set("frmContenido.cbMarca",new Array(get("frmContenido.varCbMarca")));
        //set("frmContenido.cbLineaProducto",new Array(get("frmContenido.varCbLineaProducto")));
        set("frmContenido.cbUnNegocio",new Array(get("frmContenido.varCbUnNegocio")));
        set("frmContenido.cbNegocio",new Array(get("frmContenido.varCbNegocio")));
        //set("frmContenido.cbGenerico",new Array(get("frmContenido.varCbGenerico")));
        //set("frmContenido.cbSuperGenerico",new Array(get("frmContenido.varCbSuperGenerico")));
        set("frmContenido.txtCodSAP",get("frmContenido.vartxtCodSAP"));
        set("frmContenido.txtDescripcion",get("frmContenido.vartxtDescripcion"));
        set("frmContenido.txtPagDesde",get("frmContenido.vartxtPagDesde"));
        set("frmContenido.txtPagHasta",get("frmContenido.vartxtPagHasta"));
    }

    function botonBuscar(){

	//contenido_producto_buscar_perf

        if(!sicc_validaciones_generales()){
          return false;
        }
        fBorrar();
        flag2= true;
        //document.all["capaMaestro"].style.display='block';
        //document.all["capaSP"].style.display='block';
        //document.all["capaTitulo"].style.display='block';
        // document.all["capaTitulo2"].style.display='block';
        //document.all["capaAniadida"].style.display='block';
        //document.all["capaResultado"].style.display='block';

        set('frmContenido.flag', 'no');

            var codigos = listado1.codigos();
            var longitud = codigos.length;
            for(var i=0;i<longitud;i++) {
            listado1.deselecciona(i);    
            }
            var codigos = listado3.codigos();
            var longitud = codigos.length;
            for(var i=0;i<longitud;i++) {
            listado3.deselecciona(i);    
            }

            // Modifica encabezado al estandard
            var cabecera = 'Cód. producto|Descripción|Precio catálogo|Página|Tipo oferta|Ciclo vida|Atributo1|Atributo2|Atributo3';
            modificaEncabezados(cabecera, listado2);

            set("frmContenido.varCbMarca",get("frmContenido.cbMarca").toString());
            //set("frmContenido.varCbLineaProducto",get("frmContenido.cbLineaProducto").toString());
            set("frmContenido.varCbUnNegocio",get("frmContenido.cbUnNegocio").toString());
            set("frmContenido.varCbNegocio",get("frmContenido.cbNegocio").toString());
            //set("frmContenido.varCbGenerico",get("frmContenido.cbGenerico").toString());
            //set("frmContenido.varCbSuperGenerico",get("frmContenido.cbSupergenerico").toString());

            set("frmContenido.vartxtCodSAP",get("frmContenido.txtCodSAP"));
            set("frmContenido.vartxtDescripcion",get("frmContenido.txtDescripcion"));
            set("frmContenido.vartxtPagDesde",get("frmContenido.txtPagDesde"));
            set("frmContenido.vartxtPagHasta",get("frmContenido.txtPagHasta"));

            //visualizarDisplay("block");
			mmat = false;
            configurarPaginado(mipgndo1,"PREBuscarProductosEstimadosPerf",
                              "ConectorBuscarProductosPerf",
                              "es.indra.sicc.dtos.pre.DTOEBuscarProductos",
                              armaArray());

            eval (ON_RSZ);
            //document.all["capaResultado"].style.visibility='visible';
            //document.all["capaTitulo2"].style.visibility='visible';
            //document.all["capaTitulo"].style.visibility='visible';
            //document.all["capaAniadida"].style.visibility='visible';

            var multiseleccion = get('frmContenido.multiseleccion');
            if (multiseleccion == "false"){
                listado1.maxSel = 1;
            }else{
                listado1.maxSel = -1;
            }
    }        

   function armaArray(){ 
      var arrDatos = new Array();
      var i=0;

      if (get('frmContenido.oidCabeceraMF')!=''){
           arrDatos[i] = new Array('oidCabeceraMF',get('frmContenido.oidCabeceraMF'));
           i++;
      }
      /*if (get('frmContenido.oidEstrategia')!=''){
             arrDatos[i] = new Array('oidEstrategia',get('frmContenido.oidEstrategia'));
             i++;
      }*/
      if (get('frmContenido.cbMarca')!=''){
             arrDatos[i] = new Array('oidMarca',get('frmContenido.cbMarca'));
             i++;
      }
      if (get('frmContenido.oidIdioma')!=''){
             arrDatos[i] = new Array('oidIdioma',get('frmContenido.oidIdioma'));
             i++;
      }
      if (get('frmContenido.oidPais')!=''){
             arrDatos[i] = new Array('oidPais',get('frmContenido.oidPais'));
             i++;
      }
      if (get('frmContenido.oidAcceso')!=''){
             arrDatos[i] = new Array('oidAcceso',get('frmContenido.oidAcceso'));
             i++;
      }
      if (get('frmContenido.oidSubacceso')!=''){
             arrDatos[i] = new Array('oidSubacceso',get('frmContenido.oidSubacceso'));
             i++;
      }
      
      if (get('frmContenido.oidCatalogo')!=''){
             // cambio SiCC 20070317 - Rafael Romero - 26/07/2007
             //arrDatos[i] = new Array('oidCatalogo',get('frmContenido.oidCatalogo'));
             arrDatos[i] = new Array('oidCatalogo',get('frmContenido.cbCatalogo'));
             // fin cambio SICC 20070317
             i++;
      }
      // Agregados Fede
      if (get('frmContenido.vartxtCodSAP')!=''){
             arrDatos[i] = new Array('codSAP',get('frmContenido.vartxtCodSAP'));
             i++;
      }
      if (get('frmContenido.vartxtDescripcion')!=''){
             arrDatos[i] = new Array('descripcionSAP',get('frmContenido.vartxtDescripcion'));
             i++;
      }
      
      if (get('frmContenido.vartxtPagDesde')!=''){
             arrDatos[i] = new Array('paginaDesde',get('frmContenido.vartxtPagDesde'));
             i++;
      }

      if (get('frmContenido.vartxtPagHasta')!=''){
             arrDatos[i] = new Array('paginaHasta',get('frmContenido.vartxtPagHasta'));
             i++;
      }

      if (get('frmContenido.varCbLineaProducto')!=''){
             arrDatos[i] = new Array('oidLineaProducto',get('frmContenido.varCbLineaProducto'));
             i++;
      }

      if (get('frmContenido.varCbUnNegocio')!=''){
             arrDatos[i] = new Array('oidUnidadNegocio',get('frmContenido.varCbUnNegocio'));
             i++;
      }

      if (get('frmContenido.varCbNegocio')!=''){
             arrDatos[i] = new Array('oidNegocio',get('frmContenido.varCbNegocio'));
             i++;
      }

      if (get('frmContenido.varCbGenerico')!=''){
             arrDatos[i] = new Array('oidGenerico',get('frmContenido.varCbGenerico'));
             i++;
      }
      if (get('frmContenido.varCbSuperGenerico')!=''){
             arrDatos[i] = new Array('oidSupergenerico',get('frmContenido.varCbSuperGenerico'));
             i++;
      }

      return arrDatos;
                    
  }

   function crearParametros(padre, valor1, valor2){
      padre[padre.length] = new Array(valor1, valor2);
   }
   
   function botonAniadirBis(){
                  if (mmat == true){
                           botonAniadir(listado3);
                  }else{
                           botonAniadir(listado1);
                  }
   }
   
    function botonAniadir(list){
        var cant = list.numSelecc(); 
        var cantTemporal = listado2.codigos().length;  // Cantidad de elementos en 
        var multiseleccion = get("frmContenido.multiseleccion");
        var toAdd = "";
        var codigo = "";
        //alert(multiseleccion == "false");
        if  (((multiseleccion == "false") && (cantTemporal > 0))||
             ((multiseleccion == "false") && (cant > 1))){             
            GestionarMensaje("41"); // No se puede añiadir mas de un item
            return;
        }

        var cantElementosPermitidos = "true";

        if ( cant == 0 ){            
            GestionarMensaje("PRE0077");                                    
        }else{
            codigo = list.codSeleccionados();
            for(var a = 0; a < codigo.length ; a++){
                if(mmat == true){
                    toAdd = list.extraeDato(codigo[a], 0);
                    toAdd = toAdd + "|" + list.extraeDato(codigo[a], 1);
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 2));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 3));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 4));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 5));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 6));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 7));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 8));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 9)); //progfide
                }
                if(mmat == false){
                    toAdd = list.extraeDato(codigo[a], 0);
                    toAdd = toAdd + "|" +list.extraeDato(codigo[a], 1);
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 2));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 3));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 4));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 5));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 6));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 7));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 8));
                                             
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 9));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 10));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 11));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 12));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 13));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 14));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 15));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 16));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 17));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 18));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 19));
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 20)); // TEXTO Breve
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 21)); // OID
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 22)); 
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 23)); //progfide
                    toAdd = toAdd + "|" + dejaEsp(list.extraeDato(codigo[a], 24));
                }
                pasaListaTemporal( codigo[a], toAdd);
            }
            if(muestraMsg == true){                
                muestraMsg = false;
                GestionarMensaje("PRE0079", null,null,null);
            }
        }
    }

var muestraMsg = false;
         
function pasaListaTemporal(codigo, datos){
var codigosTemporal = listado2.codigos();
	var match = rowMatch(codigo, codigosTemporal);
	if (match){
		muestraMsg = true;
	}else{
		datos = codigo + "|" + datos;  // Agrega el codigo al String de valores. 
		var newRow = new Array();
		newRow = datos.split("|");
		listado2.insertar(newRow);
	}
}


function dejaEsp(a){
	if (a.length == 0){
		return ' ';
	}else{
		return a;
  }
}

function quitaEsp(a){
	if (a == ' '){
		return '';
	}else{
		return a;
  }
}

function rowMatch(codigo, codigosTemporal){
      var flag = false;
      var i = 0;
      while ( (i < codigosTemporal.length) && (flag == false) ){
           if ( codigo == codigosTemporal[i] )
                flag = true;      
           i++;
      }
      return flag;
}

         
function almacenarEnDtoOferta(){

      var codigo = listado2.codigos();
      set('frmContenido.mmat', mmat);
      
      for(var a = 0; a < codigo.length ; a++){

					// Caso en el cual se trae los datos del maestro de materiales
					var dtoDetalle = new Object();
					if(mmat == true){
			
								dtoDetalle.oidSAP = codigo[a];//equivale al Oid de DTOProducto
								dtoDetalle.codigoSAP = quitaEsp(listado2.extraeDato(codigo[a], 0));
								dtoDetalle.descripcionSAP = quitaEsp(listado2.extraeDato(codigo[a], 1));//No se usa luego
								dtoDetalle.precioCatalogo = numeroDeFormatoSICC(quitaEsp(listado2.extraeDato(codigo[a], 2)));
								dtoDetalle.precioPosicionamiento = numeroDeFormatoSICC(quitaEsp(listado2.extraeDato(codigo[a], 3)));
								dtoDetalle.costeEstandar = numeroDeFormatoSICC(quitaEsp(listado2.extraeDato(codigo[a], 4)));
								dtoDetalle.atributo1 = quitaEsp(listado2.extraeDato(codigo[a], 5));
								dtoDetalle.atributo2 = quitaEsp(listado2.extraeDato(codigo[a], 6));
								dtoDetalle.atributo3 = quitaEsp(listado2.extraeDato(codigo[a], 7));
								dtoDetalle.descripcion = quitaEsp(listado2.extraeDato(codigo[a], 8));//equivale al TextoBreve de DTOProducto
								dtoDetalle.descripcionCorta = quitaEsp(listado2.extraeDato(codigo[a], 8));//No se usa Luego
								dtoDetalle.programaFidelizacion = quitaEsp(listado2.extraeDato(codigo[a], 9));
								dtoDetalle.programaFidelizacionMAE = quitaEsp(listado2.extraeDato(codigo[a], 9));//repito para mantener el valor original y no tener que ir a buscarlo cada vez.

								//inicializacion demas variables
								dtoDetalle.oidDetalleOferta = '';
								dtoDetalle.lineaOferta = '';
								dtoDetalle.origen = '';
								dtoDetalle.posicionRanking = '';
								dtoDetalle.oidFormaPago = '';
								dtoDetalle.descripcionFormaPago = '';
								dtoDetalle.numeroGrupo = '';
								dtoDetalle.matrizFacturacionGenerada = '';
								dtoDetalle.oidGrupo = '';
								dtoDetalle.codigoVentaGenerado = '';
								dtoDetalle.codigoVenta = '';
								dtoDetalle.tipoOperacion = '';
								dtoDetalle.precioUnitario = '';

								dtoDetalle.paginaCatalogo = '';
								dtoDetalle.posicionPagina = '';
								dtoDetalle.unidadesEstimadas = '';
								dtoDetalle.ventaNetaEstimada = '';
								dtoDetalle.oidCatalogo = get('frmContenido.oidCatalogo');
								dtoDetalle.descripcionCatalogo = get('frmContenido.descripcionCatalogo');
								dtoDetalle.oidTipoOferta = '';
								dtoDetalle.oidCicloVida = '';
								dtoDetalle.centro = '';
								dtoDetalle.oidCondicionPromocion = '';
								dtoDetalle.descripcionTipoOferta = '';
								dtoDetalle.descripcionCicloVida = '';
								dtoDetalle.factorRepeticion = '';								

                    }

                    // Caso en que no trae los datos del maestro de materiales
					if(mmat == false){
								dtoDetalle.codigoSAP = quitaEsp(listado2.extraeDato(codigo[a], 0));
								dtoDetalle.descripcionSAP = quitaEsp(listado2.extraeDato(codigo[a], 1));
								dtoDetalle.precioCatalogo = numeroDeFormatoSICC(quitaEsp(listado2.extraeDato(codigo[a], 2)));
								dtoDetalle.paginaCatalogo = quitaEsp(listado2.extraeDato(codigo[a], 3));
								dtoDetalle.descripcionTipoOferta = quitaEsp(listado2.extraeDato(codigo[a], 4));
								dtoDetalle.descripcionCicloVida = quitaEsp(listado2.extraeDato(codigo[a], 5));
								dtoDetalle.atributo1 = quitaEsp(listado2.extraeDato(codigo[a], 6));
								dtoDetalle.atributo2 = quitaEsp(listado2.extraeDato(codigo[a], 7));
								dtoDetalle.atributo3 = quitaEsp(listado2.extraeDato(codigo[a], 8));
								// campos ocultos 
								dtoDetalle.posicionPagina = quitaEsp(listado2.extraeDato(codigo[a], 9));
								dtoDetalle.unidadesEstimadas = numeroDeFormatoSICC(quitaEsp(listado2.extraeDato(codigo[a], 10)));
								dtoDetalle.factorRepeticion = quitaEsp(listado2.extraeDato(codigo[a], 11));
								dtoDetalle.ventaNetaEstimada = numeroDeFormatoSICC(quitaEsp(listado2.extraeDato(codigo[a], 12)));
								dtoDetalle.precioPosicionamiento = numeroDeFormatoSICC(quitaEsp(listado2.extraeDato(codigo[a], 13)));
								dtoDetalle.costeEstandar = numeroDeFormatoSICC(quitaEsp(listado2.extraeDato(codigo[a], 14)));
                                
                                // Modificaciones por incidencia SiCC 20070313 - Rafael Romero - 20/06/2007
                                // el codigo de catalogo asignado debe ser el seleccionado en la pantalla inicial
                                // no el que viene de la tabla de estimados de venta.
								//dtoDetalle.oidCatalogo = quitaEsp(listado2.extraeDato(codigo[a], 15));
								//dtoDetalle.descripcionCatalogo = quitaEsp(listado2.extraeDato(codigo[a], 16));
								dtoDetalle.oidCatalogo = get('frmContenido.oidCatalogo');
								dtoDetalle.descripcionCatalogo = get('frmContenido.descripcionCatalogo');
                                // Fin modificaciones
                                
								dtoDetalle.oidTipoOferta = quitaEsp(listado2.extraeDato(codigo[a], 17));
								dtoDetalle.oidCicloVida = quitaEsp(listado2.extraeDato(codigo[a], 18));
								dtoDetalle.centro = quitaEsp(listado2.extraeDato(codigo[a], 19));
								dtoDetalle.descripcion = quitaEsp(listado2.extraeDato(codigo[a], 20));//equivale al TextoBreve de DTOProducto
								dtoDetalle.oidSAP = quitaEsp(listado2.extraeDato(codigo[a], 21));//equivale al Oid de DTOProducto
								dtoDetalle.oidCondicionPromocion = quitaEsp(listado2.extraeDato(codigo[a], 22));
								dtoDetalle.programaFidelizacion = quitaEsp(listado2.extraeDato(codigo[a], 23));
								dtoDetalle.programaFidelizacionMAE = quitaEsp(listado2.extraeDato(codigo[a], 24));

								dtoDetalle.lineaOferta = '';
								dtoDetalle.origen = '';
								dtoDetalle.posicionRanking = '';
								dtoDetalle.oidFormaPago = '';
								dtoDetalle.descripcionFormaPago = '';
								dtoDetalle.numeroGrupo = '';
								dtoDetalle.matrizFacturacionGenerada = '';
								dtoDetalle.oidGrupo = '';
								dtoDetalle.codigoVentaGenerado = '';
								dtoDetalle.codigoVenta = '';
								dtoDetalle.tipoOperacion = '';
								dtoDetalle.precioUnitario = '';
								dtoDetalle.descripcionCorta = '';
								dtoDetalle.oidDetalleOferta = '';

                }
				dtoDetalle.modificado = 'nuevo';//indicador para que InsertarDatosProducto lo tome para editar
				agregarDetalle(dtoDetalle);
      }
}

function fGuardar(){ 
	var cantElementos = listado2.codigos();
	if ( cantElementos.length == 0 ){
		GestionarMensaje("PRE0025", null, null, null);
		return;
	}

	if (parametros.volverLPBuscarProducto=='LPDefinirOfertaPerf'||parametros.volverLPBuscarProducto=='LPCrearGrupoPerf') {
		//comportamiento si es llamado desde Definir Oferta o Crear Grupo.
		almacenarEnDtoOferta();
		setMV('frmContenido.cbMarca','N');
		set('frmContenido.conectorAction','LPDatosProductoPerf');
		set('frmContenido.accion','');
		enviaSICC('frmContenido');
	} else if (parametros.volverLPBuscarProducto=='') {
		//comportamiento si es llamado desde Definir Condicion Oferta.
		var matriz = new Array();
		var j = 0;
        var codigo = listado2.codigos();      	
		for(var a = 0; a < codigo.length ; a++){
		    var fila = new Array();

			if(mmat == true){
				fila[0] = codigo[a]; //oidSAP
				fila[1] = quitaEsp(listado2.extraeDato(codigo[a], 0)); // codigoSAP
				fila[2] = quitaEsp(listado2.extraeDato(codigo[a], 1)); // descripcionSAP
            }

			if(mmat == false){
				fila[0] = quitaEsp(listado2.extraeDato(codigo[a], 21)); // oidSAP
				fila[1] = quitaEsp(listado2.extraeDato(codigo[a], 0)); // codigoSAP
				fila[2] = quitaEsp(listado2.extraeDato(codigo[a], 1)); // descripcionSAP
            }

			matriz[j] = fila;
			j++;
		}		

		returnValue = matriz;
		window.close();
	}
}
         
function botonEliminar() {
      var cantElementos = listado2.codSeleccionados();
      if ( cantElementos.length == 0 ){
         GestionarMensaje("4", null, null, null);
//         alert("Debe seleccionar un elemento para eliminar");
      }else{
           listado2.eliminarSelecc();
      }
}

function fBorrar() {
         var codigos = listado2.codigos();

         for (var i = 0; i < codigos.length ; i++ ){
                listado2.seleccionaCod(codigos[i]) ;
         }
         listado2.eliminarSelecc();	
      
}

function fLimpiar() {
     // set('frmContenido.accion','');
     // enviaSICC('frmContenido');
     focaliza('frmContenido.txtCodSAP'); 
}

         function modificaEncabezados(cab, list){
                  list.txtCab = cab.split('|');
         }


function focalizaBotonTab() {
   // alert("flag2 " + flag2);
           if (!flag2) {
          // alert("pepe" + get('frmContenido.flag'));
     //   alert("entro por si");
                   focaliza('frmContenido.txtCodSAP'); 
           }
      else{
        //  alert("entro por no");
                    //alert("pepe2" + get('frmContenido.flag'));
           //si el flag 2 es si, quiere decir que la capa que se muestra es la capaMaestro
                    //alert(get('frmContenido.flag2'));
                  // alert("entro por no 222222   "+ mmat);
                    if (mmat){
         //      alert("entro por MAE");
                             focalizaBotonHTML('botonContenido','AnadirMae');
                    }else{
             // alert("entro por ESTIMADO");
                            focalizaBotonHTML('botonContenido','Anadir');
                    }
                    

      }
}


function focalizaEliminarOnShTab(){ 
   // alert("MMAT: " + mmat);
          if (mmat){
      // alert("true");
            focalizaBotonHTML('botonContenido','AnadirMae');
          }
          else{
    //  alert ("false");
            focalizaBotonHTML('botonContenido','Anadir');
          }
 }

function focalizaTxtCodSAPOnShTab(){ 
     if (!flag2){
	      focalizaBotonHTML('botonContenido','btnBuscar');
     }
     else{
          focalizaBotonHTML('botonContenido','Eliminar');
     }
 }

 function mostrarResultado(){
         document.all["Cplistado1"].style.visibility='visible'; 
         document.all["separa1Div"].style.visibility='visible';
         document.all["primera1Div"].style.visibility='visible'; 
         document.all["ret1Div"].style.visibility='visible'; 
         document.all["ava1Div"].style.visibility='visible';
         document.all["CpLin1listado1"].style.visibility='visible';
         document.all["CpLin2listado1"].style.visibility='visible';
         document.all["CpLin3listado1"].style.visibility='visible';
         document.all["CpLin4listado1"].style.visibility='visible';
         document.all["AnadirDiv"].style.visibility='visible';    
         //document.all["DefinirTxtDiv"].style.visibility='visible'; 
 }
 function ocultarResultado(){
         //Al principio se debe ocular la lista
         document.all["Cplistado1"].style.visibility='hidden';   //la lista se llama listado1 pero hay que anteponer Cp
         document.all["separa1Div"].style.visibility='hidden';
         document.all["primera1Div"].style.visibility='hidden';     //el boton se llama prim1 pero hay que poner al final Div
         document.all["ret1Div"].style.visibility='hidden'; 
         document.all["ava1Div"].style.visibility='hidden';   
         document.all["CpLin1listado1"].style.visibility='hidden';   //para ocultar las lineas que conforman el marco
         document.all["CpLin2listado1"].style.visibility='hidden'; 
         document.all["CpLin3listado1"].style.visibility='hidden'; 
         document.all["CpLin4listado1"].style.visibility='hidden';
         document.all["AnadirDiv"].style.visibility='hidden';  // Para ocultar los botones  
}
 function mostrarMaestro(){
         document.all["Cplistado3"].style.visibility='visible'; 
         document.all["separa3Div"].style.visibility='visible';
         document.all["prim3Div"].style.visibility='visible'; 
         document.all["ret3Div"].style.visibility='visible'; 
         document.all["ava3Div"].style.visibility='visible';
         document.all["CpLin1listado3"].style.visibility='visible';
         document.all["CpLin2listado3"].style.visibility='visible';
         document.all["CpLin3listado3"].style.visibility='visible';
         document.all["CpLin4listado3"].style.visibility='visible';                  
         document.all["AnadirMaeDiv"].style.visibility='visible';
 }
 function ocultarMaestro(){
         //Al principio se debe ocular la lista
         document.all["Cplistado3"].style.visibility='hidden';   //la lista se llama listado1 pero hay que anteponer Cp
         document.all["separa3Div"].style.visibility='hidden';
         document.all["prim3Div"].style.visibility='hidden';     //el boton se llama prim1 pero hay que poner al final Div
         document.all["ret3Div"].style.visibility='hidden'; 
         document.all["ava3Div"].style.visibility='hidden';   
         document.all["CpLin1listado3"].style.visibility='hidden';   //para ocultar las lineas que conforman el marco
         document.all["CpLin2listado3"].style.visibility='hidden'; 
         document.all["CpLin3listado3"].style.visibility='hidden'; 
         document.all["CpLin4listado3"].style.visibility='hidden';     
         document.all["AnadirMaeDiv"].style.visibility='hidden'; 
 } 
 function mostrarSeleccion(){
         document.all["Cplistado2"].style.visibility='visible'; 
         document.all["CpLin1listado2"].style.visibility='visible';
         document.all["CpLin2listado2"].style.visibility='visible';
         document.all["CpLin3listado2"].style.visibility='visible';
         document.all["CpLin4listado2"].style.visibility='visible';
         document.all["EliminarDiv"].style.visibility='visible';  // Para poner visibles los botones                   
 }
 function ocultarSeleccion(){
         //Al principio se debe ocular la lista
         document.all["Cplistado2"].style.visibility='hidden';   //la lista se llama listado1 pero hay que anteponer Cp
         document.all["CpLin1listado2"].style.visibility='hidden';   //para ocultar las lineas que conforman el marco
         document.all["CpLin2listado2"].style.visibility='hidden'; 
         document.all["CpLin3listado2"].style.visibility='hidden'; 
         document.all["CpLin4listado2"].style.visibility='hidden';
         document.all["EliminarDiv"].style.visibility='hidden';  // Para ocultar los botones                   
 }  

 /*Agregado por Gacevedo a fin de reemplazar los combos por la busqueda generica*/
 
 function buscarLineaProducto(){
	var datos= new Object();
	datos.dto = "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOGenBusquedaLineaProducto";
	datos.conector = "ConectorGENBusquedaProducto";
	var salida = abrirBusquedaGenerica(datos, "","0075");
	var oid = "";
	var descripcion = "";
	if(salida){
		oid = salida[0][0];
		descripcion = salida [0][2];
	}
	set('frmContenido.varCbLineaProducto',oid);
	set('frmContenido.cbLineaProducto',descripcion);	
 }
 function buscarSuperGenerico(){
	var datos = new Object();
 	datos.dto = "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOGenBusquedaSuperGenerico";
	datos.conector = "ConectorGENBusquedaProducto";
	var salida = abrirBusquedaGenerica(datos, "","0075");
	var oid = "";
	var descripcion = "";
	if(salida){
		oid = salida[0][0];
		descripcion = salida [0][2];
	}
	set('frmContenido.varCbSuperGenerico',oid);
	set('frmContenido.cbSupergenerico',descripcion);	
	
 }
 function buscarGenerico(){
	var datos = new Object();
  	datos.dto = "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOGenBusquedaGenerico";
	datos.conector = "ConectorGENBusquedaProducto";
	var salida = abrirBusquedaGenerica(datos, "","0075");
	var oid = "";
	var descripcion = "";
	if(salida){
		oid = salida[0][0];
		descripcion = salida [0][2];
	}
	set('frmContenido.varCbGenerico',oid);
	set('frmContenido.cbGenerico',descripcion);	
 }
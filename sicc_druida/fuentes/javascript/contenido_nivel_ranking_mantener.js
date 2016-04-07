var datosNiveles = null;
  var numeroPremio = null;
  var secDesc = 1;
  var secMonet = 1;
  var secArtProd = 1;
  var secArt = 1;
  
  varNoLimpiarSICC='S';

  function onLoadPag(){
  
    configurarMenuSecundario('formulario');
    
    if(!fMostrarMensajeError()){
    
         // Muestra los Datos de Niveles
         mostrarListadoNiveles();
         
         // Carga los datos de niveles
         var nivelesString = get('formulario.datosNiveles');
         datosNiveles = nivelesString.split("%");
         
         // Numero de Premio
         numeroPremio = Number(get('formulario.numeroPremio'));
         //alert("numeroPremio: " + numeroPremio);
         
        
         // Deshabilita los campos si es una consulta
         if(get('formulario.opcionMenu')=="Consultar Concurso Ranking"){  
             deshabilitarListadoNiveles();
             btnProxy(5,0);
    
         } else {
             focalizaDatosNiveles();
         }
         
    } else {
         close();
    }
    
  }
  
  
  function deshabilitarListadoNiveles() {  
  
      listado.tiposCol[1][8]=true;
      listado.tiposCol[2][8]=true;
      listado.tiposCol[3][6]=true;
      listado.tiposCol[4][8]=true;
      listado.tiposCol[5][8]=true;
      listado.tiposCol[6][8]=true;
      listado.tiposCol[7][8]=true;
      listado.tiposCol[8][8]=true;
      
      listado.actualizaDat();
      listado.repinta();
  }
  
  
  
  function accionDefinirPremio() {   
  
    var codigo = listado.codSeleccionados();    
    
    if(codigo!="") {  
    
         if(listado.extraeDato(codigo, 2)=="") {
             GestionarMensaje('1545');
             eval("listado.preparaCamposDR()");
             focaliza('frm'+'listado'+'.'+'cbTipoPremio'+'_'+codigo,'');
             return;
         }
         
         // Puntje Servicio
         if(!sicc_valida_numero_lista(listado.extraeDato(codigo, 1), GestionarMensaje('1546'),0, 9999999)) {
             eval("listado.preparaCamposDR()");
             focaliza('frm'+'listado'+'.'+'txtPuntajeServicio'+'_'+codigo,'');
             return;
         }
         
         // Cantidad Fijo Puntos
         if(!sicc_valida_numero_lista(listado.extraeDato(codigo, 4), GestionarMensaje('1547'),1, 9999999)) {
             eval("listado.preparaCamposDR()");
             focaliza('frm'+'listado'+'.'+'txtCantidadFijoPuntos'+'_'+codigo,'');
             return;
         }
                  
         // Cantidad Desde
         if(!sicc_valida_numero_lista(listado.extraeDato(codigo, 5), GestionarMensaje('1548'),0, 9999999)) {
             eval("listado.preparaCamposDR()");
             focaliza('frm'+'listado'+'.'+'txtCantidadDesde'+'_'+codigo,'');
             return;
         }
         
         // Cantidad Hasta
         if(!sicc_valida_numero_lista(listado.extraeDato(codigo, 6), GestionarMensaje('1549'),0, 9999999)) {
             eval("listado.preparaCamposDR()");
             focaliza('frm'+'listado'+'.'+'txtCantidadHasta'+'_'+codigo,'');
             return;
         }
         
         // Puntos Productos Exigidos
         if(!sicc_valida_numero_lista(listado.extraeDato(codigo, 7), GestionarMensaje('1550'),0, 9999)) {
             eval("listado.preparaCamposDR()");
             focaliza('frm'+'listado'+'.'+'txtPuntosProductosExigidos'+'_'+codigo,'');
             return;
         }
         
         // Numero de Aspirantes
         if(!sicc_valida_numero_lista(listado.extraeDato(codigo, 8), GestionarMensaje('1557'),0, 999)) {
             eval("listado.preparaCamposDR()");
             focaliza('frm'+'listado'+'.'+'txtNumAspirantes'+'_'+codigo,'');
             return;
         }
    
         
         // Deshabilita Aceptar
         deshabilitarHabilitarBoton('botonContenido','btnAceptar','D')
         
         // Levanta los datos del nivel seleccionado
         var nivel = datosNiveles[codigo];
                 
         var nivelPremio = nivel.split("#");
         
        // alert("nivel almacenado: " + nivelPremio[1]);
         //alert("nivel seleccionado: " + listado.extraeDato(codigo, 2));
         
         tipoPremioAlmacenado= nivelPremio[1];
         tipoPremioSeleccionado= listado.extraeDato(codigo, 2);
         
         // Guarda el nivel a ingresarse
         set('formulario.nivelAIngresar', codigo);      

                  // Limpia
         set('formulario.codLotelista', '');   
         
         
         // Carga la pantalla
         if(tipoPremioAlmacenado!="BLANCO" && tipoPremioAlmacenado==tipoPremioSeleccionado){
             if(tipoPremioSeleccionado==get('formulario.OID_TIPO_PREMIO_PUNTOS')) {
                  premioPuntos(nivelPremio);
             } else if(tipoPremioSeleccionado==get('formulario.OID_TIPO_PREMIO_DESCUENTO')) {
                  premioDescuento(nivelPremio);
             } else if(tipoPremioSeleccionado==get('formulario.OID_TIPO_PREMIO_MONETARIO')) {
                  premioMonetario(nivelPremio);
             } else if(tipoPremioSeleccionado==get('formulario.OID_TIPO_PREMIO_ARTICULO')) {
                  premioArticulos(nivelPremio);
             }
             
         } else if(tipoPremioAlmacenado!="BLANCO" && tipoPremioAlmacenado!=tipoPremioSeleccionado){
             if(tipoPremioSeleccionado==get('formulario.OID_TIPO_PREMIO_PUNTOS')) {
                  premioPuntosInicial(nivelPremio);
             } else if(tipoPremioSeleccionado==get('formulario.OID_TIPO_PREMIO_DESCUENTO')) {
                  premioDescuentoInicial(nivelPremio);
             } else if(tipoPremioSeleccionado==get('formulario.OID_TIPO_PREMIO_MONETARIO')) {
                  premioMonetarioInicial(nivelPremio);
             } else if(tipoPremioSeleccionado==get('formulario.OID_TIPO_PREMIO_ARTICULO')) {
                  premioArticulosInicial();
             }
             
         } else {
             if(tipoPremioSeleccionado==get('formulario.OID_TIPO_PREMIO_PUNTOS')) {
                  premioPuntosInicial("");
             } else if(tipoPremioSeleccionado==get('formulario.OID_TIPO_PREMIO_DESCUENTO')) {
                  premioDescuentoInicial("");
             } else if(tipoPremioSeleccionado==get('formulario.OID_TIPO_PREMIO_MONETARIO')) {
                  premioMonetarioInicial("");
             } else if(tipoPremioSeleccionado==get('formulario.OID_TIPO_PREMIO_ARTICULO')) {
                  premioArticulosInicial();
             }
         }    
    
    } else {
         GestionarMensaje('8', null, null, null);
    }
    
  }
  
  function onclickRdTipoEntrega(){

    if(get('formulario.rdTipoEntrega')=="B"){
          set('formulario.cbCenServEntrega', '');         
          accion('formulario.cbCenServEntrega', '.disabled=true');   
          
    } else if(get('formulario.rdTipoEntrega')=="C"){    
          accion('formulario.cbCenServEntrega', '.disabled=false');   
    }
  }
  
  function onclickIndCenServGar(){

    if(get('formulario.ChkIndCenServGar')=="S"){
          accion('formulario.cbCenServGar', '.disabled=false');  
          accion('formulario.txtNumMeses', '.disabled=false');  
          accion('formulario.areaObservaciones', '.disabled=false');
          
    } else if(get('formulario.ChkIndCenServGar')=="N"){    
          set('formulario.cbCenServGar', '');   
          set('formulario.txtNumMeses', '');   
          set('formulario.areaObservaciones', ''); 
          
          accion('formulario.cbCenServGar', '.disabled=true');  
          accion('formulario.txtNumMeses', '.disabled=true');  
          accion('formulario.areaObservaciones', '.disabled=true');  
    }
}
  
  
  
  
  function premioArticulosInicial(){  
      
      // Numero de Premio
      txt_to('lbNumPremio4', numeroPremio +1);
      set('formulario.numeroPremioArticulos', numeroPremio +1); 
      
      set('formulario.txtNumUnidadesPremiosArticulo', '1');      
      set('formulario.oidPremioArticulos', '');  
      
      // Limpia
      set('formulario.txtCodProducto', '');   
      set('formulario.oidProdArticulos', '');   
      set('formulario.txtNumUnidades4', '1');        
      set('formulario.txtPrecioPublico4', '');        
      set('formulario.ckArticuloDespacha4', 'N');          
      set('formulario.txtDescripcionLote4', '');  
      
      set('formulario.ChkIndCenServGar', 'N');          
      set('formulario.cbCenServGar', '');   
      set('formulario.txtNumMeses', '');   
      set('formulario.areaObservaciones', '');        
      accion('formulario.cbCenServGar', '.disabled=true');  
      accion('formulario.txtNumMeses', '.disabled=true');  
      accion('formulario.areaObservaciones', '.disabled=true');  
      
      set('formulario.rdTipoEntrega', 'B');          
      set('formulario.cbCenServEntrega', '');        
      accion('formulario.cbCenServEntrega', '.disabled=true');  
      
      // Habilita botones
      deshabilitarHabilitarBoton('botonContenido','btnAnadirLotes','A');
      deshabilitarHabilitarBoton('botonContenido','btnBuscar','A');
      deshabilitarHabilitarBoton('botonContenido','btnAnadirProductos','A');
      deshabilitarHabilitarBoton('botonContenido','btnEliminarProductos','A');
      deshabilitarHabilitarBoton('botonContenido','btnEliminarLotes','A');
        
      accion('formulario.txtCodProducto', '.disabled=false'); 
      accion('formulario.txtNumUnidades4', '.disabled=false'); 
      accion('formulario.txtPrecioPublico4', '.disabled=false'); 
      accion('formulario.ckArticuloDespacha4', '.disabled=false'); 
      accion('formulario.txtDescripcionLote4', '.disabled=false'); 
      
      accion('formulario.ChkIndCenServGar', '.disabled=false');
      accion('formulario.rdTipoEntrega', '.disabled=false'); 
      
      listado2.limpia();
      listado4.limpia();
      
      visualizarPremioArticulo();
  }

  function premioArticulos(nivelPremio) {  
      /*  0-ind
           1-tipoPremiacion
           2-numUnidades
           3-oidPremioArticulos
           4-listaLotes  
      */
      
      // Numero de Premio
      txt_to('lbNumPremio4', numeroPremio +1);
      set('formulario.numeroPremioArticulos', numeroPremio +1); 
      
      set('formulario.txtNumUnidadesPremiosArticulo', nivelPremio[2]);
      
      set('formulario.oidPremioArticulos', nivelPremio[3]=="BLANCO"?"":nivelPremio[3]);  
      
      llenaListaLotes(nivelPremio[4]);
      
      listado2.limpia();
      
      // Limpia
      set('formulario.txtCodProducto', '');   
      set('formulario.oidProdArticulos', '');   
      set('formulario.txtNumUnidades4', '1');        
      set('formulario.txtPrecioPublico4', '');        
      set('formulario.ckArticuloDespacha4', 'N');          
      set('formulario.txtDescripcionLote4', '');  
      
      set('formulario.ChkIndCenServGar', 'N');          
      set('formulario.cbCenServGar', '');   
      set('formulario.txtNumMeses', '');   
      set('formulario.areaObservaciones', '');        
      accion('formulario.cbCenServGar', '.disabled=true');  
      accion('formulario.txtNumMeses', '.disabled=true');  
      accion('formulario.areaObservaciones', '.disabled=true');  
      
      set('formulario.rdTipoEntrega', 'B');          
      set('formulario.cbCenServEntrega', '');        
      accion('formulario.cbCenServEntrega', '.disabled=true');  
      
      if(get('formulario.opcionMenu')=="Consultar Concurso Ranking"){  
           deshabilitarPremioArticulo();
      }
      
      visualizarPremioArticulo();
      
  }

  function llenaListaLotes(lotes){
  
      if(lotes!="BLANCO"){      

                    listado4.limpia();

           // Hay lotes ingresados
           lote = lotes.split('$');
           
           for(var i=0; i<lote.length; i++) {
                //alert(lote[i]);
                loteDatos = lote[i].split(';');
                
                oid = listado4.generaCodigo(secArt);
                secArt = oid;
      
                numPremio = loteDatos[0];
                descLote = loteDatos[1];
                listProdLote = loteDatos[2];          
                oidLote = loteDatos[3];
              
                listado4.insertar(new Array(oid, numPremio, descLote, listProdLote, oidLote ));                                                      
           }
      } else {
            listado4.limpia();
      }
  }
  
  function deshabilitarPremioArticulo(){
  
      set('formulario.txtCodProducto', '');   
      set('formulario.oidProdArticulos', '');   
      set('formulario.txtNumUnidades4', '1');        
      set('formulario.txtPrecioPublico4', '');        
      set('formulario.ckArticuloDespacha4', 'N');          
      set('formulario.txtDescripcionLote4', '');  
      
      set('formulario.ChkIndCenServGar', 'N');          
      set('formulario.cbCenServGar', '');   
      set('formulario.txtNumMeses', '');   
      set('formulario.areaObservaciones', '');        
      accion('formulario.cbCenServGar', '.disabled=true');  
      accion('formulario.txtNumMeses', '.disabled=true');  
      accion('formulario.areaObservaciones', '.disabled=true');  
      
      set('formulario.rdTipoEntrega', 'B');          
      set('formulario.cbCenServEntrega', '');        
      accion('formulario.cbCenServEntrega', '.disabled=true');  
      
      // Habilita botones
      deshabilitarHabilitarBoton('botonContenido','btnAnadirLotes','D');
      deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
      deshabilitarHabilitarBoton('botonContenido','btnAnadirProductos','D');
      deshabilitarHabilitarBoton('botonContenido','btnEliminarProductos','D');
      deshabilitarHabilitarBoton('botonContenido','btnEliminarLotes','D');
        
      //accion('formulario.txtNumUnidadesPremiosArticulo', '.disabled=true');  
      accion('formulario.txtCodProducto', '.disabled=true'); 
      accion('formulario.txtNumUnidades4', '.disabled=true'); 
      accion('formulario.txtPrecioPublico4', '.disabled=true'); 
      accion('formulario.ckArticuloDespacha4', '.disabled=true'); 
      accion('formulario.txtDescripcionLote4', '.disabled=true');
      
      accion('formulario.ChkIndCenServGar', '.disabled=true');
      accion('formulario.cbCenServGar', '.disabled=true');  
      accion('formulario.txtNumMeses', '.disabled=true');  
      accion('formulario.areaObservaciones', '.disabled=true'); 
      accion('formulario.rdTipoEntrega', '.disabled=true'); 
      accion('formulario.cbCenServEntrega', '.disabled=true');  
  }

  
  function onSelectLotesPremio(fila){  
  
      codigo = listado4.codSeleccionados();
      
      if(codigo !="") {
           listaProdLotes = listado4.extraeDato(codigo, 2);
           numPremio = listado4.extraeDato(codigo, 0);
           descLote = listado4.extraeDato(codigo, 1);
           
           set('formulario.txtCodProducto', '');   
           
           // Actualiza el numero premio
           txt_to('lbNumPremio4', numPremio);
           set('formulario.numeroPremioArticulos', numPremio);
           
           set('formulario.codLotelista', codigo);   
           set('formulario.txtDescripcionLote4', descLote);          
           
           // Lista los productos
           listado2.limpia();
           
           set('formulario.txtCodProducto', '');   
           set('formulario.oidProdArticulos', '');   
           set('formulario.txtNumUnidades4', '1');        
           set('formulario.txtPrecioPublico4', '');        
           set('formulario.ckArticuloDespacha4', 'N');  
           
           set('formulario.ChkIndCenServGar', 'N');          
           set('formulario.cbCenServGar', '');   
           set('formulario.txtNumMeses', '');   
           set('formulario.areaObservaciones', '');        
           accion('formulario.cbCenServGar', '.disabled=true');  
           accion('formulario.txtNumMeses', '.disabled=true');  
           accion('formulario.areaObservaciones', '.disabled=true');  
           
           set('formulario.rdTipoEntrega', 'B');          
           set('formulario.cbCenServEntrega', '');        
           accion('formulario.cbCenServEntrega', '.disabled=true');  
        
           if(listaProdLotes!="BLANCO") {
                prodLotes = listaProdLotes.split("|");
                //alert("prodLotes: " + prodLotes);
                
                for(var i=0; i<prodLotes.length; i++){
                
                    prodLote = prodLotes[i].split("&");
                
                    oid = listado2.generaCodigo(secArtProd);
                    secArtProd = oid;
                    
                    codProducto = prodLote[0];
                    numUnidades = prodLote[1];
                    precioPublico = prodLote[2];
                    despachoArt = prodLote[3]=="S"?GestionarMensaje("84"):GestionarMensaje("86");
                    codVentaFicticio = prodLote[4]=="BLANCO"?"":prodLote[4];     
                    
                    indCentSerGar = prodLote[5]=="S"?GestionarMensaje("84"):GestionarMensaje("86");
                    descCentSerGar = prodLote[6]=="BLANCO"?"":prodLote[6];   
                    numMeses = prodLote[7]=="BLANCO"?"":prodLote[7];   
                    obs = prodLote[8]=="BLANCO"?"":prodLote[8];   
                    tipoEntrega = prodLote[9]; 
                    descCentSerEntrega = prodLote[10]=="BLANCO"?"":prodLote[10];
                    oidCentSerGar = prodLote[11]=="BLANCO"?"":prodLote[11];
                    oidCentSerEntrega = prodLote[12]=="BLANCO"?"":prodLote[12];
                    
                    oidProducto = prodLote[13]=="BLANCO"?"":prodLote[13];           
                    oidLoteProd = prodLote[14]=="BLANCO"?"":prodLote[14];   
                   
                    listado2.insertar(new Array(oid, codProducto, numUnidades, precioPublico, despachoArt, codVentaFicticio, 
                                                    indCentSerGar, descCentSerGar, numMeses, obs, tipoEntrega, descCentSerEntrega,
                                                    oidCentSerGar, oidCentSerEntrega,
                                                    oidProducto, oidLoteProd ));
                } 
           }
           
           if(get('formulario.opcionMenu')!="Consultar Concurso Ranking"){  
                // Habilita botones
                deshabilitarHabilitarBoton('botonContenido','btnAnadirLotes','A');
                deshabilitarHabilitarBoton('botonContenido','btnBuscar','A');
                deshabilitarHabilitarBoton('botonContenido','btnAnadirProductos','A');
                deshabilitarHabilitarBoton('botonContenido','btnEliminarProductos','A');
                 
                accion('formulario.txtCodProducto', '.disabled=false'); 
                accion('formulario.txtNumUnidades4', '.disabled=false'); 
                accion('formulario.txtPrecioPublico4', '.disabled=false'); 
                accion('formulario.ckArticuloDespacha4', '.disabled=false'); 
                accion('formulario.txtDescripcionLote4', '.disabled=false'); 
                
                accion('formulario.ChkIndCenServGar', '.disabled=false');
                accion('formulario.rdTipoEntrega', '.disabled=false'); 
           }
      } else {
           
           // Actualiza el numero premio
           txt_to('lbNumPremio4', numeroPremio +1);
           set('formulario.numeroPremioArticulos', numeroPremio +1);
           
           set('formulario.codLotelista', '');   
           
           set('formulario.txtCodProducto', '');   
           set('formulario.oidProdArticulos', '');   
           set('formulario.txtNumUnidades4', '1');        
           set('formulario.txtPrecioPublico4', '');        
           set('formulario.ckArticuloDespacha4', 'N');          
           set('formulario.txtDescripcionLote4', '');  
           
           set('formulario.ChkIndCenServGar', 'N');          
           set('formulario.cbCenServGar', '');   
           set('formulario.txtNumMeses', '');   
           set('formulario.areaObservaciones', '');        
           accion('formulario.cbCenServGar', '.disabled=true');  
           accion('formulario.txtNumMeses', '.disabled=true');  
           accion('formulario.areaObservaciones', '.disabled=true');  
           
           set('formulario.rdTipoEntrega', 'B');          
           set('formulario.cbCenServEntrega', '');        
           accion('formulario.cbCenServEntrega', '.disabled=true');
           
           listado2.limpia();
           
           if(get('formulario.opcionMenu')!="Consultar Concurso Ranking"){  
                // Habilita botones
                deshabilitarHabilitarBoton('botonContenido','btnAnadirLotes','A');
                deshabilitarHabilitarBoton('botonContenido','btnBuscar','A');
                deshabilitarHabilitarBoton('botonContenido','btnAnadirProductos','A');
                deshabilitarHabilitarBoton('botonContenido','btnEliminarProductos','A');
                 
                accion('formulario.txtCodProducto', '.disabled=false'); 
                accion('formulario.txtNumUnidades4', '.disabled=false'); 
                accion('formulario.txtPrecioPublico4', '.disabled=false'); 
                accion('formulario.ckArticuloDespacha4', '.disabled=false'); 
                accion('formulario.txtDescripcionLote4', '.disabled=false'); 
                
                accion('formulario.ChkIndCenServGar', '.disabled=false');
                accion('formulario.rdTipoEntrega', '.disabled=false'); 
           }
      }
  }
  
  
  function accionAniadirLotePremio(){  
      if(sicc_validaciones_generales("gArticulo")){
      
           if(get('formulario.codLotelista')!=""){
                // Modifico registro
              codigoModif = get('formulario.codLotelista');
              
              listado4.insertaDato(codigoModif,'1',get('formulario.txtDescripcionLote4'));
              listado4.insertaDato(codigoModif,'2',obtenerListaProdLotes());
                                     
                // Actualiza el mumero Premio
                txt_to('lbNumPremio4', numeroPremio + 1);
                set('formulario.numeroPremioArticulos', numeroPremio + 1); 
                
                // Limpia
                set('formulario.txtCodProducto', '');   
                set('formulario.oidProdArticulos', '');   
                set('formulario.txtNumUnidades4', '1');        
                set('formulario.txtPrecioPublico4', '');        
                set('formulario.ckArticuloDespacha4', 'N');          
                set('formulario.txtDescripcionLote4', '');  
                
                set('formulario.ChkIndCenServGar', 'N');          
                set('formulario.cbCenServGar', '');   
                set('formulario.txtNumMeses', '');   
                set('formulario.areaObservaciones', '');        
                accion('formulario.cbCenServGar', '.disabled=true');  
                accion('formulario.txtNumMeses', '.disabled=true');  
                accion('formulario.areaObservaciones', '.disabled=true');  
                
                set('formulario.rdTipoEntrega', 'B');          
                set('formulario.cbCenServEntrega', '');        
                accion('formulario.cbCenServEntrega', '.disabled=true');  
                
                listado2.limpia();
                
                listado4.deselecciona (DrIndiceEnArray(listado4.datos, codigoModif, 0));
                
                set('formulario.codLotelista', '');   
                
                if(get('formulario.hIndPremiosElectivosPremios')== get('formulario.IND_INACTIVO')){
                        // Deshabilita botones
                        deshabilitarHabilitarBoton('botonContenido','btnAnadirLotes','D');
                        deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
                        deshabilitarHabilitarBoton('botonContenido','btnAnadirProductos','D');
                        deshabilitarHabilitarBoton('botonContenido','btnEliminarProductos','D');
                        
                        accion('formulario.txtCodProducto', '.disabled=true'); 
                        accion('formulario.txtNumUnidades4', '.disabled=true'); 
                        accion('formulario.txtPrecioPublico4', '.disabled=true'); 
                        accion('formulario.ckArticuloDespacha4', '.disabled=true'); 
                        accion('formulario.txtDescripcionLote4', '.disabled=true'); 
                        
                        accion('formulario.ChkIndCenServGar', '.disabled=true');
                        accion('formulario.cbCenServGar', '.disabled=true');  
                        accion('formulario.txtNumMeses', '.disabled=true');  
                        accion('formulario.areaObservaciones', '.disabled=true'); 
                        accion('formulario.rdTipoEntrega', '.disabled=true'); 
                        accion('formulario.cbCenServEntrega', '.disabled=true');  
                }
                    
                
           } else {
                // Inserto registro nuevo                
                if(get('formulario.hIndPremiosElectivosPremios')== get('formulario.IND_INACTIVO') &&
                   listado4.codigos.length > 0) {
                   // No se puede ingresar nuevos registros
                   GestionarMensaje("1552");
                   
                   // Deshabilita botones
                   deshabilitarHabilitarBoton('botonContenido','btnAnadirLotes','D');
                   deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
                   deshabilitarHabilitarBoton('botonContenido','btnAnadirProductos','D');
                   deshabilitarHabilitarBoton('botonContenido','btnEliminarProductos','D');
                   
                  // Limpia
                  set('formulario.txtCodProducto', '');   
                  set('formulario.oidProdArticulos', '');   
                  set('formulario.txtNumUnidades4', '');        
                  set('formulario.txtPrecioPublico4', '');        
                  set('formulario.ckArticuloDespacha4', 'N');          
                  set('formulario.txtDescripcionLote4', '');  
                  
                  set('formulario.ChkIndCenServGar', 'N');          
                  set('formulario.cbCenServGar', '');   
                  set('formulario.txtNumMeses', '');   
                  set('formulario.areaObservaciones', '');     
                  set('formulario.rdTipoEntrega', 'B');  
                  set('formulario.cbCenServEntrega', '');     
                  
                  accion('formulario.txtCodProducto', '.disabled=true'); 
                  accion('formulario.txtNumUnidades4', '.disabled=true'); 
                  accion('formulario.txtPrecioPublico4', '.disabled=true'); 
                  accion('formulario.ckArticuloDespacha4', '.disabled=true'); 
                  accion('formulario.txtDescripcionLote4', '.disabled=true'); 
                  
                  accion('formulario.ChkIndCenServGar', '.disabled=true');
                  accion('formulario.cbCenServGar', '.disabled=true');  
                  accion('formulario.txtNumMeses', '.disabled=true');  
                  accion('formulario.areaObservaciones', '.disabled=true'); 
                  accion('formulario.rdTipoEntrega', '.disabled=true'); 
                  accion('formulario.cbCenServEntrega', '.disabled=true'); 
                  
                  listado2.limpia();
                  
                } else {
                    // Se puede ingresar nuevos registros
                    oid = listado4.generaCodigo(secArt);
                    secArt = oid;
                    
                    numPremio = get('formulario.numeroPremioArticulos');
                    descLote = get('formulario.txtDescripcionLote4');
                    listProdLote = obtenerListaProdLotes();
                    oidLote = ''; 
                   
                    listado4.insertar(new Array(oid, numPremio, descLote, listProdLote, oidLote ));
                                          
                    // Actualiza el mumero Premio
                    numeroPremio = Number(numPremio);
                    txt_to('lbNumPremio4', numeroPremio +1);
                    set('formulario.numeroPremioArticulos', numeroPremio +1);
                    
                    // Limpia
                    set('formulario.txtCodProducto', '');   
                    set('formulario.oidProdArticulos', '');   
                    set('formulario.txtNumUnidades4', '1');        
                    set('formulario.txtPrecioPublico4', '');        
                    set('formulario.ckArticuloDespacha4', 'N');          
                    set('formulario.txtDescripcionLote4', '');  
                    
                    set('formulario.ChkIndCenServGar', 'N');          
                    set('formulario.cbCenServGar', '');   
                    set('formulario.txtNumMeses', '');   
                    set('formulario.areaObservaciones', '');        
                    accion('formulario.cbCenServGar', '.disabled=true');  
                    accion('formulario.txtNumMeses', '.disabled=true');  
                    accion('formulario.areaObservaciones', '.disabled=true');  
                    
                    set('formulario.rdTipoEntrega', 'B');          
                    set('formulario.cbCenServEntrega', '');        
                    accion('formulario.cbCenServEntrega', '.disabled=true');  
                    
                    listado2.limpia();
                    
                    set('formulario.codLotelista', '');   
                    
                    if(get('formulario.hIndPremiosElectivosPremios')== get('formulario.IND_INACTIVO')){
                        // Deshabilita botones
                        deshabilitarHabilitarBoton('botonContenido','btnAnadirLotes','D');
                        deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
                        deshabilitarHabilitarBoton('botonContenido','btnAnadirProductos','D');
                        deshabilitarHabilitarBoton('botonContenido','btnEliminarProductos','D');
                        
                        accion('formulario.txtCodProducto', '.disabled=true'); 
                        accion('formulario.txtNumUnidades4', '.disabled=true'); 
                        accion('formulario.txtPrecioPublico4', '.disabled=true'); 
                        accion('formulario.ckArticuloDespacha4', '.disabled=true'); 
                        accion('formulario.txtDescripcionLote4', '.disabled=true'); 
                        
                        accion('formulario.ChkIndCenServGar', '.disabled=true');
                        accion('formulario.cbCenServGar', '.disabled=true');  
                        accion('formulario.txtNumMeses', '.disabled=true');  
                        accion('formulario.areaObservaciones', '.disabled=true'); 
                        accion('formulario.rdTipoEntrega', '.disabled=true'); 
                        accion('formulario.cbCenServEntrega', '.disabled=true'); 
                    }
                }
           }
      }
  }
  
  function accionEliminarLotes(){  
    var cantElementos = listado4.codSeleccionados();

     if( cantElementos.length == 0 ){
         GestionarMensaje("4", null, null, null);
     }else{
         // Actualiza el mumero Premio
         txt_to('lbNumPremio4', numeroPremio + 1);
         set('formulario.numeroPremioArticulos', numeroPremio + 1); 
         
         // Limpia
                  set('formulario.codLotelista', '');   

         set('formulario.txtCodProducto', '');   
         set('formulario.oidProdArticulos', '');   
         set('formulario.txtNumUnidades4', '1');        
         set('formulario.txtPrecioPublico4', '');        
         set('formulario.ckArticuloDespacha4', 'N');          
         set('formulario.txtDescripcionLote4', '');  
         
         set('formulario.ChkIndCenServGar', 'N');          
         set('formulario.cbCenServGar', '');   
         set('formulario.txtNumMeses', '');   
         set('formulario.areaObservaciones', '');        
         accion('formulario.cbCenServGar', '.disabled=true');  
         accion('formulario.txtNumMeses', '.disabled=true');  
         accion('formulario.areaObservaciones', '.disabled=true');  
         
         set('formulario.rdTipoEntrega', 'B');          
         set('formulario.cbCenServEntrega', '');        
         accion('formulario.cbCenServEntrega', '.disabled=true');  
         
         listado2.limpia();
         
         listado4.eliminarSelecc();
         
         if(get('formulario.hIndPremiosElectivosPremios')== get('formulario.IND_INACTIVO') && 
             listado4.codigos.length > 0){
              // Deshabilita botones
              deshabilitarHabilitarBoton('botonContenido','btnAnadirLotes','D');
              deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
              deshabilitarHabilitarBoton('botonContenido','btnAnadirProductos','D');
              deshabilitarHabilitarBoton('botonContenido','btnEliminarProductos','D');
              
              accion('formulario.txtCodProducto', '.disabled=true'); 
              accion('formulario.txtNumUnidades4', '.disabled=true'); 
              accion('formulario.txtPrecioPublico4', '.disabled=true'); 
              accion('formulario.ckArticuloDespacha4', '.disabled=true'); 
              accion('formulario.txtDescripcionLote4', '.disabled=true'); 
              
              accion('formulario.ChkIndCenServGar', '.disabled=true');
              accion('formulario.cbCenServGar', '.disabled=true');  
              accion('formulario.txtNumMeses', '.disabled=true');  
              accion('formulario.areaObservaciones', '.disabled=true'); 
              accion('formulario.rdTipoEntrega', '.disabled=true'); 
              accion('formulario.cbCenServEntrega', '.disabled=true');  
          }
     }
  }
  
  
  function obtenerListaProdLotes(){   
  
      var codigos = listado2.codigos();
                    var cadena = "";
                    
                    for (var i=0; i<codigos.length ; i++){
                              if( i != 0)
             cadena = cadena + "|";

                              codProducto = listado2.extraeDato(codigos[i], 0);
                              cadena = cadena + codProducto + "&";

                              numUnidades = listado2.extraeDato(codigos[i], 1);
                              cadena = cadena + numUnidades + "&";

                              precioPublico = listado2.extraeDato(codigos[i], 2);
                              cadena = cadena + precioPublico + "&";

                              despachoArt = listado2.extraeDato(codigos[i], 3)==GestionarMensaje("84")?"S":"N";
                              cadena = cadena + despachoArt + "&";

                              codVentaFicticio = listado2.extraeDato(codigos[i], 4)==""?"BLANCO":listado2.extraeDato(codigos[i], 4);
                              cadena = cadena + codVentaFicticio + "&";
          
          indCentSerGar = listado2.extraeDato(codigos[i], 5)==GestionarMensaje("84")?"S":"N";
          cadena = cadena + indCentSerGar + "&";
          
          descCentSerGar = listado2.extraeDato(codigos[i], 6)==""?"BLANCO":listado2.extraeDato(codigos[i], 6);
          cadena = cadena + descCentSerGar + "&";
          
          numMeses = listado2.extraeDato(codigos[i], 7)==""?"BLANCO":listado2.extraeDato(codigos[i], 7);
          cadena = cadena + numMeses + "&";
          
          obs = listado2.extraeDato(codigos[i], 8)==""?"BLANCO":listado2.extraeDato(codigos[i], 8);
          cadena = cadena + obs + "&";
          
          tipoEntrega = listado2.extraeDato(codigos[i], 9);
                              cadena = cadena + tipoEntrega + "&";
          
          descCentSerEntrega = listado2.extraeDato(codigos[i], 10)==""?"BLANCO":listado2.extraeDato(codigos[i], 10);
          cadena = cadena + descCentSerEntrega + "&";
          
          oidCentSerGar = listado2.extraeDato(codigos[i], 11)==""?"BLANCO":listado2.extraeDato(codigos[i], 11);
          cadena = cadena + oidCentSerGar + "&";
          
          oidCentSerEntrega = listado2.extraeDato(codigos[i], 12)==""?"BLANCO":listado2.extraeDato(codigos[i], 12);
          cadena = cadena + oidCentSerEntrega + "&";

                              oidProducto = listado2.extraeDato(codigos[i], 13)==""?"BLANCO":listado2.extraeDato(codigos[i], 13);
                              cadena = cadena + oidProducto + "&";
                             
          oidLoteProd = listado2.extraeDato(codigos[i], 14)==""?"BLANCO":listado2.extraeDato(codigos[i], 14);
                              cadena = cadena + oidLoteProd;
                   }

     cadena = cadena==""?"BLANCO":cadena;
     
     listado2.limpia();
     
                   return cadena;
  }
  
  
  function accionAniadirProductoLote(){  
      if(sicc_validaciones_generales("gArticuloProducto")) {
      
         if((get('formulario.ChkIndCenServGar')=="N" || sicc_validaciones_generales("gCenServGar"))
           && (get('formulario.rdTipoEntrega')=="B" || sicc_validaciones_generales("gCenServEntrega"))) {
      
           oid = listado2.generaCodigo(secArtProd);
           secArtProd = oid;
           
           codProducto = get('formulario.txtCodProducto');
           numUnidades = get('formulario.txtNumUnidades4');
           precioPublico = get('formulario.txtPrecioPublico4','T');
           despachoArt = get('formulario.ckArticuloDespacha4')=="S"?GestionarMensaje("84"):GestionarMensaje("86");
           codVentaFicticio = '';      
           
           indCentSerGar = get('formulario.ChkIndCenServGar')=="S"?GestionarMensaje("84"):GestionarMensaje("86");
           descCentSerGar = get('formulario.cbCenServGar', 'T');
           oidCentSerGar = get('formulario.cbCenServGar');
           numMeses = get('formulario.txtNumMeses');
           obs = get('formulario.areaObservaciones');
           tipoEntrega = get('formulario.rdTipoEntrega');
           descCentSerEntrega = get('formulario.cbCenServEntrega', 'T');
           oidCentSerEntrega = get('formulario.cbCenServEntrega');
           
           oidProducto = get('formulario.oidProdArticulos');
           oidLoteProd = '';
          
           if(!yaIngresadoProductoLote(codProducto)){
                listado2.insertar(new Array(oid, codProducto, numUnidades, precioPublico, despachoArt, codVentaFicticio, 
                                                indCentSerGar, descCentSerGar, numMeses, obs, tipoEntrega, descCentSerEntrega,
                                                oidCentSerGar, oidCentSerEntrega,
                                                oidProducto, oidLoteProd ));
                                     
                // Limpia 
                set('formulario.txtCodProducto', '');        
                set('formulario.oidProdArticulos', '');   
                set('formulario.txtNumUnidades4', '1');        
                set('formulario.txtPrecioPublico4', '');        
                set('formulario.ckArticuloDespacha4', 'N');  
                
                set('formulario.ChkIndCenServGar', 'N');          
                set('formulario.cbCenServGar', '');   
                set('formulario.txtNumMeses', '');   
                set('formulario.areaObservaciones', '');        
                accion('formulario.cbCenServGar', '.disabled=true');  
                accion('formulario.txtNumMeses', '.disabled=true');  
                accion('formulario.areaObservaciones', '.disabled=true');  
    
                set('formulario.rdTipoEntrega', 'B');          
                set('formulario.cbCenServEntrega', '');        
                accion('formulario.cbCenServEntrega', '.disabled=true');  
           }
         }      
      }
  }  
  
  
  function yaIngresadoProductoLote(articuloAIngresar){  
  
      var codigos = listado2.codigos();
                    
                    for (var i=0; i<codigos.length ; i++){
          articuloIngresado = listado2.extraeDato(codigos[i], 0);
          
         //alert("articuloIngresado: " + articuloIngresado)     
         //alert("articuloAIngresar: " + articuloAIngresar);
                                  
         if(articuloIngresado == articuloAIngresar){
             return true;
         }
      }
      return false;
  }
  
  
  function accionEliminarArticulo(){  
    var cantElementos = listado3.codSeleccionados();

     if( cantElementos.length == 0 ){
         GestionarMensaje("4", null, null, null);
     }else{
         listado3.eliminarSelecc();
     }
  }
  
  
  
  function accionBuscarProducto(){  
         // Busca el producto
         var obj = new Object();
         obj.casoDeUso= 'buscarProducto' 
         obj.accion = '';
         obj.oidMarcaCorporativa = get('formulario.hOidMarca');
         var retorno = mostrarModalSICC('LPBuscarProductosDTO', '', obj, null, null);
         
         if(retorno!=null) {         
             // Productos seleccionados
             productosString = retorno[0];      
             productosString = productosString.substring(1,productosString.length);
             
             productos = productosString.split('$');
             //alert("productos: " + productos);
             
             // Verifica que se haya seleccionado un producto
             if(productos.length==1 ){
                  producto = productos[0].split('|');
                  set('formulario.txtCodProducto', producto[1]); 
                  set('formulario.oidProdDescuentos', producto[0]); 
             } else {
                  set('formulario.txtCodProducto', ''); 
                  set('formulario.oidProdArticulos', ''); 
                  GestionarMensaje('1497');
             }
         }
  }
  
  
  function premioMonetarioInicial(nivelPremio){  
  
      if(nivelPremio=="") {
           // Numero de Premio
           txt_to('lbNumPremio2', numeroPremio +1);
           set('formulario.numeroPremioMonetarios', numeroPremio +1); 
      } else {
           // Numero de Premio
           txt_to('lbNumPremio2', nivelPremio[2]);
           set('formulario.numeroPremioMonetarios', nivelPremio[2]); 
      }
             
      set('formulario.oidPremioMonetario', '');  
      
      txt_to('lbNPago', '1');
      set('formulario.numeroPago', '1');  
      
      // Deshabilitar
      set('formulario.cbTipoPremioMonetario2', '');                  
      set('formulario.txtCantidad2', '');          
      set('formulario.txtPorcentaje2', ''); 
      set('formulario.cbMoneda', '');        
      set('formulario.cbFormaPago', '');      
      accion('formulario.txtCantidad2', '.disabled=true'); 
      accion('formulario.txtPorcentaje2', '.disabled=true'); 
      
      set('formulario.ckPagoPartes', 'S');        
      set('formulario.cbCumplimiento', '');   
      set('formulario.ckDescontarPago', 'N');   
      accion('formulario.ckDescontarPago', '.disabled=true'); 
      
      set('formulario.txtPremio', '');        
      set('formulario.cbPeriodoControl', '');
      
      listado1.limpia();
      
      // Verifica si la calificacion es metas bono anual     
      if(get('formulario.hOidTipoDeterminacionMetas')==get('formulario.OID_TIPO_DET_METAS_BONO_ANUAL')){
           visibilidad('capa3','V');
           visibilidad('capaBoton','O');
           mostrarListado1();
      } else {         
           visibilidad('capa3','O');
           visibilidad('capaBoton','V');
           ocultarListado1();
      }

           // INC 21869 - dmorello, 14/12/2005    
           // Se asigna al combo cbMoneda el valor de la moneda local del país
           var oidMonedaDefault = get('formulario.oidMonedaDefault');
           set('formulario.cbMoneda', new Array(oidMonedaDefault));        
                    
      visualizarPremioMonetario();
  }
  
  
  function premioMonetario(nivelPremio) {  
      /*  0-ind
           1-tipoPremiacion
           2-numPremio            
           3-tipoPremMonet
           4-cant
           5-porcenj
           6-oidMoneda
           7-oidFormaPago
           8-oidPremioMonet
           9-pagoPartes
           10-oidCumplimiento
           11-descontarPagos
           12-listaPago
      */
      
      txt_to('lbNumPremio2', nivelPremio[2]);
      set('formulario.numeroPremioMonetarios', nivelPremio[2]);  
      
      // Seleccion de los combos
      iSeleccionado = new Array(); 
      
      iSeleccionado[0] = nivelPremio[3];
      set('formulario.cbTipoPremioMonetario2', iSeleccionado);   
      
      iSeleccionado[0] = nivelPremio[6];
      set('formulario.cbMoneda', iSeleccionado);   
      
      iSeleccionado[0] = nivelPremio[7];
      set('formulario.cbFormaPago', iSeleccionado);   
      
      set('formulario.oidPremioMonetario', nivelPremio[8]=="BLANCO"?"":nivelPremio[8]);  
      
      // Habilitacion
      tipoPremioMonet = nivelPremio[3];
      
      if(tipoPremioMonet == get('formulario.OID_TIPO_PREM_MONET_CANT_FIJA')) { 
      
           set('formulario.txtCantidad2', nivelPremio[4]=="BLANCO"?"":nivelPremio[4]);
           accion('formulario.txtCantidad2', '.disabled=false');     
           set('formulario.txtPorcentaje2', ''); 
           accion('formulario.txtPorcentaje2', '.disabled=true'); 
           
      } else if(tipoPremioMonet == get('formulario.OID_TIPO_PREM_MONET_PORC_PUNTAJE_OBT')) {
      
           set('formulario.txtPorcentaje2', nivelPremio[5]=="BLANCO"?"":nivelPremio[5]); 
           accion('formulario.txtPorcentaje2', '.disabled=false'); 
           set('formulario.txtCantidad2', ''); 
           accion('formulario.txtCantidad2', '.disabled=true');
           
      } else if(tipoPremioMonet == get('formulario.OID_TIPO_PREM_MONET_PUNTAJE_OBT')) {
      
           set('formulario.txtCantidad2', ''); 
           accion('formulario.txtCantidad2', '.disabled=true');
           set('formulario.txtPorcentaje2', ''); 
           accion('formulario.txtPorcentaje2', '.disabled=true'); 
      }
      
      if(get('formulario.hOidTipoDeterminacionMetas')==get('formulario.OID_TIPO_DET_METAS_BONO_ANUAL')){
           
           iSeleccionado[0] = nivelPremio[10]=="BLANCO"?"":nivelPremio[10];
           set('formulario.cbCumplimiento', iSeleccionado);   
           
           set('formulario.ckPagoPartes', nivelPremio[9]); 
           
           tipoCumplimiento = nivelPremio[10]=="BLANCO"?"":nivelPremio[10];
           
           if(tipoCumplimiento == get('formulario.OID_TIPO_CUMPLIMIENTO_TOTAL')) {
                set('formulario.ckDescontarPago', nivelPremio[11]);                      
                accion('formulario.ckDescontarPago', '.disabled=false'); 
           } else {
                set('formulario.ckDescontarPago', 'N');     
                accion('formulario.ckDescontarPago', '.disabled=true'); 
           }  
           
           llenaListaPagos(nivelPremio[12]);
           
           set('formulario.txtPremio', '');        
           set('formulario.cbPeriodoControl', '');
           
           visibilidad('capa3','V');
           visibilidad('capaBoton','O');
           mostrarListado1();
           
      } else {
      
           set('formulario.ckPagoPartes', 'N');        
           set('formulario.cbCumplimiento', '');   
           set('formulario.ckDescontarPago', 'N');   
           accion('formulario.ckDescontarPago', '.disabled=true'); 
           
           set('formulario.txtPremio', '');        
           set('formulario.cbPeriodoControl', '');
           
           listado1.limpia();
           
           visibilidad('capa3','O');
           visibilidad('capaBoton','V');
           ocultarListado1();
          
      }
      
      if(get('formulario.opcionMenu')=="Consultar Concurso Ranking"){  
           deshabilitarPremioMonetario();
      }
      
      visualizarPremioMonetario();
  }  
  
  function deshabilitarPremioMonetario(){
  
      accion('formulario.cbTipoPremioMonetario2', '.disabled=true'); 
      accion('formulario.txtCantidad2', '.disabled=true'); 
      accion('formulario.txtPorcentaje2', '.disabled=true'); 
      accion('formulario.cbMoneda', '.disabled=true'); 
      accion('formulario.cbFormaPago', '.disabled=true'); 
      
      accion('formulario.ckPagoPartes', '.disabled=true'); 
      accion('formulario.cbCumplimiento', '.disabled=true'); 
      accion('formulario.ckDescontarPago', '.disabled=true'); 
      
      accion('formulario.txtPremio', '.disabled=true'); 
      accion('formulario.cbPeriodoControl', '.disabled=true'); 
      
      deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');
      deshabilitarHabilitarBoton('botonContenido','btnEliminar2','D');
  }
  
  
  function llenaListaPagos(pagos){
  
      if(pagos!="BLANCO"){      
           // Hay pagos ingresados
           pago = pagos.split('|');
           numPago = 0;
           
           for(var i=0; i<pago.length; i++) {
                //alert(pago[i]);
                pagoDatos = pago[i].split('&');
                numPago = numPago + 1;
                
                oid = listado1.generaCodigo(secMonet);
                secMonet = oid;
      
                numeroPago = pagoDatos[0];
                premioPorcj = pagoDatos[1];
                periodeControlDesc = pagoDatos[2];
                oidPeriodoControl = pagoDatos[3];                
                oidPago = pagoDatos[4];
              
                listado1.insertar(new Array(oid, numeroPago, premioPorcj, periodeControlDesc, oidPeriodoControl, oidPago ));                                                      
           }
           
           txt_to('lbNPago', numPago + 1);
           set('formulario.numeroPago', numPago + 1);  
      
      } else {
           txt_to('lbNPago', '1');
           set('formulario.numeroPago', '1');  
      }
  }
  

  function accionAniadirPagoMonetario(){  
      if(sicc_validaciones_generales("gMonetarioPago")) {
           oid = listado1.generaCodigo(secMonet);
           secMonet = oid;
           
           numeroPago = get('formulario.numeroPago');
           premioPorcj = get('formulario.txtPremio');
           periodeControlDesc = get('formulario.cbPeriodoControl','T');
           oidPeriodoControl = get('formulario.cbPeriodoControl');
           oidPago = '';           
          
           listado1.insertar(new Array(oid, numeroPago, premioPorcj, periodeControlDesc, oidPeriodoControl, oidPago ));
                                 
           // Limpia         
           txt_to('lbNPago', Number(numeroPago) + 1);
           set('formulario.numeroPago', Number(numeroPago) + 1);  
           set('formulario.txtPremio', '');     
           set('formulario.cbPeriodoControl', ''); 
      }      
  }
  
  
  function onChangeTipoPremiosMonetarios() {  
      tipoPremioPuntos = get('formulario.cbTipoPremioMonetario2');
      
      if(tipoPremioPuntos == get('formulario.OID_TIPO_PREM_MONET_CANT_FIJA')) {
           accion('formulario.txtCantidad2', '.disabled=false');
           set('formulario.txtPorcentaje2', '');                      
           accion('formulario.txtPorcentaje2', '.disabled=true'); 
      } else if(tipoPremioPuntos == get('formulario.OID_TIPO_PREM_MONET_PORC_PUNTAJE_OBT')) {
           accion('formulario.txtPorcentaje2', '.disabled=false'); 
           set('formulario.txtCantidad2', '');     
           accion('formulario.txtCantidad2', '.disabled=true'); 
      } else if(tipoPremioPuntos == get('formulario.OID_TIPO_PREM_MONET_PUNTAJE_OBT')) {
           set('formulario.txtCantidad2', '');          
           set('formulario.txtPorcentaje2', '');          
           accion('formulario.txtCantidad2', '.disabled=true'); 
           accion('formulario.txtPorcentaje2', '.disabled=true'); 
      }
  }
  
  
  function onChangeCumplimiento() {  
      tipoCumplimiento = get('formulario.cbCumplimiento');
      
      if(tipoCumplimiento == get('formulario.OID_TIPO_CUMPLIMIENTO_TOTAL')) {
           set('formulario.ckDescontarPago', 'N');                      
           accion('formulario.ckDescontarPago', '.disabled=false'); 
      } else {
           set('formulario.ckDescontarPago', 'N');     
           accion('formulario.ckDescontarPago', '.disabled=true'); 
      }
  }
  
  
  function accionEliminarPago() {  
  
    var cantElementos = listado1.codSeleccionados();

     if( cantElementos.length == 0 ){
          GestionarMensaje("4", null, null, null);
     }else{
          listado1.eliminarSelecc();
          
          // Re-calcula el numero de pagos
          var codigos = listado1.codigos();
          var contador = Number(0);
                    
          for (var i=0; i<codigos.length ; i++){        
             contador = contador + 1;
             set('formulario.numeroPago', contador);
             listado1.insertaDato(codigos[i],'0',get('formulario.numeroPago'));
          }
          
          // Actualiza el numero de pago siguiente
          txt_to('lbNPago', contador + 1);
          set('formulario.numeroPago', contador + 1);  
     }
  }
   
  
  
  function premioDescuentoInicial(nivelPremio){  
  
      if(nivelPremio=="") {
           // Numero de Premio
           txt_to('lbNumPremio5', numeroPremio +1);
           set('formulario.numeroPremioDescuento', numeroPremio +1); 
      } else {
           // Numero de Premio
           txt_to('lbNumPremio5', nivelPremio[2]);
           set('formulario.numeroPremioDescuento', nivelPremio[2]); 
      }
      
      
      set('formulario.oidPremioDescuento', '');  
      
      // Deshabilitar
      set('formulario.cbTipoPremioDescuento5', '');          
      set('formulario.cbPeriodoAplicacionDesde', '');        
      set('formulario.cbPeriodoAplicacionHasta', '');        
      set('formulario.txtCantidadDescuento', '');          
      set('formulario.txtPorcentaje5', '');                
      accion('formulario.txtCantidadDescuento', '.disabled=true'); 
      accion('formulario.txtPorcentaje5', '.disabled=true'); 
      
      listado3.limpia();
      
      visualizarPremioDescuento(get('formulario.cbTipoPremioDescuento5'));
  }
  
  
  function premioDescuento(nivelPremio) {  
      /*  0-ind
           1-tipoPremiacion
           2-numPremio            
           3-tipoPremDesc
           4-cant
           5-porcenj
           6-periodoDesde
           7-periodoHasta
           8-oidPremioDesc
           9-listaArticulos
      */
      
      txt_to('lbNumPremio5', nivelPremio[2]);
      set('formulario.numeroPremioDescuento', nivelPremio[2]);  
      
      // Seleccion de los combos
      iSeleccionado = new Array(); 
      
      iSeleccionado[0] = nivelPremio[3];
      set('formulario.cbTipoPremioDescuento5', iSeleccionado);   
      
      iSeleccionado[0] = nivelPremio[6];
      set('formulario.cbPeriodoAplicacionDesde', iSeleccionado);   
      
      iSeleccionado[0] = nivelPremio[7]=="BLANCO"?"":nivelPremio[7];
      set('formulario.cbPeriodoAplicacionHasta', iSeleccionado);   
      
      set('formulario.oidPremioDescuento', nivelPremio[8]=="BLANCO"?"":nivelPremio[8]);  
      
      // Habilitacion
      tipoPremioDesc = nivelPremio[3];
      
      if(tipoPremioDesc == get('formulario.OID_TIPO_DESCUENTO_IMPORTE')) { 
      
           set('formulario.txtCantidadDescuento', nivelPremio[4]=="BLANCO"?"":nivelPremio[4]);
           accion('formulario.txtCantidadDescuento', '.disabled=false');     
           set('formulario.txtPorcentaje5', ''); 
           accion('formulario.txtPorcentaje5', '.disabled=true'); 
           
           listado3.limpia();
           
      } else if(tipoPremioDesc == get('formulario.OID_TIPO_DESCUENTO_PORCENTAJE')) {
      
           set('formulario.txtPorcentaje5', nivelPremio[5]=="BLANCO"?"":nivelPremio[5]); 
           accion('formulario.txtPorcentaje5', '.disabled=false'); 
           set('formulario.txtCantidadDescuento', ''); 
           accion('formulario.txtCantidadDescuento', '.disabled=true');
           
           llenaListaArticulos(nivelPremio[9]);
           
      } else {
           set('formulario.txtCantidadDescuento', ''); 
           accion('formulario.txtCantidadDescuento', '.disabled=true');
           set('formulario.txtPorcentaje5', ''); 
           accion('formulario.txtPorcentaje5', '.disabled=true'); 
           
           listado3.limpia();
      }
      
      visualizarPremioDescuento(tipoPremioDesc);
      
      if(get('formulario.opcionMenu')=="Consultar Concurso Ranking"){  
           deshabilitarPremioDescuento();
      }
  }
  
  function deshabilitarPremioDescuento(){
  
      accion('formulario.cbTipoPremioDescuento5', '.disabled=true'); 
      accion('formulario.txtCantidadDescuento', '.disabled=true');           
      accion('formulario.txtPorcentaje5', '.disabled=true'); 
      accion('formulario.cbPeriodoAplicacionDesde', '.disabled=true');
      accion('formulario.cbPeriodoAplicacionHasta', '.disabled=true'); 
  
      accion('formulario.cbMarca', '.disabled=true'); 
      accion('formulario.cbUnidadNegocio', '.disabled=true'); 
      accion('formulario.cbNegocio', '.disabled=true'); 
      accion('formulario.cbSupergenerico', '.disabled=true'); 
      accion('formulario.cbGenerico', '.disabled=true'); 
      accion('formulario.txtCodProducto5', '.disabled=true'); 
      
      // Deshabilita botones
      deshabilitarHabilitarBoton('botonContenido','btnAnadir5','D');
      deshabilitarHabilitarBoton('botonContenido','btnBuscar5','D');
      deshabilitarHabilitarBoton('botonContenido','btnEliminar','D');
  }
  
  function llenaListaArticulos(articulos){
  
      if(articulos!="BLANCO"){      
           // Hay articulos ingresados
           articulo = articulos.split('|');
           
           for(var i=0; i<articulo.length; i++) {
                //alert(articulo[i]);
                articuloDatos = articulo[i].split('&');
                
                oid = listado3.generaCodigo(secDesc);
                secDesc = oid;
      
                marcaDesc = articuloDatos[0];
                uniNegDesc = articuloDatos[1]=="BLANCO"?"":articuloDatos[1];
                negDesc = articuloDatos[2]=="BLANCO"?"":articuloDatos[2];
                superGenerDesc = articuloDatos[3]=="BLANCO"?"":articuloDatos[3];
                generDesc = articuloDatos[4]=="BLANCO"?"":articuloDatos[4];
                codProd = articuloDatos[5]=="BLANCO"?"":articuloDatos[5];
                oidMarca = articuloDatos[6]=="BLANCO"?"":articuloDatos[6];
                oidUniNeg = articuloDatos[7]=="BLANCO"?"":articuloDatos[7];
                oidNeg = articuloDatos[8]=="BLANCO"?"":articuloDatos[8];
                oidSuperGener = articuloDatos[9]=="BLANCO"?"":articuloDatos[9];
                oidGener = articuloDatos[10]=="BLANCO"?"":articuloDatos[10];
                oidProd = articuloDatos[11]=="BLANCO"?"":articuloDatos[11];
                oidArticulo = articuloDatos[12]=="BLANCO"?"":articuloDatos[12];
                
                listado3.insertar(new Array(oid, marcaDesc, uniNegDesc, negDesc, superGenerDesc, generDesc, codProd,
                                                     oidMarca, oidUniNeg, oidNeg, oidSuperGener, oidGener, oidProd, oidArticulo));
                                                      
           }
      }
  
  }
  
  
  function onChangeTipoPremioDescuento () {  
  
      tipoPremioDescuento = get('formulario.cbTipoPremioDescuento5');
      
      set('formulario.cbMarca', '');     
      set('formulario.cbUnidadNegocio', '');     
      set('formulario.cbNegocio', '');     
      set('formulario.cbSupergenerico', '');     
      set('formulario.cbGenerico', '');     
      set('formulario.txtCodProducto5', '');     
      set('formulario.oidProdDescuentos', ''); 
  
      if(tipoPremioDescuento==get('formulario.OID_TIPO_DESCUENTO_IMPORTE')){
                
           accion('formulario.txtCantidadDescuento', '.disabled=false');     
           set('formulario.txtPorcentaje5', ''); 
           accion('formulario.txtPorcentaje5', '.disabled=true'); 
      
           accion('formulario.cbMarca', '.disabled=true'); 
           accion('formulario.cbUnidadNegocio', '.disabled=true'); 
           accion('formulario.cbNegocio', '.disabled=true'); 
           accion('formulario.cbSupergenerico', '.disabled=true'); 
           accion('formulario.cbGenerico', '.disabled=true'); 
           accion('formulario.txtCodProducto5', '.disabled=true'); 
           
           listado3.limpia();
           ocultarListado3();
           
           // Deshabilita botones
           deshabilitarHabilitarBoton('botonContenido','btnAnadir5','D');
           deshabilitarHabilitarBoton('botonContenido','btnBuscar5','D');
           
      } else if(tipoPremioDescuento==get('formulario.OID_TIPO_DESCUENTO_PORCENTAJE')){
      
           accion('formulario.txtPorcentaje5', '.disabled=false'); 
           set('formulario.txtCantidadDescuento', ''); 
           accion('formulario.txtCantidadDescuento', '.disabled=true');
      
           accion('formulario.cbMarca', '.disabled=false'); 
           accion('formulario.cbUnidadNegocio', '.disabled=false'); 
           accion('formulario.cbNegocio', '.disabled=false'); 
           accion('formulario.cbSupergenerico', '.disabled=false'); 
           accion('formulario.cbGenerico', '.disabled=false'); 
           accion('formulario.txtCodProducto5', '.disabled=false'); 
           
           listado3.limpia();
           mostrarListado3();
           
           // Deshabilita botones
           deshabilitarHabilitarBoton('botonContenido','btnAnadir5','A');
           deshabilitarHabilitarBoton('botonContenido','btnBuscar5','A');
           
      } else {
      
           set('formulario.txtCantidadDescuento', ''); 
           set('formulario.txtPorcentaje5', ''); 
           accion('formulario.txtCantidadDescuento', '.disabled=true');     
           accion('formulario.txtPorcentaje5', '.disabled=true'); 
      
           accion('formulario.cbMarca', '.disabled=true'); 
           accion('formulario.cbUnidadNegocio', '.disabled=true'); 
           accion('formulario.cbNegocio', '.disabled=true'); 
           accion('formulario.cbSupergenerico', '.disabled=true'); 
           accion('formulario.cbGenerico', '.disabled=true'); 
           accion('formulario.txtCodProducto5', '.disabled=true'); 
           
           listado3.limpia();
           ocultarListado3();
           
           // Deshabilita botones
           deshabilitarHabilitarBoton('botonContenido','btnAnadir5','D');
           deshabilitarHabilitarBoton('botonContenido','btnBuscar5','D');
      }
  }
  

  function accionAniadirProducto(){ 
      if(sicc_validaciones_generales("gDescuentoProducto")) {
           oid = listado3.generaCodigo(secDesc);
           secDesc = oid;
           
           marcaDesc = get('formulario.cbMarca','T');
           uniNegDesc = get('formulario.cbUnidadNegocio','T');
           negDesc = get('formulario.cbNegocio','T');
           superGenerDesc = get('formulario.cbSupergenerico','T');
           generDesc = get('formulario.cbGenerico','T');
           codProd = get('formulario.txtCodProducto5');
           oidMarca = get('formulario.cbMarca');
           oidUniNeg = get('formulario.cbUnidadNegocio');
           oidNeg = get('formulario.cbNegocio');
           oidSuperGener = get('formulario.cbSupergenerico');
           oidGener = get('formulario.cbGenerico');
           oidProd = get('formulario.oidProdDescuentos');
           oidArticulo = '';
           
           articuloAIngresar= oidMarca + "&" + oidUniNeg + "&" + oidNeg + "&" + oidSuperGener + "&" + oidGener + "&" + codProd;
              
           if(!yaIngresadoProdDescuento(articuloAIngresar)){
                listado3.insertar(new Array(oid, marcaDesc, uniNegDesc, negDesc, superGenerDesc, generDesc, codProd,
                                                 oidMarca, oidUniNeg, oidNeg, oidSuperGener, oidGener, oidProd, oidArticulo));
                                     
                // Limpia los combos                                 
                set('formulario.cbMarca', '');     
                set('formulario.cbUnidadNegocio', '');     
                set('formulario.cbNegocio', '');     
                set('formulario.cbSupergenerico', '');     
                set('formulario.cbGenerico', '');     
                set('formulario.txtCodProducto5', '');     
                set('formulario.oidProdDescuentos', ''); 
           }
      }
  }
  
    
  function yaIngresadoProdDescuento(articuloAIngresar){  
  
      var codigos = listado3.codigos();
                    
                    for (var i=0; i<codigos.length ; i++){
          articuloIngresado = listado3.extraeDato(codigos[i], 6) + "&" + listado3.extraeDato(codigos[i], 7) + "&" +
                                 listado3.extraeDato(codigos[i], 8) + "&" + listado3.extraeDato(codigos[i], 9) + "&" +
                                 listado3.extraeDato(codigos[i], 10) + "&" + listado3.extraeDato(codigos[i], 5);
         //alert("articuloIngresado: " + articuloIngresado)     
         //alert("articuloAIngresar: " + articuloAIngresar);
                                  
         if(articuloIngresado == articuloAIngresar){
             return true;
         }
      }
      return false;
  }
  
  
  function accionEliminarProductos() {
     var cantElementos = listado2.codSeleccionados();

     if( cantElementos.length == 0 ){
                GestionarMensaje("4", null, null, null);
     }else{
                listado2.eliminarSelecc();
     }
  }
  
  
  function accionBuscarProductoDescuento(){  
         // Busca el producto
         var obj = new Object();
         obj.casoDeUso= 'buscarProducto' 
         obj.accion = '';
         obj.oidMarcaCorporativa = get('formulario.hOidMarca');
         var retorno = mostrarModalSICC('LPBuscarProductosDTO', '', obj, null, null);
              
         if(retorno!=null) {         
             // Productos seleccionados
             productosString = retorno[0];      
             productosString = productosString.substring(1,productosString.length);
             
             productos = productosString.split('$');
             //alert("productos: " + productos);
             
             // Verifica que se haya seleccionado un producto
             if(productos.length==1 ){
                  producto = productos[0].split('|');
                  set('formulario.txtCodProducto5', producto[1]); 
                  set('formulario.oidProdDescuentos', producto[0]); 
             } else {
                  set('formulario.txtCodProducto5', ''); 
                  set('formulario.oidProdDescuentos', ''); 
                  GestionarMensaje('1497');
             }
         }
  }
  
  function premioPuntosInicial(nivelPremio) {  
      if(nivelPremio=="") {
           // Numero de Premio
           txt_to('lbNumPremio1', numeroPremio +1);
           set('formulario.numeroPremioPuntos', numeroPremio +1); 
      } else {
           // Numero de Premio
           txt_to('lbNumPremio1', nivelPremio[2]);
           set('formulario.numeroPremioPuntos', nivelPremio[2]); 
      }
      
      set('formulario.oidPremioPuntos', '');  
      
      // Deshabilitar
      set('formulario.cbConcursoDestino', '');          
      set('formulario.cbTipoPremioPuntos1', '');          
      set('formulario.txtCantidad1', '');          
      set('formulario.txtPorcentaje1', '');          
      accion('formulario.txtCantidad1', '.disabled=true'); 
      accion('formulario.txtPorcentaje1', '.disabled=true'); 
  
      visualizarPremioPuntos();
  }
  
  function premioPuntos(nivelPremio) {  
      /*  0-ind
           1-tipoPremiacion
           2-numPremio 
           3-concDest
           4-tipoPremPuntos
           5-cant
           6-porcenj
           7-oidPremioPuntos
      */
      txt_to('lbNumPremio1', nivelPremio[2]);
      set('formulario.numeroPremioPuntos', nivelPremio[2]);  
      
      // Seleccion de los combos
      iSeleccionado = new Array(); 
      
      iSeleccionado[0] = nivelPremio[3];
      set('formulario.cbConcursoDestino', iSeleccionado);   
      
      iSeleccionado[0] = nivelPremio[4];
      set('formulario.cbTipoPremioPuntos1', iSeleccionado);   
      
      set('formulario.oidPremioPuntos', nivelPremio[7]=="BLANCO"?"":nivelPremio[7]);   
      
      // Habilitacion
      tipoPremioPuntos = nivelPremio[4];
      
      if(tipoPremioPuntos == get('formulario.OID_TIPO_PREM_PTOS_CANT_FIJA')) {
           set('formulario.txtCantidad1', nivelPremio[5]=="BLANCO"?"":nivelPremio[5]);   
           accion('formulario.txtCantidad1', '.disabled=false');
           set('formulario.txtPorcentaje1', '');                      
           accion('formulario.txtPorcentaje1', '.disabled=true'); 
      } else if(tipoPremioPuntos == get('formulario.OID_TIPO_PREM_PTOS_PORC_PUNTAJE_OBT')) {
           set('formulario.txtPorcentaje1', nivelPremio[6]=="BLANCO"?"":nivelPremio[6]);          
           accion('formulario.txtPorcentaje1', '.disabled=false'); 
           set('formulario.txtCantidad1', '');     
           accion('formulario.txtCantidad1', '.disabled=true'); 
      } else if(tipoPremioPuntos == get('formulario.OID_TIPO_PREM_PTOS_PUNTAJE_OBT')) {
           set('formulario.txtCantidad1', '');          
           set('formulario.txtPorcentaje1', '');          
           accion('formulario.txtCantidad1', '.disabled=true'); 
           accion('formulario.txtPorcentaje1', '.disabled=true'); 
      }
      
      
      if(get('formulario.opcionMenu')=="Consultar Concurso Ranking"){  
           deshabilitarPremioPuntos();
      }
      
      visualizarPremioPuntos();
  }
  
  
  function deshabilitarPremioPuntos(){
  
      accion('formulario.cbConcursoDestino', '.disabled=true'); 
      accion('formulario.cbTipoPremioPuntos1', '.disabled=true'); 
      accion('formulario.txtCantidad1', '.disabled=true'); 
      accion('formulario.txtPorcentaje1', '.disabled=true'); 
  }
  
  
  function onChangeTipoPremiosPuntos () {  
      tipoPremioPuntos = get('formulario.cbTipoPremioPuntos1');
      
      if(tipoPremioPuntos == get('formulario.OID_TIPO_PREM_PTOS_CANT_FIJA')) {
           accion('formulario.txtCantidad1', '.disabled=false');
           set('formulario.txtPorcentaje1', '');                      
           accion('formulario.txtPorcentaje1', '.disabled=true'); 
      } else if(tipoPremioPuntos == get('formulario.OID_TIPO_PREM_PTOS_PORC_PUNTAJE_OBT')) {
           accion('formulario.txtPorcentaje1', '.disabled=false'); 
           set('formulario.txtCantidad1', '');     
           accion('formulario.txtCantidad1', '.disabled=true'); 
      } else if(tipoPremioPuntos == get('formulario.OID_TIPO_PREM_PTOS_PUNTAJE_OBT')) {
           set('formulario.txtCantidad1', '');          
           set('formulario.txtPorcentaje1', '');          
           accion('formulario.txtCantidad1', '.disabled=true'); 
           accion('formulario.txtPorcentaje1', '.disabled=true'); 
      }
  }
  
  
  function accionAceptar(tipoPremio) {  
  
      if(get('formulario.opcionMenu')!="Consultar Concurso Ranking"){  
           // Almacena segun el tipo de premio
           if(tipoPremio == get('formulario.OID_TIPO_PREMIO_PUNTOS')) {
           
                if(sicc_validaciones_generales("gPuntos")) {
                
                    // Valida cantidad y porcentaje
                    tipoPremPuntos= get('formulario.cbTipoPremioPuntos1');  
                    
                    if(tipoPremPuntos == get('formulario.OID_TIPO_PREM_PTOS_CANT_FIJA')) {
                         if (!sicc_validaciones_generales('gPuntosCantidad')){
                           return;
                         }                            
                    } else if(tipoPremPuntos == get('formulario.OID_TIPO_PREM_PTOS_PORC_PUNTAJE_OBT')) {
                         if (!sicc_validaciones_generales('gPuntosPorcentaje')){
                           return;
                         }
                    }
                
                    numPremio = get('formulario.numeroPremioPuntos');  
                    // Actualiza el numero de premio si no es una modificación
                    if(numeroPremio < numPremio) {
                         numeroPremio = numeroPremio + 1;
                    }
                    
                    concDest= get('formulario.cbConcursoDestino');  
                    cant= get('formulario.txtCantidad1')==""?"BLANCO":get('formulario.txtCantidad1');  
                    porcenj= get('formulario.txtPorcentaje1')==""?"BLANCO":get('formulario.txtPorcentaje1');  
                    oidPremioPunto = get('formulario.oidPremioPuntos')==""?"BLANCO":get('formulario.oidPremioPuntos');  
                    
                    ind = get('formulario.nivelAIngresar');
                    datosNiveles[ind] = ind + "#" + tipoPremio + "#" + numPremio + "#" + concDest + "#" + tipoPremPuntos + "#" + cant + "#" + porcenj + "#" + oidPremioPunto;
                    
                    //alert(datosNiveles);
                    
                    // Visualiza la lista principal
                    mostrarListadoNiveles();
                    
                    // Habilita Aceptar
                    deshabilitarHabilitarBoton('botonContenido','btnAceptar','A');
                    
                    // Deselecciona
                    listado.deselecciona (DrIndiceEnArray(listado.datos, ind, 0));
                    
                    // Focaliza la lista de niveles                
                    focalizaDatosNiveles();
                    
                }
           } else if(tipoPremio == get('formulario.OID_TIPO_PREMIO_DESCUENTO')) {
           
                if(sicc_validaciones_generales("gDescuento")) {
                
                    // Valida cantidad y porcentaje
                    tipoPremDesc= get('formulario.cbTipoPremioDescuento5');  
                    
                    if(tipoPremDesc == get('formulario.OID_TIPO_DESCUENTO_IMPORTE')) {
                         if (!sicc_validaciones_generales('gDescuentoCantidad')){
                           return;
                         }                            
                    } else if(tipoPremDesc == get('formulario.OID_TIPO_DESCUENTO_PORCENTAJE')) {
                         if (!sicc_validaciones_generales('gDescuentoPorcentaje')){
                           return;
                         }
                    }
                
                    numPremio = get('formulario.numeroPremioDescuento'); 
                    // Actualiza el numero de premio si no es una modificación
                    if(numeroPremio < numPremio) {
                         numeroPremio = numeroPremio + 1;
                    }
                    
                    cant = get('formulario.txtCantidadDescuento')==""?"BLANCO":get('formulario.txtCantidadDescuento');  
                    porcenj = get('formulario.txtPorcentaje5')==""?"BLANCO":get('formulario.txtPorcentaje5'); 
                    periodoDesde = get('formulario.cbPeriodoAplicacionDesde');  
                    periodoHasta = get('formulario.cbPeriodoAplicacionHasta')==""?"BLANCO":get('formulario.cbPeriodoAplicacionHasta'); 
                    oidPremioDesc = get('formulario.oidPremioDescuento')==""?"BLANCO":get('formulario.oidPremioDescuento');  
                              
                    ind = get('formulario.nivelAIngresar');
                    datosNiveles[ind] = ind + "#" + tipoPremio + "#" + numPremio + "#" + tipoPremDesc + "#" + 
                                           cant + "#" + porcenj + "#" + periodoDesde + "#" + periodoHasta + "#" + oidPremioDesc + "#" +
                                           obtenerListaArticulosDesc(); 
                                           
                    //alert(datosNiveles);
                    
                    // Visualiza la lista principal
                    mostrarListadoNiveles();
                    
                    // Habilita Aceptar
                    deshabilitarHabilitarBoton('botonContenido','btnAceptar','A');
                    
                    // Deselecciona
                    listado.deselecciona (DrIndiceEnArray(listado.datos, ind, 0));
                                    
                    // Focaliza la lista de niveles
                    focalizaDatosNiveles();
                }
           } else if(tipoPremio == get('formulario.OID_TIPO_PREMIO_MONETARIO')) {
           
                if(sicc_validaciones_generales("gMonetario")) {
                
                    tipoPremMonet= get('formulario.cbTipoPremioMonetario2');  
                    
                    if(tipoPremMonet == get('formulario.OID_TIPO_PREM_MONET_CANT_FIJA')) {
                         if (!sicc_validaciones_generales('gMonetarioCantidad')){
                           return;
                         }                            
                     } else if(tipoPremMonet == get('formulario.OID_TIPO_PREM_MONET_PORC_PUNTAJE_OBT')) {
                         if (!sicc_validaciones_generales('gMonetarioPorcentaje')){
                           return;
                         }
                     }
                
                    numPremio = get('formulario.numeroPremioMonetarios');  
                    // Actualiza el numero de premio si no es una modificación
                    if(numeroPremio < numPremio) {
                         numeroPremio = numeroPremio + 1;
                    }
                    
                    cant = get('formulario.txtCantidad2')==""?"BLANCO":get('formulario.txtCantidad2');  
                    porcenj = get('formulario.txtPorcentaje2')==""?"BLANCO":get('formulario.txtPorcentaje2'); 
                    oidMoneda = get('formulario.cbMoneda');  
                    oidFormaPago = get('formulario.cbFormaPago');  
                    oidPremioMonet = get('formulario.oidPremioMonetario')==""?"BLANCO":get('formulario.oidPremioMonetario'); 
                    
                    if(get('formulario.hOidTipoDeterminacionMetas')==get('formulario.OID_TIPO_DET_METAS_BONO_ANUAL')){
                    
                         if(sicc_validaciones_generales("gMonetarioCumplimiento")){
                         
                             pagoPartes = get('formulario.ckPagoPartes');
                             oidCumplimiento = get('formulario.cbCumplimiento')==""?"BLANCO":get('formulario.cbCumplimiento'); 
                             descontarPagos = get('formulario.ckDescontarPago');
                             listaPago = obtenerListaPagosMonet();
                             
                         } else {
                             return;
                         }
                         
                    } else {
                         pagoPartes = "N";
                         oidCumplimiento = "BLANCO";
                         descontarPagos = "N";
                         listaPago = "BLANCO";
                    }
                
                    ind = get('formulario.nivelAIngresar');
                    datosNiveles[ind] = ind + "#" + tipoPremio + "#" + numPremio + "#" + tipoPremMonet + "#" + 
                                           cant + "#" + porcenj + "#" + oidMoneda + "#" + oidFormaPago + "#" + oidPremioMonet + "#" +
                                           pagoPartes + "#" + oidCumplimiento + "#" + descontarPagos + "#" + listaPago;
                    
                    
                    //alert(datosNiveles);
                    
                    // Visualiza la lista principal
                    mostrarListadoNiveles();
                    
                    // Habilita Aceptar
                    deshabilitarHabilitarBoton('botonContenido','btnAceptar','A')     
                    
                    // Deselecciona
                    listado.deselecciona (DrIndiceEnArray(listado.datos, ind, 0));
                                    
                    // Focaliza la lista de niveles
                    focalizaDatosNiveles();
                }
           } else if(tipoPremio == get('formulario.OID_TIPO_PREMIO_ARTICULO')) {
                          
                
                             ind = get('formulario.nivelAIngresar');
                             numUnidades = get('formulario.txtNumUnidadesPremiosArticulo');
                             oidPremioArticulo = get('formulario.oidPremioArticulo')==""?"BLANCO":get('formulario.oidPremioArticulo'); 
                             
                             datosNiveles[ind] = ind + "#" + tipoPremio + "#" + numUnidades + "#" + oidPremioArticulo + "#" + listaLotes();
                             
                             //alert(datosNiveles);
                             
                             // Visualiza la lista principal
                             mostrarListadoNiveles();
                             
                             // Habilita Aceptar
                             deshabilitarHabilitarBoton('botonContenido','btnAceptar','A')    
                             
                             // Deselecciona
                             listado.deselecciona (DrIndiceEnArray(listado.datos, ind, 0));
                             
                             // Focaliza la lista de niveles
                             focalizaDatosNiveles();
           
           }
      } else {
      
           // Visualiza la lista principal
           mostrarListadoNiveles();
           
           // Habilita Aceptar
           deshabilitarHabilitarBoton('botonContenido','btnAceptar','A');    
           
           // Deselecciona
           listado.deselecciona (DrIndiceEnArray(listado.datos, get('formulario.nivelAIngresar'), 0));
      }
  }
  
  function listaLotes(){  
  
      var codigos = listado4.codigos();
                    var cadena = "";
      
                    for (var i=0; i<codigos.length ; i++){
                              if( i != 0)
                                             cadena = cadena + "$";

                              numPremio = listado4.extraeDato(codigos[i], 0);
                              cadena = cadena + numPremio + ";";

                              descLote = listado4.extraeDato(codigos[i], 1);
                              cadena = cadena + descLote + ";";

                              loteArticulo = listado4.extraeDato(codigos[i], 2)==""?"BLANCO":listado4.extraeDato(codigos[i], 2);
                              cadena = cadena + loteArticulo + ";";

                              oidLote = listado4.extraeDato(codigos[i], 3)==""?"BLANCO":listado4.extraeDato(codigos[i], 3);
                              cadena = cadena + oidLote;
                   }

     cadena = cadena==""?"BLANCO":cadena;
     
     listado4.limpia();
     
                   return cadena;

  }
  
  
  function obtenerListaPagosMonet(){  
  
      var codigos = listado1.codigos();
                    var cadena = "";
                    
                    for (var i=0; i<codigos.length ; i++){
                              if( i != 0)
                                             cadena = cadena + "|";

                              numPago = listado1.extraeDato(codigos[i], 0)==""?"BLANCO":listado1.extraeDato(codigos[i], 0);
                              cadena = cadena + numPago + "&";

                              premioPorcj = listado1.extraeDato(codigos[i], 1)==""?"BLANCO":listado1.extraeDato(codigos[i], 1);
                              cadena = cadena + premioPorcj + "&";

                              periodoControlDesc = listado1.extraeDato(codigos[i], 2)==""?"BLANCO":listado1.extraeDato(codigos[i], 2);
                              cadena = cadena + periodoControlDesc + "&";

                              oidPeriodoControl = listado1.extraeDato(codigos[i], 3)==""?"BLANCO":listado1.extraeDato(codigos[i], 3);
                              cadena = cadena + oidPeriodoControl + "&";

                              oidPago = listado1.extraeDato(codigos[i], 4)==""?"BLANCO":listado1.extraeDato(codigos[i], 4);
                              cadena = cadena + oidPago;
                   }

     cadena = cadena==""?"BLANCO":cadena;
     
     listado1.limpia();
     
                   return cadena;

  }

  
  function obtenerListaArticulosDesc(){  
  
      var codigos = listado3.codigos();
                    var cadena = "";
                    
                    for (var i=0; i<codigos.length ; i++){
                              if( i != 0)
                                             cadena = cadena + "|";

                              marcaDesc = listado3.extraeDato(codigos[i], 0)==""?"BLANCO":listado3.extraeDato(codigos[i], 0);
                              cadena = cadena + marcaDesc + "&";

                              uniNegDesc = listado3.extraeDato(codigos[i], 1)==""?"BLANCO":listado3.extraeDato(codigos[i], 1);
                              cadena = cadena + uniNegDesc + "&";

                              negDesc = listado3.extraeDato(codigos[i], 2)==""?"BLANCO":listado3.extraeDato(codigos[i], 2);
                              cadena = cadena + negDesc + "&";

                              superGenerDesc = listado3.extraeDato(codigos[i], 3)==""?"BLANCO":listado3.extraeDato(codigos[i], 3);
                              cadena = cadena + superGenerDesc + "&";

                              generDesc = listado3.extraeDato(codigos[i], 4)==""?"BLANCO":listado3.extraeDato(codigos[i], 4);
                              cadena = cadena + generDesc + "&";

                              codProd = listado3.extraeDato(codigos[i], 5)==""?"BLANCO":listado3.extraeDato(codigos[i], 5);
                              cadena = cadena + codProd + "&";

                              oidMarca = listado3.extraeDato(codigos[i], 6)==""?"BLANCO":listado3.extraeDato(codigos[i], 6);
                              cadena = cadena + oidMarca + "&";

                              oidUniNeg = listado3.extraeDato(codigos[i], 7)==""?"BLANCO":listado3.extraeDato(codigos[i], 7);
                              cadena = cadena + oidUniNeg + "&";
          
          oidNeg = listado3.extraeDato(codigos[i], 8)==""?"BLANCO":listado3.extraeDato(codigos[i], 8);
                              cadena = cadena + oidNeg + "&";
          
          oidSuperGener = listado3.extraeDato(codigos[i], 9)==""?"BLANCO":listado3.extraeDato(codigos[i], 9);
                              cadena = cadena + oidSuperGener + "&";
          
          oidGener = listado3.extraeDato(codigos[i], 10)==""?"BLANCO":listado3.extraeDato(codigos[i], 10);
                              cadena = cadena + oidGener + "&";
          
          oidProd = listado3.extraeDato(codigos[i], 11)==""?"BLANCO":listado3.extraeDato(codigos[i], 11);
                              cadena = cadena + oidProd + "&";
          
          oidArticulo = listado3.extraeDato(codigos[i], 12)==""?"BLANCO":listado3.extraeDato(codigos[i], 12);
                              cadena = cadena + oidArticulo;
                   }

     cadena = cadena==""?"BLANCO":cadena;
     
     listado3.limpia();
     
                   return cadena;

  }
  
  
  function accionAceptarNiveles(){ 
    if(validacionNiveles()){         
         set('formulario.listaDatosNiveles', armarListaDatosNiveles());          
         set('formulario.datosNiveles', armarDatosNiveles()); 
         eval('formulario').oculto = 'S';
         set('formulario.conectorAction', 'LPMantenerPremiosRanking');
         set('formulario.accion', 'almacenar niveles');
         enviaSICC('formulario', null, null, 'N');
    }      
  }
  
  
  function validacionNiveles(){
  
      var codigos = listado.codigos();    
      
                    for (var i=0; i<codigos.length ; i++){
         if(validacionNivel(codigos[i])){
             tipoPremioSeleccionado = listado.extraeDato(codigos[i], 2);  
             
             nivel = datosNiveles[i];                 
             nivelPremio = nivel.split("#");
             tipoPremioAlmacenado= nivelPremio[1];
             
             if(tipoPremioSeleccionado=="") {
                  GestionarMensaje('1545');
                  eval("listado.preparaCamposDR()");
                  focaliza('frm'+'listado'+'.'+'cbTipoPremio'+'_'+i,'');
                  return false;
             }
             
             // Verifica que la capa se ha rellenado y que se corresponde con el tipo de premio seleccionado
             if((tipoPremioSeleccionado!="" && tipoPremioAlmacenado=="BLANCO") || 
                 (tipoPremioSeleccionado!="" && tipoPremioSeleccionado!=tipoPremioAlmacenado)) {
                  GestionarMensaje('1551');
                  eval("listado.preparaCamposDR()");
                  focaliza('frm'+'listado'+'.'+'cbTipoPremio'+'_'+i,'');
                  return false;
             }        
             
         } else {
             return false;
         }
      }
      
      return true;
  }
  
  function validacionNivel(codigo){
        // Tipo Premio
        if(listado.extraeDato(codigo, 2)=="") {
             GestionarMensaje('1545');
             eval("listado.preparaCamposDR()");
             focaliza('frm'+'listado'+'.'+'cbTipoPremio'+'_'+codigo,'');
             return false;
         }
         
         // Puntje Servicio
         if(!sicc_valida_numero_lista(listado.extraeDato(codigo, 1), GestionarMensaje('1546'),0, 9999999)) {
             eval("listado.preparaCamposDR()");
             focaliza('frm'+'listado'+'.'+'txtPuntajeServicio'+'_'+codigo,'');
             return false;
         }
         
         // Cantidad Fijo Puntos
         if(!sicc_valida_numero_lista(listado.extraeDato(codigo, 4), GestionarMensaje('1547'),1, 9999999)) {
             eval("listado.preparaCamposDR()");
             focaliza('frm'+'listado'+'.'+'txtCantidadFijoPuntos'+'_'+codigo,'');
             return false;
         }
                  
         // Cantidad Desde
         if(!sicc_valida_numero_lista(listado.extraeDato(codigo, 5), GestionarMensaje('1548'),0, 9999999)) {
             eval("listado.preparaCamposDR()");
             focaliza('frm'+'listado'+'.'+'txtCantidadDesde'+'_'+codigo,'');
             return false;
         }
         
         // Cantidad Hasta
         if(!sicc_valida_numero_lista(listado.extraeDato(codigo, 6), GestionarMensaje('1549'),0, 9999999)) {
             eval("listado.preparaCamposDR()");
             focaliza('frm'+'listado'+'.'+'txtCantidadHasta'+'_'+codigo,'');
             return false;
         }
         
         // Puntos Productos Exigidos
         if(!sicc_valida_numero_lista(listado.extraeDato(codigo, 7), GestionarMensaje('1550'),0, 9999)) {
             eval("listado.preparaCamposDR()");
             focaliza('frm'+'listado'+'.'+'txtPuntosProductosExigidos'+'_'+codigo,'');
             return false;
         }
         
         // Numero de Aspirantes
         if(!sicc_valida_numero_lista(listado.extraeDato(codigo, 8), GestionarMensaje('1557'),0, 999)) {
             eval("listado.preparaCamposDR()");
             focaliza('frm'+'listado'+'.'+'txtNumAspirantes'+'_'+codigo,'');
             return false;
         }
      
      return true;
  }
  
  
  
  function fLimpiar(){
      if(get('formulario.opcionMenu')!="Crear Concurso Ranking"){
           // Reinicia la modal
           set('formulario.conectorAction', 'LPMantenerPremiosRanking');
           set('formulario.accion', 'cargar mantener nivel');
           // Los valores de opcionMenu, hIndPremiosElectivosPremios y numeroNiveles ya se han seteado en la pagina
           enviaSICC('formulario', null, null, 'N');
           
      } else {
           // Limpia la capa
           if(get_visibilidad('capa1')){
                premioPuntosLimpiar();
           } else if(get_visibilidad('capa5')){
                premioDescuentosLimpiar();
           } else if(get_visibilidad('capa2')){
                premioMonetariosLimpiar();
           } else if(get_visibilidad('capa4')){
                premioArticulosLimpiar();
           } else {
                // Limpia datos niveles
                nivelesLimpiar();
           }
           
      }
  }
  
  function fVolver(){
    close();
  }
  
  
  function nivelesLimpiar(){
         listado.actualizaDat();
         listadatosNiveles = listado.datos;
         var cantFilas = listadatosNiveles.length;   
           
         for(var i=0 ; i<cantFilas ; i++ ) {
             listadatosNiveles[i][2] = "";
             listadatosNiveles[i][4] = "";         
             listadatosNiveles[i][5] = "";
             listadatosNiveles[i][6] = "";        
             listadatosNiveles[i][7] = "";         
             listadatosNiveles[i][8] = "";
             listadatosNiveles[i][9] = ""; 
         }  
    
         listado.setDatos(listadatosNiveles);   
         
         focalizaDatosNiveles();
  }
  
  
  function premioArticulosLimpiar(){
  
      //set('formulario.txtNumUnidadesPremiosArticulo', '');    
      set('formulario.txtCodProducto', '');   
      set('formulario.oidProdArticulos', '');   
      set('formulario.txtNumUnidades4', '1');        
      set('formulario.txtPrecioPublico4', '');        
      set('formulario.ckArticuloDespacha4', 'N');          
      set('formulario.txtDescripcionLote4', '');  
      
      set('formulario.ChkIndCenServGar', 'N');          
      set('formulario.cbCenServGar', '');   
      set('formulario.txtNumMeses', '');   
      set('formulario.areaObservaciones', '');        
      accion('formulario.cbCenServGar', '.disabled=true');  
      accion('formulario.txtNumMeses', '.disabled=true');  
      accion('formulario.areaObservaciones', '.disabled=true');  
      
      set('formulario.rdTipoEntrega', 'B');          
      set('formulario.cbCenServEntrega', '');        
      accion('formulario.cbCenServEntrega', '.disabled=true');  
      
      focaliza("formulario.txtCodProducto");
  }
  
  function premioMonetariosLimpiar(){
      
      // Deshabilitar
      set('formulario.cbTipoPremioMonetario2', '');                  
      set('formulario.txtCantidad2', '');          
      set('formulario.txtPorcentaje2', ''); 
      set('formulario.cbMoneda', '');        
      set('formulario.cbFormaPago', '');      
      accion('formulario.txtCantidad2', '.disabled=true'); 
      accion('formulario.txtPorcentaje2', '.disabled=true'); 
      
      set('formulario.ckPagoPartes', 'S');        
      set('formulario.cbCumplimiento', '');   
      set('formulario.ckDescontarPago', 'N');   
      accion('formulario.ckDescontarPago', '.disabled=true'); 
      
      set('formulario.txtPremio', '');        
      set('formulario.cbPeriodoControl', '');
      
      // Verifica si la calificacion es metas bono anual
      if(get('formulario.hOidTipoDeterminacionMetas')==get('formulario.OID_TIPO_DET_METAS_BONO_ANUAL')){
           visibilidad('capa3','V');
           visibilidad('capaBoton','O');
           mostrarListado1();
      } else {         
           visibilidad('capa3','O');
           visibilidad('capaBoton','V');
           ocultarListado1();
      }
      
      focaliza("formulario.cbTipoPremioMonetario2");
  }
  
  
  function premioDescuentosLimpiar(){
   
      // Deshabilitar
      set('formulario.cbTipoPremioDescuento5', '');          
      set('formulario.cbPeriodoAplicacionDesde', '');        
      set('formulario.cbPeriodoAplicacionHasta', '');        
             
      onChangeTipoPremioDescuento();
      
      focaliza("formulario.cbTipoPremioDescuento5");
  }
  
  
  function premioPuntosLimpiar(){
      
      set('formulario.cbConcursoDestino', '');          
      set('formulario.cbTipoPremioPuntos1', '');          
      set('formulario.txtCantidad1', '');          
      set('formulario.txtPorcentaje1', '');          
      accion('formulario.txtCantidad1', '.disabled=true'); 
      accion('formulario.txtPorcentaje1', '.disabled=true'); 
      
      focaliza("formulario.cbConcursoDestino");
  }
  
  
  function cerrarModal(){
     
                   close();
  }
  
  function errorAlmacenarNivel(){  
      var codigos = listado.codigos();    
      
                    if(codigos.length!=0){
           focalizaDatosNiveles();
      } else {
           focalizaBotonHTML_XY('btnDefinirPremio');
      }
                   
  }
  
  function armarListaDatosNiveles(){    
      var codigos = listado.codigos();
                    var cadena = "";
                    
                    for (var i=0; i<codigos.length ; i++){
                              if( i != 0)
                                             cadena = cadena + "|";

                              numNivel = listado.extraeDato(codigos[i], 0)==""?"BLANCO":listado.extraeDato(codigos[i], 0);
                              cadena = cadena + numNivel + "#";

                              puntajeServ = listado.extraeDato(codigos[i], 1)==""?"BLANCO":listado.extraeDato(codigos[i], 1);
                              cadena = cadena + puntajeServ + "#";

                              tipoPremio = listado.extraeDato(codigos[i], 2)==""?"BLANCO":listado.extraeDato(codigos[i], 2);
                              cadena = cadena + tipoPremio + "#";
          
          descTipoPremio = document.getElementById('cbTipoPremio'+'_'+i).options[document.getElementById('cbTipoPremio'+'_'+i).selectedIndex].text;
                              cadena = cadena + descTipoPremio + "#";

                              nivelElegible = listado.extraeDato(codigos[i], 3)==""?"BLANCO":listado.extraeDato(codigos[i], 3);
                              cadena = cadena + nivelElegible + "#";

                              cantFijaPuntos = listado.extraeDato(codigos[i], 4)==""?"BLANCO":listado.extraeDato(codigos[i], 4);
                              cadena = cadena + cantFijaPuntos + "#";

                              cantDesde = listado.extraeDato(codigos[i], 5)==""?"BLANCO":listado.extraeDato(codigos[i], 5);
                              cadena = cadena + cantDesde + "#";

                              cantHasta = listado.extraeDato(codigos[i], 6)==""?"BLANCO":listado.extraeDato(codigos[i], 6);
                              cadena = cadena + cantHasta + "#";

                              puntosProdExigidos = listado.extraeDato(codigos[i], 7)==""?"BLANCO":listado.extraeDato(codigos[i], 7);
                              cadena = cadena + puntosProdExigidos + "#";
          
          numAspirantes = listado.extraeDato(codigos[i], 8)==""?"BLANCO":listado.extraeDato(codigos[i], 8);
                              cadena = cadena + numAspirantes + "#";
          
          oidPremio = listado.extraeDato(codigos[i], 9)==""?"BLANCO":listado.extraeDato(codigos[i], 9);
                              cadena = cadena + oidPremio;
                   }

          //alert("cadena:" + cadena);
                   return cadena;

         }
  
  function armarDatosNiveles(){ 
     var cadena = "";
                    
                    for (var i=0; i<datosNiveles.length ; i++){
                              if( i != 0)
             cadena = cadena + "%";
             
          cadena = cadena + datosNiveles[i];
      }
           
     //alert("cadena:" + cadena);
                   return cadena;
  }


  function focalizaDatosNiveles() {  
      if(listado.datos.length!=0) {
           eval("listado.preparaCamposDR()");
           
           focaliza('frm'+'listado'+'.'+'txtPuntajeServicio'+'_0','');
      }
  }
  
   
  function visualizarPremioPuntos() {  
      // Visualizar capa
      visibilidad('capa1','V');
      visibilidad('capa2','O');
      visibilidad('capaBoton','O');
      visibilidad('capa3','O');
      visibilidad('capa4','O');
      visibilidad('capa5','O');
      ocultarListado1();
      ocultarListado2();
      ocultarListado3();
      ocultarListado4();
      
      eval (ON_RSZ);  
  }
  
  function visualizarPremioMonetario() {  
      // Visualizar capa
      visibilidad('capa1','O');
      visibilidad('capa2','V');
      visibilidad('capa4','O');
      visibilidad('capa5','O');
      ocultarListado2();
      ocultarListado3();
      ocultarListado4();    
      
      eval (ON_RSZ);  
  }
  
  function visualizarPremioArticulo() {  
      // Visualizar capa
      visibilidad('capa1','O');
      visibilidad('capa2','O');
      visibilidad('capaBoton','O');
      visibilidad('capa3','O');
      visibilidad('capa4','V');
      visibilidad('capa5','O');
      ocultarListado1();
      mostrarListado2();
      ocultarListado3();
      mostrarListado4();    
      
      eval (ON_RSZ);  
  }
  
  function visualizarPremioDescuento(tipoPremioDescuento) {  
      // Visualizar capa
      visibilidad('capa1','O');
      visibilidad('capa2','O');
      visibilidad('capaBoton','O');
      visibilidad('capa3','O');
      visibilidad('capa4','O');
      visibilidad('capa5','V');
      ocultarListado1();
      ocultarListado2();
      
      set('formulario.cbMarca', '');     
      set('formulario.cbUnidadNegocio', '');     
      set('formulario.cbNegocio', '');     
      set('formulario.cbSupergenerico', '');     
      set('formulario.cbGenerico', '');     
      set('formulario.txtCodProducto5', '');     
      set('formulario.oidProdDecuentos', ''); 
      
      if(tipoPremioDescuento==get('formulario.OID_TIPO_DESCUENTO_PORCENTAJE')){
           mostrarListado3();
           
           accion('formulario.cbMarca', '.disabled=false'); 
           accion('formulario.cbUnidadNegocio', '.disabled=false'); 
           accion('formulario.cbNegocio', '.disabled=false'); 
           accion('formulario.cbSupergenerico', '.disabled=false'); 
           accion('formulario.cbGenerico', '.disabled=false'); 
           accion('formulario.txtCodProducto5', '.disabled=false'); 
           
           // Habilita botones
           deshabilitarHabilitarBoton('botonContenido','btnAnadir5','A');
           deshabilitarHabilitarBoton('botonContenido','btnBuscar5','A');
      } else {
           ocultarListado3();
           
           accion('formulario.cbMarca', '.disabled=true'); 
           accion('formulario.cbUnidadNegocio', '.disabled=true'); 
           accion('formulario.cbNegocio', '.disabled=true'); 
           accion('formulario.cbSupergenerico', '.disabled=true'); 
           accion('formulario.cbGenerico', '.disabled=true'); 
           accion('formulario.txtCodProducto5', '.disabled=true'); 
           
           // Deshabilita botones
           deshabilitarHabilitarBoton('botonContenido','btnAnadir5','D');
           deshabilitarHabilitarBoton('botonContenido','btnBuscar5','D');
      }
      
      ocultarListado4();    
      
      eval (ON_RSZ);  
  }
  
    
  function mostrarListadoNiveles(){
  
    DrdEnsanchaConMargenDcho('listado',12);
    document.all["Cplistado"].style.visibility='';
    document.all["CpLin1listado"].style.visibility='';
    document.all["CpLin2listado"].style.visibility='';
    document.all["CpLin3listado"].style.visibility='';
    document.all["CpLin4listado"].style.visibility='';
    document.all["separaDiv"].style.visibility='hidden';
    document.all["primeraDiv"].style.visibility='hidden';
    document.all["retDiv"].style.visibility='hidden';
    document.all["avaDiv"].style.visibility='hidden';
    
    visibilidad('capa1','O');
    visibilidad('capa2','O');
    visibilidad('capaBoton','O');
    visibilidad('capa3','O');
    visibilidad('capa4','O');
    visibilidad('capa5','O');
    
    ocultarListado1();
    ocultarListado2();
    ocultarListado3();
    ocultarListado4();    
    
    eval (ON_RSZ);     
  }
    
  function ocultarListado1(){
  
    DrdEnsanchaConMargenDcho('listado1',26);
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["separa1Div"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["btnEliminar2Div"].style.visibility='hidden';
  }
  
  function mostrarListado1(){
  
    DrdEnsanchaConMargenDcho('listado1',26);
    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["separa1Div"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["btnEliminar2Div"].style.visibility='';
  }
  
  function ocultarListado2(){
    
    DrdEnsanchaConMargenDcho('listado2',40);
    document.all["Cplistado2"].style.visibility='hidden';
    document.all["CpLin1listado2"].style.visibility='hidden';
    document.all["CpLin2listado2"].style.visibility='hidden';
    document.all["CpLin3listado2"].style.visibility='hidden';
    document.all["CpLin4listado2"].style.visibility='hidden';
    document.all["separa2Div"].style.visibility='hidden';
    document.all["primera2Div"].style.visibility='hidden';
    document.all["ret2Div"].style.visibility='hidden';
    document.all["ava2Div"].style.visibility='hidden';
  }
    
  function mostrarListado2(){
    
    DrdEnsanchaConMargenDcho('listado2',40);
    document.all["Cplistado2"].style.visibility='';
    document.all["CpLin1listado2"].style.visibility='';
    document.all["CpLin2listado2"].style.visibility='';
    document.all["CpLin3listado2"].style.visibility='';
    document.all["CpLin4listado2"].style.visibility='';
    document.all["separa2Div"].style.visibility='hidden';
    document.all["primera2Div"].style.visibility='hidden';
    document.all["ret2Div"].style.visibility='hidden';
    document.all["ava2Div"].style.visibility='hidden';
  }
    
  function ocultarListado4(){  
  
    DrdEnsanchaConMargenDcho('listado4',26);
    document.all["Cplistado4"].style.visibility='hidden';
    document.all["CpLin1listado4"].style.visibility='hidden';
    document.all["CpLin2listado4"].style.visibility='hidden';
    document.all["CpLin3listado4"].style.visibility='hidden';
    document.all["CpLin4listado4"].style.visibility='hidden';
    document.all["separa4Div"].style.visibility='hidden';
    document.all["primera4Div"].style.visibility='hidden';
    document.all["ret4Div"].style.visibility='hidden';
    document.all["ava4Div"].style.visibility='hidden';
  }
    
  function mostrarListado4(){  
  
    DrdEnsanchaConMargenDcho('listado4',26);
    document.all["Cplistado4"].style.visibility='';
    document.all["CpLin1listado4"].style.visibility='';
    document.all["CpLin2listado4"].style.visibility='';
    document.all["CpLin3listado4"].style.visibility='';
    document.all["CpLin4listado4"].style.visibility='';
    document.all["separa4Div"].style.visibility='hidden';
    document.all["primera4Div"].style.visibility='hidden';
    document.all["ret4Div"].style.visibility='hidden';
    document.all["ava4Div"].style.visibility='hidden';
  }
  
  function ocultarListado3(){  
    
    DrdEnsanchaConMargenDcho('listado3',26);
    document.all["Cplistado3"].style.visibility='hidden';
    document.all["CpLin1listado3"].style.visibility='hidden';
    document.all["CpLin2listado3"].style.visibility='hidden';
    document.all["CpLin3listado3"].style.visibility='hidden';
    document.all["CpLin4listado3"].style.visibility='hidden';
    document.all["separa3Div"].style.visibility='hidden';
    document.all["primera3Div"].style.visibility='hidden';
    document.all["ret3Div"].style.visibility='hidden';
    document.all["ava3Div"].style.visibility='hidden';
    document.all["btnEliminarDiv"].style.visibility='hidden';
  }
  
  function mostrarListado3(){  
    
    DrdEnsanchaConMargenDcho('listado3',26);
    document.all["Cplistado3"].style.visibility='';
    document.all["CpLin1listado3"].style.visibility='';
    document.all["CpLin2listado3"].style.visibility='';
    document.all["CpLin3listado3"].style.visibility='';
    document.all["CpLin4listado3"].style.visibility='';
    document.all["separa3Div"].style.visibility='hidden';
    document.all["primera3Div"].style.visibility='hidden';
    document.all["ret3Div"].style.visibility='hidden';
    document.all["ava3Div"].style.visibility='hidden';
    document.all["btnEliminarDiv"].style.visibility='';
  }
  
  
  function sicc_valida_numero_lista(strValor, strMostrar, valorMinimo, valorMaximo) {
          var formulario_local = getFormularioSICC();
          var valorTest = strValor;
          if(valorTest==""){
                    return true;
          }        
                  
          strCantDec="0";
          strSepDec = get(formulario_local+".hSeparadorDecimalPais");
          strSepMil = get(formulario_local+".hSeparadorMilesPais");
          

          //Primero me fijo si es un numero, para eso
          //le saco todos los separadores
          var strCleaned = valorTest.split(strSepDec).join("");
          strCleaned = strCleaned.split(strSepMil).join("")+"";
          
          if(!parseInt(strCleaned.substr(0,1),10) && parseInt(strCleaned.substr(0,1),10)!=0){//si el primero no es un numero, puede ser solo el simbolo negativo
                    if(strCleaned.substr(0,1)!="-"){
                              cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
                              return false;
                    }else{//tambien lo saco para testear el numero
                              strCleaned = strCleaned.substr(1);
                    }
          }

          var RegInteger = /^\d+$/; //Solo numeros
          if(!RegInteger.test(strCleaned)){
                    cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
                    return false;
          }
          
          //Ahora se que es un numero, primero valido los decimales
          //el ultimo debe ser un numero
          if(isNaN(parseInt(valorTest.substr(valorTest.length-1),10))){
                              cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
                              return false;
          }

          //me fijo el largo de los decimales
          var arrTest = valorTest.split(strSepDec);
          if(arrTest.length ==2 && arrTest[1]!=null && arrTest[1]!=""){//si tiene decimales
                    if(parseInt(strCantDec,10)==0){
                              cdos_mostrarAlert(GestionarMensaje("000000000000104"));
                              return false;
                    }
                    var strDecimales = arrTest[arrTest.length-1]+"";
                    if(strDecimales.length > parseInt(strCantDec,10)){//me fijo cuantos son
                              cdos_mostrarAlert(GestionarMensaje("000000000000101" ,  strMostrar,parseInt(strCantDec,10)));
                              return false;
                    }
          }else{
                    if(arrTest.length > 2){//sino
                              cdos_mostrarAlert(GestionarMensaje("000000000000102" ,  strMostrar));
                              return false;
                    }
          }
          //ahora voy por la parte entera

          var strInteger = arrTest[0]+"";
          
          if(strInteger.indexOf(strSepMil) >- 1){//si tiene separadores de miles
                    var arrInteger = strInteger.split(strSepMil);
                    //en todo el array los numero son de a 3 digitos
                    //excepto en la primera posicion, 
                    //donde solo no pueden ser 4 digitos
                    for(var i=0; i < arrInteger.length; i++){
                              if(i==0){
                                         if((arrInteger[i]+"").length>3){
                                                   cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
                                                   return false;
                                         }
                              }else{
                                         if((arrInteger[i]+"").length!=3){
                                                   cdos_mostrarAlert(GestionarMensaje("000000000000105",strSepMil));
                                                   return false;
                                         }
                              }
                    }
          }


          //por ultimo valido el rango del valor
          //saco el separador de miles
          var strNumeroTest = valorTest.split(strSepMil).join("");
          //si el separador decimal es el punto, lo dejo, sino, lo reemplazo por el punto
          if(strSepDec!="."){
                    strNumeroTest  = strNumeroTest.split(strSepDec).join(".")
          }
          
          if(valorMinimo!=""){
                    if(parseFloat(strNumeroTest )<parseFloat(valorMinimo)){
                              cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));                              
                              return false;
                    }
          }      
          if(valorMaximo!=""){
                    if(parseFloat(strNumeroTest)>parseFloat(valorMaximo)){
                              cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));                              
                              return false;
                    }
          }
          return true;
  }


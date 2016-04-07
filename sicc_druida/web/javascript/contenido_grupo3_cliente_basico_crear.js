/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/ 


/*
    INDRA/CAR/PROY
    $Id: contenido_grupo3_cliente_basico_crear.js,v 1.1 2009/12/03 19:02:01 pecbazalar Exp $
    DESC
	mamontie fue creado para separa javascrip para solucionar inc Peru
*/

             function onLoadPag(){
                  
/*                if( get('frmInsertarCliente.hidCerrarVentana') == 'true') {
                           cerrarVentana();
                  } else {

					  
*/                

                            DrdEnsanchaConMargenDcho('listado1',12);
                            DrdEnsanchaConMargenDcho('listado2',12);
                            DrdEnsanchaConMargenDcho('listado3',12);
                            configurarMenuSecundario("frmInsertarCliente");
                                                      
                            eval (ON_RSZ);  
                  
                            if(get('frmInsertarCliente.usaGeoreferenciador')=='true'){
                                                         procesoGeoTrue();
                            }else{
                                             procesoGeoFalse();
                            }

                             if(get('frmInsertarCliente.elementosP3')!=""){
                                     recargarValor();
                                     recargarValoresExtra();
                                     recargarValoresMarca();
                             }

                             accion("frmInsertarCliente.comboTipoClasificacion", ".disabled=true");
                             accion("frmInsertarCliente.comboClasificacion", ".disabled=true");

                             focaliza('frmInsertarCliente.comboTipoDireccion');
//                  }
         }
                           
                             
                           
/* Funcion para recargar la pantalla con datos anteriores de sesion */

                           function recargarValor(){           	
                                    var valores = get('frmInsertarCliente.elementosP3');

                                    var elementos = valores.split(";");
                                    var list1 = new Array();
                                    
                                    for(var x=0;x<elementos.length - 1;x++){
                                             var linea    = elementos[x].split("=");
                                             var elemento = linea[0].split("_");
                                             
                                             //elemento[0] tiene h
                                             //elemento[1] tiene TipoControl
                                             //elemento[2] el indice del combo
                                             var ind = Math.abs(elemento[2]);
                                             // alert('elemento' + elemento);
                                             // alert('linea ' + linea);
                                             
                                             if((list1[ind]) == null){ 
                                                      list1[ind] = new Array(17);
                                                      list1[ind][0] = Math.abs(list1[ind].length + 1);
                                                      //alert('deberia pasar una vez');
                                             } 
                                
//                                  alert("Elementos: "+elementos);
                  if(elemento[1]=="TerritorioDesc"){
                                          list1[ind][1]= linea[1];
                     
                                }

                                if(elemento[1]=="DescripcionDireccion"){
                                          list1[ind][2]= linea[1];
                      
                                }

                  if(elemento[1]=="DescripcionTipoVia"){
                                          list1[ind][3]= linea[1];
                                }
             
                 
                  if(elemento[1]=="TextoNombreVia"){
                                          list1[ind][4]= linea[1];
                                }

                  if(elemento[1]=="DescripcionVia"){
                                     
                                          list1[ind][5]= linea[1];
                                }
                  

                  if(elemento[1]=="TextoNumeroPrincipal"){
                                          list1[ind][6]= linea[1];
                                }

                  if(elemento[1]=="TextoCodPostal"){
                                          list1[ind][7]= linea[1];
                                }

                 /* if(elemento[1]=="TextoInterior"){
                                          list1[ind][8]= linea[1];
                                }

                  if(elemento[1]=="TextoManzana"){
                                          list1[ind][9]= linea[1];
                                }

                  if(elemento[1]=="TextoLote"){
                                          list1[ind][10]= linea[1];
                                }

                                if(elemento[1]=="TextoKm"){
                                          list1[ind][11]= linea[1];
                                }*/

                  if(elemento[1]=="AreaTxtObservaciones"){
                                          //list1[ind][12]= linea[1];
                                                      list1[ind][8]= linea[1];
                                }

                  if(elemento[1]=="cbxDireccionPrincipal"){
//                                        list1[ind][13]= linea[1];
                                          list1[ind][9]= linea[1];
                                }

                  if(elemento[1]=="Territorio"){
//                                        list1[ind][14]= linea[1];
                                          list1[ind][10]= linea[1];
                                }


                  if(elemento[1]=="comboNombreVia"){
//                                        list1[ind][17]= linea[1];
                                          list1[ind][11]= linea[1];
                      
                                }
                  if(elemento[1]=="comboTipoVia"){
//                                        list1[ind][16]= linea[1];
                                          list1[ind][12]= linea[1];
                                }

                   if(elemento[1]=="comboTipoDireccion"){
//                                        list1[ind][15]= linea[1];
                                          list1[ind][13]= linea[1];
                                }

                  //Cargo la lista de clasificaciones

                 
                  
              }
              //alert('list1 - ' + list1);
                             
              for(var g=0;g<list1.length;g++){
                  //alert('contenido de la lista ' + list1 );                   
                                listado1.insertar(list1[g]);
                     }
              listado1.repinta();


              
           }

           function recargarValoresMarca(){

              var valores = get('frmInsertarCliente.elementosP3Marca');
                     var elementos = valores.split(";");
              var list2 = new Array();

              for(var x=0;x<elementos.length - 1;x++){
                                var linea    = elementos[x].split("=");
                                      var elemento = linea[0].split("_");

                                //elemento[0] tiene h
                                //elemento[1] tiene TipoControl
                                //elemento[2] el indice del combo
                  var ind = Math.abs(elemento[2]);
                 // alert('elemento' + elemento);
                 // alert('linea ' + linea);
          
                  
                 if((list2[ind]) == null){ 
                    list2[ind] = new Array(10);
                    list2[ind][0] = Math.abs(list2[ind].length + 1);
                    //alert('deberia pasar una vez');
                 }

                  if(elemento[1] =="DescripcionMarcaClasificacion"){
                     list2[ind][1]= linea[1];

                  }

             
                  if(elemento[1] =="DescripcionCanalClasificacion"){
                     list2[ind][2]= linea[1];

                  }

                  if(elemento[1] =="DescripcionTipo"){
                     list2[ind][3]= linea[1];

                  }

                  if(elemento[1] =="DescripcionSubtipo"){
                     list2[ind][4]= linea[1];

                  }


                  if(elemento[1] =="DescripcionTipoClasificacion"){
                     list2[ind][5]= linea[1];

                  }

                  if(elemento[1] =="DescripcionClasificacion"){
                     list2[ind][6]= linea[1];

                  }

                  if(elemento[1] =="comboMarcaClasificacion"){
                     list2[ind][7]= linea[1];

                  }

                  if(elemento[1] =="comboCanal"){
                     list2[ind][8]= linea[1];

                  }

                  if(elemento[1] =="comboTipoClasificacion"){
                     list2[ind][9]= linea[1];

                  }

                  if(elemento[1] =="comboClasificacion"){
                     list2[ind][10]= linea[1];
                  }
              }

              for(var g=0;g<list2.length;g++){
                 // alert('lista[' + g +']: ' + list2[g] );
                  //alert('contenido de la lista ' + list2 );
                                listado3.insertar(list2[g]);
                     }
              listado3.repinta();
			  //alert("listado3.datos: "+listado3.datos);

           }

           function recargarValoresExtra(){
                     listado2.eliminar(0,1);
                     var val=get('frmInsertarCliente.elementosExtra');
                     //alert(val);
                     var elems = val.split(";");
              // alert(elems.length);
                     var cant = Math.round((elems.length-1) / 1 );

                     var listaIdent = new Array(cant);
                     for(var t=0;t<cant;t++){
                                listaIdent[t] = new Array(6);
                                listaIdent[t][0] = t+1;
                     }
         
                     for(var x=0;x<elems.length;x++){
                                var line = elems[x].split("=");
                                var elem = line[0].split("_");
                            	         var ind = Math.abs(elem[2]);

                                if(elem[1]=="comboMarca"){
                                         listaIdent[ind][1]= line[1];
                  }
              }

                     for(var g=0;g<cant;g++){
         
                                listado2.insertar(listaIdent[g]);
                  

                     }
              
              listado1.repinta();
              recargaComboMarcaClasificacion();
              
              
           }            
           

/******************************************************************************************************************/


    
/************************************************Funciones de combos************************************************************/
   

           function cambioMarca(){
                 // esta funcion se llama al cambiar el combo marca.
                 // esta funcion agrega la marca seleccionada al combo marcaClasificacion
                 // siempre que no se haye repetida
                 var comboname=window.event.srcElement.getAttribute("NAME");
              var combo=window.event.srcElement;
              var selectedValue=window.event.srcElement.getAttribute("VALUE");
              var sOptions=window.event.srcElement.all;
              var selectedOption;
              
                 for(var t=0;t<sOptions.length;t++){
                  if(sOptions.item(t).selected){
                    selectedOption = sOptions.item(t);
                    
                           }
                  
                 }
    
                 var option=window.event.srcElement.options;
              var tempArray = new Array();
              //tempArray[1] va a contener el indice del combo Marca seleccionado         
                 tempArray = comboname.split('_');
              //esto indica si se selecciono un valor distinto de vacio
                 if(selectedValue > -1){ // -1 es el value del valor '""
              
                           //verifico si estaba repetida la marca
                  
                           var colection = document.getElementById('tblDatlistado2');
                  var combosMarca = colection.all.tags("SELECT");
                  var marcaRepetida= false;
                
                           for(var x=0;x<combosMarca.length;x++){
                  
                     
                                     //veo si no es la que cambio a ver si esta repetida
                     
                                     if(selectedValue ==  combosMarca.item(x).value && tempArray[1] != x ) {// esta repetida la marca
                        
                                              // tengo qeu seleccionar el blanco
                                              marcaRepetida=true;
                        GestionarMensaje('1342')
                                     combo.value = '';
                        break;
                                     }else{
                                      recargaComboMarcaClasificacion();
                     }
                           }
              }else{
                          recargaComboMarcaClasificacion();
                  
              }
                          
           }
    
           function recargaComboMarcaClasificacion(){
                 // primero borro los combos
                 //borrarCombosMarcaClasificacion();
              //alert('entro en recagra1');
                borrarCombo('comboMarcaClasificacion');
                cargarCombosMarcaClasificacion();
              
           }
         
    
           function borrarCombo(nombreCombo){
              
              var elCombo = document.getElementById(nombreCombo);
              var optis = elCombo.options;
              var cant = optis.length-1;
                           

                 for(var z=cant;z>=0;z--){
              
              
                           optis.remove(z);
                 }
          }
    
          function cargarCombosMarcaClasificacion(){
                      
                var colection = document.getElementById('tblDatlistado2');
             
                var combosMarca = colection.all.tags("SELECT");
             var comboMarcaClasificacion = document.getElementById('comboMarcaClasificacion');

             var optionVacio = document.createElement("OPTION");
             comboMarcaClasificacion.options.add(optionVacio);
             optionVacio.innerText = "";    
                                    optionVacio.value= "";
                
                for(var xx=0;xx<combosMarca.length;xx++){
                          if(combosMarca.item(xx).value != -1 ){ 
                   		      var esteCombo = combosMarca.item(xx);
                                    var nombreMarca;
                 //   alert('estas');
    
                    if(esteCombo.options.item(esteCombo.selectedIndex) != -1){
                                                nombreMarca =	esteCombo.options.item(esteCombo.selectedIndex).innerText;
                                           }
                                    
                                                  var option      = document.createElement("OPTION");
                   
                                                  comboMarcaClasificacion.options.add(option);
                           
                                                  option.innerText = nombreMarca;    
                                                  option.value= esteCombo.value;		 				
                  
                                        }   
             }

             ordenaCombo_SICC(comboMarcaClasificacion);
          }
         /*******************************************************************/
         function getRefCombo(){
             var combo=window.event.srcElement.getAttribute("NAME");
             
             var option=window.event.srcElement.options;
             
             for(var i=0;i<option.length;i++){
                if(option.item(i).getAttribute("selected")){
                         
                    set('frmInsertarCliente.nameComboSelected',combo);
                    set('frmInsertarCliente.valueComboSelected',option.item(i).getAttribute("value"));
                    borrarCombo('comboClasificacion');
                    
                    cargarComboEditable();
                 }
             }
         }

           
         function cargarComboEditable(){
            var name = get('frmInsertarCliente.nameComboSelected');
            var cad = new String();
            cad=name;
            var largo = cad.length;
            var Lista  = document.getElementById("comboClasificacion");
            var optionVacia = document.createElement("OPTION");
            Lista.options.add(optionVacia);
            optionVacia.innerText = "";
            optionVacia.value = "";
            
            
            for(var k=0;k<Lista1.datos.longitud;k++) {
             if (Lista1.datos.ij(k,2) == get('frmInsertarCliente.valueComboSelected')) {
                  
                   var option = document.createElement("OPTION");
                   Lista.options.add(option);
                   option.innerText=Lista1.datos.ij(k,1);
                   option.value= Lista1.datos.ij(k,0);
                }
            }
                     
         }
        

/*****************************************************************************************************************/         

/**************************recarga de subtipo******************************************/

         function onChangeTipo(){
             var combo = window.event.srcElement.getAttribute("NAME");             
             var option = window.event.srcElement.options;

             accion("frmInsertarCliente.comboTipoClasificacion", ".disabled=true");
             accion("frmInsertarCliente.comboClasificacion", ".disabled=true");
             
             for(var i=0;i<option.length;i++){
                if(option.item(i).getAttribute("selected")){

                    set('frmInsertarCliente.nameComboSelectedTipo',combo);
                    set('frmInsertarCliente.valueComboSelectedTipo',option.item(i).getAttribute("value"));
					//alert("get(frm.cbTipoCliente)_" + get('frmInsertarCliente.cbTipoCliente'));
                    //alert("el value selected del cbTipoCliente es_" + get('frmInsertarCliente.valueComboSelectedTipo'));
                    var aCombo = new Array(new Array("",""));
                    set_combo('frmInsertarCliente.cbSubtipoCliente',aCombo, []);
                    set_combo('frmInsertarCliente.comboClasificacion',aCombo, []);
                    set_combo('frmInsertarCliente.comboTipoClasificacion',aCombo, []);
              
                    cargarComboSubtipo();
                 }
             }
         }

           
         function cargarComboSubtipo(){
             var name = get('frmInsertarCliente.nameComboSelectedTipo');
             var cad = new String();
             cad = name;
             var largo = cad.length;
             var Lista  = document.getElementById("cbSubtipoCliente");
             //  var optionVacia = document.createElement("OPTION");
             //  Lista.options.add(optionVacia);
             //  optionVacia.innerText = '';
             //  optionVacia.value = -1;
                   
            
             for(var k=0;k<ListaSubtipo.datos.longitud;k++) {
                 if (ListaSubtipo.datos.ij(k,0) == get('frmInsertarCliente.valueComboSelectedTipo')) {
                     accion("frmInsertarCliente.comboTipoClasificacion", ".disabled=false");
                     accion("frmInsertarCliente.comboClasificacion", ".disabled=false");

                     var option = document.createElement("OPTION");
                     Lista.options.add(option);
                     option.innerText=ListaSubtipo.datos.ij(k,2);
                     option.value= ListaSubtipo.datos.ij(k,1);
                 }
             }          
         }
        

/**************************************************************************************/

/**************************recarga de tipo clasificacion******************************************/

         function onChangeSubtipo(){
         
             var combo=window.event.srcElement.getAttribute("NAME");
             
             var option=window.event.srcElement.options;
             
             for(var i=0;i<option.length;i++){
                if(option.item(i).getAttribute("selected")){
                
                         
                    set('frmInsertarCliente.nameComboSelectedSubtipo',combo);
                    set('frmInsertarCliente.valueComboSelectedSubtipo',option.item(i).getAttribute("value"));
                    //alert('el value es ' + get('frmInsertarCliente.valueComboSelectedTipo'));
                    borrarCombo('comboClasificacion');
                    borrarCombo('comboTipoClasificacion');
                    
                    cargarComboTipoClasificacion();
                 }
             }
         }

           
         function cargarComboTipoClasificacion(){
            var name = get('frmInsertarCliente.nameComboSelectedSubtipo');
            var cad = new String();
            cad=name;
            var largo = cad.length;
            var Lista  = document.getElementById("comboTipoClasificacion");
            var optionVacia = document.createElement("OPTION");
            Lista.options.add(optionVacia);
            optionVacia.innerText = "";
            optionVacia.value = "";
            //alert('esta en cargar');
            
            
            for(var k=0;k<ListaTipoClasi.datos.longitud;k++) {
             if (ListaTipoClasi.datos.ij(k,2) == get('frmInsertarCliente.valueComboSelectedSubtipo')) {
             
                  
                   var option = document.createElement("OPTION");
                   Lista.options.add(option);
                   option.innerText=ListaTipoClasi.datos.ij(k,1);
                   option.value= ListaTipoClasi.datos.ij(k,0);
                }
            }
                     
         }
        

/**************************************************************************************/

        

/**************************Funciones para añadir filas a los listados*********************************************/         
         function aniadirFilaDirecciones(){
            var linea = new Array();            

            var strUnidadGeografica = get('frmInsertarCliente.hidDescTerritorio');
            var oidUnidadGeografica = get('frmInsertarCliente.hidTerritorio');
            var tipoDireccion = document.getElementById('comboTipoDireccion');
            var numeroPrincipal = get('frmInsertarCliente.TextoNumeroPrincipal');
            var codigoPostal = get('frmInsertarCliente.TextoCodPostal');
            var observaciones = get('frmInsertarCliente.AreaTxtObservaciones');
            var principal = get('frmInsertarCliente.cbxDireccionPrincipal');
            var principalObjeto = document.getElementById('cbxDireccionPrincipal');
            var siI18N = GestionarMensaje("84");
            var noI18N = GestionarMensaje("86");
            var strTipoDireccion = tipoDireccion.options[tipoDireccion.selectedIndex].text;
            var oidTipoDireccion = tipoDireccion.options[tipoDireccion.selectedIndex].value;

			//Cleal Mae-03
			var tipoVia     = document.getElementById('comboTipoVia');
            var strTipoVia  = tipoVia.options[tipoVia.selectedIndex].text;
			var oidTipoVia  = tipoVia.options[tipoVia.selectedIndex].value;               
            
            linea[linea.length] = listado1.generaCodigo('');
            linea[linea.length] = strUnidadGeografica;
            linea[linea.length] = strTipoDireccion;
			
            if(get('frmInsertarCliente.usaGeoreferenciador') == 'true'){              
                var nombreVia  = get('frmInsertarCliente.TextoNombreVia');

                if(validarInsercionDireccion()){
				   linea[linea.length] = strTipoVia;
                   linea[linea.length] = nombreVia;
                   linea[linea.length] = '';
                }                      
            }
			else{
                //var tipoVia     = document.getElementById('comboTipoVia');
				
				//cvalenzu - 25/10/2006 - ahora el oid se toma de una variable
				//oculta, porque el combo ya no existe.
				var via          = get('frmInsertarCliente.hiddenOidVia');
                //var via          = document.getElementById('cbVia');

                var flag;

                if(validarInsercionDireccion()){          
				  //alert("if");
                  //var strTipoVia  = tipoVia.options[tipoVia.selectedIndex].text;

				  //cvalenzu - 25/10/2006 - ahora la descripcion se toma de una 
				  //caja de texto, porque el combo ya no existe.
				  var strVia      = get('frmInsertarCliente.comboNombreVia');
				  //alert("strVia " + strVia);
                  //var strVia      = via.options[via.selectedIndex].text;
                
                  //var oidTipoVia  = tipoVia.options[tipoVia.selectedIndex].value;


				  //cvalenzu - 25/10/2006 - ahora el oid se toma de una variable
 				  //oculta, porque el combo ya no existe.
				  var oidVia      = get('frmInsertarCliente.hiddenOidVia');
  				  //alert("oidVia " + oidVia);
                  //var oidVia      = via.options[via.selectedIndex].value;
              

                   linea[linea.length] = strTipoVia;//
                   linea[linea.length] = '';
                   linea[linea.length] = strVia;
                   flag = 'true';
                }else{
				  //alert("else");
                   return;
                }
            }

            linea[linea.length] = numeroPrincipal;
            linea[linea.length] = codigoPostal; 
            linea[linea.length] = observaciones;

            if(principal == 'S'){
                linea[linea.length] = siI18N; 
            }else{
                linea[linea.length] = noI18N; 
            }

            linea[linea.length] = oidUnidadGeografica;
            //linea[linea.length] = oidTipoDireccion;

            if(get('frmInsertarCliente.usaGeoreferenciador') == 'true'){
                linea[linea.length] = '';
                //linea[linea.length] = '';
				linea[linea.length] = oidTipoVia;
            }
			else{
	            linea[linea.length] = oidVia;
                linea[linea.length] = oidTipoVia;//
            }

			linea[linea.length] = oidTipoDireccion;    

			//alert("linea: " + linea);
            listado1.insertar(linea);
            listado1.repinta();

            // ahora borro el form direccion                         

             iSeleccionado = new Array(); 
             iSeleccionado[0] = '';
             set('frmInsertarCliente.comboTipoDireccion',iSeleccionado);

             iSeleccionado2 = new Array(); 
             iSeleccionado2[0] = '';
             set('frmInsertarCliente.comboTipoVia',iSeleccionado2);

             //cvalenzu - 25/10/2006 - ya no existe el combo
			 //ahora existe una caja de texto
			 set("frmInsertarCliente.comboNombreVia",'');   
		     set("frmInsertarCliente.hiddenOidVia",'');
			 //var aCombo = new Array(new Array("",""));
             //set_combo('frmInsertarCliente.cbVia',aCombo, []);

             set("frmInsertarCliente.TextoNombreVia","");
  		     set("frmInsertarCliente.TextoNumeroPrincipal","");
		     set("frmInsertarCliente.TextoCodPostal","");
		     set("frmInsertarCliente.AreaTxtObservaciones",""); 
		     txt_to("lblUnidadesGeograficasXX","");	
			 set("frmInsertarCliente.hidTerritorio","");
			 set("frmInsertarCliente.hidDescTerritorio","");
			 principalObjeto.checked = false;

			 focaliza("frmInsertarCliente.comboTipoDireccion");  
         }
         

         function aniadirFilaClasificacion(){
             /* Inc.23061
			   Si Georeferenciador esta Activo (Geo + Gis):
			   - El grupo clasificación debe incluir una linea con Marca y Canal obligatoriamente
			   - Si además se selecciona TipoCliente entonces Tipo/SubtipoClien y TipoClasi/Clasi son obligatorios todos
			   Si Georeferenciador esta Inactivo (solo Gis):
			   - No es obligatorio insertar una fila en Grupo Clasificacion
			   - Si se desea insertar una fila, todos sus campos son obligatorios */

            if(!sicc_validaciones_generales("grupo1")) { // VALIDACIONES "GRUPO 1" !!
                return false;
			} else {
                var linea = new Array(); 
                
				// Marca y Canal
				var cbMarcaClasificacion    = document.getElementById("comboMarcaClasificacion");
                var cbCanal                 = document.getElementById("comboCanal");
				var strMarcaClasificacion   = cbMarcaClasificacion.options[cbMarcaClasificacion.selectedIndex].text;
                var strCanal                = cbCanal.options[cbCanal.selectedIndex].text;
                var oidMarcaClasificacion   = cbMarcaClasificacion.options[cbMarcaClasificacion.selectedIndex].value;
                var oidCanal                = cbCanal.options[cbCanal.selectedIndex].value;

				var strTipo = '';
				var strSubtipo = '';
				var strTipoClasificacion = '';
                var strClasificacion = '';
                var oidTipoClasificacion = '';
				var oidClasificacion = '';

                var comboTipoCliente        = document.getElementById("cbTipoCliente");
                var tipoClienteSeleccionado = comboTipoCliente.selectedIndex;
				
                if ( (tipoClienteSeleccionado == -1 || tipoClienteSeleccionado == 0) && (get('frmInsertarCliente.usaGeoreferenciador') != "true") ) {
					/* Al no elegir una opcion del combo TipoCliente entonces los otros 3 campos no son obligatorios
					   y sus valores van 'en blanco' como se inicializaron */
                } else {
					if (!sicc_validaciones_generales("grupo2")) { // VALIDACIONES "GRUPO 2" !!
						return false;
					}
					// TipoCliente, SubtipoCliente, TipoClasificacion y Clasificacion
                    var comboSubtipoCliente     = document.getElementById("cbSubtipoCliente");
                    var cbTipoClasificacion     = document.getElementById("comboTipoClasificacion");
                    var cbClasificacion         = document.getElementById("comboClasificacion");
                    strTipo                  = comboTipoCliente.options[comboTipoCliente.selectedIndex].text;
                    strSubtipo               = comboSubtipoCliente.options[comboSubtipoCliente.selectedIndex].text;
					strTipoClasificacion     = cbTipoClasificacion.options[cbTipoClasificacion.selectedIndex].text;
					strClasificacion         = cbClasificacion.options[cbClasificacion.selectedIndex].text;
					oidTipoClasificacion     = cbTipoClasificacion.options[cbTipoClasificacion.selectedIndex].value;
					oidClasificacion         = cbClasificacion.options[cbClasificacion.selectedIndex].value;
				}

				var repetido = false;

                linea[0]  = listado3.generaCodigo('');
                linea[1]  = strMarcaClasificacion;
                linea[2]  = strCanal;
                linea[3]  = strTipo;
                linea[4]  = strSubtipo;
                linea[5]  = strTipoClasificacion;
                linea[6]  = strClasificacion;
                linea[7]  = oidMarcaClasificacion;
                linea[8]  = oidCanal;
                linea[9]  = oidTipoClasificacion;
                linea[10] = oidClasificacion;
                //alert("linea del GrupoClasificacion:_" + linea);

				for(var i =0;i < listado3.datos.length;i++) {
                    if(oidTipoClasificacion == listado3.datos[i][9]){
                        repetido = true;
                    }
                }

                if(!repetido){
                    listado3.insertar(linea);
                    listado3.repinta();
              
                    set('frmInsertarCliente.comboMarcaClasificacion', '-1');
                    var aCombo = new Array(new Array("",""));
                
                    set_combo('frmInsertarCliente.comboClasificacion', aCombo, []);          
                    set_combo('frmInsertarCliente.comboTipoClasificacion', aCombo, []);
                  
					set_combo('frmInsertarCliente.cbSubtipoCliente', aCombo, []);
                    set('frmInsertarCliente.cbTipoCliente', '0'); 
                    cbCanal.value = -1;

					accion("frmInsertarCliente.comboTipoClasificacion", ".disabled=true");
                    accion("frmInsertarCliente.comboClasificacion", ".disabled=true");
                } else {
					// 'MAE-0012' = El tipo de clasificación seleccionado ya se está utilizando para otra clasificación
                    GestionarMensaje('MAE0012');
                }

			}
             
             
			/*if(!sicc_validaciones_generales()){
				//alert("***1");
                 return false;
             }else{
				 //alert("***2");
                 var linea = new Array(); 
                 linea.length = 10;
                      
                 var ComboMarcaClasificacion = document.getElementById("comboMarcaClasificacion");
                 var ComboCanal                = document.getElementById("comboCanal");
                 var ComboTipo                 = document.getElementById("cbTipoCliente");
                 var ComboSubtipo             = document.getElementById("cbSubtipoCliente");
                 var ComboTipoClasi           = document.getElementById("comboTipoClasificacion");
                 var ComboClasi                = document.getElementById("comboClasificacion");
                 
                 var strMarcaClasificacion = ComboMarcaClasificacion.options[ComboMarcaClasificacion.selectedIndex].text;
                 var strCanal                = ComboCanal.options[ComboCanal.selectedIndex].text;
                 var strTipo                 = ComboTipo.options[ComboTipo.selectedIndex].text;
                 var strSubtipo             = ComboSubtipo.options[ComboSubtipo.selectedIndex].text;

				 var strTipoClasificacion;
				 if(ComboTipoClasi.options[ComboTipoClasi.selectedIndex]!=null || ComboTipoClasi.options[ComboTipoClasi.selectedIndex]!=''){
				     strTipoClasificacion  = ComboTipoClasi.options[ComboTipoClasi.selectedIndex].text;
				 }
 
				 var strClasificacion ;
				 var oidClasificacion;
				 if( ComboClasi.value !=null && ComboClasi.value !='' ){
					  strClasificacion = ComboClasi.options[ComboClasi.selectedIndex].text;
					  oidClasificacion      = ComboClasi.options[ComboClasi.selectedIndex].value;
				 }else{
					strClasificacion = '';
					oidClasificacion = '';
				 }

				 var oidMarcaClasificacion = ComboMarcaClasificacion.options[ComboMarcaClasificacion.selectedIndex].value;
                 var oidCanal                = ComboCanal.options[ComboCanal.selectedIndex].value;
				 var oidTipoClasificacion  = ComboTipoClasi.options[ComboTipoClasi.selectedIndex].value;

                 var repetido = false;
                 linea[0] = listado3.generaCodigo('');
                 linea[1] = strMarcaClasificacion;
                 linea[2] = strCanal;
                 linea[3] = strTipo;
                 linea[4] = strSubtipo;
                 linea[5] = strTipoClasificacion;
                 linea[6] = strClasificacion;
                 linea[7] = oidMarcaClasificacion;
                 linea[8] = oidCanal;
                 linea[9] = oidTipoClasificacion;
                 linea[10] = oidClasificacion;
				 //alert("linea: "+linea);

                 for(var i =0;i < listado3.datos.length;i++) {
                    if(oidTipoClasificacion == listado3.datos[i][9]){
                         repetido = true;
                    }
                 }

                 if(!repetido){
                        listado3.insertar(linea);
                        listado3.repinta();
              
                        set('frmInsertarCliente.comboMarcaClasificacion', '-1');
                        var aCombo = new Array(new Array("",""));
                
                        set_combo('frmInsertarCliente.comboClasificacion',aCombo, []);          
                        set_combo('frmInsertarCliente.comboTipoClasificacion',aCombo, []);
                  
                        set_combo('frmInsertarCliente.cbSubtipoCliente',aCombo, []);
                        set('frmInsertarCliente.cbTipoCliente', '-1'); 
                        ComboCanal.value = -1;

                 }else{
                    GestionarMensaje('MAE0012');
                    //  alert('MAE-0012(El tipo de clasificación seleccionado ya se está utilizando para otra clasificación)');
                 }
            }*/

         }

         function aniadirFilaGrupoMarcas(){
              var linea = new Array(); 
              linea.length = 1;
              linea[0] = listado2.generaCodigo('');
              linea[1] = '';
              listado2.insertar(linea);
              listado2.actualizaDat();
           }
    
/*****************************************************************************************************************/


/********************************************Validacion***********************************************************/
            
           function validarInsercionDireccion(){

              var tipoDireccion = document.getElementById('comboTipoDireccion');
              var oidTipoDireccion = tipoDireccion.options[tipoDireccion.selectedIndex].value;
              var cbTipoVia = document.getElementById('comboTipoVia');
              var tipoVia           = cbTipoVia.options[cbTipoVia.selectedIndex].value;
              
              
			  //cvalenzu - 25/10/2006 - Ya no existe el combo, ahora se usa
			  //una caja de texto
			  var via                = get('frmInsertarCliente.comboNombreVia');
			  //var via                = cbVia.options[cbVia.selectedIndex].value;
              

              var nombreVia     = document.getElementById('textoNombreVia');
              var dirPrincipal  = document.getElementById('cbxDireccionPrincipal');
              var nPrincipal    = document.getElementById('TextoNumeroPrincipal');
              var codPostal     = document.getElementById('TextoCodPostal');
              var observaciones = document.getElementById('AreaTxtObservaciones');
              var territorio    = get('frmInsertarCliente.hidTerritorio');
              
                         
              
              if(oidTipoDireccion == ''){
                   GestionarMensaje('1116');
                   focaliza('frmInsertarCliente.comboTipoDireccion');
                   return;
              }

              if(get('frmInsertarCliente.usaGeoreferenciador') == 'true'){

                  if(nombreVia == ''){
                     GestionarMensaje('1117');
                     focaliza('frmInsertarCliente.TextoNombreVia');
                     return;
                  }
              }else{
                  if(tipoVia == ''){
                     GestionarMensaje('1118');
                     focaliza('frmInsertarCliente.comboTipoVia');
                     return;
                  }

                  if((via == '') || (via == "")){
                  
                     GestionarMensaje('1119');					 
					 focaliza('frmInsertarCliente.comboNombreVia');
                     //focaliza('frmInsertarCliente.cbVia');
                     return;
                  }

              }
             
                             
              if(dirPrincipal.checked)
                                     {
                 if(nPrincipal.value != ''){
                     if(fValidarNumero(nPrincipal.value, 200, 0, 9999999)!='OK'){
                                      GestionarMensaje('405'); 
                                      focaliza('frmInsertarCliente.TextoNumeroPrincipal');
                                      return ;
                     }
                  }
                                    

                  if(territorio == ''){
                     GestionarMensaje('1078');
                     focalizaBotonHTML('botonContenido','SeleccionarUnidadesGeograficas');
                     return;
                  }

              
                  
              }else{

                  if(nPrincipal.value!="")
                                              {
                     if(fValidarNumero(nPrincipal.value, 200, 0, 9999999)!='OK'){
                                             GestionarMensaje('405'); 
                                             focaliza('frmInsertarCliente.TextoNumeroPrincipal');
                        return;
                                   }
                        }

                  if(territorio == ''){
                     GestionarMensaje('1078');
                     focalizaBotonHTML('botonContenido','SeleccionarUnidadesGeograficas');
                     return;
                  }
              }

             
              return true;
             
                
           }

         
/*****************************************************************************************************************/



/**********************************Funciones para eliminar filas de los listados**********************************/         

         function eliminarFilaDirecciones(){
            if(listado1.numSelecc() != 0){        
                listado1.eliminarSelecc();          
            }else{
                GestionarMensaje('50');
            }
         }

          function eliminarFilaClasificacion(){
            if(listado3.numSelecc() != 0){
                listado3.eliminarSelecc();          
            }else{
                GestionarMensaje('50');
            }
         }

         function eliminarFilaGrupoMarcas(){
            if(!listado2.numSelecc() == 0){ 
                listado2.actualizaDat();
                 //alert('antes del primero' + listado3.datos);
                 //listado3.eliminar(1, 1);
                 //alert('paso al segundo' + listado3.datos);
                 //listado3.eliminar(0, 1);
                verificarListadoClasificaciones();
                listado2.eliminarSelecc();
                set('frmInsertarCliente.comboCanal', '');
                set('frmInsertarCliente.comboTipoClasificacion', '');
                var aCombo = new Array(new Array("",""));
                set_combo('frmInsertarCliente.comboClasificacion',aCombo, []);                
                recargaComboMarcaClasificacion();
            }else{
                GestionarMensaje('50');
            }  
         }
/*****************************************************************************************************************/

         function verificarListadoClasificaciones(){
           arr = new Array();
           arrMarcas = new Array();
           arr = listado2.codSeleccionados();

           for(var x=0;x<arr.length;x++){
                
              //var ComboMarca  = document.getElementById("comboMarca_" + arr[x]);
              var dato = listado2.extraeDato(arr[x], 0);
              arrMarcas[arrMarcas.length] = dato;
              
           }     
           var datos = listado3.datos;
           var nuevoDatos = new Array();

           for (var j = 0; j < datos.length; j++){ 
             for (var i = 0; i < arrMarcas.length; i++){
                if (arrMarcas[i] == datos[j][7]){
                    // Agregar codigo a nuevoDatos.
                    nuevoDatos[nuevoDatos.length] = datos[j][0];
                }
             }
           }
  

           for (var i = nuevoDatos.length-1; i >= 0 ; i--){
              listado3.eliminar(nuevoDatos[i], 1);
           }
         }
/************************************************Procesos diversos************************************************/

         function accionP2DesdeP3(){
            recolectarValor();
            recolectarValorMarca();
            duplicarValores();
                
                   //set('frmInsertarCliente.accion','BackPestania2');
            set('frmInsertarClienteVolver.accion','siguiente1_validar');//Validar
		    set('frmInsertarClienteVolver.conectorAction','LPInsertarClienteBasico');
		    set('frmInsertarClienteVolver.envia','Pag3');
            set('frmInsertarClienteVolver.hidFocusPrimerComponente', 'false');
            enviaSICC('frmInsertarClienteVolver'); 
                }  

         function duplicarValores(){
            set('frmInsertarClienteVolver.accion', get('frmInsertarCliente.accion'));
            set('frmInsertarClienteVolver.conectorAction', get('frmInsertarCliente.conectorAction'));
            set('frmInsertarClienteVolver.casoDeUso', get('frmInsertarCliente.casoDeUso'));
            set('frmInsertarClienteVolver.cbTipo', get('frmInsertarCliente.cbTipo'));
            set('frmInsertarClienteVolver.cbSTipo', get('frmInsertarCliente.cbSTipo'));
            set('frmInsertarClienteVolver.nameComboSelected', get('frmInsertarCliente.nameComboSelected'));
            set('frmInsertarClienteVolver.valueComboSelected', get('frmInsertarCliente.valueComboSelected'));
            set('frmInsertarClienteVolver.usaGeoreferenciador', get('frmInsertarCliente.usaGeoreferenciador'));
            set('frmInsertarClienteVolver.hidPais', get('frmInsertarCliente.hidPais'));
            set('frmInsertarClienteVolver.hidIdioma', get('frmInsertarCliente.hidIdioma'));
            set('frmInsertarClienteVolver.hidTerritorio', get('frmInsertarCliente.hidTerritorio'));
            set('frmInsertarClienteVolver.hidDescTerritorio', get('frmInsertarCliente.hidDescTerritorio'));
            set('frmInsertarClienteVolver.elementosP3', get('frmInsertarCliente.elementosP3'));
            set('frmInsertarClienteVolver.elementosP3Marca', get('frmInsertarCliente.elementosP3Marca'));
            set('frmInsertarClienteVolver.elementosExtra', get('frmInsertarCliente.elementosExtra'));
            set('frmInsertarClienteVolver.primeraVez', get('frmInsertarCliente.primearVez'));
            set('frmInsertarClienteVolver.envia', get('frmInsertarCliente.envia'));
            set('frmInsertarClienteVolver.errCodigo', get('frmInsertarCliente.errCodigo'))
            set('frmInsertarClienteVolver.errDescripcion', get('frmInsertarCliente.errDescripcion'));
            set('frmInsertarClienteVolver.hidFocusPrimerComponente', get('frmInsertarCliente.hidFocusPrimerComponente')); 
         }

         function seleccionarTerritorioFunc() {   
                   // Selleccionamos Territorio

            var obj = new Object();
            obj.casoDeUso = "clienteBasico";
            var vWnd = mostrarModalSICC('LPSeleccionTerritorio','clienteBasico',obj,490,518);
                   if (vWnd != null && vWnd != "") {
                             oidTerr = vWnd[0];
                             set('frmInsertarCliente.hidTerritorio', vWnd[0]);
                                           strTerritorio = vWnd[1];
                                           set('frmInsertarCliente.hidDescTerritorioOLD', vWnd[1])
                                           set('frmInsertarCliente.hidDescTerritorio', vWnd[2])

                //scs, inc: BELC300022030  / 803   
                //txt_to('lblUnidadesGeograficasXX',get('frmInsertarCliente.hidDescTerritorioOLD'));         
				txt_to('lblUnidadesGeograficasXX',get('frmInsertarCliente.hidDescTerritorio'));         

                   }
         }

         function procesoGeoTrue(){

           //en el listado mostramos la columna nombre via y ocultamos via y tipovia
            //listado1.alternaVerColumna(2,false);
            listado1.alternaVerColumna(4,false);
            document.all["capaComboTipoVia"].style.visibility = 'visible';
            document.all["capalblTipoVia"].style.visibility = 'visible';
            document.all["capaTextoNombreVia"].style.visibility = 'visible';
            document.all["capalblNombreVia"].style.visibility = 'visible';
            document.all["capaComboVia"].style.visibility = 'hidden';
            document.all["capalblVia"].style.visibility = 'hidden';
            
         }

         function procesoGeoFalse(){

            //en el listado ocultamos la columna nombre via y mostramos via y tipo via
            listado1.alternaVerColumna(3,false);
            document.all["capaComboTipoVia"].style.visibility = 'visible';
            document.all["capalblTipoVia"].style.visibility = 'visible';
            document.all["capaTextoNombreVia"].style.visibility = 'hidden';
            document.all["capalblNombreVia"].style.visibility = 'hidden';
            document.all["capaComboVia"].style.visibility = 'visible';
            document.all["capalblVia"].style.visibility = 'visible';
			accion('frmInsertarCliente.comboNombreVia', '.disabled=true');             
         }

      /**************************************Recolecta valores******************************************/

      function recolectarValor(){
                 // obtengo datos de lista 1
                 var datosLista1= new String();
        //  var indices = new String();
              //  indices = "indices_direcciones=";
          
                        
                 for(var x=0;x<listado1.datos.length;x++){
          

        //    indices = indices + x + ",";

            datosLista1 = datosLista1 + 'h_Territorio_' + x +  '=' + listado1.datos[x][10] + ';'; //14
            datosLista1 = datosLista1 + 'h_TerritorioDesc_' + x +  '=' + listado1.datos[x][1] + ';';
            datosLista1 = datosLista1 + 'h_comboTipoDireccion_' + x +  '=' + listado1.datos[x][13] + ';';//15
			datosLista1 = datosLista1 + 'h_comboTipoVia_' + x +  '=' + listado1.datos[x][12]+ ';';//16
			//Cleal
			datosLista1 = datosLista1 + 'h_DescripcionTipoVia_' + x +  '=' + listado1.datos[x][3]+ ';';

		    if(get('frmInsertarCliente.usaGeoreferenciador')=='true'){
				//datosLista1 = datosLista1 + 'h_TextoNombreVia_' + x +  '=' + listado1.datos[x][3] + ';';
				datosLista1 = datosLista1 + 'h_TextoNombreVia_' + x +  '=' + listado1.datos[x][4] + ';';
								
		    }else{
				  //Cleal Mae-03
				  //datosLista1 = datosLista1 + 'h_comboTipoVia_' + x +  '=' + listado1.datos[x][12]+ ';';//16
				  datosLista1 = datosLista1 + 'h_comboNombreVia_' + x +  '=' + listado1.datos[x][11]+ ';';//17
				  //datosLista1 = datosLista1 + 'h_DescripcionTipoVia_' + x +  '=' + listado1.datos[x][3]+ ';';
				  datosLista1 = datosLista1 + 'h_DescripcionVia_' + x +  '=' + listado1.datos[x][5]+ ';';
				}
                                  
            datosLista1 = datosLista1 + 'h_DescripcionDireccion_' + x +  '=' + listado1.datos[x][2]+ ';';
			datosLista1 = datosLista1 + 'h_TextoNumeroPrincipal_' + x +  '=' + listado1.datos[x][6]+ ';';
	 	    datosLista1 = datosLista1 + 'h_TextoCodPostal_' + x +  '=' + listado1.datos[x][7]+ ';';
		    datosLista1 = datosLista1 + 'h_AreaTxtObservaciones_' + x +  '=' + listado1.datos[x][8]+ ';';//12
		    datosLista1 = datosLista1 + 'h_cbxDireccionPrincipal_' + x +  '=' + listado1.datos[x][9]+ ';';//13
            
            
            
                             }	

         set('frmInsertarCliente.elementosP3', datosLista1);

         var datosLista2 = new String();

                for(var xxx=0;xxx<listado2.datos.length;xxx++){
                          var ComboMarca =document.getElementById("comboMarca_" + xxx);

                          if(ComboMarca.value!="-1"){
                                    datosLista2 = datosLista2 +  'h_comboMarca_' + xxx + '=' + ComboMarca.value + ';';
                          }
                }
         //alert("datos de lista de marcas " + datosLista2);

                set('frmInsertarCliente.elementosExtra', datosLista2);
         //alert('lista' + get('frmInsertarCliente.elementosExtra'));
         
            }

     function recolectarValorMarca(){
                           var datosLista3= new String();
                           for(var xx=0;xx<listado3.datos.length;xx++){
                                    datosLista3 = datosLista3 + 'h_DescripcionMarcaClasificacion_' + xx + '=' + listado3.datos[xx][1] + ';';
                                    datosLista3 = datosLista3 + 'h_DescripcionCanalClasificacion_' + xx + '=' + listado3.datos[xx][2] + ';';
         datosLista3 = datosLista3 + 'h_DescripcionTipo_' + xx + '=' + listado3.datos[xx][3] + ';';
                                    datosLista3 = datosLista3 + 'h_DescripcionSubtipo_' + xx + '=' + listado3.datos[xx][4] + ';';
                                    datosLista3 = datosLista3 + 'h_DescripcionTipoClasificacion_' + xx + '=' + listado3.datos[xx][5] + ';';
                                    datosLista3 = datosLista3 + 'h_DescripcionClasificacion_' + xx + '=' + listado3.datos[xx][6] + ';';
                                    datosLista3 = datosLista3 + 'h_comboMarcaClasificacion_' + xx + '=' + listado3.datos[xx][7] + ';';
                                    datosLista3 = datosLista3 + 'h_comboCanal_' + xx + '=' + listado3.datos[xx][8] + ';';
                                    datosLista3 = datosLista3 + 'h_comboTipoClasificacion_' + xx + '=' + listado3.datos[xx][9] + ';';
                                    datosLista3 = datosLista3 + 'h_comboClasificacion_' + xx + '=' + listado3.datos[xx][10] + ';';
                           }
                           set('frmInsertarCliente.elementosP3Marca', datosLista3);


                           listado2.actualizaDat();
                           var datosLista2=new String();
/*						   alert("listado2.datos: "+listado2.datos);
  						   alert("listado2.datos: "+listado2.datos.length);
						   if(listado2.datos.length == 1 && listado2.datos[0][1]!=""){*/

							   for(var xx=0;xx<listado2.datos.length;xx++){
										//alert(listado2.datos[xx][1]);
										datosLista2 = datosLista2 + 'h_MarcaListado2_' + xx + '=' + listado2.datos[xx][1] + ';';				
							   }
						  // }
                           //alert(datosLista2);
                           set('frmInsertarCliente.elementosP3MarcaListado2', datosLista2);
     }

	 function validarMarca(){
//		alert('en validar marca');
		for(var t=0;t<listado2.datos.length;t++){
			var cbMarc = document.getElementById("comboMarca_" + t);
			//alert('entro a validar marca ' + cbMarc.value);
			if(cbMarc.value == ''){
				//alert("Marca vacia");
				GestionarMensaje("63");
				cbMarc.focus();
				return false;
			}
		}
		

		return true;
}

	function validaClasificacion(){
		if(!sicc_validaciones_generales()){
//			GestionarMensaje("MAE0010");
			document.getElementById("comboMarcaClasificacion").focus();
			return false;
		} else return true;


		if(listado2.datos.length==0){
		////alert("MAE-0010 (El cliente debe tener por lo menos una linea de clasificacion)");
		GestionarMensaje("MAE0010");
		document.getElementById("comboMarca").focus();
		return false;
	}
	
	}

     function fLimpiar(){
         listado1.setDatos(new Array());
         listado2.setDatos(new Array());
         listado3.setDatos(new Array());
         recargaComboMarcaClasificacion();

		 //cvalenzu - 25/10/2006
		 //se reemplazo el combo por una caja de texto
         //var aCombo = new Array(new Array("",""));
         //set_combo('frmInsertarCliente.cbVia',aCombo, []);
	     set("frmInsertarCliente.comboNombreVia",'');   
		 set("frmInsertarCliente.hiddenOidVia",'');
     }

    function fGuardar(){
        //alert('esta en fguardar');
              if(validarPestanya3()){
                         //alert('Validacion termino con exito');
              }else{
                	//alert('Validacion termino con error');
                      return false;
              }
              recolectarValor();
        recolectarValorMarca();
        set('frmInsertarCliente.accion','Guardar');
              set('frmInsertarCliente.conectorAction','LPInsertarClienteBasico');
              eval('frmInsertarCliente').oculto = 'S';
              enviaSICC('frmInsertarCliente','' ,'','N');
    }

         function reiniciarCasoDeUso(){
              eval('frmInsertarCliente').oculto = 'N';
              set('frmInsertarCliente.accion','');
        set('frmInsertarCliente.conectorAction','LPInsertarClienteBasico');
        
        enviaSICC('frmInsertarCliente','' ,'','N');
                  
         }

    function validarPestanya3() {
        var largoListado3 = listado3.datos.length;  // Grupo Clasificacion
        
        if (validarHayDireccionPrincipal()) { 
            if (validarUnaSolaDireccionPrincipal()) {
			    if (!validarMarca()) {
				    return false;
				} 
                
				if(largoListado3 == 0 && get("frmInsertarCliente.usaGeoreferenciador") != "true") {
                    GestionarMensaje('MAE0010'); // MAE-0010 (El cliente debe tener por lo menos una linea de clasificacion)
                    return false;
                } else {
                    return true;
                }
           } else {
               GestionarMensaje('1130');
               return false;
           }
        
        } else {
            GestionarMensaje('1079');
            return false;
        }
    }

    function validarHayDireccionPrincipal(){
          //var res = false;
          //alert('esta en valida dir');
          var resind;// indice direccion completa
          var cont = 0;
          var siI18N = GestionarMensaje("84");   
          for(var f=0;f<listado1.datos.length;f++){
                   // if(listado1.datos[f][13]==siI18N){
                                             if(listado1.datos[f][9]==siI18N){
                    //alert('esta dentro del for dentro del if');
                              resind=f;
                              return true;
                    }
                    
          }
          
      
    }

     function validarUnaSolaDireccionPrincipal(){
          //var res = false;
         // alert('esta en valida dir');
          var resind;// indice direccion completa
          var cont = 0;
          var siI18N = GestionarMensaje("84");   
          for(var f=0;f<listado1.datos.length;f++){
//                    if(listado1.datos[f][13]==siI18N){
                                             if(listado1.datos[f][9]==siI18N){
                  //  alert('esta dentro del for dentro del if');
                              //res =true;
                                 cont = cont + 1;
                                // alert('el contador es: ' + cont);
                    }
                    
          }
          
          if(cont > 1 ){
           //  alert('es mayor a 1');
             return false;
          }else{
             resind=f;
             return true;
          }
        //   alert('contador ' + cont);
    }
   

   function cerrarVentana2(oidCliente, codigoCliente, oitTipoCliente) {
//                alert("Se va a cerrar la ventana");
                  var arr = new Array();
                  arr[0] = codigoCliente;
                  arr[1] = oidCliente;
                  arr[2] = oitTipoCliente;
//                alert("array: " + arr);
                  window.returnValue = arr;
//                alert("array: " + arr);
                  window.close();
   }


   //--------------------------------------------------------------------------------------------------------------------
/*Se agrega la busqueda de via dado que cuando intenta cargar el combo con muchos registros el sistema se paraliza
cvalenzu 25/10/2006
*/

function buscarVia(){
	var tipoVia = get("frmInsertarCliente.comboTipoVia") ;

	if(tipoVia != ''){
		 var datos= new Object();
		 var arr = new Array();
		 arr[arr.length] = ["codigoVia", tipoVia[0]];

         datos.dto = "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOGenBusquedaVias";
         datos.conector = "ConectorGENBusquedaProducto";
		 datos.buscarInicio = true;
		 datos.array = arr;
		 datos.esMultiple=false;
         var salida = abrirBusquedaGenerica(datos, "","0075");
         var oid = "";
         var descripcion = "";
         if(salida){
                  oid = salida[0][0];
                  descripcion = salida [0][2];
         }
         set('frmInsertarCliente.hiddenOidVia',oid);
         set('frmInsertarCliente.comboNombreVia',descripcion);	
      }
}


//cvalenzu - ya no se recarga el combo via, ahora existe una caja de texto
//que siempre estara deshabilitada y un boton buscar
/*function recargaVia(){
	var arr = new Array();
    arr[arr.length] = new Array("oid", get('frmInsertarCliente.comboTipoVia'));
    arr[arr.length] = new Array("oidPais", get('frmInsertarCliente.hidPais'));
    arr[arr.length] = new Array("oidIdioma", get('frmInsertarCliente.hidIdioma'));
    recargaCombo('frmInsertarCliente.cbVia', 'MAERecargarVias', 'es.indra.sicc.util.DTOOID', arr);                          
}*/

function recargaVia(){
    set("frmInsertarCliente.comboNombreVia",'');   
    set("frmInsertarCliente.hiddenOidVia",'');
}
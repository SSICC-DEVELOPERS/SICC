var banderaRegion = false;
  var banderaZona = false;
  var banderaSeccion = false;
  
  function onLoad(){  
    configurarMenuSecundario('Formulario');  
    DrdEnsanchaConMargenDcho('listado1',24);

    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["primera1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
    
    ocultarListaBase();    
    cargarLabels();
    cargarNivelesPremios();
    validarDirigidoA();
   }
   
   function ocultarListaBase(){   
        DrdEnsanchaConMargenDcho('listado2',12);
        document.all["Cplistado2"].style.visibility='hidden';
        document.all["CpLin1listado2"].style.visibility='hidden';
        document.all["CpLin2listado2"].style.visibility='hidden';
        document.all["CpLin3listado2"].style.visibility='hidden';
        document.all["CpLin4listado2"].style.visibility='hidden';    
        document.all["primera2Div"].style.visibility='hidden';
        document.all["ret2Div"].style.visibility='hidden';
        document.all["ava2Div"].style.visibility='hidden';
        document.all["separa2Div"].style.visibility='hidden';
        document.all["btnGanadoras2Div"].style.visibility='hidden';
        eval (ON_RSZ);      
   }
   
   function mostrarListaBase(){   
        DrdEnsanchaConMargenDcho('listado2',12);
        document.all["Cplistado2"].style.visibility='';
        document.all["CpLin1listado2"].style.visibility='';
        document.all["CpLin2listado2"].style.visibility='';
        document.all["CpLin3listado2"].style.visibility='';
        document.all["CpLin4listado2"].style.visibility='';    
        document.all["primera2Div"].style.visibility='';
        document.all["ret2Div"].style.visibility='';
        document.all["ava2Div"].style.visibility='';
        document.all["separa2Div"].style.visibility='';
        document.all["btnGanadoras2Div"].style.visibility='';
        eval (ON_RSZ);     
   }
   
//------------------------------------------------------------------------------
   function validarDirigidoA(){
      var diriParam = get('Formulario.oidDirigidoA');
      var diriCte   = get('Formulario.dirigidoGte');
      
      if(diriParam == diriCte){
         accion('Formulario.cbNivelAgregacion', '.disabled=false');
		 
		 //Agregado por Cristian Valenzuela - 2/5/2006 - DBLG500000181
		 var oidConcurso = get('Formulario.oidConcurso');
         var pais = get('Formulario.pais');
         var arr = new Array();
             
         arr[arr.length] = ['oidConcurso', oidConcurso];
         arr[arr.length] = ['oidPais', pais];
       
         recargaCombo('Formulario.cbSubgerenciaVentas', 'INCObtenerSGVConcursoAmbito', 'es.indra.sicc.dtos.inc.DTOAmbitRC',  arr);
 		 //FIN - Agregado por Cristian Valenzuela - 2/5/2006 - DBLG500000181
      }
	  else{
         accion('Formulario.cbNivelAgregacion', '.disabled=true');
      }      
   }

//------------------------------------------------------------------------------

   function cargarLabels(){
      var concurso = get('Formulario.descConcurso');
      var version = get('Formulario.version');
      var valorCalculo = get('Formulario.descValorCalculo');
      var baseCalculo = get('Formulario.descBaseCalculo');
      
      txt_to('lbldtNumConcurso', concurso);
      txt_to('lbldtVersion', version);
      txt_to('lbldtValorCalculo', valorCalculo);
      txt_to('lbldtBaseCalculo', baseCalculo);   
      
   
   }
//------------------------------------------------------------------------------

  function cargarNivelesPremios(){
      var concurso = get('Formulario.oidConcurso');
      var arr = new Array();
      
      arr[arr.length] = ['oid', concurso];
      
      configurarPaginado(mipgndo, "INCRecuperarNivelesPremios", "ConectorRecuperarNivelesPremios", "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado", arr);
   
   }

//------------------------------------------------------------------------------   
//Funcion modificada por Cristian Valenzuela
//Incidencia DBLG500000181 - 2/5/2006
   function onchangeAgrupacion(){
      /*var agGeneral = get('Formulario.agrupacionGeneral');
      var agSgv     = get('Formulario.agrupacionSGV');
      var agRegion  = get('Formulario.agrupacionRegion');
      var agZona    = get('Formulario.agrupacionZona');
      var agSeccion = get('Formulario.agrupacionSeccion');
      
      var agrupacion = get('Formulario.cbNivelAgregacion');
          
      if(agrupacion == agGeneral){        
         var aCombo = new Array(new Array("",""));
         set_combo('Formulario.cbSubgerenciaVentas', aCombo, []);
         set_combo('Formulario.cbRegion', aCombo, []);
         set_combo('Formulario.cbZona', aCombo, []);
         set_combo('Formulario.cbSeccion', aCombo, []);
         set_combo('Formulario.cbTerritorio', aCombo, []);
         
         accion('Formulario.cbSubgerenciaVentas', '.disabled=true');
         accion('Formulario.cbRegion', '.disabled=true');
         accion('Formulario.cbZona', '.disabled=true');
         accion('Formulario.cbSeccion', '.disabled=true');
         accion('Formulario.cbTerritorio', '.disabled=true');
         return;         
      }
      
      if(agrupacion == agSgv){
               
         var aCombo = new Array(new Array("",""));
         set_combo('Formulario.cbSubgerenciaVentas', aCombo, []);
         set_combo('Formulario.cbRegion', aCombo, []);
         set_combo('Formulario.cbZona', aCombo, []);
         set_combo('Formulario.cbSeccion', aCombo, []);
         set_combo('Formulario.cbTerritorio', aCombo, []);
         
         accion('Formulario.cbSubgerenciaVentas', '.disabled=false');
         accion('Formulario.cbRegion', '.disabled=true');
         accion('Formulario.cbZona', '.disabled=true');
         accion('Formulario.cbSeccion', '.disabled=true');
         accion('Formulario.cbTerritorio', '.disabled=true');
         
         var oidConcurso = get('Formulario.oidConcurso');
         var pais = get('Formulario.pais');
         var arr = new Array();
             
         arr[arr.length] = ['oidConcurso', oidConcurso];
         arr[arr.length] = ['oidPais', pais];
       
         recargaCombo('Formulario.cbSubgerenciaVentas', 'INCObtenerSGVConcursoAmbito', 'es.indra.sicc.dtos.inc.DTOAmbitRC',  arr);
         
         
         banderaRegion = true;
         return;
       }
      
      if(agrupacion == agRegion){
         var aCombo = new Array(new Array("",""));
         set_combo('Formulario.cbSubgerenciaVentas', aCombo, []);
         set_combo('Formulario.cbRegion', aCombo, []);
         set_combo('Formulario.cbZona', aCombo, []);
         set_combo('Formulario.cbSeccion', aCombo, []);
         set_combo('Formulario.cbTerritorio', aCombo, []);
         
         accion('Formulario.cbSubgerenciaVentas', '.disabled=false');
         accion('Formulario.cbRegion', '.disabled=false');
         accion('Formulario.cbZona', '.disabled=true');
         accion('Formulario.cbSeccion', '.disabled=true');
         accion('Formulario.cbTerritorio', '.disabled=true');
         
         var oidConcurso = get('Formulario.oidConcurso');
         var pais = get('Formulario.pais');
         var arr = new Array();
             
         arr[arr.length] = ['oidConcurso', oidConcurso];
         arr[arr.length] = ['oidPais', pais];
       
         recargaCombo('Formulario.cbSubgerenciaVentas', 'INCObtenerSGVConcursoAmbito', 'es.indra.sicc.dtos.inc.DTOAmbitRC',  arr);
         
         banderaRegion = false;
         banderaZona = true;
         return;

      }
      
      if(agrupacion == agZona){
      
         var aCombo = new Array(new Array("",""));
         set_combo('Formulario.cbSubgerenciaVentas', aCombo, []);
         set_combo('Formulario.cbRegion', aCombo, []);
         set_combo('Formulario.cbZona', aCombo, []);
         set_combo('Formulario.cbSeccion', aCombo, []);
         set_combo('Formulario.cbTerritorio', aCombo, []);
         
         accion('Formulario.cbSubgerenciaVentas', '.disabled=false');
         accion('Formulario.cbRegion', '.disabled=false');
         accion('Formulario.cbZona', '.disabled=false');
         accion('Formulario.cbSeccion', '.disabled=true');
         accion('Formulario.cbTerritorio', '.disabled=true');
         
         var oidConcurso = get('Formulario.oidConcurso');
         var pais = get('Formulario.pais');
         var arr = new Array();
             
         arr[arr.length] = ['oidConcurso', oidConcurso];
         arr[arr.length] = ['oidPais', pais];
       
         recargaCombo('Formulario.cbSubgerenciaVentas', 'INCObtenerSGVConcursoAmbito', 'es.indra.sicc.dtos.inc.DTOAmbitRC',  arr);
         
         banderaRegion = false;
         banderaZona = false;
         banderaSeccion = true;
         return;
      }
      
      if(agrupacion == agSeccion){
         
         var aCombo = new Array(new Array("",""));
         set_combo('Formulario.cbSubgerenciaVentas', aCombo, []);
         set_combo('Formulario.cbRegion', aCombo, []);
         set_combo('Formulario.cbZona', aCombo, []);
         set_combo('Formulario.cbSeccion', aCombo, []);
         set_combo('Formulario.cbTerritorio', aCombo, []);
         
         accion('Formulario.cbSubgerenciaVentas', '.disabled=false');
         accion('Formulario.cbRegion', '.disabled=false');
         accion('Formulario.cbZona', '.disabled=false');
         accion('Formulario.cbSeccion', '.disabled=false');
         accion('Formulario.cbTerritorio', '.disabled=false');
         
         var oidConcurso = get('Formulario.oidConcurso');
         var pais = get('Formulario.pais');
         var arr = new Array();
             
         arr[arr.length] = ['oidConcurso', oidConcurso];
         arr[arr.length] = ['oidPais', pais];
       
         recargaCombo('Formulario.cbSubgerenciaVentas', 'INCObtenerSGVConcursoAmbito', 'es.indra.sicc.dtos.inc.DTOAmbitRC',  arr);
         
         banderaRegion = false;
         banderaZona = false;
         banderaSeccion = false;
         return;
      }
      
      var aCombo = new Array(new Array("",""));
      set_combo('Formulario.cbSubgerenciaVentas', aCombo, []);
      set_combo('Formulario.cbRegion', aCombo, []);
      set_combo('Formulario.cbZona', aCombo, []);
      set_combo('Formulario.cbSeccion', aCombo, []);
      set_combo('Formulario.cbTerritorio', aCombo, []);
      
      accion('Formulario.cbSubgerenciaVentas', '.disabled=false');
      accion('Formulario.cbRegion', '.disabled=false');
      accion('Formulario.cbZona', '.disabled=false');
      accion('Formulario.cbSeccion', '.disabled=false');
      accion('Formulario.cbTerritorio', '.disabled=false');
      
      var oidConcurso = get('Formulario.oidConcurso');
      var pais = get('Formulario.pais');
      var arr = new Array();
             
      arr[arr.length] = ['oidConcurso', oidConcurso];
      arr[arr.length] = ['oidPais', pais];
       
      recargaCombo('Formulario.cbSubgerenciaVentas', 'INCObtenerSGVConcursoAmbito', 'es.indra.sicc.dtos.inc.DTOAmbitRC',  arr);   */
   }

//------------------------------------------------------------------------------   
   //(BELC300023779)
   function onchangeSGV(){      
      if(banderaRegion){
         return;
      } else{
         opciones = new Array();                 
         set_combo('Formulario.cbZona',opciones);                      
         set_combo('Formulario.cbSeccion',opciones);                      
         set_combo('Formulario.cbTerritorio',opciones);    
      
         if(get('Formulario.cbSubgerenciaVentas')!=''){
            recargaCombo('Formulario.cbRegion', 'INCObtenerConcursoAmbito', 
              'es.indra.sicc.dtos.inc.DTOAmbitRC', [['oidPais', get('Formulario.pais')], ['oidIdioma', get('formulario.hIdioma')],
              ['oidConcurso', get('Formulario.oidConcurso')], ['oidsSvg', get('Formulario.cbSubgerenciaVentas')]]);
            
         } else {            
            set_combo('Formulario.cbRegion',opciones);     
         }
      }
   }

//------------------------------------------------------------------------------   

   //(BELC300023779)
   function onchangeRegion(){   
      if(banderaZona){
         return;
     } else{
         opciones = new Array();                   
         set_combo('Formulario.cbSeccion',opciones);                      
         set_combo('Formulario.cbTerritorio',opciones);    
      
         if(get('Formulario.cbRegion')!=''){
            recargaCombo('Formulario.cbZona', 'INCObtenerConcursoAmbito', 
              'es.indra.sicc.dtos.inc.DTOAmbitRC', [['oidPais', get('Formulario.pais')], ['oidIdioma', get('formulario.hIdioma')],
              ['oidConcurso', get('Formulario.oidConcurso')], ['oidsRegion', get('Formulario.cbRegion')]]);
            
         } else {            
            set_combo('Formulario.cbZona',opciones);      
         }
      }
   }

//------------------------------------------------------------------------------   

   function onchangeZona(){
      if(banderaSeccion){
         return;
      } else{   
         opciones = new Array();                        
         set_combo('Formulario.cbTerritorio',opciones);    
      
         if(get('Formulario.cbZona')!=''){
            recargaCombo('Formulario.cbSeccion', 'INCObtenerConcursoAmbito', 
              'es.indra.sicc.dtos.inc.DTOAmbitRC', [['oidPais', get('Formulario.pais')], ['oidIdioma', get('formulario.hIdioma')],
              ['oidConcurso', get('Formulario.oidConcurso')], ['oidsZona', get('Formulario.cbZona')]]);
            
         } else {            
            set_combo('Formulario.cbSeccion',opciones);        
         }
      }
   }
//------------------------------------------------------------------------------   

   //BELC300023779
   function onchangeSeccion(){   
     opciones = new Array();   
  
     if(get('Formulario.cbSeccion')!=''){
        recargaCombo('Formulario.cbTerritorio', 'INCObtenerConcursoAmbito', 
          'es.indra.sicc.dtos.inc.DTOAmbitRC', [['oidPais', get('Formulario.pais')], ['oidIdioma', get('formulario.hIdioma')],
          ['oidConcurso', get('Formulario.oidConcurso')], ['oidsSeccion', get('Formulario.cbSeccion')]]);
        
     } else {            
        set_combo('Formulario.cbTerritorio',opciones);        
     }
   }   
   
//------------------------------------------------------------------------------   

 function calcularOnclick(){
      //declaro las variables para ver si voy a una accion u otra del CU
      var  cteVarVenta = get('Formulario.variablesVenta');
      var  oidValorCalculo = get('Formulario.oidValorCalculo');
      
          
      if(oidValorCalculo == cteVarVenta){
         var nivelAgrupacion  = get('Formulario.cbNivelAgregacion') ;
         var constanteSGV     = get('Formulario.agrupacionSGV');
         var constanteRegion  = get('Formulario.agrupacionRegion');
         var constanteZona    = get('Formulario.agrupacionZona');
         var constanteSeccion = get('Formulario.agrupacionSeccion');
         var agrupacionGeneral = get('Formulario.agrupacionGeneral');
         
         sicc_cambiar_estado('textNumAspirantes', true);
         sicc_cambiar_estado('cbNivelAgregacion', true);

        /* vbongiov -- No depende del nivel de agrupacion 
        if(nivelAgrupacion == agrupacionGeneral){
            sicc_cambiar_estado('cbSubgerenciaVentas', false);
            sicc_cambiar_estado('cbRegion', false);
            sicc_cambiar_estado('cbZona', false);
            sicc_cambiar_estado('cbSeccion', false);
            sicc_cambiar_estado('cbTerritorio', false);
         }
          
         if(nivelAgrupacion == constanteSGV){
            sicc_cambiar_estado('cbSubgerenciaVentas', true);
            sicc_cambiar_estado('cbRegion', false);
            sicc_cambiar_estado('cbZona', false);
            sicc_cambiar_estado('cbSeccion', false);
            sicc_cambiar_estado('cbTerritorio', false);
         }
         
         if(nivelAgrupacion == constanteRegion){
            sicc_cambiar_estado('cbSubgerenciaVentas', true);
            sicc_cambiar_estado('cbRegion', true);
            sicc_cambiar_estado('cbZona', false);
            sicc_cambiar_estado('cbSeccion', false);
            sicc_cambiar_estado('cbTerritorio', false);
         }
         
         if(nivelAgrupacion == constanteZona){
            sicc_cambiar_estado('cbSubgerenciaVentas', true);
            sicc_cambiar_estado('cbRegion', true);
            sicc_cambiar_estado('cbZona', true);
            sicc_cambiar_estado('cbSeccion', false);
            sicc_cambiar_estado('cbTerritorio', false);
         }
         
         if(nivelAgrupacion == constanteSeccion){
            sicc_cambiar_estado('cbSubgerenciaVentas', true);
            sicc_cambiar_estado('cbRegion', true);
            sicc_cambiar_estado('cbZona', true);
            sicc_cambiar_estado('cbSeccion', true);
            sicc_cambiar_estado('cbTerritorio', true);
         }*/
      
         if(sicc_validaciones_generales()){
             var a = new Object();
                     
             a.accion      = 'resultadosRankingGerentes';
             a.oidConcurso = get('Formulario.oidConcurso');
             a.sgv         = get('Formulario.cbSubgerenciaVentas');
             a.region      = get('Formulario.cbRegion');
             a.zona        = get('Formulario.cbZona');
             a.seccion     = get('Formulario.cbSeccion');
             a.territorio  = get('Formulario.cbTerritorio');
             a.oidNivelAgrupacion = nivelAgrupacion;
             a.numAspi = get('Formulario.textNumAspirantes');

			 a.tipoRanking = get('Formulario.oidTipoRanking');
             
             mostrarModalSICC('LPMantenimientoRanking','resultadosRankingGerentes', a);  
         }
      }else{
         var arr  = new Array();
         
         var pais = get('Formulario.pais');
         var oidConcurso = get('Formulario.oidConcurso');
         var oidSGV = get('Formulario.cbSubgerenciaVentas');
         var oidRegion = get('Formulario.cbRegion');
         var oidZona = get('Formulario.cbZona');
         var oidSeccion = get('Formulario.cbSeccion');
         var oidTerritorio = get('Formulario.cbTerritorio');
         var oidNivelAgrupacion = get('Formulario.cbNivelAgregacion');
         var numAspi = get('Formulario.textNumAspirantes');
		 var tipoRanking = get('Formulario.oidTipoRanking');
         
         
         arr[arr.length] = ["oidPais", pais];
         arr[arr.length] = ["oidConcurso", oidConcurso];
         /* No utilizado 
         arr[arr.length] = ["oidSGV", oidSGV];
         arr[arr.length] = ["oidRegion", oidRegion];
         arr[arr.length] = ["oidZona", oidZona];
         arr[arr.length] = ["oidSeccion", oidSeccion];
         arr[arr.length] = ["oidTerritorio", oidTerritorio];
         arr[arr.length] = ["oidNivelAgrupacion", oidNivelAgrupacion];
         arr[arr.length] = ["indIncurrencias",numAspi]; 
         */
         
         arr[arr.length] = ["oidTipoRanking", tipoRanking];

         mostrarListaBase();
         
         configurarPaginado(mipgndo2, "INCCalcularRanking", "ConectorCalcularRanking", "es.indra.sicc.dtos.inc.DTOVentaRankingGerentes", arr);  
          
      }
   }

//------------------------------------------------------------------------------   

   function ganadorasOnClick(){
      
       if (listado2.codSeleccionados().length == 1)  {
          var a = new Object();
          a.accion = 'cargarGanadoras';
          a.numAspirantes = get('Formulario.textNumAspirantes');
          a.oidConcurso = get('Formulario.oidConcurso');   
          a.oidNivelPremiacion =  listado2.codSeleccionados();
          a.inicialPuntos = listado1.extraeDato(listado2.codSeleccionados(),1);
          a.finalPuntos   = listado1.extraeDato(listado2.codSeleccionados(),2);
          a.numPremio   = listado2.extraeDato(listado2.codSeleccionados(),3);
          a.numAspirantes   = listado2.extraeDato(listado2.codSeleccionados(),4);
          a.oidPremio   = listado1.extraeDato(listado2.codSeleccionados(),5);
          a.oidTipoPremio   = listado2.extraeDato(listado2.codSeleccionados(),6);
         
          mostrarModalSICC('LPMantenimientoRanking','cargarGanadoras', a);  
       
       }else{
          GestionarMensaje('INC023');
       }
   }

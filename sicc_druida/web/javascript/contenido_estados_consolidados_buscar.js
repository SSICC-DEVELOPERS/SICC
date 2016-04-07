  var frmLista;
  var haySecuencia; //Para saber si algún GP tiene secuencia
  var x;  //Utilizado para validar la selección de los GP
  var y;  //Utilizado para validar la selección de los GP
  var ultimoTxt; //Usado para determinar el ultimo txt de la lista



  
	function onLoadPag()   
	{
 		configurarMenuSecundario("formulario");
		//mostrarCodigoError();
    cargarDatos();
		mostrarCodigoError();
		focaliza('formulario.txtFechaInicio');
    
    
	}



   function mostrarCodigoError() {  
	     
		  var vErrCodigo = get('formulario.errCodigo');
		  var vErrDescrip = get('formulario.errDescripcion');

		  if (get('formulario.errDescripcion')!=''){
      		var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);
          document.all["capa2"].style.visibility='hidden';
          document.all["capa3"].style.visibility='hidden';
	     }		
   }



  function cargarDatos() {
		set('formulario.txtFechaInicio', get('formulario.hFechaIni'));
		set('formulario.txtFechaFin', get('formulario.hFechaFin'));
		
		//PER-SiCC-2011-0079 - Sergio Apaza - 15/02/2011
		document.getElementById("periodoActivo").innerHTML = get('formulario.hCodigoPeriodo'); 

		txt_to('lblTotalGP1XXX', get('formulario.hTotalGP1'));
		txt_to('lblTotalGP2XXX', get('formulario.hTotalGP2'));
		txt_to('lblTotalGP3XXX', get('formulario.hTotalGP3'));
		txt_to('lblTotalGP4XXX', get('formulario.hTotalGP4'));
		txt_to('lblTotalGP5XXX', get('formulario.hTotalGP5'));

 		if ( get('formulario.hUsaPlantillas')=="false")
		{
		    document.getElementById('cbCodigoPlantilla').disabled=true;

		    //accion('formulario.cbCodigoPlantilla.disabled=true');
		} else {
  		    var aCombo = new Array();         
		    aCombo[0] = get('formulario.hCbCodPlantilla');	       
		    set('formulario.cbCodigoPlantilla',aCombo);      

                    if (get('formulario.txtFechaFacturacion')=='') {
  		      set('formulario.txtFechaFacturacion', get('formulario.hFechaFact'));
		    }
                }   
  }

	function mostrarLista() {
	}

  function ocultarLista() {
	    }


  function cargarLista() {
      /*borrarLista();*/
      if (oTableContainer.hasChildNodes()){
              oTableContainer.removeChild(oTable);           
          }
      if (!sicc_validaciones_generales("grupo1"))
           return;

      if (!validaFechasIniFin()) 
          return;

// Por incidencia DBLG500000866 Desabilito todos los botones antes de cargar la lista. 
      deshabilitarHabilitarBoton('botonContenido','btnProcesoValidacion','D');
      deshabilitarHabilitarBoton('botonContenido','btnReporteFaltantes','D');
      deshabilitarHabilitarBoton('botonContenido','btnGenerarTipificacion','D');
      deshabilitarHabilitarBoton('botonContenido','btnGestionStocks','D');
      deshabilitarHabilitarBoton('botonContenido','btnFacturar','D');
      deshabilitarHabilitarBoton('botonContenido','btnRevertirProcesos','D');
      deshabilitarHabilitarBoton('botonContenido','btnCrearGruposReversion','D');
      deshabilitarHabilitarBoton('botonContenido','btnAlarmaPedidosNoFacturados','D');

      set('formulario.accion', 'buscar');
      set('formulario.conectorAction', 'LPMonitor');
      set('formulario.hFechaIni', get('formulario.txtFechaInicio'));
      set('formulario.hFechaFin', get('formulario.txtFechaFin'));
      set('formulario.hCbCodPlantilla', get('formulario.cbCodigoPlantilla'));
      set('formulario.hTipoSol', get('formulario.cbTipoSolicitud'));
      set('formulario.hAcceso', get('formulario.cbAcceso'));
      set('formulario.hRegion', get('formulario.cbRegion'));
      set('formulario.hZona', get('formulario.cbZona'));

      eval("formulario.oculto = 'S'");
      enviaSICC('formulario');
  
  }

      //SACAR ESTE METODO. ES PARA PROBAR
  function cargarLista2() {
        if (!sicc_validaciones_generales("grupo1"))
             return;
    
        set('formulario.accion', 'buscar2');
        set('formulario.conectorAction', 'LPMonitor');
        set('formulario.hFechaIni', get('formulario.txtFechaInicio'));
        set('formulario.hFechaFin', get('formulario.txtFechaFin'));
        set('formulario.hCbCodPlantilla', get('formulario.cbCodigoPlantilla'));
		
        eval("formulario.oculto = 'N'");
        enviaSICC('formulario');
      
      }
 
   function fGuardar() {
		  //Como se usan los ocultos ya está validado
		  //if (!validaFechasIniFin()) 
		  //    return;
		  // splatas - 14/09/2006 - 
		  //if (!validaSecuencia("")) {
		  //    return false;
		  //}
		  //Mostramos un dialogo de confirmación Javascipt con el siguiente mensaje UIPED004 
		  //(¿Desea grabar la secuencia del monitor especificada?) 
		  var acepta = GestionarMensaje("UIPED004");
		  //SEGUN DECU SOLO ENVIAR EN CASO INDICADOR hCbCodPlantilla = INDI_SECU_MONI de tabla PAIS sea: S o 1
		  if (acepta && get('formulario.hUsaPlantillas') == "true") {
			  var grupoProceso = new Array(); 
			  grupoProceso = obtenerGP();					  
			  // Valido las secuencias de los GP obtenidos	  
			  for(var i = 0; i < grupoProceso.length; i++){
				if(grupoProceso[i] != null && grupoProceso[i] != ''){
					if(!validaSecuencia(grupoProceso[i])){
						return false;
					}
				}
			  }

			  var obj = new Object();
			  if (get('formulario.hCbCodPlantilla') != "") {
				  obj.hModificar="true";
			  }
				var ar = mostrarModalSICC('LPMonitor','datosPlantilla',obj,600,300);
				if (ar != "") {
				  var pos = ar.indexOf('|#|');
				  var cod = ar.substring(0,pos);
				  var desc = ar.substring(pos+3,ar.length);
				  set('formulario.hCodigoPlantilla', cod);
				  set('formulario.hDescripcion', desc);
				  
				  setMV('formulario.txtFechaInicio','N');
				  set('formulario.accion', 'guardar');
				  set('formulario.conectorAction', 'LPMonitor');
				  //set('formulario.hFechaIni', get('formulario.hFechaIni'));
				  //set('formulario.hFechaFin', get('formulario.hFechaFin'));
				  set('formulario.hCbCodPlantilla', get('formulario.cbCodigoPlantilla'));
				  eval("formulario.oculto = 'S'");
				  enviaSICC('formulario');
			  } else {
				  //cerró la pantalla

				  return;
			  }
		  }
  }

      var oTable = document.createElement("TABLE");
      var oThead = document.createElement("THEAD");
      var oTBody = document.createElement("TBODY");
      
      var oRow, oCell;
      var cantColumnas = 14;
      var i, j;
      
      var rowOculta = new Array();
	  var rowOcultaAux = new Array(); //sapaza -- PER-SiCC-2010-0141 -- 18/08/2010
      
      function borrarLista(){
          document.all["capa2"].style.visibility='hidden';
          document.all["capa3"].style.visibility='hidden';
          if (oTableContainer.hasChildNodes()){
              oTableContainer.removeChild(oTable);           
          }
      }
       
    
      function initLista(valores, gp1, gp2, gp3, gp4, gp5, fecha){
          //var valor = "1####Consolidado NC - Consultora####12####1012####0########1########0########0########0########1####1####13%%%%0####Consolidado NC - Consultora############0########1########0########0########0########1####0####0%%%%1####Consolidado NC - Consultora####12####1012####0########1########0########0########0########1####1####13%%%%0####Consolidado NC - Consultora############0########1########0########0########0########1####0####0";
          //gp1 = "1";
          //gp2 = "5";
          //gp3 = "4";
          //gp4 = "3";
          //gp5 = "2";
          //fecha = "21/11/2005";

// Por incidencia DBLG500000866 Vuelvo a habilitar todos los botones despues de cargar la lista. 
              deshabilitarHabilitarBoton('botonContenido','btnProcesoValidacion','A');
              deshabilitarHabilitarBoton('botonContenido','btnReporteFaltantes','A');
              deshabilitarHabilitarBoton('botonContenido','btnGenerarTipificacion','A');
              deshabilitarHabilitarBoton('botonContenido','btnGestionStocks','A');
              deshabilitarHabilitarBoton('botonContenido','btnFacturar','A');
              deshabilitarHabilitarBoton('botonContenido','btnRevertirProcesos','A');
              deshabilitarHabilitarBoton('botonContenido','btnCrearGruposReversion','A');
              deshabilitarHabilitarBoton('botonContenido','btnAlarmaPedidosNoFacturados','A');

          if (oTableContainer.hasChildNodes()){
              oTableContainer.removeChild(oTable);           
          }
          inicializarLista();
          if (valores!= ''){
              insertarDatosLista(valores);
              set('formulario.txtFechaFacturacion',fecha);
              txt_to('lblTotalGP1XXX', gp1);
              txt_to('lblTotalGP2XXX', gp2);
              txt_to('lblTotalGP3XXX', gp3);
              txt_to('lblTotalGP4XXX', gp4);
              txt_to('lblTotalGP5XXX', gp5);
              document.all["capa2"].style.visibility='visible';
              document.all["capa3"].style.visibility='visible';
              ponerScroll();
          }else{
              borrarLista();
          }        
      }
      
      function ponerScroll(){
	
          if(listado.rows.length >10){
            tblHeader.style.setExpression("width",tblPrincipal.clientWidth-15);
            oTableContainer.style.overflowY="scroll";
          }else{
            tblHeader.style.removeExpression("width");
            tblHeader.style.width="100%"
            oTableContainer.style.overflowY="hidden";
          }
      }
    
      function inicializarLista(){    
          oTable = document.createElement("TABLE");
          oThead = document.createElement("THEAD");
          oTBody = document.createElement("TBODY");
          var colGroup = document.createElement("COLGROUP");    
          oThead.appendChild(colGroup);    
          for ( i = 0 ; i < cantColumnas; i++){    
              var col = document.createElement("COL");    
              
              if (i == 0){    
                  col.width="250px";    
              }else if (i == 1 || i==2){    
                  col.width = "75px";    
              }else{    
                  col.width="50px";    
              }
    
              if (i == 0 || i == 2 || i == 5 || i == 6 || i == 9 || i == 10){    
                  col.className="EstDatEven";    
              }else{    
                  col.className="EstDatOdd";                  
              }        
              col.style.paddingLeft = "5px";
              oThead.appendChild(col);    
          }    
          oTable.appendChild(oThead);    
          oTable.appendChild(oTBody);    
          oTable.border=0;    
          oTable.cellSpacing=0;    
          oTable.cellPadding=0;    
          oTable.scroll = "auto";    
          oTable.id = "listado";    
          oTable.width = "100%";
          oTableContainer.appendChild(oTable);    
      }

      function insertarDatosLista(s){
          var array = parserString(s);
		  //pzerbino 4/8/2006 Incidencia DBLG500000866
          rowOculta = new Array();
          for ( i = 0 ; i < array.length; i++){
              insertarRow(array[i],i);
              rowOculta [i] = new Array(array[i][0],array[i][14],array[i][15],array[i][16],
										array[i][17],array[i][18],array[i][19],array[i][20],array[i][21]);
			 
			 //sapaza -- PER-SiCC-2010-0141 -- 18/08/2010
			 rowOcultaAux [i] = new Array(array[i][4],array[i][6],array[i][8],array[i][10],array[i][12]);										
          }       
      }
    
      /*Input generico*/
      var inPutGenerico = document.createElement("INPUT");
	  inPutGenerico.size = "3";
	  inPutGenerico.className = "input";
	  inPutGenerico.onclick = onClickInput;
	  inPutGenerico.onmouseover = onmouseoverInput;
	  inPutGenerico.onmouseout = onmouseoutInput;
	  /*fin inputGenerico*/
	  /*TR Generico*/
	  var oRowGenerico1 = document.createElement("TR");
      oRowGenerico1.CLASS="AlSt";
      oRowGenerico1.height = "25px";
	  oRowGenerico1.height = "25px";
	  var oRowGenerico2 = document.createElement("TR");
      oRowGenerico2.CLASS="AlSt";
      oRowGenerico2.height = "25px";
	  oRowGenerico2.height = "25px";
	  oRowGenerico2.style.fontWeight = "bold";
      oRowGenerico2.className="EstCab";
	  /*fin TR Generico*/	
	  /*CELL generico*/
	  var oCellGenerico = document.createElement("TD");
	  oCellGenerico.align = "left";         
	  /*fin CELL generico*/
      function insertarRow(array, index){
          /*oRow = document.createElement("TR");
          oRow.CLASS="AlSt";
          oRow.height = "25px";*/
		  if (array[0] == 1){
		      oRow = oRowGenerico1.cloneNode(false);
		  }else{
			  oRow = oRowGenerico2.cloneNode(false);
		  }
          oTBody.appendChild(oRow);
          
          for (var j=1; j<cantColumnas; j++){
              //oCell = document.createElement("TD");
			  oCell = oCellGenerico.cloneNode(false);
              oCell.id = "TD"+index+j;
              oCell.indexI = index;
              oCell.indexJ = j;
              if (j == 1){
                  oCell.className="BrdNoLeft";
                  oCell.width = "250px";
              }else if (j == 2 || j==3){
                  oCell.width = "75px";
                  oCell.className="cabTit";
              }else{
                  oCell.width = "50px";
                  oCell.className="BrdWhite";
              }
              if (j == 0 || j == 2 || j == 4 || j == 5 || j == 8 || j == 9 || j == 12 || j == 13){
                  oCell.className="BrdOWhite";
              }else{
                  oCell.className="BrdEWhite";              
              }  
              if (array[0] == 1){
                  if ((j == 5 || j == 7 || j == 9 || j == 11 || j == 13)){
                      /*var oInput = document.createElement("INPUT");
                      oInput.size = "2";
                      oInput.id = "text"+index+(j-1);
                      oInput.className = "input";
                      oInput.onclick = onClickInput;
                      oInput.indexI = index;
                      oInput.indexJ = j;
                      oInput.onmouseover = onmouseoverInput;
                      oInput.onmouseout = onmouseoutInput;
                      oInput.value =array[j];*/ //pintar por codigo plantilla, incidencia DBLG700000082
					  var oInput = inPutGenerico.cloneNode(false);
					  oInput.id = "text"+index+(j-1);
					  oInput.indexI = index;
                      oInput.indexJ = j;
					  oInput.value =array[j];
                      oCell.appendChild(oInput);
                  }else{
					 
					  if (((j == 4 && array[17] > 0 )
							|| (j == 6 && array[18] > 0 )
							|| (j == 8 && array[19] > 0 )
							|| (j == 10 && array[20] > 0 )
							|| (j == 12 && array[21] > 0 ))){
						  
							oCell.style.backgroundColor = "FAFAD7";
					  
					  }else{
						  oCell.onmouseover = pintarcelda;
						  oCell.onmouseout = unpintarcelda;
						  if (j >3 ){
							oCell.onclick = celdaOnClick;
						  }
					  }
					  
					  if (array[j] == null || array[j] == ''){
						  oCell.innerText = " ";
					  }else{
						  oCell.innerText = array[j];
					  }
					  
                  }
              }else{
                  if (array[j] == null || array[j] == ''){
                      oCell.innerText = " ";
                  }else{
                      oCell.innerText = array[j];
                  }
                  oCell.onmouseover = pintarcelda;
                  oCell.onmouseout = unpintarcelda;
              }
              
              /*if (array[0] == 0){
                  oRow.style.fontWeight = "bold";
                  oRow.className="EstCab";
              }*/
              //oCell.align = "left";         
              oRow.appendChild(oCell);    
          }    
      }
    
      var celdaClickeada = null;
    
      function pintarcelda(){
          obj = window.event.srcElement;
          obj.style.backgroundColor = "D0D9E8";
      }
    
      function unpintarcelda(){
          obj = window.event.srcElement;
          if (obj != celdaClickeada ){
              obj.style.backgroundColor = "";
          }
      }      
    
      function celdaOnClick(){
          obj = window.event.srcElement;
          if (celdaClickeada != null){
              if (celdaClickeada == obj){
                  celdaClickeada = null;
                  obj.style.backgroundColor = "";
              }else{
                  celdaClickeada.style.backgroundColor = "";
                  celdaClickeada = obj;
                  obj.style.backgroundColor = "D0D9E8";	      
              }          
          }else{			  
              celdaClickeada = obj;
              obj.style.backgroundColor = "D0D9E8";
          }
      }
    
      function onClickInput(){
    			obj = window.event.srcElement;
    			obj.style.backgroundColor = "";
      }
      
      function onmouseoverInput(){
      }
      
      function onmouseoutInput(){
      }      
    
      function parserString (s){
          var array = new Array();
          var array2 = new Array();
          var arrayFinal = new Array();
          array = s.split("%%%%");
          for ( i = 0 ; i < array.length; i++){
              array2 = array[i].split("####");
              arrayFinal[i] = array2;
          }
          return arrayFinal;
      }    
      
      function validarDatos(valores){
		  //V_PED_13, HHA: PARA QUE INGRESE 999 COMO MAXIMO EN LOS NUMEROS DE SECUENCIA
          for(i = 0; i < valores.length; i++){
              if (fValidarNumero(valores[i][0], 6, 1, 999999) != 'OK'){ //10-04-2007, Se modifica para que ingrese 999999 COMO MAXIMO EN LOS NUMEROS DE SECUENCIA
                    GestionarMensaje(1390);
                    valores[i][2].focus();
                    return false;
              }
          }
          return true;
      }
      
      function validaSecuencia(gp, secuenciacionAutomatica){
		      
			  //debugger;

    	      var numero = eval((gp*2)+2);
    	      var datos = new Array();
    	      j=0;
    	      for (i = 0; i < rowOculta.length ; i++){
                if (rowOculta[i][0] == '1'){
                    obj = eval("text"+i+numero);
                    dato = obj.value;
                    if (dato != null && dato != ''){
                        datos[j] = new Array(dato, i, obj);
                        j++;
                    }	                    
                }			  
    	      }
            if (datos.length < 1){
				//sapaza -- PER-SiCC-2010-0141 -- 18/08/2010
            	if(secuenciacionAutomatica) {
		    		var datosAux = new Array();
              		j=0;
              	
		    	    for (i = 0; i < rowOculta.length ; i++){
		            	if (rowOculta[i][0] == '1'){
		                	if((rowOcultaAux[i][gp-1]) != '0') {
		                		datosAux[j] = new Array(j+1, i);
		                		j++;
		                	}
		              	}	
					}    
								
					if(datosAux.length > 0) {
						var acepta = GestionarMensaje("PED086");
						
						if(acepta) {
							var cadCrear = '';  
				            for (k = 0; k < datosAux.length; k++) {
			    	            cadCrear = cadCrear + rowOculta[datosAux[k][1]][1]+"|";//Tipo Solicitud
			        		    cadCrear = cadCrear + rowOculta[datosAux[k][1]][3]+"|";//Zona
			                	cadCrear = cadCrear + datosAux[k][0]+"|#|";//Secuencia
				            }
			  	  	        set('formulario.hCrearGP'+gp,cadCrear);
							
							return true; 
	  	  		      	}
	  				}        	  
				}
				
                return false;
            }
            /*if (!haySecuencia){
                if (datos.length < 1){
                    if (gp != ""){
                        GestionarMensaje("UIPED018");
                    }else{
                        GestionarMensaje("UIPED027");
                    }
                    return;
                }
            }*/
            //haySecuencia = true;
            if (!validarDatos(datos)){
                huboError = true;
                return false;
            }
    	      datos = ordenarValores(datos);
    	      if (!verificarRepetidos(datos)){
                huboError = true;
                return false;
    	      }
            var cad = '';
            var cadCrear = '';  
            for (j = 0; j < datos.length; j++) {
                //Para la generacion de los TreeSet
                cad = cad + rowOculta[datos[j][1]][1]+"|";//Tipo Solicitud
                cad = cad + rowOculta[datos[j][1]][2]+"|";//Region
                cad = cad + rowOculta[datos[j][1]][3]+"|";//Zona
                cad = cad + datos[j][0]+ "|#|";//Secuencia
                
                //Para el llamado el crear grupos de reversion
                cadCrear = cadCrear + rowOculta[datos[j][1]][1]+"|";//Tipo Solicitud
                cadCrear = cadCrear + rowOculta[datos[j][1]][3]+"|";//Zona
                cadCrear = cadCrear + datos[j][0]+"|#|";//Secuencia
                
            }
          
            set('formulario.hTreeGP'+gp,cad);      
            set('formulario.hCrearGP'+gp,cadCrear); 
          
            return true;        	      	      
      }
      
      function verificarRepetidos(datos){
          for (j = 0; j < datos.length-1; j++){
              if (datos[j][0] == datos[j+1][0]) {
                GestionarMensaje("UIPED005");
                return false;
    
              }
          }        
          return true;
      }
      
      function ordenarValores( valores){    
          for (i = 0 ; i < (valores.length-1); i++){
              ordenado = true;
              for (j = 0 ; j < (valores.length-1); j++){
                  if (valores[j][0] > valores [i+1][0]){
                      var aux = valores[j];
                      valores[j] = valores[j+1];
                      valores[j+1] = aux;
                      ordenado = false;
      	          }
    		      }
              if (ordenado == true){
                  break;
              }
          }
          return valores;
      }
      
       function desglose() {
          if (celdaClickeada == null){
              GestionarMensaje('UIPED003');
              return;
          }
          var x = celdaClickeada.indexI;
          var y = celdaClickeada.indexJ;          
    
          //Obtenemos el número de GP a partir del número de columna, teniendo en cuenta que cada GP tiene dos columnas 
          var GP = Math.round( (y-2) /2); 
    
          dato = cmbDesglose.value;
          if (dato == null || dato == ''){
              return;
          }
		  /**
		  VALIDACION CAMBIADA POR V_PED_14, ANTES SOLO DEJABA PARA GP2 AHORA SOLO DEBE DEJAR PARA GP1
		  DEBE HACER DESGLOSE POR ESTADO
		  **/
		  if (dato == 4 && GP != 1) {
              GestionarMensaje('UIPED006');
              return;
          }
    
          var LP;
    	  
      	  if( dato == 1 ) LP = 'LPDesgloseTipoSubtipoClasificacion'; 
          else if( dato == 2 ) LP = 'LPDesgloseAccesos'; 
          else if( dato == 3 ) LP = 'LPDesgloseContenido'; 
      	  else if( dato == 4 ) LP = 'LPDesgloseEstados'; 
      	  else{ 
              return; 
          }
          /* Abrimos un popup modal y direccionamos a la lp indicada por la variable LP, pasandole como parametros: 
          -tipoSolicitud = el valor de la columna oidTipoSolicitud para la fila x 
          -region = el valor de la columna oidRegion para la fila x 
          -zona = el valor de la columna oidZona para la fila x 
          -gp= la variable GP 
          -fechaInicio = el campo oculto fechaInicio de la página 
          -fechaFin = el campo oculto fechaFin de la página
          */ 
    
          tipoSolicitud = rowOculta[x][1];
          region = rowOculta[x][2];
          zona = rowOculta[x][3];
    
          var obj = new Object();
          obj.accion = '';
          obj.tipoSolicitud = tipoSolicitud;
          obj.region = region;
          obj.zona = zona;
          obj.gp = GP;
          obj.fechaInicio = get("formulario.txtFechaInicio");
          obj.fechaFin = get("formulario.txtFechaFin");
          obj.tipoDesglose = dato;
          var winModal = mostrarModalSICC(LP, '', obj, 780, 500);
      }
      var huboError = false;
      function crearGrupo() {
		  var huboError = false; 
          var cad = "";
          var i;
        
          var cantValores;
          var haySec;
          var gpConSec = 0;
          
          if (cdos_trim(get('formulario.txtGrupoReversion')) == "") {
              GestionarMensaje("UIPED026");
              focaliza('formulario.txtGrupoReversion');
              return;
          }
          
          for (i = 1; i < 6; i++) {
              cantValores = cantValoresSecGP(i);
              if (cantValores > 0) {
                  if (haySec) {
                      GestionarMensaje("UIPED017");
                      return;
                  } else {
                      haySec = true;
                      gpConSec = i;
                  }
              }
              /*if (cantValores == -1) {
                  huboError = true;
              }*/
                  
          }
          
          if (huboError){
              return;
          }
          if (!haySec) {
              GestionarMensaje("UIPED025"); //Inc. 8113
              return;
          }
        
          var obj = new Object();
          obj.hListaOidsCrear = get('formulario.hCrearGP'+gpConSec);
          obj.hGrupoReversion = get('formulario.txtGrupoReversion');
          obj.hGPRever = gpConSec;   
          obj.hFechaIni = get('formulario.hFechaIni');   
          obj.hFechaFin = get('formulario.hFechaFin');   
          mostrarModalSICC('LPMonitor','CrearGrupoRevesion',obj,740,580);
      }
      
      function cantValoresSecGP(gp) {
          var numero = eval((gp*2)+2);
          if (!validaSecuencia(gp)){
              return -1;
          }
              
          var cantValores = 0;
          for (i = 0; i < rowOculta.length; i++){
              if (rowOculta[i][0] == "1"){
                  obj = eval("text"+i+numero);
                  dato = obj.value;
                  if (dato != ""){
                      cantValores++;
                  }
              }
          }          
    
          return cantValores;
      }
      
      function reporteFaltantes() {
          if (!validaSecuencia(2)) 
              return; 
        
          var obj = new Object();
          obj.fechaIni = get('formulario.hFechaIni');   
          obj.fechaFin = get('formulario.hFechaFin');   
          mostrarModalSICC('LPValidaFaltantes','',obj,740,580);
      }
        
      function generarSecTipificacion() {
          var obj = new Object();
          obj.hIdioma = get('formulario.hIdioma');
          mostrarModalSICC('LPMonitorTipificacion','',obj,720,580);        
      }
        
      function procesoValidacion() {
          if (!validaSecuencia(1, true)) 
              return; 
        
          // sapaza -- PER-SiCC-2010-0349 -- 27/05/2010
		  deshabilitarHabilitarBoton('botonContenido','btnProcesoValidacion','D');
		
          set('formulario.accion', 'validaciones');
          set('formulario.conectorAction', 'LPMonitor');
          eval("formulario.oculto = 'S'");
          enviaSICC('formulario');    
      }
    
      function revertirProcesos() {
          if (cdos_trim(get('formulario.txtGrupoReversion')) == "") {
              GestionarMensaje("UIPED012");
              return;
          }
        
          set('formulario.accion', 'revertirProcesos');
          set('formulario.conectorAction', 'LPMonitor');
          set('formulario.hGrupoReversion', get('formulario.txtGrupoReversion'));
          eval("formulario.oculto = 'S'");
          enviaSICC('formulario');
          
      }
        
      function gestionStock() {
              if (!validaSecuencia(3, true)) 
                  return; 
            
	          // sapaza -- PER-SiCC-2010-0349 -- 27/05/2010
			  deshabilitarHabilitarBoton('botonContenido','btnGestionStocks','D');
			
              set('formulario.accion', 'gestionStock');
              set('formulario.conectorAction', 'LPMonitor');
              set('formulario.hIndTipif', get('formulario.chkTipificacionCliente'));
              eval("formulario.oculto = 'S'");
              enviaSICC('formulario');    
      }
    
      function facturar() {
          if (!validaFechaFact()) 
              return;
          
          if (!validaSecuencia(4, true)) 
              return; 
        
          if (cdos_trim(get('formulario.txtFechaFacturacion')) == "") {
              GestionarMensaje("UIPED013");
              return;
          }

          // vbongiov -- Mejora RI 20080588 -- 15/08/2008
		  deshabilitarHabilitarBoton('botonContenido','btnFacturar','D');
        
          set('formulario.accion', 'facturar');
          set('formulario.conectorAction', 'LPMonitor');
          set('formulario.hFechaFact', get('formulario.txtFechaFacturacion'));
		  
		  
		  
          eval("formulario.oculto = 'S'");
          enviaSICC('formulario');    
      }
    
      function demandaAnticipada() {
          if (!validaFechaFact()) 
              return;
        
          if (!validaSecuencia(4)) 
              return; 
        
          if (cdos_trim(get('formulario.txtFechaFacturacion')) == "") {
              GestionarMensaje("UIPED013");
              return;
          }
        
          cdos_mostrarAlert("Esta opción no está disponible en esta versión");
      }
      
      function alarmaPedidos() {
          set('formulario.accion', '');
          set('formulario.conectorAction', 'LPAlarmaPedidos');
        
          if (cdos_trim(get('formulario.hFechaFin')) == "") 
              set('formulario.hFechaFin', get('formulario.hFechaIni'));
              
          eval("formulario.oculto = 'N'");
          enviaSICC('formulario');    
      }
    
      function validaFechasIniFin() {
          if (EsFechaValida(get('formulario.txtFechaInicio'),get('formulario.txtFechaInicio'), 'formulario') != 0) {
              GestionarMensaje('947','formulario.txtFechaInicio');
              focaliza('formulario.txtFechaInicio')
              return false;
          }
        
          if (cdos_trim(get('formulario.txtFechaFin')) != "") {
              if (EsFechaValida(get('formulario.txtFechaFin'),get('formulario.txtFechaFin'), 'formulario')  != 0) {
                  GestionarMensaje('947','formulario.txtFechaFin');
                  focaliza('formulario.txtFechaFin')
                  return false;
              }
          }        
          return true;    
      }
    
      function validaFechaFact() {
          if (EsFechaValida(get('formulario.txtFechaFacturacion'),get('formulario.txtFechaFacturacion'), 'formulario')  != 0) {
              GestionarMensaje('947','formulario.txtFechaFacturacion');
              focaliza('formulario.txtFechaFacturacion')
              return false;
          }
          return true;
      }
    
	// splatas - 14/09/2006 - 	
	// Retorna un array con los gp que tienen secuencia
	function obtenerGP() {
		var idGP = new Array();
		
		// El parámetro 'j' es el GP actual
		for (var j = 1; j <= 5; j++) {
			var numero = eval((j*2)+2);
		
			for (var i = 0; i < rowOculta.length; i++) {
				if (rowOculta[i][0] == '1'){
										
					var obj = eval("text"+i+numero);
					var dato = obj.value;

					if(dato != null && dato != ''){
						idGP[j-1] = j;					
					}	      					
				}			  							
			}			
		}
		
		return idGP;		
	}      
  
  function cambioRegion(){
    
    opciones = new Array();
    set_combo('formulario.cbZona',opciones);
    combo_add('formulario.cbZona', '', '');

    var regiones = quitarItemVacio(get('formulario.cbRegion'));
    var pais = get('formulario.hPais');
    var regionConc = new String();
    
    for(i=0;i<regiones.length;i++){
      regionConc += regiones[i] + "x";
    }

    regionConc = regionConc.substring(0, regionConc.length-1);
    
    var arr = new Array();
    arr[arr.length] = ['cadena', regionConc];
    arr[arr.length] = ['oidPais', pais]
    
    if(regionConc != ''){
      recargaCombo("formulario.cbZona", "REPRecargaZonas", "es.indra.sicc.util.DTOString",arr);
    }     
  }

   function quitarItemVacio(elemento){
      var elementoADevolver = new Array();
     
      for(var k=0;k<elemento.length;k++) {
           if (elemento[k] != ''){                                
              elementoADevolver[elementoADevolver.length] = elemento[k];
           }
      }
          
      return elementoADevolver;
      
   }

	//	Agregado por HRCS - Fecha 24/07/2007 - Cambio Sicc20070303
	function revertirSolicitudesServicio() {

	  set('formulario.accion', 'revertirSolicitudesServicio');
	  set('formulario.conectorAction', 'LPMonitor');
	  set('formulario.hFechaIni', get('formulario.txtFechaInicio'));
	  eval("formulario.oculto = 'S'");
	  enviaSICC('formulario');
	  
	}
	
	function habilitarBotonFacturar() {
		deshabilitarHabilitarBoton('botonContenido','btnFacturar','A');		
	}

    //PER-SiCC-2011-0079 - Sergio Apaza - 25/02/2011	
	function actualizaFecha(){
		if (get('formulario.ckPeriodoSiguiente') == 'S') {
			set('formulario.txtFechaFin', get('formulario.hFechaFinPeriodoSiguiente'));
		} 
		else {
			set('formulario.txtFechaFin', '');
		}
		
	    set('formulario.hIndPeriodoSiguiente', get('formulario.ckPeriodoSiguiente'));	 
	}	
	
	function habilitarBotonGestionStocks() {
		deshabilitarHabilitarBoton('botonContenido','btnGestionStocks','A');
	}	
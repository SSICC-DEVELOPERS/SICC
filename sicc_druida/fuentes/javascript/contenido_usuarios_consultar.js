		var vTipoUsuario = new Array();
		vTipoUsuario[0]=['INTERACTIVO',GestionarMensaje('88',null,null,null)];
		vTipoUsuario[1]=['TERCERO',GestionarMensaje('90',null,null,null)];
		vTipoUsuario[2]=['BATCH',GestionarMensaje('89',null,null,null)];

		var vRastreoAcceso = new Array();			
		vRastreoAcceso[0]=['ACCESO' ,GestionarMensaje('1090',null,null,null)];
		vRastreoAcceso[1]=['NO', GestionarMensaje('1011',null,null,null)];
		vRastreoAcceso[2]=['TOTAL', GestionarMensaje('1091',null,null,null)];

		var vSINO = new Array();			
		vSINO[0]=['S', GestionarMensaje('1010',null,null,null)];
		vSINO[1]=['N', GestionarMensaje('1011',null,null,null)];
		
		function StrReplace(str1, str2, str3)
		{
		  str1 = str1.split(str2).join(str3);
		  return str1;
		}

		function cargarLabels(){
			var cadena 			= null;
			var cadenaFinal 	= null;			
			var camposLabel = new Array();

			camposLabel[0]=['hIndicacionClaveInicial','lblIndicacionClaveInicial','vSINO','0','1'];
			camposLabel[1]=['hRastreoAcceso','lblRastreoAcceso','vRastreoAcceso','0','1'];
			camposLabel[2]=['hTipoUsuario','lblTipoUsuario','vTipoUsuario','0','1'];
			camposLabel[3]=['hUsuarioHabilitado','lblUsuarioHabilitado','vSINO','0','1'];
			camposLabel[4]=['hIndNDG','lblIndNDG','vSINO','0','1'];						
			camposLabel[5]=['hIndAdmNDG','lblAminNDG','vSINO','0','1'];						

			for (var j=0; j<camposLabel.length; j++){
				cadena = get('frmFormulario.' + camposLabel[j][0]);

				var desc = '';
				var codigos= new Array();
				codigos = cadena.split('|');
				for(var t=0; t < codigos.length ; t++){					
					desc = desc + '|' + obtenerDescLista( camposLabel[j][2], codigos[t], camposLabel[j][3], camposLabel[j][4]);					
				}

				cadenaFinal = desc.substr(1);
				cadenaFinal = cadenaFinal.split("|").join("<BR>");			
				txt_to(camposLabel[j][1], cadenaFinal );
			}
		}

		function obtenerDescLista(lista, codigo, colID, colDESC){
			var desc = '';
						
			for (var k=0; k < eval(lista + '.length'); k++){				
				if ( eval(lista)[k][colID] == codigo ){
					desc = eval(lista)[k][colDESC];
					return desc;
				}			
			}  
			
			return desc;
		}

      function inicializar(){      				
			//cargarBarra("barra_usuarios_consultar");			
	try{
			fnErrores();			
			cargarLabels();
			configurarMenuSecundario("frmFormulario");
	}catch(e){
	}
				
      }      
      
		function fnErrores(){
			var errCodigo = get('frmFormulario.errCodigo');
			var errDescripcion = get('frmFormulario.errDescripcion');
			var result;

			if (	(errCodigo!=null && errCodigo!='') || 
					(errDescripcion!=null && errDescripcion!='') ){
						
						fMostrarMensajeError(errCodigo, errDescripcion);
						
						return true;
			} else {
				return false;
			}

		}	

      function fVolver(){
		 window.close();
      }


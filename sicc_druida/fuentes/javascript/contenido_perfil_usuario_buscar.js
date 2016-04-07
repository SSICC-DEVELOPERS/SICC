
//***************************************************************
// Funcion de Validación de caracteres ingresados en en el campo.
//***************************************************************
function validaChars(str)
{
	var c;		
	permitidos="*#%abcdefghijklmnñopqrstuvwxyz ABCDEFGHIJKLMNÑOPQRSTUVWXYZ_-0123456789.";
	for (var i=0; i<str.length; i++)
	{
	   c=str.charAt(i);
	   if ( permitidos.indexOf(c) == -1 ) 
		  return false;
	   else if ( c == ' ' && i == 0 )
		  return false;
	   else if ( c == ' ' && i == (str.length-1) )
		   return false;				
	}
	return true;     
}

function postForm(busca) 
{
	if ( busca)
	{
		enviaSICC("frmBuscar");
	} else {
		enviaSICC("frmBuscar",null,null,"N");
	}
 }


 //***************************************************************
// Funcion de chequeo e invocacion de LPs.
//***************************************************************
function checkSelection(tipo, destino){

	if ( get('frmBuscar.txtNombrePerfil') != ''
		 && (validaChars(get('frmBuscar.txtNombrePerfil')) == false) )
	{
		cdos_mostrarAlert(GestionarMensaje('121'));
		focaliza('frmBuscar.txtNombrePerfil');
		return false;						
	}
	
	if(tipo!="busca"){
		if(lstResultado.seleccion.longitud!=1){
			GestionarMensaje('50',null,null,null);
			return false;
		}
	}
	/*
	else{
		if(get("frmBuscar.txtNombrePerfil")==""){
			GestionarMensaje('9');
			return false;
		}
	}
	*/
	set('frmBuscar.accion',tipo);
	if(tipo=='elimina')
	{					
		if(!window.confirm(GestionarMensaje('51',null,null,null)+" "+lstResultado.getSeleccion() + " ?"))
		{
			return;
		}
	}
	
	if(get('frmBuscar.seleccion')==""){
		set('frmBuscar.seleccion',lstResultado.getSeleccion());
	}
	postForm(tipo=="busca");
}


//***************************************************************
// Funcion de Errores.
//***************************************************************
function fnErrores(){

	
	configurarMenuSecundario("frmBuscar");
	if ("S" == get("frmBuscar.botonVolver"))
	{
		btnProxy(2,0);
	}
    var exitoModificar = get("frmBuscar.exitoModificar");
	if ( exitoModificar == "S")
	{
		set("frmBuscar.exitoModificar", "");
		parent.frames["menu"].recarga();   // Recarga el menu para reflejar la actualizacion. 
	}

  
	var msg = get("frmBuscar.mensaje");

	if(msg!=null && msg!=''){
		GestionarMensaje(msg);
		return;
	}
	else
	{
		var codigo = get("frmBuscar.errCodigo");
		var descripcion = get("frmBuscar.errDescripcion");

		if(descripcion!=null && descripcion!='' )
			{
				//if(fMostrarMensajeError(codigo,descripcion)==0){
					var retorno = fMostrarMensajeError();
					//			alert("retorno: " + retorno);
					if(retorno){
					//postForm();
                          set('frmBuscar.accion','');
						  //enviaSICC('frmBuscar');
						//alert(get('frmBuscar.txtNombrePerfil'));
					}
			}
		
		else if (codigo!=null && descripcion!=null && codigo=='' && descripcion!='')
			{
				if(descripcion.substr(0,4)=="ERR_")
				{
					var errNums = descripcion.split("_");
					var txtDescrip = null; 

					if ( descripcion.split("_")[2]!=null)
						txtDescrip = GestionarMensaje(errNums[1],errNums[2],null,null);		
					
					else
						txtDescrip = GestionarMensaje(errNum[1],"",null,null);
					
										
					if(errNums[1]=="52")
						configurarMenuSecundario("frmBuscar");
					

					
					
					descripcion=txtDescrip;
					if(fMostrarMensajeError(codigo,descripcion)==0)
						postForm();
					
				}				
			}
	}
	focaliza('frmBuscar.txtNombrePerfil','');
	
}

function Limpiar(){
	setTimeout("Limpiar2()",100);
}

function Limpiar2(){
	set("frmBuscar.txtNombrePerfil","");
/*
	visibilidad("capaResultado","hidden");
	visibilidad("capaBotonCopia","hidden");
	visibilidad("capaBotonModifica","hidden");
	visibilidad("capaBotonConsulta","hidden");
	visibilidad("capaBotonElimina","hidden");
	visibilidad("capaBorde","hidden");
*/
	focaliza("frmBuscar.txtNombrePerfil");
}


function Buscar()
{
	var texto = get("frmBuscar.txtNombrePerfil");
	//alert("Caja de texto: " + texto);

	if ( texto != ""  && (validaChars(get('frmBuscar.txtNombrePerfil')) == false) )
	{
		// Si hay algun caracter no valido, muestra un mensaje y focaliza sobre el textBox.
		cdos_mostrarAlert(GestionarMensaje('121'));
		focaliza('frmBuscar.txtNombrePerfil');
		return false;						
	} else
	{
		set("frmBuscar.accion", "busca");
		enviaSICC("frmBuscar");
	}

}


function fBorrar()
{
	Eliminar();
}

function Eliminar()
{
      // Chequea que haya al menos un perfil seleccionado
	  var nSeleccion = lstResultado.getSeleccion();
      //alert("nSeleccion: " + nSeleccion);
	  if ( nSeleccion == "")
	  {
		  GestionarMensaje("50"); // "Debe seleccionar un elemento de la lista.
		  return;
	  } ;

	  // Ahora muestra el mensaje de Aceptar / Cancelar para que el usuario confirme el borrado.
	 var nRetorno = cdos_mostrarConfirm(GestionarMensaje("51") + nSeleccion + "?");
	 //alert("Valor de retorno: " + nRetorno);
	 if (nRetorno == true)
	 {
 		 //alert("nRetorno es true");
		 set("frmBuscar.seleccion", nSeleccion);
		 set("frmBuscar.accion", "elimina");
		 enviaSICC("frmBuscar");
	  };

	 return;
}


function fLimpiar()
{
	set("frmBuscar.txtNombrePerfil", "");
}
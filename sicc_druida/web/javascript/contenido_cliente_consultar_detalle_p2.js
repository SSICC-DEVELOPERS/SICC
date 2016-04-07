// -----------------------------------------------------------------------------------------------------------------------------------------------
function init() {

   fMostrarMensajeError();

   configurarMenuSecundario("frmInsertarCliente");

   DrdEnsanchaConMargenDcho('listado2', 12);
   DrdEnsanchaConMargenDcho('listado3', 12);
   DrdEnsanchaConMargenDcho('listado4', 12);
   document.all["Cplistado2"].style.visibility='visible';
   document.all["CpLin1listado2"].style.visibility='visible';
   document.all["CpLin2listado2"].style.visibility='visible';
   document.all["CpLin3listado2"].style.visibility='visible';
   document.all["CpLin4listado2"].style.visibility='visible';

   document.all["Cplistado3"].style.visibility='visible';
   document.all["CpLin1listado3"].style.visibility='visible';
   document.all["CpLin2listado3"].style.visibility='visible';
   document.all["CpLin3listado3"].style.visibility='visible';
   document.all["CpLin4listado3"].style.visibility='visible';

   document.all["Cplistado4"].style.visibility='visible';
   document.all["CpLin1listado4"].style.visibility='visible';
   document.all["CpLin2listado4"].style.visibility='visible';
   document.all["CpLin3listado4"].style.visibility='visible';
   document.all["CpLin4listado4"].style.visibility='visible';

   eval(ON_RSZ);

   cargaDatos();

   // Deshabilito Checkbox "Indicador Activo"
   var chkActivo = document.getElementById('ckIndActivo');
   chkActivo.disabled = true;

}

// -----------------------------------------------------------------------------------------------------------------------------------------------
function cargaDatos() {

	 //  ------------ Internacionaliza el campo Tratamiento ----------------
	 var codTratamiento = get("frmInsertarCliente.hidTratamiento");
	 var descTratamiento = "";
	 if (codTratamiento == 1)  // Sr. 
			descTratamiento = GestionarMensaje("1031", null, null, null);
	 if (codTratamiento == 2) // Sra. 
			descTratamiento = GestionarMensaje("1032", null, null, null);
	 if (codTratamiento == 3) // Srta. 
			descTratamiento = GestionarMensaje("1033", null, null, null);

	 txt_to('lbl2dtTratamiento', descTratamiento);



	 // ---------- Setea la forma de Pago en el combo ---------------------
	 var formaPago = get("frmInsertarCliente.hidFormaPago");
	 txt_to("lbl2dtFormaPago", formaPago);


	 // -------- Setea Sexo ----------------------
	 var sexo = get("frmInsertarCliente.hidSexo");
	 txt_to("lbl2dtSexo", sexo);


	 // ---------- Setea Nacionalidad en el Combo corresp. --------------------
	 var nacionalidad = get("frmInsertarCliente.hidNacionalidad");
	 txt_to("lbl2dtNacionalidad", nacionalidad);

	 // ---------- Setea Estado Civil en combo----------------------
	 var estadoCivil = get("frmInsertarCliente.hidEstadoCivil");
	 txt_to("lbl2dtEstadoCivil", estadoCivil);

	 // ------- Setea NSE Pais en combo --------------------------------
	 var NSEP = get("frmInsertarCliente.hidNSE");
	 txt_to("lbl2dtNivelSocioEconomico", NSEP);

	 // --------- Setea Nivel de Ciclo Familiar ------------------------
	 var nivelCicloFamiliar = get("frmInsertarCliente.hidCicloVidaFamiliar");
	 txt_to("lbl2dtCicloVidaFamiliar", nivelCicloFamiliar);

	 // ------------- Setea Nivel Estudios ----------------
	 var nivelEstudios = get("frmInsertarCliente.hidNivelEstudios");
	 txt_to("lbl2dtNivelEstudios", nivelEstudios);

	 // -------------- Setea Corresp. ----------------------
	 var corresp = get("frmInsertarCliente.hidCorresp");
	 txt_to("lbl2dtDeseaCorrespondencia", corresp);



	 // ------------- Internacionaliza ListaEditable --------------------
	 var cods = listado2.codigos();

	 var si = GestionarMensaje("1010", null, null, null);
	 var no = GestionarMensaje("1011", null, null, null);

	 for (var i = 0; i < cods.length; i++)
	 {
			var SiNo = listado2.extraeDato(cods[i], 4); 
			if (SiNo == "1")
				listado2.insertaDato(cods[i], 4, si);
			else
				listado2.insertaDato(cods[i], 4, no);							
	 }

	 // ---------- Actualiza campo Edad si hay una Fecha de Nacimiento ---------------
	 var fechaNacimiento = get("frmInsertarCliente.hFechaNacimiento");

	 if (fechaNacimiento != "")
		actualizaFechaNacimiento(fechaNacimiento);
	 else
		txt_to('lbl2dtEdad',"");	

}

//---------------------------------------------------------------------------------------------------------------------
function actualizaFechaNacimiento(campoFecha){

	var formName = "frmInsertarCliente";
	var edad = 0;
	if(campoFecha != "" && !EsFechaValida_SICC(campoFecha, formName)){
		// no es valida la fecha
		GestionarMensaje('1006',get(formName + '.hFormatoFechaPais')); 
		txt_to('lbl2dtEdad','');	
		focaliza(formName + '.'  + campoFecha.name);
		return;
	}else{
		if(campoFecha=="" ){
			txt_to('lbl2dtEdad','');	
			return;
		}
		// la fecha es valida. asi que veo como calculo la edad.
		var fecha = campoFecha;
		var today = new Date();
		var todayDay = today.getDate();
		var todayMonth = (today.getMonth() + 1);
		var todayYear = today.getFullYear();
		var formatoFecha = get(formName + ".hFormatoFechaPais" );
            var delim  = obtieneDelimitador(formName);
            var fechaSpliteada = "";
            FechaCortada = fecha.split(delim);
            fechaSpliteada = formatoFecha.split(delim);
		    // Chequea cuál es el año (Y o y), al resto (mes o dia, le agrega ceros si es necesario).
           var formatoArray = new Array(3);
           for (var i = 0; i<3; i++ ){
                    formatoArray[i] = parseaFormato(i, formName);
           }	

          var diaMesAgno = "";
          for (var i = 0; i<3; i++){
                  diaMesAgno = formatoArray[i];
                  switch (diaMesAgno)
                  {
                  case 1:
                            NDiaD = FechaCortada[i];
                            break;
                  case 2:
                            NMesD = FechaCortada[i];
                            break;
                  case 3: 
                        NAnoD = FechaCortada[i];
                            break;
                  }
          }
	    ////alert("Dia:"  + NDiaD +"  Mes:"  + NMesD + " Anio:"  + NAnoD );
	    ////alert("Dia:"  + todayDay +"  Mes:"  + todayMonth + " Anio:"  + todayYear );
	    edad= todayYear - NAnoD;
	    if(todayMonth>NMesD){
			// no hago nada
	    }else if (todayMonth<NMesD){
			// resto un anio a la edad porque todavia no se cumplio
			edad= edad - 1;
	    }else if (todayMonth==NMesD){
			// si son iguales debo comprobar los dias
			if(todayDay>NDiaD){
				// no hago nada
			}else if(todayDay<NDiaD){
				edad = edad - 1;
			}
	    }
	}
	txt_to('lbl2dtEdad',edad);	
}


// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function siguientePestanya() {

	set('frmInsertarCliente.conectorAction', 'LPDetalleCliente');
	set('frmInsertarCliente.accion', 'pestanya3' );

	enviaSICC('frmInsertarCliente');  

}


// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function anteriorPestanya() {

	set('frmInsertarCliente.conectorAction', 'LPDetalleCliente');
	set('frmInsertarCliente.accion', 'pestanya1' );

	enviaSICC('frmInsertarCliente');  

}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fVolver() {
	window.close();
}

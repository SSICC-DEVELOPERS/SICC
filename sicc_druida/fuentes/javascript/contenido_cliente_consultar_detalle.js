function Init()   
	{
		
		  configurarMenuSecundario("frmInsertarCliente");
			fnErrores();

//código referente a la lista de la pestaña Tipo y Subtipo que se oculta: listado0
	    document.all["Cplistado0"].style.visibility='hidden';
		 //alert"1-1");
	    document.all["CpLin1listado0"].style.visibility='hidden';
		 //alert"1-2");
	    document.all["CpLin2listado0"].style.visibility='hidden';
		 //alert"1-3");
	    document.all["CpLin3listado0"].style.visibility='hidden';
		 //alert"1-4");
	    document.all["CpLin4listado0"].style.visibility='hidden';	    
		 //alert"1-5");
	    document.all["Siguiente0Div"].style.visibility='hidden';
		 //alert"1-6");

//código referente a la lista de la pestaña 1 que se oculta: listado1
	    document.all["Cplistado1"].style.visibility='hidden';
		 //alert"2-1");
	    document.all["CpLin1listado1"].style.visibility='hidden';
		 //alert"2-2");
	    document.all["CpLin2listado1"].style.visibility='hidden';
		 //alert"2-3");
	    document.all["CpLin3listado1"].style.visibility='hidden';
		 //alert"2-4");
	    document.all["CpLin4listado1"].style.visibility='hidden';
		 //alert"2-5");
	    document.all["Anterior1Div"].style.visibility='hidden';	    
		 //alert"2-6");
		 document.all["Siguiente1Div"].style.visibility='hidden';
			 //alert"2-FINAL");
	    //document.all["Validar1Div"].style.visibility='hidden';

		 
//código referente a las listas de la pestaña 2 que se ocultan: listado2, listado3, listado4

		 ocultaCapa("listado2", 'hidden');
		 ocultaCapa("listado3", 'hidden');
		 ocultaCapa("listado4", 'hidden');
		 ocultaCapa("listado5", 'hidden');
		 ocultaCapa("listado6", 'hidden');
	    
//código referente a las listas de la pestaña 3 que se ocultan: listado5, listado6, listado7

	    document.all["Cplistado7"].style.visibility='hidden';
	    document.all["CpLin1listado7"].style.visibility='hidden';
	    document.all["CpLin2listado7"].style.visibility='hidden';
	    document.all["CpLin3listado7"].style.visibility='hidden';
	    document.all["CpLin4listado7"].style.visibility='hidden';
	    document.all["Anterior7Div"].style.visibility='hidden';	    
	    document.all["Siguiente7Div"].style.visibility='hidden';	 
	       
//código referente a las listas de la pestaña 4 que se ocultan: listado5, listado6, listado7

		 ocultaCapa("listado8", 'hidden');
		 ocultaCapa("listado9", 'hidden');

		 //alert"Capa 10");
	    document.all["Cplistado10"].style.visibility='hidden';
	    document.all["CpLin1listado10"].style.visibility='hidden';
	    document.all["CpLin2listado10"].style.visibility='hidden';
	    document.all["CpLin3listado10"].style.visibility='hidden';
	    document.all["CpLin4listado10"].style.visibility='hidden';
	    document.all["primera10Div"].style.visibility='hidden';	     
		 //alert"Capa 10 - 1");
	    document.all["ava10Div"].style.visibility='hidden';
		 //alert"Capa 10 - 2");
	    document.all["ret10Div"].style.visibility='hidden';	 
		 //alert"Capa 10 - 3");
		 //ocultaCapa("listado10", 'hidden');

	    document.all["Cplistado11"].style.visibility='hidden';
		 //alert"Capa 11 -1");
	    document.all["CpLin1listado11"].style.visibility='hidden';
		 //alert"Capa 11 -2");
	    document.all["CpLin2listado11"].style.visibility='hidden';
		 //alert"Capa 11 -3");
	    document.all["CpLin3listado11"].style.visibility='hidden';
		 //alert"Capa 11 -4");
	    document.all["CpLin4listado11"].style.visibility='hidden';
		 //alert"Capa 11 -5");
	    document.all["Anterior11Div"].style.visibility='hidden';	    
		 //alert"Capa 11 -6");


//Paginado SIEMPRE OCULTO
       document.all["primera0Div"].style.visibility='hidden';	     
	    document.all["ava0Div"].style.visibility='hidden';
	    document.all["ret0Div"].style.visibility='hidden';
	    document.all["primera1Div"].style.visibility='hidden';	     
	    document.all["ava1Div"].style.visibility='hidden';
	    document.all["ret1Div"].style.visibility='hidden';
	    document.all["primera2Div"].style.visibility='hidden';	     
	    document.all["ava2Div"].style.visibility='hidden';
	    document.all["ret2Div"].style.visibility='hidden';	    
	    document.all["primera3Div"].style.visibility='hidden';	     
	    document.all["ava3Div"].style.visibility='hidden';
	    document.all["ret3Div"].style.visibility='hidden';	    
	    document.all["primera4Div"].style.visibility='hidden';	     
	    document.all["ava4Div"].style.visibility='hidden';
	    document.all["ret4Div"].style.visibility='hidden';	    
	    document.all["primera5Div"].style.visibility='hidden';	     
	    document.all["ava5Div"].style.visibility='hidden';
	    document.all["ret5Div"].style.visibility='hidden';	    
	    document.all["primera6Div"].style.visibility='hidden';	     
	    document.all["ava6Div"].style.visibility='hidden';
	    document.all["ret6Div"].style.visibility='hidden';	    
	    document.all["primera7Div"].style.visibility='hidden';	     
	    document.all["ava7Div"].style.visibility='hidden';
	    document.all["ret7Div"].style.visibility='hidden';	    
	    document.all["primera8Div"].style.visibility='hidden';	     
	    document.all["ava8Div"].style.visibility='hidden';
	    document.all["ret8Div"].style.visibility='hidden';	    
	    document.all["primera9Div"].style.visibility='hidden';	     
	    document.all["ava9Div"].style.visibility='hidden';
	    document.all["ret9Div"].style.visibility='hidden';	    
	    document.all["primera10Div"].style.visibility='hidden';	     
	    document.all["ava10Div"].style.visibility='hidden';
	    document.all["ret10Div"].style.visibility='hidden';	    
	    document.all["primera11Div"].style.visibility='hidden';	     
	    document.all["ava11Div"].style.visibility='hidden';
	    document.all["ret11Div"].style.visibility='hidden';


//Código común obligado.	    
       DrdEnsanchaConMargenDcho('listado0',12);
	    DrdEnsanchaConMargenDcho('listado1',12);
	    DrdEnsanchaConMargenDcho('listado2',12);
	    DrdEnsanchaConMargenDcho('listado3',12);
	    DrdEnsanchaConMargenDcho('listado4',12);
	    DrdEnsanchaConMargenDcho('listado5',12);
	    DrdEnsanchaConMargenDcho('listado6',12);
	    DrdEnsanchaConMargenDcho('listado7',12);		    	        	    
	    DrdEnsanchaConMargenDcho('listado8',12);	    
	    DrdEnsanchaConMargenDcho('listado9',12);		    
	    DrdEnsanchaConMargenDcho('listado10',12);	    
	    DrdEnsanchaConMargenDcho('listado11',12);	    
	    eval (ON_RSZ);  	    

		mostrarCapas();
		actualizaChkIndActivo();
//		alert("Fin Init");
	}

	function fnErrores()
	{

			var codigoError = get("frmInsertarCliente.errCodigo");

			// Para Prueba
			//codigoError = "5";
			//set("frmInsertarCliente.errDescripcion", "Prueba de Error");
			if (codigoError != "")
			{
				fMostrarMensajeError();
			}


	}


	function ocultaCapa(nombreCapa, valorVisibilidad)
	{
		 var capaMain = "Cp" + nombreCapa;
		 var capaLinea1 = "CpLin1" + nombreCapa;
		 var capaLinea2 = "CpLin2" + nombreCapa;
		 var capaLinea3 = "CpLin3" + nombreCapa;
		 var capaLinea4 = "CpLin4" + nombreCapa;


	    document.all[capaMain].style.visibility= valorVisibilidad;
	    document.all[capaLinea1].style.visibility= valorVisibilidad;
	    document.all[capaLinea2].style.visibility= valorVisibilidad;
	    document.all[capaLinea3].style.visibility= valorVisibilidad;
	    document.all[capaLinea4].style.visibility= valorVisibilidad;  


	}

	function mostrarCapas()
	{
			// Muestra las capas correspondientes de las listas,
			// de acuerdo al valor de la variable de form. hidCapasAMostrar. 

			var nivel = get("frmInsertarCliente.hidCapasAMostrar");
			//alert("Nivel: " + nivel);

			//alert("mostrarCapas: " + parseInt(nivel, 10) );
			
			switch ( parseInt(nivel, 10) )
			{
				case 0:
					 //alert("Pestaña 1");
					 document.all["Cplistado0"].style.visibility='visible';
					 document.all["CpLin1listado0"].style.visibility='visible';
					 document.all["CpLin2listado0"].style.visibility='visible';
					 document.all["CpLin3listado0"].style.visibility='visible';
					 document.all["CpLin4listado0"].style.visibility='visible';
					 document.all["Siguiente0Div"].style.visibility='visible';					
/*					 document.all["imagenBuffer1"].firstChild.style.height="10";
					 document.all["imagenBuffer2"].firstChild.style.height="10";
 					 seteaPestanyas(0);*/
					 cargaDatos(0);
					 //deshabilitar(0);
					 break;

				case 1: 
					 //alert("Mostrando 1");
					 document.all["Cplistado1"].style.visibility='visible';
					 document.all["CpLin1listado1"].style.visibility='visible';
					 document.all["CpLin2listado1"].style.visibility='visible';
					 document.all["CpLin3listado1"].style.visibility='visible';
					 document.all["CpLin4listado1"].style.visibility='visible';
					 document.all["Anterior1Div"].style.visibility='visible';	    
					 document.all["Siguiente1Div"].style.visibility='visible';

/*					 document.all["imagenBuffer1"].firstChild.style.height="10";
					 document.all["imagenBuffer2"].firstChild.style.height="10";
 					 seteaPestanyas(1);*/
					 cargaDatos(1);
					 //deshabilitar(1);
					 break;
				case 2:
					//alert("Mostrando 2");
					ocultaCapa("listado2", 'visible');
					ocultaCapa("listado3", 'visible');
					ocultaCapa("listado4", 'visible');
/*				   document.all["imagenBuffer1"].firstChild.style.height="1007";
					document.all["imagenBuffer2"].firstChild.style.height="1007";
 					seteaPestanyas(2); */
					cargaDatos(2);
					//deshabilitar(2);
					break;

				case 3: 
					//alert("Mostrando 3");
					ocultaCapa("listado5", "visible");
					ocultaCapa("listado6", "visible");
					document.all["Cplistado7"].style.visibility='visible';
					document.all["CpLin1listado7"].style.visibility='visible';
					document.all["CpLin2listado7"].style.visibility='visible';
					document.all["CpLin3listado7"].style.visibility='visible';
					document.all["CpLin4listado7"].style.visibility='visible';
					document.all["Anterior7Div"].style.visibility='visible';	    
					document.all["Siguiente7Div"].style.visibility='visible';	 
/*					document.all["imagenBuffer1"].firstChild.style.height="10";
					document.all["imagenBuffer2"].firstChild.style.height="10";
					seteaPestanyas(3);*/
					cargaDatos(3);
					//deshabilitar(3);
					break;

   		   case 4:
					//alert("Mostrando 4");
				   ocultaCapa("listado8", 'visible');
				   ocultaCapa("listado9", 'visible');
   		      ocultaCapa("listado10", 'visible');
					document.all["Cplistado11"].style.visibility='visible';
					document.all["CpLin1listado11"].style.visibility='visible';
					document.all["CpLin2listado11"].style.visibility='visible';
					document.all["CpLin3listado11"].style.visibility='visible';
					document.all["CpLin4listado11"].style.visibility='visible';
					document.all["Anterior11Div"].style.visibility='visible';	    
/*					document.all["imagenBuffer1"].firstChild.style.height="10";
					document.all["imagenBuffer2"].firstChild.style.height="10";
 					seteaPestanyas(4); */
					cargaDatos(4);
					//deshabilitar(4);
					break;

			}

			// Oculta la capa temporal.

			//document.all["capaFull"].style.visibility='hidden';


			// Si es la segunda pestaña, se muestra la capa de los combos (se oculto desde la LP
			// para que no se vieran los combos arriba de la capa temporal
			if (parseInt(nivel, 10) == 2)
					document.all["capaFormulario2"].style.visibility = "visible";


	}


 function navegaPestaniasDetalle(pestanya)
 {
		//alert("navegaPestanyas");
      set('frmInsertarCliente.conectorAction', 'LPBusquedaCliente');
		set('frmInsertarCliente.accion', "consultar");

//		alert("pestanya a navegar: " + pestanya);

		var pestActual = get("frmInsertarCliente.hidPestanya"); // Obtiene el numero de pestanya donde se está parado.
//		alert("pestActual");

		// Solo se navega si la pestanya destino no es la misma que la que se está parado.
		if  ( parseInt(pestActual, 10) != parseInt(pestanya,10) )
		{
				//alert("if");
				//alert( parseInt(pestanya, 10) );
				if (pestanya == 0)
				{
					set("frmInsertarCliente.hidPestanya", "0");
				}
				if (pestanya == 1)
				{
					//alert("Pestanya 1");
				  set("frmInsertarCliente.hidPestanya", "1");
			   }
				if (pestanya == 2)
				{
					//alert("Pestanya 2");
				  set("frmInsertarCliente.hidPestanya", "2");

				}
				if (pestanya == 3)
				{
					//alert("Pestanya 3");
				  set("frmInsertarCliente.hidPestanya", "3");
				}

				if (pestanya == 4)  
				{
					//alert("Pestanya 4");
					set("frmInsertarCliente.hidPestanya", "4");
				}


				enviaSICC('frmInsertarCliente');  
		}
}
	function cargaDatos(pestanya)
	{
		//alert("i18n - Pestanya: " + pestanya);
		switch (	 parseInt(pestanya, 10) )
		{
				case 1: 
					
					// Internacionaliza los 1 y 0 de DocPrincipal por Si/No
					// y los P y E por Persona y Empresa (internacionalizados, tambien)
					//alert("Internacionaliza Pestanya 1");

					var si = GestionarMensaje("1010", null, null, null);
					var no = GestionarMensaje("1011", null, null, null);

					var persona = GestionarMensaje("1043", null, null, null);
					var empresa = GestionarMensaje("1050", null, null, null);

					var codigos = listado1.codigos();
					var cantFilas = codigos.length;

					//alert("codigos: " + codigos);
					for (var i = 0; i < cantFilas; i++)
					{
						// Documento Principal
						var SiNo = listado1.extraeDato(codigos[i], 2); 
						//alert("Fila " + i + ": " + SiNo);
						if (SiNo == "1")
						{
							listado1.insertaDato(codigos[i], 2, si);
							//alert("si: " + si);
						}
						else
						{
							listado1.insertaDato (codigos[i], 2, no);
							//alert("no: " + no);
						}

						// Persona o Empresa.
						var PersonaEmpresa = listado1.extraeDato(codigos[i], 3);
						if (PersonaEmpresa == "P")
							listado1.insertaDato(codigos[i], 3, persona);
						else
							listado1.insertaDato(codigos[i], 3, empresa);
					}
					break;
				
				case 2: 

					 //  ------------ Internacionaliza el campo Tratamiento ----------------
					 var codTratamiento = get("frmInsertarCliente.hidTratamiento");
					 var descTratamiento = "";
					 if (codTratamiento == 0)  // Sr. 
							descTratamiento = GestionarMensaje("1031", null, null, null);
					 if (codTratamiento == 1) // Sra. 
							descTratamiento = GestionarMensaje("1032", null, null, null);
					 if (codTratamiento == 2) // Srta. 
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

					 // ------------ Inbound / Outbound ------------------------------
/*					 var inbound = get("frmInsertarCliente.hidInbound");
					 if (inbound != "")
					 {
							if (inbound == "I")
								set("frmInsertarCliente.cbCodTipoContactado", new Array("I") );
							else if (inbound == "O")
								set("frmInsertarCliente.cbCodTipoContactado", new Array("O") );
					 } */

					 // ----------- Tipo Cliente Contactado ----------------------------
/*					 var tipoClienteContactado = get("frmInsertarCliente.hidTipoClienteContactado");
					 var datosCombo = new Array();

					 if (tipoClienteContactado != "")
					 {
							datosCombo[0] = [0, tipoClienteContactado];
							set_combo("frmInsertarCliente.cbTipoClienteContactado", datosCombo);
							set("frmInsertarCliente.cbTipoClienteContactado", new Array("0") );
					 }*/

					 // ------------- Pais Cliente Contactado ---------------------------
/*					 var paisClienteContactado = get("frmInsertarCliente.hidPaisClienteContactado");
					 var datosCombo = new Array();

					 if ( paisClienteContactado != "")
					 {
							 datosCombo[0] = [0, paisClienteContactado];
							 set_combo("frmInsertarCliente.cbPaisContactado", datosCombo);
							 set("frmInsertarCliente.cbTipoClienteContactado", new Array("0") );
					 }*/


					 // ---------- Actualiza campo Edad si hay una Fecha de Nacimiento ---------------
					 var fechaNacimiento = get("frmInsertarCliente.hFechaNacimiento");

					 if (fechaNacimiento != "")
						actualizaFechaNacimiento(fechaNacimiento);
					 else
						txt_to('lbl2dtEdad',"");	

					 break;

				case 3:

					// -------------- Lista Tipo de Comunicacion ----------------------
					var codigos = listado6.codigos();
					var cantElem = codigos.length;

					var si = GestionarMensaje("1010", null, null, null);
					var no = GestionarMensaje("1011", null, null, null);

					var LunesAViernes = GestionarMensaje('1332', null, null, null)
					var LunesADomingo = GestionarMensaje('1333', null, null, null)

					var dias = new Array();
					for (var i = 0; i < 7; i++)
						dias[i] = GestionarMensaje(1034 + i, null, null, null);

					var iniciales = new Array();
					iniciales[0] = "D";
					iniciales[1] = "L";
					iniciales[2] = "M";
					iniciales[3] = "I";
					iniciales[4] = "J";
					iniciales[5] = "V";
					iniciales[6] = "S";

					for (var i = 0; i < cantElem; i++)
					{
							// Internacionaliza SI/No,  Dias de la Semana e Intervalo Comunicacion.
						var SiNo = listado6.extraeDato(codigos[i], 3); 
						if (SiNo == "1")
							listado6.insertaDato(codigos[i], 3, si);
						else
							listado6.insertaDato(codigos[i], 3, no);

						for (var j = 0; j < 7; j++)
						{
							var inicialDia = listado6.extraeDato(codigos[i], 1); 
							if ( inicialDia == iniciales[j] )
								listado6.insertaDato(codigos[i], 1, dias[j]);									
						}

						var intervalo = listado6.extraeDato(codigos[i], 6);
						if ( intervalo == "1")
							listado6.insertaDato(codigos[i], 6, LunesADomingo);
						else
							listado6.insertaDato(codigos[i], 6, LunesAViernes);
	
						
					}

					// ------------- Lista Direcciones -----------------------

					var codigos = listado5.codigos();
					var cantElem = codigos.length;

					var si = GestionarMensaje("1010", null, null, null);
					var no = GestionarMensaje("1011", null, null, null);

					for (var i = 0; i < cantElem; i++)
					{//Cleal - MAE-005
						var SiNo = listado5.extraeDato(codigos[i], 7); 
						//alert("FIla " + i + ": " + SiNo);
						if (SiNo == "1")
							listado5.insertaDato(codigos[i], 7, si);
						else
							listado5.insertaDato(codigos[i], 7, no);
					}

					break;

				case 4:
					// ------------- Internacionaliza Si / No de Lista Problema - Solucion -------------------
					var codigos = listado10.codigos();
					//alert("codigos: " + codigos);
					var cantElem = codigos.length;

					var si = GestionarMensaje("1010", null, null, null);
					var no = GestionarMensaje("1011", null, null, null);
					
					for (var i = 0; i < cantElem; i++)
					{
							// Internacionaliza SI/No y Dias de la Semana.
						var SiNo = listado10.extraeDato(codigos[i], 2); 
						//alert("SI/NO Fila: " + i + ": " + SiNo);
						if (SiNo == "true")
							listado10.insertaDato(codigos[i], 2, si);
						else
							listado10.insertaDato(codigos[i], 2, no);
					}

					break;
		}  


  }

  function seteaPestanyas(pestanya)
  {
			  switch ( parseInt(pestanya, 10) )
			  {
					case 0: 
						document.getElementById("ConsultarP0").style.backgroundColor = "#496A9A";
						document.getElementById("ConsultarP0").style.color = "#FFFFFF";
						seteaTitulosPestanyas();
						break;

					case 1: 
						document.getElementById("ConsultarP1").style.backgroundColor = "#496A9A";
						document.getElementById("ConsultarP1").style.color = "#FFFFFF";
						seteaTitulosPestanyas();
						break;

					case 2:
						document.getElementById("ConsultarP2").style.backgroundColor = "#496A9A";
						document.getElementById("ConsultarP2").style.color = "#FFFFFF";
						seteaTitulosPestanyas();
						break;

					case 3:
						document.getElementById("ConsultarP3").style.backgroundColor = "#496A9A";
						document.getElementById("ConsultarP3").style.color = "#FFFFFF";
						seteaTitulosPestanyas();
						break;

					case 4:
						document.getElementById("ConsultarP4").style.backgroundColor = "#496A9A";
						document.getElementById("ConsultarP4").style.color = "#FFFFFF";
						seteaTitulosPestanyas();

						break;

			  }



	  }

	  function seteaTitulosPestanyas()
	  {
			var tituloP = GestionarMensaje("1511", null, null, null);
			document.getElementById("ConsultarP0").innerText = tituloP;
		
			var tituloP = GestionarMensaje("1507", null, null, null);
			document.getElementById("ConsultarP1").innerText = tituloP;

			var tituloP = GestionarMensaje("1508", null, null, null);
			document.getElementById("ConsultarP2").innerText = tituloP;

			var tituloP = GestionarMensaje("1509", null, null, null);
			document.getElementById("ConsultarP3").innerText = tituloP;

			var tituloP = GestionarMensaje("1510", null, null, null);
			document.getElementById("ConsultarP4").innerText = tituloP;

	  }

	  function deshabilitar(pestanya)
	  {
				// Deshabilita los controles para una pestaña dada.
				//alert("Deshabilitar " + pestanya);

				switch ( parseInt(pestanya, 10) )
				{

						case 1: 

							break;

						case 2: 

								accion("frmInsertarCliente.textApellido1", ".disabled=true");
								accion("frmInsertarCliente.textApellido2", ".disabled=true");
								accion("frmInsertarCliente.textApellidoCasada", ".disabled=true");
								accion("frmInsertarCliente.textNombre1", ".disabled=true");
								accion("frmInsertarCliente.textNombre2", ".disabled=true");
								accion("frmInsertarCliente.cbTratamiento", ".disabled=true");
								accion("frmInsertarCliente.cbFormaPago", ".disabled=true");
								accion("frmInsertarCliente.textFechaNacimiento", ".disabled=true");
								accion("frmInsertarCliente.textCodEmpleado", ".disabled=true");
								accion("frmInsertarCliente.cbNacionalidad", ".disabled=true");
								accion("frmInsertarCliente.cbEstadoCivil", ".disabled=true");
								accion("frmInsertarCliente.textOcupacion", ".disabled=true");
								accion("frmInsertarCliente.textProfesion", ".disabled=true");
								accion("frmInsertarCliente.textCentroTrabajo", ".disabled=true");
								accion("frmInsertarCliente.textCargoDesempena", ".disabled=true");
								accion("frmInsertarCliente.cbNivelEstudios", ".disabled=true");
								accion("frmInsertarCliente.textCentroEstudios", ".disabled=true");
								accion("frmInsertarCliente.textNHijos", ".disabled=true");
								accion("frmInsertarCliente.textNPersonasDependientes", ".disabled=true");
								accion("frmInsertarCliente.cbNivelSocioEconomico", ".disabled=true");
								accion("frmInsertarCliente.cbCicloVidaFamiliar", ".disabled=true");
								accion("frmInsertarCliente.textImporteIngresoFamiliar", ".disabled=true");
								accion("frmInsertarCliente.cbPaisContactado", ".disabled=true");
								accion("frmInsertarCliente.textCodClienteContactado", ".disabled=true");
								accion("frmInsertarCliente.cbTipoClienteContactado", ".disabled=true");
								accion("frmInsertarCliente.cbCodTipoContactado", ".disabled=true");
								accion("frmInsertarCliente.textFechaContacto", ".disabled=true");
								accion("frmInsertarCliente.textFecha1PedidoContacto", ".disabled=true");
								accion("frmInsertarCliente.textFechaSiguienteContacto", ".disabled=true");

							break;

						case 3:
							break;

						case 4: 
							break;


				}

	  }

	  function fVolver()
	  {
			window.close();
	  }
//---------------------------------------------------------------------------------------------------------------------
function actualizaChkIndActivo(){
//	alert(get("frmInsertarCliente.hchkIndActivo"));
	if(get("frmInsertarCliente.hchkIndActivo")== "1"){
//		alert("*** En 1");
		set('frmInsertarCliente.ckIndActivo','S');
		
	} else{
//			alert("*** En 0");	
			set('frmInsertarCliente.ckIndActivo','N');
				
	}
	
	document.getElementById("ckIndActivo").disabled = true;
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
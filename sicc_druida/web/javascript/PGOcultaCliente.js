/**
* Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* Espa�a
*
* Privado y Confidencial.
* La informaci�n contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permiti�ndose
* la distribuci�n de este c�digo sin permiso expreso.
*/ 


/*
    INDRA/CAR/PROY
    $Id: PGOcultaCliente.js,v 1.1 2009/12/03 19:02:14 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmFormulario';



    function cerrarVentana() {
          // Muestro la infirnaci�n en la p�gina RegistroVentas 
         var oidCliente = get(FORMULARIO + '.oidCliente');
         var nombre1 = get(FORMULARIO + '.nombre1');
         var nombre2 = get(FORMULARIO + '.nombre2');
         var apellido1 = get(FORMULARIO + '.apellido1');
         var apellido2 = get(FORMULARIO + '.apellido2');
		 window.opener.asignarDatosCliente(oidCliente, nombre1, nombre2, apellido1, apellido2) 
		 window.close();
     }
/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import LPSICCBase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
 
public class LPInsertarReclamos extends LPSICCBase {

          public LPInsertarReclamos() {
                    super();
          }
          
          public void inicio() throws Exception {
          
          }

          public void ejecucion() throws Exception {
          	rastreo();
          	setTrazaFichero();
          	traza("*** Entrada - LPInsertarReclamos - ejecucion ***");
                try  {
                   	conectorAction("LPMantenimientoReclamos"); 
			conectorActionParametro("accion","insertar_menu_principal"); 
                }catch ( Exception e ) {
                        logStackTrace(e);
                        lanzarPaginaError(e);
                }
           traza("*** Salida - LPInsertarReclamos - ejecucion ***");
          }

    private void logStackTrace(Throwable e) throws Exception {
                    traza("Se produjo la excepcion: " + e.getMessage());
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(baos);
                    e.printStackTrace(ps);
                    traza("Stack Trace: " + baos.toString());
     }

}
































/*
import java.util.Vector;
import java.util.Date;
import java.util.Calendar;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.druida.DruidaConector;
 
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesFecha;

import es.indra.sicc.dtos.ccc.DTOBancoSucursal;
import es.indra.sicc.dtos.ccc.DTOCargaInicialReclamos;
import es.indra.sicc.dtos.ccc.DTOReclamo;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// Definicion de la clase
public class LPInsertarReclamos extends LPSICCBase {
	
	Long pais = null;
        Long idioma = null; 
        String fechaD= null;
    // Definicion del constructor
    public LPInsertarReclamos() {super();}

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {

      	
	}
    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
    	 rastreo();
         try{
                            
                setTrazaFichero();
                traza("***Entrada - LPInsertarReclamos - ejecucion***");
                
                  // Defino el nombre de la vista
        	pagina("contenido_reclamos_insertar");
        	
        	this.idioma = UtilidadesSession.getIdioma(this);
                this.pais = UtilidadesSession.getPais(this);
      
                String accion = conectorParametroLimpia("accion","",true);
                traza("***accion : "+accion);
                    
                  //Bifurcamos la accion
                  if ( accion.equals("")) {
                  	//Rellena datos generales de la pagina
	       		accionVacia();
	       		
                  }
                  if ( accion.equals("guardar")) {
                  	   accionGuardar();
                  }
                 traza("cs AAAAntes de getConfiguraciion menu");
                 //getConfiguracionMenu("LPInsertarReclamos",accion);
                 getConfiguracionMenu("LPInsertarReclamos","");
                  
                 
                 
                
                 traza("***Salida - LPInsertarReclamos - ejecucion***");
         }catch(Exception e){
                  logStackTrace(e);
                  lanzarPaginaError(e);
         }
    }
  
private void accionVacia() throws Exception {
        traza("***Entrada - LPInsertarReclamos - accionVacia");
			
		//-Creamos un DTOBancoSucursal con el pais y el idioma del usuario.
		// (los atributos sucursal y banco se quedan a null). 
	asignarAtributo("VAR", "idioma", "valor",this.idioma.toString());
	traza("IIIIIdioma= " + this.idioma.toString());
	asignarAtributo("VAR", "pais", "valor", this.pais.toString());
	asignarAtributo("VAR", "casoUso", "valor", "insertar");
	traza("ANTES DE ASIGNAR CODIGO ");
	asignarAtributo("PAGINA","contenido_reclamos_insertar","cod","0532");
	asignarAtributo("PAGINA","contenido_reclamos_insertar","msgle","Insertar reclamos");
	//getConfiguracionMenu("LPInsertarReclamos","");
        
        
	                


	
        
        //Se instancia un DTOBelcorp
        DTOBancoSucursal dtoEntrada = new DTOBancoSucursal();
        dtoEntrada.setOidPais(this.pais);
        dtoEntrada.setOidIdioma(this.idioma);
        
        //-Llamamos al idBussiness CCCCargaInicialReclamos
        MareBusinessID idBussiness = new MareBusinessID("CCCCargaInicialReclamos");
          
        //Almacenamos los parametros de entrada
        Vector paramEntrada = new Vector();
        paramEntrada.addElement(dtoEntrada);
        paramEntrada.addElement(idBussiness);
         
        traza ("Llamo a conectar");
        
        //- Se invoca al ConectorCargaInicialReclamo 
        DruidaConector conector = conectar("ConectorCargaInicialReclamo", paramEntrada);
       traza ("vuelvo de conectar");
		//-Con el dto obtenido cargamos los combos correpondientes; 
		//salvo en los casos de acceso y subacceso en los que guardamos 
		//los recordsets correspondientes en listas ocultas con las que recargaremos 
		//dichos combos. Como los recordsets sucursales y cuentas deben venir vacios 
		//no cargamos los combos correspondientes. 
		
		DTOCargaInicialReclamos dtoCarga = (DTOCargaInicialReclamos) conector.objeto("DTOSalida");
		
		//canales
		RecordSet rsCanal = dtoCarga.getCanales();
		 
        Vector cols = rsCanal.getColumnIdentifiers();
        DruidaConector conectorCanales = UtilidadesBelcorp.generarConector(
                                         "DTOCargaInicialReclamos.canales",rsCanal,cols);
        asignar("COMBO","cbCanal",conectorCanales,"DTOCargaInicialReclamos.canales");
        
        RecordSet rsUsuarios = dtoCarga.getUsuarios();
        traza("rsUsuarios=========" + rsUsuarios);
        if(dtoCarga.getUsuarios()!=null){
        	cols = rsUsuarios.getColumnIdentifiers();
         	traza("rsUsuarios=========" + rsUsuarios);
        	DruidaConector conectorUsuarios = UtilidadesBelcorp.generarConector(
                                         "DTOCargaInicialReclamos.usuarios",rsUsuarios,cols);
       
        	asignar("COMBO","cbUsuarioGestorReclamoReal",conectorUsuarios,"DTOCargaInicialReclamos.usuarios");
        	asignar("COMBO","cbUsuarioGestorReclamoPrevisto",conectorUsuarios,"DTOCargaInicialReclamos.usuarios");
	}
		//accesos  
	RecordSet rsAccesos = dtoCarga.getAccesos();
       	cols = rsAccesos.getColumnIdentifiers();
	DruidaConector conectorAcceso = UtilidadesBelcorp.generarConector(
											"DTOCargaInicialReclamos.acceso", rsAccesos, cols);
        asignar("MATRIZJS", "datosAccesos", conectorAcceso);
     
		//subaccesos
		RecordSet rsSubaccesos = dtoCarga.getSubaccesos();
		cols = rsSubaccesos.getColumnIdentifiers();
		DruidaConector conectorSubacceso = UtilidadesBelcorp.generarConector(
											"DTOCargaInicialReclamos.subacceso", rsSubaccesos, cols);
        asignar("MATRIZJS", "datosSubaccesos", conectorSubacceso);
		
		//bancos
		RecordSet rsBancos = dtoCarga.getBancos();
        cols = rsBancos.getColumnIdentifiers();
        DruidaConector conectorBancos = UtilidadesBelcorp.generarConector(
                                         "DTOCargaInicialReclamos.bancos",rsBancos,cols);
        asignar("COMBO","cbBancoRecaudacion",conectorBancos,"DTOCargaInicialReclamos.bancos");
		
		//RecordSet sucursales (Vacios)
		//RecordSet cuentas (Vacios)
		
		//mediosPago
		RecordSet rsPagos = dtoCarga.getMediosPago();
        cols = rsPagos.getColumnIdentifiers();
        DruidaConector conectorPagos = UtilidadesBelcorp.generarConector(
                                         "DTOCargaInicialReclamos.mediosPago",rsPagos,cols);
        asignar("COMBO","cbMedioPago",conectorPagos,"DTOCargaInicialReclamos.mediosPago");
		
		//periodos
		RecordSet rsPeriodos = dtoCarga.getPeriodos();
        cols = rsPeriodos.getColumnIdentifiers();
        DruidaConector conectorPeriodos = UtilidadesBelcorp.generarConector(
                                         "DTOCargaInicialReclamos.periodos",rsPeriodos,cols);
        asignar("COMBO","cbPeriodoReclamante",conectorPeriodos,"DTOCargaInicialReclamos.periodos");
		
		//motivosRechazoDesbloqueo //BELC300004710
		RecordSet rsMotivos = dtoCarga.getMotivosRechazoDesbloqueo();
		traza("  cbCodigoSolucionRechazo rsMotivosDE RACHAZO = " + rsMotivos);
        cols = rsMotivos.getColumnIdentifiers();
        DruidaConector conectorMotivos = UtilidadesBelcorp.generarConector(
                                         "DTOCargaInicialReclamos.motivosRechazoDesbloqueo",rsMotivos,cols);
        asignar("COMBO","cbCodigoSolucionRechazo",conectorMotivos,"DTOCargaInicialReclamos.motivosRechazoDesbloqueo");
		
		//situaciones
		//en el combo situación seleccionamos el elemento cuyo value es 1 (Solicitado) (Se pedia mas abajo)
		RecordSet rsSituaciones = dtoCarga.getSituaciones();
        cols = rsSituaciones.getColumnIdentifiers();
        traza("rsSituaciones = " +rsSituaciones);
        DruidaConector conectorSituaciones = UtilidadesBelcorp.generarConector(
                                         "DTOCargaInicialReclamos.situaciones",rsSituaciones,cols);
        asignar("COMBO","cbSituacion",conectorSituaciones,"DTOCargaInicialReclamos.situaciones",cols.get(0).toString(),"1");
	traza("Cargamos El combo situacion con valor 1 ");
	asignar("VAR","situacion", "1");

		//empresas
		traza("dtoCarga.getEmpresas" + dtoCarga.getEmpresas());
	if(dtoCarga.getEmpresas()!=null){
		
		RecordSet rsEmpresa = dtoCarga.getEmpresas();
        	cols = rsEmpresa.getColumnIdentifiers();
        	DruidaConector conectorEmpresas = UtilidadesBelcorp.generarConector(
                                         "DTOCargaInicialCargosAbonos.empresas",rsEmpresa,cols);
        	asignar("COMBO","cbEmpresa",conectorEmpresas,"DTOCargaInicialCargosAbonos.empresas");
        }
        
        //numero lote //BELC300004710
        Integer numLote = dtoCarga.getNumero();
        traza("CCCCCCCCCnumLote " +numLote);
        if(numLote != null) {
        	asignarAtributo("LABELC","lbldtNumIdentificacion","valor",numLote.toString());
        	asignar("VAR","hid_numLote", numLote.toString());
        }
        
        //longitudCodigoCliente  
        Byte longitud = this.obtenerLongitudCodigoCliente();
		Long longitudCodigoCliente = new Long(longitud.longValue());
		asignarAtributo("VAR","longitudCodigoCliente","valor",longitudCodigoCliente.toString());
        
        //Además rellenamos los siguientes campos con valores por defecto. 
		//fechaDocumento = ponemos la fecha actual 
		 traza ("fechaD");
		
		this.fechaD = UtilidadesBelcorp.fechaFormateada(new java.util.Date(), UtilidadesSession.getFormatoFecha(this));
		asignarAtributo("LABELC","lbldtFechaDoc","valor",this.fechaD);
		 traza ("des pues de asignarla fechaD");
		//en usuarioSolicitante ponemos el código de usuario del usuario 
		//actual del sistema, cogiendolo de la sesión. 
		String usuario = UtilidadesSession.getIdUsuario(this);
		asignarAtributo("LABELC", "lblUsuarioSolicitantedt", "valor" , usuario);
		asignar("VAR","hUsuarioSolicitante", usuario);
		//en pais ponemos la descripcion del pais activo 
	//CAMBIOS EN LA MAQUETACION
	String desPais = UtilidadesSession.getDescripcionPais(this);
	//CAMBIOS EN LA MAQUETACION   asignarAtributo("LABELC", "lblPaisActual", "valor", desPais);DESAPARECE
	asignar("VAR","hPais", desPais);
		//en año ponemos las dos ultimas cifras del año actual del sistema 
		//en periodoMes ponemos el número de mes actual con dos cifras. 
      	String anyo = UtilidadesFecha.convertirAString(new Date(System.currentTimeMillis()),"yy");
      	String mes = UtilidadesFecha.convertirAString(new Date(System.currentTimeMillis()),"MM");
      	asignarAtributo("LABELC","lbldtAño","valor",anyo);
      	asignarAtributo("LABELC","lbldtMes","valor",mes);
      	
      	asignar("VAR","hAnyo", anyo);
      	asignar("VAR","hPeriodoMes", mes);
      	
      	String anyoFormal = UtilidadesFecha.convertirAString(new Date(System.currentTimeMillis()),"yyyy");
		asignar("VAR","hAnyoFormal",anyoFormal);
	
    	//Guardamos los valores de los separadores
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
	    String separadorMiles = ",";
		if (separadorDecimales.equals(",")) {
			 separadorMiles = ".";
		}
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
    
       
        //Generamos el hidden para el formato de fecha
        this.generarHiddenFormatoFecha();
        
        //Datos preseleccionados
		Long canal = UtilidadesSession.getCanalPorDefecto(this);
		if (canal != null) {
			asignar("VAR", "canal", canal.toString());
		}
		Long empresa = UtilidadesSession.getSociedadPorDefecto(this);
		if (empresa != null) {
			asignar("VAR", "empresa", empresa.toString());
		}
 		Long subacceso = UtilidadesSession.getSubaccesoPorDefecto(this);
		if (subacceso != null) {
			asignar("VAR", "subacceso", subacceso.toString());
		}
		
		traza("***Salida -  LPInsertarReclamos - accionVacia");
    }
    
private void accionGuardar() throws Exception {
        traza("***Entrada - LPInsertarReclamos - accionGuardar");

        //Salida Generica
        pagina("salidaGenerica");
        asignar("VAR", "cerrarVentana", "false");
	asignar("VAR", "ejecutar", "insercionCorrecta()");
        
        //Creamos un DTOReclamo y lo rellenamos con los campos correspondientes 
        //de la pantalla (salvo el oid, que no lo tenemos). 
        DTOReclamo dtoCarga = new DTOReclamo();
        
        UtilidadesSession sesion = new UtilidadesSession();
        Long pais = sesion.getPais(this); 
        Long idioma = sesion.getIdioma(this);
        dtoCarga.setOidPais(pais);
        dtoCarga.setOidIdioma(idioma);
        
        
        traza("dtoCarga.getOidPais" + dtoCarga.getOidPais());
        traza("dtoCarga.setOidIdioma(idioma);" +dtoCarga.getOidIdioma());
        //Anyo
        String anyo = conectorParametroLimpia("hAnyoFormal","",true);
        if(!anyo.equals("")) {
        	dtoCarga.setAnyo(anyo);
        }
        //Periodo Mes
        String periodoMes = conectorParametroLimpia("hPeriodoMes","",true);
        if(!periodoMes.equals("")) {
        	dtoCarga.setPeriodoMes(periodoMes);
        }
        //Numero Lote
        String numeroLote = conectorParametroLimpia("hid_numLote","",true);
        
        if(!numeroLote.equals("")) {
        	dtoCarga.setNumeroLote(new Integer(numeroLote));
        }
        //Banco
        String bancoRecaudacion = conectorParametroLimpia("cbBancoRecaudacion","",true);
        if(!bancoRecaudacion.equals("")) {
        	dtoCarga.setBancoRecaudacion(new Long(bancoRecaudacion));
        }
        traza("2");
        //Sucursal
        String sucursal = conectorParametroLimpia("cbSucursalRecaudacion","",true);
        if(!sucursal.equals("")) {
        	dtoCarga.setSucursal(new Long(sucursal));
        }
        //Cuenta corriente
        String cuentaCorriente = conectorParametroLimpia("cbCuenta","",true);
        if(!cuentaCorriente.equals("")) {
        	dtoCarga.setCuentaCorriente(new Long(cuentaCorriente));
        }
         traza("3");
        //Codigo Cliente
        String codigoCliente = conectorParametroLimpia("textCodigoClienteReclamante","",true);
        if(!codigoCliente.equals("")) {
        	dtoCarga.setCodigoCliente(codigoCliente);
        }
           traza("3.1");
        //Fecha Documento
        //String fechaDocumento = conectorParametroLimpia("lbldtFechaDoc,"",true);
	//	if(!fechaDocumento.equals("")) {
	
	this.fechaD = UtilidadesBelcorp.fechaFormateada(new java.util.Date(), UtilidadesSession.getFormatoFecha(this));
	traza("this.fechaD, " + this.fechaD);
	dtoCarga.setFechaDocumento(UtilidadesBelcorp.getDatefromSICCStringFormat(this.fechaD, UtilidadesSession.getFormatoFecha(this)));
	  traza("3.2");
	
	//	}
	//Siutacion
		
		String situacion = conectorParametroLimpia("cbSituacion","",true);
        if(!situacion.equals("")) {
        	dtoCarga.setSituacion(new Long(situacion));
        	traza("situacion" + situacion);
        	
        }
        //Usuario Gestor Previsto
        String usuarioGestorPrevisto = conectorParametroLimpia("textUsuarioGestorReclamoPrevisto","",true);
		if(!usuarioGestorPrevisto.equals("")) {
        	dtoCarga.setUsuarioGestorPrevisto(usuarioGestorPrevisto);
        }
        //Usuario Gestor Real  AHORA ES OBLIGATORIO
        String usuarioGestorReal = conectorParametroLimpia("cbUsuarioGestorReclamoReal","",true);
		if(!usuarioGestorReal.equals("")) {
        	dtoCarga.setUsuarioGestorReal(usuarioGestorReal);
        }
        //Usuario Solicitante
        String usuarioSolicitante = conectorParametroLimpia("hUsuarioSolicitante","",true);
		if(!usuarioSolicitante.equals("")) {
        	dtoCarga.setUsuarioSolicitante(usuarioSolicitante);
        }
        //Canal
        traza("4");
        String canal = conectorParametroLimpia("cbCanal","",true);
        if(!canal.equals("")) {
        	dtoCarga.setCanal(new Long(canal));
        	traza("[cs]canal= "+canal);
        }
        //Acceso
        String acceso = conectorParametroLimpia("cbAcceso","",true);
        if(!acceso.equals("")) {
        	dtoCarga.setAcceso(new Long(acceso));
        	traza("[cs]acceso= "+acceso);
        }
        //Subacceso
        String subacceso = conectorParametroLimpia("cbSubacceso","",true);
        if(!subacceso.equals("")) {
        	dtoCarga.setSubacceso(new Long(subacceso));
        	traza("[cs]subacceso= "+subacceso);
        }
        //Importe Reclamados
        String importeReclamos = conectorParametroLimpia("hid_importe","",true);
		if(!importeReclamos.equals("")) {
	        dtoCarga.setImporteReclamado(new Double(importeReclamos));
	    }
        //Observaciones Cliente Reclamante
        dtoCarga.setObservacionesClienteReclamante(conectorParametroLimpia("textObservacionesClienteReclamante","",true));
  		//Periodo Reclamante
  		String periodo = conectorParametroLimpia("cbPeriodoReclamante","",true);
  		if(!periodo.equals("")) {
  			dtoCarga.setPeriodoReclamante(new Long(periodo));
  		}
		//Motivo Desbloqueo Rechazo
		String motivoDesbloqueoRechazo = conectorParametroLimpia("cbCodigoSolucionRechazo","",true);
		if(!motivoDesbloqueoRechazo.equals("")) {
			dtoCarga.setMotivoDesbloqueoRechazo(new Long(motivoDesbloqueoRechazo));
		}
		  traza("5");
		//Numero de Serie cuota
		//String numeroSerieCuota = conectorParametroLimpia("textNumeroSerieCuota","",true);
		//if(!numeroSerieCuota.equals("")) {
		//	dtoCarga.setNumeroSerieCuota(numeroSerieCuota);
		//}
		//Numero identificador cuota
		String numeroIdentificadorCuota = conectorParametroLimpia("textNumeroIdentificadorCuota","",true);	
		if(!numeroIdentificadorCuota.equals("")) {
			dtoCarga.setNumeroIdentificadorCuota(new Integer(numeroIdentificadorCuota));
		}
		//Ejercicio cuota
		String ejercicioCuota = conectorParametroLimpia("textEjercicioCuota","",true);
		if(!ejercicioCuota.equals("")) {
			dtoCarga.setEjercicioCuota(ejercicioCuota);
		}
		//Numero orden cuota
		String numeroOrdenCuota = conectorParametroLimpia("textNumeroOrdenCuota","",true);	
		if(!numeroOrdenCuota.equals("")) {
			dtoCarga.setNumeroOrdenCuota(new Integer(numeroOrdenCuota));
		}
		//Medio Pago
		String medioPago = conectorParametroLimpia("cbMedioPago","",true);
		if(!medioPago.equals("")) {
			dtoCarga.setMedioPago(new Long(medioPago));
		}
		//Numero Cargo Abono Directo
		String numeroCargoAbonoDirecto = conectorParametroLimpia("txtNumCargoAbonoDirecto","",true);
		if(!numeroCargoAbonoDirecto.equals("")) {
			dtoCarga.setNumeroCargoAbonoDirecto(new Integer(numeroCargoAbonoDirecto));
		}
		 traza("6");
		//Anyo Abono Directo
		String anyoAbonoDirecto = conectorParametroLimpia("txtAnoCargoAbonoDirecto","",true);
		if(!anyoAbonoDirecto.equals("")) {
			dtoCarga.setAnyoAbonoDirecto(anyoAbonoDirecto);
		}
		//Periodo Mes Abono Directo
		String periodoMesCargo = conectorParametroLimpia("txtMesCargoAbonoDirecto","",true);
		if(!periodoMesCargo.equals("")) {
			dtoCarga.setPeriodoMesAbonoDirecto(periodoMesCargo);
		}
		//Observaciones Areas Reclamos
		dtoCarga.setObservacionesAreaReclamos(conectorParametroLimpia("textObservacionesAreaReclamos","",true));
		//Observaciones Resolucion
		dtoCarga.setObservacionesResolucion(conectorParametroLimpia("textObservacionesClienteReclamante","",true));
		//Fecha Resolucion Prevista
		String fechaResolucionPrevista = conectorParametroLimpia("textFechaResolucionReclamoPrevista","",true);
		if(!fechaResolucionPrevista.equals("")) {
        	dtoCarga.setFechaResolucionPrevista(UtilidadesBelcorp.getDatefromSICCStringFormat(fechaResolucionPrevista,UtilidadesSession.getFormatoFecha(this)));
		}
		//Fecha Resolucion Real					
		String fechaResolucionReal = conectorParametroLimpia("txtFechaResolucionReclamoReal","",true);
		if(!fechaResolucionReal.equals("")) {
        	dtoCarga.setFechaResolucionReal(UtilidadesBelcorp.getDatefromSICCStringFormat(fechaResolucionReal,UtilidadesSession.getFormatoFecha(this)));
		}
		String fechaValor = conectorParametroLimpia("textFechaValor","",true);
		if(!fechaValor.equals("")) {
        	//dtoCarga.setFechaResolucionReal(UtilidadesBelcorp.getDatefromSICCStringFormat(fechaValor,UtilidadesSession.getFormatoFecha(this)));
		//EN CUANTO TE DE EL CAMPO DEL DTO OPONLO AQUI Y EN EL CREATE DEL NEGOCIO.... ACUERDATE 
		//LINEA 288 DEL MONrEGULARIZACION DE PAGOS.
		
		}
		
		
		//Fichero Documental Adjunto
		dtoCarga.setFicheroDocumentalAdjunto(conectorParametroLimpia("textFicheroDocAdjunto","",true));
	     traza("7");
		//Empresa
		String empresa = conectorParametroLimpia("cbEmpresa","",true);
		if(!empresa.equals("")) {
			dtoCarga.setEmpresa(new Long(empresa));
			traza("[cs]empresa= "+empresa);
		}
		
		
		/*?????????????
		private String descBancoRecaudacion;
		private String descSucursal;
		private String descCuentaCorriente;
		private String descMedioPago;
		private String descSituacion;
		private String descCanal;
		private String descAcceso;
		private String descSubacceso;
		private String descPeriodoReclamante;
		private String descMotivoRechazo;
		private String empresaDesc;
		
		
		//idBusiness= CCCGuardarReclamo 
		//Llamamos al ConectorGuardarReclamo 
		
		//- Se crea idNegocio "CCCGuardarReclamo" 
        MareBusinessID idBussiness = new MareBusinessID("CCCGuardarReclamo");
          
        //Almacenamos los parametros de entrada
        Vector paramEntrada = new Vector();
        paramEntrada.addElement(dtoCarga);
        paramEntrada.addElement(idBussiness);
         
        //- Se invoca al ConectorGuardarReclamo
        traza("invocamos al conector DTO=  " +dtoCarga); 
        DruidaConector conector = conectar("ConectorGuardarReclamo", paramEntrada);
         //traza("DEspues del conector=  " +dtoCarga); 
        
	traza("***Salida -  LPInsertarReclamos - accionGuardar");
    }
    
    protected void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);
                    
        traza("Stack Trace: " + baos.toString());
    }
}
*/


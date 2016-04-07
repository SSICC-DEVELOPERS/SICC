//$Id: LPRealizarSeguimientoTelecobranza.java,v 1.1 2009/12/03 18:43:29 pecbazalar Exp $ 
/** 
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * 
 * Autor: Viviana Bongiovanni
 */


import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cob.DTOAsignacionesCobranza;
import es.indra.sicc.dtos.intsys.DTOLlamadaTelecobro;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.StringTokenizer;
import java.util.Vector;

public class LPRealizarSeguimientoTelecobranza extends LPSICCBase{

    private Long oidPais;
    private Long oidIdioma;

	public LPRealizarSeguimientoTelecobranza()  {
	  super();
	}  

	public void inicio() throws Exception {		
		pagina("contenido_seguimiento_telecobranza_realizar");
	}


	public void ejecucion() throws Exception{

		setTrazaFichero();

		String accion = conectorParametroLimpia("accion", "", true);
		oidPais = UtilidadesSession.getPais(this);
        oidIdioma = UtilidadesSession.getIdioma(this);
		
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "hPais", "valor", oidPais.toString());
		asignarAtributo("VAR", "hIdioma", "valor", oidIdioma.toString());

		traza("accion: " + accion);

		try{
			if( accion.equals("") ){					
				this.getFormatosValidaciones();            
				this.cargarPagina();
			}else if( accion.equals("LlamarIVR") ){
                llamadaIVR();
            }else if(accion.equals("ObtenerTotales")){
                obtenerTotales();
            }
            

	 }catch (Exception e){   

	   logStackTrace(e);
	   this.lanzarPaginaError(e);

	 }
     // Configura menu secundario
     if(!accion.equals("ObtenerTotales"))
	 getConfiguracionMenu();

	}//fin ejecucion


    private void logStackTrace(Throwable e) {
         ByteArrayOutputStream os = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(os);

         e.printStackTrace(ps);
         try {
            traza("Se produjo la excepcion: " 
                + e.getMessage() 
                + "\n" 
                + "stackTrace = " 
                + os.toString());
         }
         catch (Exception ex) {
            e.printStackTrace ();
         }
    }



    private void cargarPagina() throws Exception{
        //traza("metodo cargarPagina()");  
              
	    // Carga incial de combos
       // traza("antes de ComposerViewElementList  ");
        ComposerViewElementList cv = crearParametrosEntrada();
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
       // traza("antes del conector.ejecucion");
        conector.ejecucion();
        //traza("antes del conector");
        DruidaConector resultados = conector.getConector();

        //traza("antes de asignar los COMBOS");
        asignar("COMBO","cbEtapa",resultados,"COBObtenerEtapasUsuarioCOB");        
		asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");    
		asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");    		
		asignar("COMBO","cbOrdenacion",resultados,"COBObtenerCriteriosOrdenacionTC");    


        // Valores por defecto
		Long marcaDft = UtilidadesSession.getMarcaPorDefecto(this);
        Long canalDft = UtilidadesSession.getCanalPorDefecto(this);

		asignarAtributo("VAR", "hCbMarca", "valor", marcaDft.toString());
		asignarAtributo("VAR", "hCbCanal", "valor", canalDft.toString());
    }  

	
    private ComposerViewElementList crearParametrosEntrada() throws Exception{
        //traza("metodo ComposerViewElementList");
		ComposerViewElementList lista = new ComposerViewElementList();

        DTOBelcorp dtoBel = new DTOBelcorp();
        //traza("antes de asignar al dtobelcorp");
        dtoBel.setOidPais(UtilidadesSession.getPais(this));
        dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));

		DTOOID dtoOID= new DTOOID();
        dtoOID.setOidPais(UtilidadesSession.getPais(this));

        // Etapa
		ComposerViewElement etapa = new ComposerViewElement();        
		etapa.setIDBusiness("COBObtenerEtapasUsuarioCOB");
		etapa.setDTOE(dtoOID);
        
        lista.addViewElement(etapa);

		// Marca
		ComposerViewElement marca = new ComposerViewElement();        
		marca.setIDBusiness("SEGConsultaMarcas");
		marca.setDTOE(dtoBel);
        
        lista.addViewElement(marca);

		// Canal
		ComposerViewElement canal = new ComposerViewElement();        
		canal.setIDBusiness("SEGConsultaCanales");
		canal.setDTOE(dtoBel);
        
        lista.addViewElement(canal);
		
		// Criterios de ordenación
		ComposerViewElement criteriosOrdenacion = new ComposerViewElement();        
		criteriosOrdenacion.setIDBusiness("COBObtenerCriteriosOrdenacionTC");
		criteriosOrdenacion.setDTOE(dtoBel);
        
        lista.addViewElement(criteriosOrdenacion);

        return lista;
    }

    private void llamadaIVR() throws Exception {
        // INCIDENCIA 162
        /*Creamos un DTOOid con el atributo oidCliente recibido desde la pantalla y 
        llamamos al ConectorObtenerSubtipoIVR con el idBusiness = "COBObtenerSubTipoClienteIVR" 
        Creamos un DTOLlamadaTelecobro con los siguientes atributos recibidos desde 
        pantalla: oidCliente, telefono1, oidUsuariosCobranza, oidTipoCargoAbono, 
        oidPeriodo, oidEtapaDeuda, oidRegion, oidZona. y el oidSubTipo 
        con el DTOOid obtenido antes 
        Llamamos al ConectorLlamadaIVR con el idBussines="COBLlamadaIVR" y el dto creado.
        */

        Long oidCliente = new Long(conectorParametro("hOidCliente"));
        MareBusinessID marebusinessid = new MareBusinessID("COBObtenerSubTipoClienteIVR");
        DTOOID dtoOid = new DTOOID();
        dtoOid.setOid(oidCliente);
        
        Vector vec = new Vector();
        vec.addElement(dtoOid);
        vec.addElement(marebusinessid);
        
        traza(" ANTES DE CONECTAR");
        DruidaConector druidaconector = conectar("ConectorObtenerSubTipoClienteIVR",vec);
        traza(" DESPUES DE CONECTAR");
        
        DTOOID dtoOid2 = (DTOOID) druidaconector.objeto("DTOSalida");

        Long oidSubtipoCliente = dtoOid2.getOid();
        Long oidUsuarioCobranza = conectorParametro("hOidUsuarioCobranza").equals("") ? null : new Long(conectorParametro("hOidUsuarioCobranza"));
        Long oidTipoCargoAbono = conectorParametro("hOidTipoCargoAbonoUltimo").equals("") ?  null : new Long(conectorParametro("hOidTipoCargoAbonoUltimo"));
        Long oidRegion  = conectorParametro("hOidRegion").equals("") ? null : new Long(conectorParametro("hOidRegion"));
        Long oidZona = conectorParametro("hOidZona").equals("") ? null : new Long(conectorParametro("hOidZona"));
        String telefono1 = conectorParametro("hTelefono1");
        Long oidPreiodo = conectorParametro("hOidPeriodo").equals("") ? null : new Long(conectorParametro("hOidPeriodo"));
        Long oidEtapaDeuda = conectorParametro("hOidEtapadeuda").equals("") ? null : new Long(conectorParametro("hOidEtapadeuda"));
        
        pagina("salidaGenerica");
        
        marebusinessid = new MareBusinessID("COBLlamadaIVR");
        DTOLlamadaTelecobro dtoLlamdaTelecobro = new DTOLlamadaTelecobro();
        dtoLlamdaTelecobro.setOidCliente(oidCliente);
        dtoLlamdaTelecobro.setOidEtapaDeuda(oidEtapaDeuda);
        dtoLlamdaTelecobro.setOidPeriodo(oidPreiodo);
        dtoLlamdaTelecobro.setOidRegion(oidRegion);
        dtoLlamdaTelecobro.setOidSubTipoCliente(oidSubtipoCliente);
        dtoLlamdaTelecobro.setOidTipoCargoAbono(oidTipoCargoAbono);
        dtoLlamdaTelecobro.setOidUsuarioCobranzas(oidUsuarioCobranza);
        dtoLlamdaTelecobro.setOidZona(oidZona);
        dtoLlamdaTelecobro.setTelefono1(telefono1);
        dtoLlamdaTelecobro.setOidPais(oidPais);
        
        vec = new Vector();
        vec.addElement(dtoLlamdaTelecobro);
        vec.addElement(marebusinessid);
        
        traza(" ANTES DE CONECTAR ConectorLlamadaIVR");
        DruidaConector druidaconector2 = conectar("ConectorLlamadaIVR",vec);
        traza(" DESPUES DE CONECTAR ConectorLlamadaIVR");
        
    }

    private void obtenerTotales() throws Exception{
        this.pagina("salidaGenerica");
        this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");
        try{
            UtilidadesLog.debug("Para obtener totales...");

            DTOAsignacionesCobranza datos = new DTOAsignacionesCobranza();
            // Armando DTO
            datos.setOidIdioma(oidIdioma);
            datos.setOidPais(oidPais);
            datos.setPaginado(Boolean.TRUE);
            
            String etapaDeuda = this.conectorParametroNumero("cbEtapa",this.FORMATO_DEFAULT);
            String marca = this.conectorParametroNumero("cbMarca",this.FORMATO_DEFAULT);
            String canal = this.conectorParametroNumero("cbCanal",this.FORMATO_DEFAULT);
            String periodo = this.conectorParametroNumero("cbPeriodo",this.FORMATO_DEFAULT);
            String ordenacion = this.conectorParametroNumero("cbOrdenacion",this.FORMATO_DEFAULT);
            String region = this.conectorParametroNumero("cbRegion",this.FORMATO_DEFAULT);
            
            if(!etapaDeuda.equals("")) datos.setEtapaDeuda(new Long(etapaDeuda));
            if(!marca.equals("")) datos.setMarca(new Long(marca));
            if(!canal.equals("")) datos.setCanal(new Long(canal));
            if(!periodo.equals("")) datos.setPeriodo(new Long(periodo));
            if(!ordenacion.equals("")) datos.setOrdenacion(new Long(ordenacion));
            if(!region.equals("")) datos.setRegion(new Long(region));
            
            // Final armado DTO
            Vector params = new Vector();
            MareBusinessID bussId = new MareBusinessID("COBObtenerTotalesAsignacionesCobranzaTC");
    
            params.add(datos);
            params.add(bussId);
            UtilidadesLog.debug("Antes de conectar");
            DruidaConector con = this.conectar("ConectorObtenerTotalesAsignacionesCobranzaTC", params);
            UtilidadesLog.debug("Luego de conectar");   
            
            //String[] totales = ((DTOString)con.objeto("DTOString")).getCadena().split("|");
            
            StringTokenizer stTk = new StringTokenizer(((DTOString)con.objeto("DTOString")).getCadena(),"|");
            
            this.asignarAtributo("VAR", "ejecutar", 
                "valor", 
                "muestraTotales('"+
                    UtilidadesBelcorp.formateaNumeroSICC(stTk.nextToken(),this.FORMATO_DEFAULT,this)+
                    "','"+
                    UtilidadesBelcorp.formateaNumeroSICC(stTk.nextToken(),this.FORMATO_DEFAULT,this)+
                    "')");
            
        }catch(Exception e){
            this.asignarAtributo("VAR", "ejecutarError", "valor", "errorEnTotales()");
            throw e;
        }
    }
}

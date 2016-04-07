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
 /*
    INDRA/CCC/PROY
    $Id: LPReasignacionPagos.java,v 1.1 2009/12/03 18:32:32 pecbazalar Exp $
    DESC
 */

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.dtos.ccc.DTOReasignacionPagos;


import es.indra.sicc.util.DTOBelcorp;
//import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import java.util.Vector;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
// Definicion de la clase
public class LPReasignacionPagos extends LPSICCBase {
	public LPReasignacionPagos() {
        super();
    }
    
    private String accion = "";
    
	public void inicio() throws Exception {;}
	
	public void ejecucion() throws Exception {
        traza("***Entrada - LPReasignacionPagos -- Ejecucion");
        accion = conectorParametroLimpia("accion","",true);
		try {
            if(accion.equals("")){
                accionVacia();
            }else if(accion.equals("detalle")){
                detalleMovimiento();
            }else if(accion.equals("reasignar_paso_previo")){
                seleccionarReceptor();
            }else if(accion.equals("reasignar")){
                reasignar();
            }
		} catch (Exception e) {
			lanzarPaginaError(e); 
		}
        getFormatosValidaciones();
        getConfiguracionMenu("LPReasignacionPagos", accion);
        traza("***Salida - LPReasignacionPagos -- Ejecucion");
	}
	
    private void accionVacia()throws Exception{
        pagina("contenido_pagos_reasignar");
        asignarVariables();
        cargarBancosRegiones();
        asignar("VAR","longitudCodigo",obtenerLongitudCodigoCliente().toString());
    }

    private void detalleMovimiento() throws Exception {
		traza("***Entrada -  LPReasignacionPagos - detalleMovimiento ***");
		pagina("contenido_movimientos_bancarios_mantenimiento");	
        asignarVariables();
        asignarAtributoPagina("cod","01076");
		asignar("VAR", "oid", conectorParametroLimpia("numeroMovimiento","", true));
		asignar("VAR", "casoDeUso", "consultar");
		asignar("VAR", "cu", "consultar");
		traza("***Salida -  LPReasignacionPagos - detalleMovimiento ***");
	}

    private void seleccionarReceptor() throws Exception{
        traza("***Entrada -  LPReasignacionPagos - seleccionarReceptor ***");
        pagina("contenido_pagos_receptor_seleccionar");
        asignarVariables();
        asignar("VAR","longitudCodigo",obtenerLongitudCodigoCliente().toString());
        asignar("VAR","constanteReasignacion",CCCConstantes.TIPO_TRANSACCION_REASIGNACION_PAGO);
        ComposerViewElementList listelem = new ComposerViewElementList();
        ConectorComposerView conector = null;
        DruidaConector conConsultar = null;
        String descTransaccionReasignacion="";
        
        synchronized(this){
            ComposerViewElement elem=new ComposerViewElement();
            elem.setIDBusiness("CCCObtenerTiposTransaccion");
            elem.setDTOE(getDTOBelcorp());
            elem.setPosDesc(new Byte("1").byteValue());
            elem.setPosOID(new Byte("2").byteValue());
            listelem.addViewElement(elem);
            conector = new ConectorComposerView(listelem, this.getRequest());
            conector.ejecucion();
            conConsultar = conector.getConector();
 
            Element dtoSal = conConsultar.getXML();
            NodeList rsTiposTransaccion = dtoSal.getElementsByTagName("ROW");
            
            for(int i=0; i<rsTiposTransaccion.getLength();i++) {
                Node fila = rsTiposTransaccion.item(i);
                NodeList lista = fila.getChildNodes();
            
                if (lista.item(0).getFirstChild().getNodeValue().equals(CCCConstantes.TIPO_TRANSACCION_REASIGNACION_PAGO)) {
                    descTransaccionReasignacion = lista.item(1).getFirstChild().getNodeValue();
                    break;
                }
            }
            
        }
        try{
            asignar("LABELC","lblDescTransaccion",descTransaccionReasignacion);
        }catch(Exception e){
            e.printStackTrace();
            asignar("COMBO", "cbTipoTransaccion", conConsultar, "CCCObtenerTiposTransaccion");
        }
        traza("***Salida -  LPReasignacionPagos - seleccionarReceptor ***");
    }

    private void reasignar()throws Exception {
        traza("***Entrada -  LPReasignacionPagos - reasignar ***");
        pagina("salidaGenerica");

        DTOReasignacionPagos dtoEntrada = new DTOReasignacionPagos();
        
        String oidClienteReceptor = conectorParametroLimpia("oidClienteReceptor","",true);
        String numeroCupon = conectorParametroLimpia("nroCupon","",true);
        String numeroBoletaFactura = conectorParametroLimpia("nroBoletaFactura","",true);
        
        dtoEntrada.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoEntrada.setOidPais(UtilidadesSession.getPais(this));
        dtoEntrada.setCodigoClienteReceptor(conectorParametroLimpia("codigoCliente","",true));
        dtoEntrada.setOidMovimientoOriginal(new Long(conectorParametroLimpia("oidMovimientoReasignar","",true)));
        dtoEntrada.setTipoTransaccion(CCCConstantes.TIPO_TRANSACCION_REASIGNACION_PAGO);
        dtoEntrada.setObservaciones(conectorParametroLimpia("observaciones","",true));
        if(!oidClienteReceptor.trim().equals("")){
            dtoEntrada.setOidClienteReceptor(new Long(oidClienteReceptor.trim()));
        }
        if(!numeroCupon.trim().equals("")){
            dtoEntrada.setNumeroCupon(new Long(numeroCupon.trim()));
        }
        if(!numeroBoletaFactura.trim().equals("")){
            dtoEntrada.setNumeroBoletaFactura(new Long(numeroBoletaFactura.trim()));
        }
        
        MareBusinessID idNegocio = new MareBusinessID("CCCReasignarPagos");
        Vector params = new Vector();
        params.add(dtoEntrada);
        params.add(idNegocio);
        try{
            conectar("ConectorEliminar",params);//se usa un conector generico ya que el metodo no devuelve resultado
        }catch(Exception e) {
            e.printStackTrace();
            if(e instanceof MareException){
                throw (MareException)e;
            }else{
                throw new MareException("Error al reasignar",e);
            }
        }
        asignar("VAR", "ejecutar", "salidaExito()");
        traza("***Salida -  LPReasignacionPagos - reasignar ***");
    }


    private void cargarBancosRegiones()throws Exception{
        traza("***Entrada -  LPReasignacionPagos - cargarBancosRegiones ***");
		ComposerViewElementList listelem = new ComposerViewElementList();
        ConectorComposerView conector = null;
        DruidaConector conConsultar = null;
        synchronized(this){
            listelem.addViewElement(elementoSubsistema("CCCObtieneBancos"));
            listelem.addViewElement(elementoSubsistema("ZONObtenerRegionesPorPais"));
            conector = new ConectorComposerView(listelem, this.getRequest());
            conector.ejecucion();
            conConsultar = conector.getConector();
        }
		asignar("COMBO", "cbBanco", conConsultar, "CCCObtieneBancos"); 
		asignar("COMBO", "cbRegion", conConsultar, "ZONObtenerRegionesPorPais");
        traza("***Salida -  LPReasignacionPagos - cargarBancosRegiones ***");
    }
    
    private ComposerViewElement elementoSubsistema(String idBussines)throws Exception{
        ComposerViewElement elem=new ComposerViewElement();
        elem.setIDBusiness(idBussines);
        elem.setDTOE(getDTOBelcorp());
        
        return elem;
    }

    private DTOBelcorp getDTOBelcorp()throws Exception{
        DTOBelcorp salida = new DTOBelcorp();
        salida.setOidPais(UtilidadesSession.getPais(this));
        salida.setOidIdioma(UtilidadesSession.getIdioma(this));
        return salida;
    }
    private void asignarVariables(){
        try{
            asignar("VAR","pais",UtilidadesSession.getPais(this).toString());
            asignar("VAR","idioma",UtilidadesSession.getIdioma(this).toString());            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
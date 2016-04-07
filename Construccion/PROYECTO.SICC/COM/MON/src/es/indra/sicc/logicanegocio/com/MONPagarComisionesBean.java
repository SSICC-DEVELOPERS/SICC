package es.indra.sicc.logicanegocio.com;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.com.DTOClientPagadoCom;
import es.indra.sicc.entidades.com.ComisionesCalculadasLocal;
import es.indra.sicc.logicanegocio.intsys.MONAdam;
import es.indra.sicc.logicanegocio.intsys.MONAdamHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.com.DTOBuscarComisionesPagar;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.com.ComisionesCalculadasLocalHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.dtos.com.DTODatosPagarComision;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONPagarComisionesBean implements SessionBean  {   
    private SessionContext ctx;
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public DTOSalida obtenerComisionesPagar(DTOBuscarComisionesPagar dtoe) throws MareException {
		UtilidadesLog.info("MONPagarComisionesBean.obtenerComisionesPagar(DTOBuscarComisionesPagar dtoe): Entrada");
        DTOSalida dtoSalida = new DTOSalida();

        try{
            UtilidadesLog.debug("DTOEntrada: "+dtoe);
            DAOPagarComisiones dao = new DAOPagarComisiones(ctx.getCallerPrincipal().getName());
            RecordSet rs = dao.obtenerComisionesPagar(dtoe);
            
            dtoSalida.setResultado(rs);
    
            if (rs.esVacio()) {
               //GEN-0007 --> 005
               //this.loguearError("cargaAsignarAptas: FinderException",ce);
                throw new MareException(new Exception("No hay Registros"),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
           }
       }catch(Exception e){
           UtilidadesLog.error("Error en ObtenerComisionesPagar: ",e);
           if(e instanceof MareException){
               throw (MareException)e;
           }else  {
               throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
           }
       }
	   UtilidadesLog.info("MONPagarComisionesBean.obtenerComisionesPagar(DTOBuscarComisionesPagar dtoe): Salida");		
	   return dtoSalida;
    }

    public DTOSalida obtenerDetalleComisionPagar(DTODatosPagarComision dtoe) throws MareException {
		UtilidadesLog.info("MONPagarComisionesBean.obtenerDetalleComisionPagar(DTOOIDPaginado dtoe): Entrada");
		
		DAOPagarComisiones dao = new DAOPagarComisiones();
		RecordSet rs = dao.obtenerDetalleComisionPagar(dtoe);
        DTOSalida dtoSalida = new DTOSalida(rs);
        if (rs.esVacio()) {
           //GEN-0007 --> 005
           //this.loguearError("cargaAsignarAptas: FinderException",ce);
            throw new MareException(new Exception(),
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
       }
		
       UtilidadesLog.info("MONPagarComisionesBean.obtenerDetalleComisionPagar(DTOOIDPaginado dtoe): Salida");		
	   return dtoSalida;
    }

    public void pagarComisiones(DTODatosPagarComision dtoe) throws MareException {
		UtilidadesLog.info("MONPagarComisionesBean.pagarComisiones(DTOOID dtoe): Entrada");
		//Vamos a realizar el pago de la comisión. Se recibe un oidComision 

/*
- ComisionesCalculadas= Llama al método findByComision(oidComision) de la entidad ComisionesCalculadas -----------------------Hacer el método en el entity------------------ 
Para cada entity obtenido de la coleccion { 
- Actualiza la información de la ComisionesCalculadas con la siguiente informacion 
ComisionesCalculadas.oidEstadoComisionCliente= ConstantesCOM.ESTADO_COMISION_CLIENTE_PAGADA 
} 
*/
        ComisionesCalculadasLocalHome cclh = this.getComisionesCalculadasLocalHome();
        ComisionesCalculadasLocal ccl = null;
        Collection comisiones=null;
       
        try{
        
            if(dtoe.getFechaCalculo()==null || dtoe.getFechaCalculo().equals("")){
                comisiones = cclh.findByComisionCalculada(dtoe.getOidComision(), 
                                                          ConstantesCOM.ESTADO_COMISION_CLIENTE_CALCULADA);
                                                          
                UtilidadesLog.debug("sin fecha, comisiones calculadas a pagar: " + comisiones.size());                                                          
                
                Iterator it = comisiones.iterator();
                while (it.hasNext()){
                    ccl = (ComisionesCalculadasLocal)it.next();
                    UtilidadesLog.debug("Actualiza estado comision a cliente pagada");
                    ccl.setEstado(ConstantesCOM.ESTADO_COMISION_CLIENTE_PAGADA);
                    
                    cclh.merge(ccl);
                }
                
            } else {
            
                DAOPagarComisiones daoPagarCom = new DAOPagarComisiones();
                
                RecordSet rs = daoPagarCom.obtenerComisionesFechasCalculadas(dtoe.getOidComision(),
                                                                             dtoe.getFechaCalculo(),
                                                                             dtoe.getFormatoFecha());
                
                if(!rs.esVacio()) {
                    int rows = rs.getRowCount();
                    Long oidComiCal;
    
                    for (int i = 0; i < rows; i++) {
                        oidComiCal = Long.valueOf(((BigDecimal) rs.getValueAt(i, "OID_COMI_CALC")).toString());
                       
                        ccl = cclh.findByPrimaryKey(oidComiCal);
                        ccl.setEstado(ConstantesCOM.ESTADO_COMISION_CLIENTE_PAGADA);
                        
                        cclh.merge(ccl);
                    }
                    
                    UtilidadesLog.debug("con fecha, comisiones calculadas a pagar: " + rows);   
                }
            }
          
                
        } catch (NoResultException nre) {
            UtilidadesLog.debug(nre);
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR ", pe);
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
		//Vamos a obtener el codigo de cliente, el codigo de planilla y el importe de cada comision que hayamos pagado, pero solo de aquellos que sean empleados. 
		DAOPagarComisiones dao = new DAOPagarComisiones();
		ArrayList listaEmpleados = dao.obtenerComisionesPagadasEmpleados(dtoe.getOidComision());
		
		//Vamos a llamar al CU de INT "Ingresar comisiones e incentivos" 
		DTOClientPagadoCom dtoEmpleado = null;
		int registros = listaEmpleados.size();

        for (int i=0; i<registros; i++){
			dtoEmpleado = (DTOClientPagadoCom)listaEmpleados.get(i);
      
      UtilidadesLog.debug("ImpCalculado: " + dtoEmpleado.getImpCalculado());
			
			MONAdam local = this.getMONAdam();
			try{
				local.ingresarComisionesEIncentivos(ConstantesCOM.MODULO_GENERADOR_COMISION,dtoEmpleado.getOidCliente(),dtoEmpleado.getImpCalculado());
			}catch(RemoteException re){
				UtilidadesLog.error(re);
				System.out.println("error RemoteException");
				throw new MareException(re,
					UtilidadesError.armarCodigoError(
					CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
			}
        }
		UtilidadesLog.info("MONPagarComisionesBean.pagarComisiones(DTOOID dtoe): Salida");
    }


	 private MONAdam getMONAdam() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONPagarComisionesBean.getMONAdam(): Entrada");				
        MONAdamHome home = (MONAdamHome)UtilidadesEJB.getHome("MONAdam", MONAdamHome.class);
            
        // Se obtiene el interfaz remoto
        MONAdam ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONPagarComisionesBean.getMONAdam(): Salida");				
        return ejb;
	}

    private ComisionesCalculadasLocalHome getComisionesCalculadasLocalHome() throws MareException {      
       return new ComisionesCalculadasLocalHome();
    }

    private MONAdamHome getMONAdamHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONAdamHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONAdam"), MONAdamHome.class);
  }
    
}
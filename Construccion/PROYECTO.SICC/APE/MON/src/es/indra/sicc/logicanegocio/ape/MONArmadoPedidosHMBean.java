/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 */
package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOListaPicado;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONArmadoPedidosHMBean implements SessionBean  {
  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
  }

 /**
   * 
   * @throws es.indra.mare.common.exception.MareException
   * @param dtoE
   * @author hhernandez
   * @date 27-02-2007
 */
  public DTOSalida visualizarListaPicado(DTOOID dtoE) throws MareException {
      UtilidadesLog.info("MONArmadoPedidosHMBean.visualizarListaPicado(DTOOID dtoE): Entrada");
      DTOSalida dtoSalida=new DTOSalida();
      DAOArmadoPedidosHM daoBalanceoAreaChequeo= new DAOArmadoPedidosHM();
      dtoSalida=daoBalanceoAreaChequeo.visualizarListaPicado(dtoE);
      RecordSet rs=new RecordSet();
      rs=dtoSalida.getResultado();
      if (!rs.esVacio()) {
        DTOListaPicado dtoLP = new DTOListaPicado();
        dtoLP.setOidPais(new Long((((BigDecimal)rs.getValueAt(0,"PAIS"))).longValue()));
        dtoLP.setOidCentroDistribucion(new Long((((BigDecimal)rs.getValueAt(0,"CONFCENTDISTRIBUCION"))).longValue()));
        dtoLP.setOidListaPicado(new Long((((BigDecimal)rs.getValueAt(0,"OID"))).longValue()));
        
        /*************NOTA TECNICA*************/
        /*AQUI FALTA IMPLEMENTAR LO SIGUIENTE:*/
        /*Llamar al caso de uso "REP APE Lista de picado" pasándole el dto creado */
        /************FIN NOTA TECNICA**********/
        
      }
      else{
        UtilidadesLog.debug("****visualizarListaPicado: no hay datos ");				
        throw new MareException(new Exception(),
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));        
      }
      UtilidadesLog.info("MONArmadoPedidosHMBean.visualizarListaPicado(DTOOID dtoE): Salida");
      return dtoSalida;
  }

   /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoE
     * @author Rafael Romero Vilcherez 
     * @date 27-02-2007
   */
   public void  revertirArmadoPedidos(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("MONArmadoPedidosHMBean.revertirArmadoPedidos(DTOOID dtoE): Entrada");
        DAOArmadoPedidosHM daoArmPed = new DAOArmadoPedidosHM();
        daoArmPed.revertirArmadoPedidos(dtoE);
        UtilidadesLog.info("MONArmadoPedidosHMBean.revertirArmadoPedidos(DTOOID dtoE): Salida");
    }
}
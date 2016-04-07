package es.indra.sicc.logicanegocio.cob;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.cob.DTOConsultarLiquidacionComisionesCobranza;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;

public class MONLiquidacionCobranzaBean implements SessionBean 
{
  SessionContext ctx = null;
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx) {
    this.ctx = ctx;
  }

  public DTOSalida listarLiquidaciones(DTOConsultarLiquidacionComisionesCobranza dtoEntrada) throws MareException{
    UtilidadesLog.info("MONLiquidacionCobranzaBean.listarLiquidaciones(DTOConsultarLiquidacionComisionesCobranza dtoEntrada): Entrada");
  
    DTOSalida dtoSal = null;
    DAOLiquidacionCobranza daoLiqCob = new DAOLiquidacionCobranza(ctx);
    dtoSal = daoLiqCob.listadoLiquidaciones(dtoEntrada);
    
    UtilidadesLog.info("MONLiquidacionCobranzaBean.listarLiquidaciones(DTOConsultarLiquidacionComisionesCobranza dtoEntrada): Salida");
    
    return dtoSal;
  }
}
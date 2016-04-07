package es.indra.sicc.cmn.negocio.auditoria;
import javax.ejb.EJBLocalHome;


public interface EJBLocalHomeSICCAuditable extends EJBLocalHome {
  void parametrosAuditoria(DTOAuditableSICC dtoEntrada);

}
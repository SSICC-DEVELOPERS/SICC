package es.indra.sicc.cmn.negocio.auditoria.test;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.UtilidadesLog;

public class MONTestBean implements SessionBean  {
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

  public void find(String str) {
    try{
      MarcaTestLocalHome mtlh = this.getMarcaTestLocalHome();
      DTOAuditableSICC dtoE = new DTOAuditableSICC();
      dtoE.setIpCliente("ip");
      dtoE.setPrograma("PrubaParaAuditoria");
      //mtlh.parametrosAuditoria(dtoE);
      MarcaTestLocal mtl = mtlh.findByPrimaryKey(new Long(1));
      UtilidadesLog.debug("-->"+mtl.getCod_marc());
      
    }catch(Exception e) {
      e.printStackTrace();
    }
  }

  private MarcaTestLocalHome getMarcaTestLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MarcaTestLocalHome)context.lookup("java:comp/env/ejb/MarcaTestLocal");
  }
}
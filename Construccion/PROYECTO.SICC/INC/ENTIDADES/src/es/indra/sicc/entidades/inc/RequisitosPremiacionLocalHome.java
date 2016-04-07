package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.RequisitosPremiacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class RequisitosPremiacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public RequisitosPremiacionLocal create(Boolean indPediPeri, Boolean indPagoTiem, Long copaOidParaGral) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_REPR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		RequisitosPremiacionLocal local = new RequisitosPremiacionLocal(oid, indPediPeri, indPagoTiem, copaOidParaGral);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(RequisitosPremiacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RequisitosPremiacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RequisitosPremiacionLocal findByPrimaryKey(Long  oid) {
		RequisitosPremiacionLocal local = (RequisitosPremiacionLocal)em.find(RequisitosPremiacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("RequisitosPremiacionLocal.FindAll");
                    return query.getResultList();
            }

	public RequisitosPremiacionLocal findByUK(Long oidConcurso) {
		Query query=em.createNamedQuery("RequisitosPremiacionLocal.FindByUK");
		
		query.setParameter(1, oidConcurso);

	    return (RequisitosPremiacionLocal)(query.getSingleResult());
	}

}

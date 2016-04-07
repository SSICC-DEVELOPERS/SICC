package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.CursosExigidosPremiacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CursosExigidosPremiacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public CursosExigidosPremiacionLocal create(Long oidTipoCurso, Long oidReqPrem) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CEPR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CursosExigidosPremiacionLocal local = new CursosExigidosPremiacionLocal(oid, oidTipoCurso, oidReqPrem);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CursosExigidosPremiacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CursosExigidosPremiacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CursosExigidosPremiacionLocal findByPrimaryKey(Long  oid) {
		CursosExigidosPremiacionLocal local = (CursosExigidosPremiacionLocal)em.find(CursosExigidosPremiacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("CursosExigidosPremiacionLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByRequisito(Long oidRequisitoPrem) {
		Query query=em.createNamedQuery("CursosExigidosPremiacionLocal.FindByRequisito");
		
		query.setParameter(1, oidRequisitoPrem);

	    return query.getResultList();
	}

}

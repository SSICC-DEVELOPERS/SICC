package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.CalificacionAgrupacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CalificacionAgrupacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public CalificacionAgrupacionLocal create(Long copaOidParaGral, Long agruOidAgru) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CAAG_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CalificacionAgrupacionLocal local = new CalificacionAgrupacionLocal(oid, copaOidParaGral, agruOidAgru);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CalificacionAgrupacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CalificacionAgrupacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CalificacionAgrupacionLocal findByPrimaryKey(Long  oid) {
		CalificacionAgrupacionLocal local = (CalificacionAgrupacionLocal)em.find(CalificacionAgrupacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("CalificacionAgrupacionLocal.FindAll");
                    return query.getResultList();
            }

}

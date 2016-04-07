package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.ModoAbonoDefectoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ModoAbonoDefectoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public ModoAbonoDefectoLocal create(String codModoAbono) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_MDEF_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                ModoAbonoDefectoLocal local = new ModoAbonoDefectoLocal(oid, codModoAbono);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ModoAbonoDefectoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ModoAbonoDefectoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ModoAbonoDefectoLocal findByPrimaryKey(Long  oid) {
		ModoAbonoDefectoLocal local = (ModoAbonoDefectoLocal)em.find(ModoAbonoDefectoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ModoAbonoDefectoLocal.FindAll");
		
		return query.getResultList();
	}

}

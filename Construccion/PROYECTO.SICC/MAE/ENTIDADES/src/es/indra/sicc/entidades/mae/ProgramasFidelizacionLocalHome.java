package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ProgramasFidelizacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ProgramasFidelizacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ProgramasFidelizacionLocal create(String codigo, String descripcion, Long pais) throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_PRFI_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ProgramasFidelizacionLocal local = new ProgramasFidelizacionLocal(oid, codigo, descripcion, pais);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ProgramasFidelizacionLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ProgramasFidelizacionLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ProgramasFidelizacionLocal findByPrimaryKey(Long oid) {
            ProgramasFidelizacionLocal local = em.find(ProgramasFidelizacionLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

	public Collection findAll() {
            Query query=em.createNamedQuery("ProgramasFidelizacionLocal.FindAll");
            return query.getResultList();
	}

}

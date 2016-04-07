package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.EstadoUsuarioLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadoUsuarioLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public EstadoUsuarioLocal create(Character codigo) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_ESUS_SEQ");
		et.begin();
		EstadoUsuarioLocal local = new EstadoUsuarioLocal(oid, codigo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstadoUsuarioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstadoUsuarioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstadoUsuarioLocal findByPrimaryKey(Long  oid) {
		EstadoUsuarioLocal local = (EstadoUsuarioLocal)em.find(EstadoUsuarioLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("EstadoUsuarioLocal.FindAll");          
            return query.getResultList();
        }

}

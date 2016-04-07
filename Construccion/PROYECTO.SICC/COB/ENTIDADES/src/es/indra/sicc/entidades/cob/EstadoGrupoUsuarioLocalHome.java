package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.EstadoGrupoUsuarioLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadoGrupoUsuarioLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public EstadoGrupoUsuarioLocal create(Character cod) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_ESGR_SEQ");
		et.begin();
		EstadoGrupoUsuarioLocal local = new EstadoGrupoUsuarioLocal(oid, cod);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstadoGrupoUsuarioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstadoGrupoUsuarioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstadoGrupoUsuarioLocal findByPrimaryKey(Long  oid) {
		EstadoGrupoUsuarioLocal local = (EstadoGrupoUsuarioLocal)em.find(EstadoGrupoUsuarioLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("EstadoGrupoUsuarioLocal.FindAll");          
            return query.getResultList();
        }

}

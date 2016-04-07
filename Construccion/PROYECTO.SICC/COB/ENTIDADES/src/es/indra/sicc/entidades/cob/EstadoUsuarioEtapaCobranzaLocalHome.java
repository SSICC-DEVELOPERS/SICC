package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.EstadoUsuarioEtapaCobranzaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadoUsuarioEtapaCobranzaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public EstadoUsuarioEtapaCobranzaLocal create(Character codigo) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_ESAS_SEQ");
		et.begin();
		EstadoUsuarioEtapaCobranzaLocal local = new EstadoUsuarioEtapaCobranzaLocal(oid, codigo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstadoUsuarioEtapaCobranzaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstadoUsuarioEtapaCobranzaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstadoUsuarioEtapaCobranzaLocal findByPrimaryKey(Long  oid) {
		EstadoUsuarioEtapaCobranzaLocal local = (EstadoUsuarioEtapaCobranzaLocal)em.find(EstadoUsuarioEtapaCobranzaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("EstadoUsuarioEtapaCobranzaLocal.FindAll");          
            return query.getResultList();
        }

}

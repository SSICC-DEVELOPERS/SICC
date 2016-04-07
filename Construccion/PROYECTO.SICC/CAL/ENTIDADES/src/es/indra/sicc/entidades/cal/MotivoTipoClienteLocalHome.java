package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.MotivoTipoClienteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MotivoTipoClienteLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public MotivoTipoClienteLocal create(Long ticl_oid_tipo_clie, Long moco_oid, Long pais_oid_pais) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_MOTC_SEQ"); 
                final EntityTransaction et = em.getTransaction();
		et.begin();
		MotivoTipoClienteLocal local = new MotivoTipoClienteLocal(oid, ticl_oid_tipo_clie, moco_oid, pais_oid_pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MotivoTipoClienteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MotivoTipoClienteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MotivoTipoClienteLocal findByPrimaryKey(Long  oid) {
		MotivoTipoClienteLocal local = (MotivoTipoClienteLocal)em.find(MotivoTipoClienteLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        public Collection findAll() {
                 Query query=em.createNamedQuery("MotivoTipoClienteLocal.FindAll");
                 return query.getResultList();
       }

	
}

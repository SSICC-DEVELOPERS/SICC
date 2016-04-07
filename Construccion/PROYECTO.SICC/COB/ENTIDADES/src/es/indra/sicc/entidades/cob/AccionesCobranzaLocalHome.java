package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.AccionesCobranzaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AccionesCobranzaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public AccionesCobranzaLocal create(String codigoAccionCobranza, String descripcion, Long pais, Long subTipoAccion) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_ACCO_SEQ");
		et.begin();
		AccionesCobranzaLocal local = new AccionesCobranzaLocal(oid, codigoAccionCobranza, descripcion, pais, subTipoAccion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AccionesCobranzaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AccionesCobranzaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AccionesCobranzaLocal findByPrimaryKey(Long  oid) {
		AccionesCobranzaLocal local = (AccionesCobranzaLocal)em.find(AccionesCobranzaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("AccionesCobranzaLocal.FindAll");          
            return query.getResultList();
        }

	public AccionesCobranzaLocal findByIndicador(Long oidPais, Long valor) {
		Query query=em.createNamedQuery("AccionesCobranzaLocal.FindByIndicador");
		
		query.setParameter(1, oidPais);

		query.setParameter(2, valor);

		return (AccionesCobranzaLocal)(query.getSingleResult());
	}

	public AccionesCobranzaLocal findByUK(String codigoAccionCobranza, Long pais) {
		Query query=em.createNamedQuery("AccionesCobranzaLocal.FindByUK");
		
		query.setParameter(1, codigoAccionCobranza);

		query.setParameter(2, pais);

		return (AccionesCobranzaLocal)(query.getSingleResult());
	}

}

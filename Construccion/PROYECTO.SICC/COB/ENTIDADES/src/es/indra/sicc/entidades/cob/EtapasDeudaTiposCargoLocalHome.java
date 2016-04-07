package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.EtapasDeudaTiposCargoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EtapasDeudaTiposCargoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public EtapasDeudaTiposCargoLocal create(Long tipoCargo, Long etapaDeuda) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_EDTC_SEQ");
		et.begin();
		EtapasDeudaTiposCargoLocal local = new EtapasDeudaTiposCargoLocal(oid, tipoCargo, etapaDeuda);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EtapasDeudaTiposCargoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EtapasDeudaTiposCargoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EtapasDeudaTiposCargoLocal findByPrimaryKey(Long  oid) {
		EtapasDeudaTiposCargoLocal local = (EtapasDeudaTiposCargoLocal)em.find(EtapasDeudaTiposCargoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("EtapasDeudaTiposCargoLocal.FindAll");          
            return query.getResultList();
        }

	public EtapasDeudaTiposCargoLocal findByUK(Long tipoCargo, Long etapaDeuda) {
		Query query=em.createNamedQuery("EtapasDeudaTiposCargoLocal.FindByUK");
		
		query.setParameter(1, tipoCargo);

		query.setParameter(2, etapaDeuda);

		return (EtapasDeudaTiposCargoLocal)(query.getSingleResult());
	}

}

package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.ParametrosGeneralesdeCarteraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosGeneralesdeCarteraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public ParametrosGeneralesdeCarteraLocal create(Long pais_oid_pais, Long inij_oid_indi_nive_jera, Long nire_oid_nive_redo, Long num_peri_nuev, Long num_peri_anti) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_PGCA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrosGeneralesdeCarteraLocal local = new ParametrosGeneralesdeCarteraLocal( oid, pais_oid_pais, inij_oid_indi_nive_jera, nire_oid_nive_redo, num_peri_nuev, num_peri_anti);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrosGeneralesdeCarteraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosGeneralesdeCarteraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosGeneralesdeCarteraLocal findByPrimaryKey(Long  oid) {
		ParametrosGeneralesdeCarteraLocal local = (ParametrosGeneralesdeCarteraLocal)em.find(ParametrosGeneralesdeCarteraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public ParametrosGeneralesdeCarteraLocal findByPais(Long oidPais) {
                Query query=em.createNamedQuery("ParametrosGeneralesdeCarteraLocal.FindByPais");
                
                query.setParameter(1, oidPais);
    
                return (ParametrosGeneralesdeCarteraLocal)(query.getSingleResult());
        }
        
        public Collection findAll() {
            Query query=em.createNamedQuery("CondicionesEvaluacionNRLocal.FindAll");          
            return query.getResultList();
        }

	
}

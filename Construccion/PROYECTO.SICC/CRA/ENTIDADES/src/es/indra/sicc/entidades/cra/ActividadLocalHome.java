package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.ActividadLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ActividadLocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public ActividadLocal create(Long marc_oid_marc, Long cana_oid_cana, Long dpte_oid_depa, 
                          String cod_acti, Integer cod_tipo_acti, 
                          Boolean ind_ebel, Long clasificacion, Long pais) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_CACT_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ActividadLocal local = new ActividadLocal(oid, marc_oid_marc, cana_oid_cana, dpte_oid_depa, 
                                                            cod_acti, cod_tipo_acti, ind_ebel, clasificacion, pais );
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ActividadLocal findByPrimaryKey(Long  oid) {
		ActividadLocal local = em.find(ActividadLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByClaseActividad(Long oidClaseActividad) {
		Query query=em.createNamedQuery("ActividadLocal.FindByClaseActividad");
		
		query.setParameter(1, oidClaseActividad);

		return query.getResultList();
	}

        public Collection findReferenciantes(Long oidActividadOrigen) {
                Query query=em.createNamedQuery("ActividadLocal.findReferenciantes");
                
                query.setParameter(1, oidActividadOrigen);
    
                return query.getResultList();
        }
}

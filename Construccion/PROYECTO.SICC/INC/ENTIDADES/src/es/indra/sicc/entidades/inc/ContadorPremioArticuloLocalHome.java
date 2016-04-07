package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ContadorPremioArticuloLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ContadorPremioArticuloLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ContadorPremioArticuloLocal create(Long numRangoDesde, Long numRangoHasta, Long valUltimConta, Long paisOidPais) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_ICPA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ContadorPremioArticuloLocal local = new ContadorPremioArticuloLocal(oid, numRangoDesde, numRangoHasta, valUltimConta, paisOidPais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ContadorPremioArticuloLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ContadorPremioArticuloLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ContadorPremioArticuloLocal findByPrimaryKey(Long  oid) {
		ContadorPremioArticuloLocal local = (ContadorPremioArticuloLocal)em.find(ContadorPremioArticuloLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ContadorPremioArticuloLocal.FindAll");
                    return query.getResultList();
            }


	public ContadorPremioArticuloLocal findByPais(Long oidPais) {
		Query query=em.createNamedQuery("ContadorPremioArticuloLocal.FindByPais");
		
		query.setParameter(1, oidPais);

		return (ContadorPremioArticuloLocal)(query.getSingleResult());
	}

}

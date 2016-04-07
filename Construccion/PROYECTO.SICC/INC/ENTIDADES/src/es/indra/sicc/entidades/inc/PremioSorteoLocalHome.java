package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.PremioPuntosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

// vbongiov -- Cambio 20080811 -- 26/08/2009
public class PremioSorteoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PremioSorteoLocal create(Long copaOidParaGral, Long panpOidParaNivePrem, Integer numerosAsignado, Long prodOidProducto) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRSO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PremioSorteoLocal local = new PremioSorteoLocal(oid, copaOidParaGral, panpOidParaNivePrem, numerosAsignado, prodOidProducto);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PremioSorteoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PremioSorteoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PremioSorteoLocal findByPrimaryKey(Long  oid) {
		PremioSorteoLocal local = (PremioSorteoLocal)em.find(PremioSorteoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("PremioSorteoLocal.FindAll");
                    return query.getResultList();
        }
        
        public Collection findByParametroNivelPremiacion(Long nivelPremiacion) {
                Query query=em.createNamedQuery("PremioSorteoLocal.FindByParametroNivelPremiacion");
                
                query.setParameter(1, nivelPremiacion);
    
                return query.getResultList();
        }

        public PremioSorteoLocal findByUK(Long oidParaNivePrem) {
                Query query=em.createNamedQuery("PremioSorteoLocal.FindByUK");
                
                query.setParameter(1, oidParaNivePrem);

                return (PremioSorteoLocal)(query.getSingleResult());
        }

}

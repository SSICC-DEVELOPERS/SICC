package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ArticulosPremioAlternativoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ArticulosPremioAlternativoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ArticulosPremioAlternativoLocal create(Integer premioAlternativo, Integer cantidad, Long faltante, Long codigoProducto) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_ARPA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ArticulosPremioAlternativoLocal local = new ArticulosPremioAlternativoLocal(oid, premioAlternativo, cantidad, faltante, codigoProducto);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ArticulosPremioAlternativoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ArticulosPremioAlternativoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ArticulosPremioAlternativoLocal findByPrimaryKey(Long  oid) {
		ArticulosPremioAlternativoLocal local = (ArticulosPremioAlternativoLocal)em.find(ArticulosPremioAlternativoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ArticulosPremioAlternativoLocal.FindAll");
                    return query.getResultList();
            }

}

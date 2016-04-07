package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.GestionesCobranzaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class GestionesCobranzaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public GestionesCobranzaLocal create(String orden, Long cliente, Long periodo, Long etapaDeuda, Long usuarioCobranzas, Long codigoAccion) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_GECO_SEQ");
		et.begin();
		GestionesCobranzaLocal local = new GestionesCobranzaLocal(oid, orden, cliente, periodo, etapaDeuda, usuarioCobranzas, codigoAccion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(GestionesCobranzaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(GestionesCobranzaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public GestionesCobranzaLocal findByPrimaryKey(Long  oid) {
		GestionesCobranzaLocal local = (GestionesCobranzaLocal)em.find(GestionesCobranzaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("GestionesCobranzaLocal.FindAll");          
            return query.getResultList();
        }

}

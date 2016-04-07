package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;
import java.sql.Date;

import es.indra.sicc.entidades.cob.CronogramaCobranzaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CronogramaCobranzaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public CronogramaCobranzaLocal create(Long idCartera, Date fechaCierre, Long pais, Long periodo, Long subgerenciaVentas, Long tipoCargo, Long etapaDeuda, Long usuarioCobranzas) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_CRCO_SEQ");
		et.begin();
		CronogramaCobranzaLocal local = new CronogramaCobranzaLocal(oid, idCartera, fechaCierre, pais, periodo, subgerenciaVentas, tipoCargo, etapaDeuda, usuarioCobranzas);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CronogramaCobranzaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CronogramaCobranzaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CronogramaCobranzaLocal findByPrimaryKey(Long  oid) {
		CronogramaCobranzaLocal local = (CronogramaCobranzaLocal)em.find(CronogramaCobranzaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("CronogramaCobranzaLocal.FindAll");          
            return query.getResultList();
        }

}

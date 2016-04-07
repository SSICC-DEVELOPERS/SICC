package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.CabeceraGeneracionMasivaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CabeceraGeneracionMasivaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public CabeceraGeneracionMasivaLocal create(Integer numeroGeneracion, Long pais, Long acceso, Long tipoOperacion, Long ventaOrigen, Long ventaDestino) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_CAGM_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
	        CabeceraGeneracionMasivaLocal local = new CabeceraGeneracionMasivaLocal(oid, numeroGeneracion, pais, acceso, tipoOperacion, ventaOrigen, ventaDestino);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CabeceraGeneracionMasivaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CabeceraGeneracionMasivaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CabeceraGeneracionMasivaLocal findByPrimaryKey(Long  oid) {
		CabeceraGeneracionMasivaLocal local = (CabeceraGeneracionMasivaLocal)em.find(CabeceraGeneracionMasivaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("CabeceraGeneracionMasivaLocal.FindAll");
		
		return (query.getResultList());
	}

}

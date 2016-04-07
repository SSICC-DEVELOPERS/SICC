package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.TiposOfertaExcluidosLocal;
import es.indra.sicc.util.SecuenciadorOID;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class TiposOfertaExcluidosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public TiposOfertaExcluidosLocal create(Long pais, Long tipoOferta, Timestamp fechaDesde, Timestamp fechaHasta) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_TOEX_SEQ");
		TiposOfertaExcluidosLocal local = new TiposOfertaExcluidosLocal(oid, pais, tipoOferta, fechaDesde, fechaHasta);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TiposOfertaExcluidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TiposOfertaExcluidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TiposOfertaExcluidosLocal findByPrimaryKey(Long  oid) {
		TiposOfertaExcluidosLocal local = (TiposOfertaExcluidosLocal)em.find(TiposOfertaExcluidosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}

package es.indra.sicc.entidades.app;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.app.RutasTransporteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class RutasTransporteLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-app");
	private EntityManager em = emf.createEntityManager();

	public RutasTransporteLocal create(Long pais, String codigoRuta, Long numeroSecuencia) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("APP_RUTR_SEQ");
		RutasTransporteLocal local = new RutasTransporteLocal(oid, pais, codigoRuta, numeroSecuencia);
		em.persist(local);
		et.commit();
		return local;
	}

        public RutasTransporteLocal create(Long pais, String codigoRuta, Long numeroSecuencia, String observaciones) throws MareException {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("APP_RUTR_SEQ");
                RutasTransporteLocal local = new RutasTransporteLocal(oid, pais, codigoRuta, numeroSecuencia, observaciones);
                em.persist(local);
                et.commit();
                return local;
        }
	
	public void remove(RutasTransporteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RutasTransporteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RutasTransporteLocal findByPrimaryKey(Long  oid) {
		RutasTransporteLocal local = (RutasTransporteLocal)em.find(RutasTransporteLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}

package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.CabeceraReclamoDigitadoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CabeceraReclamoDigitadoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public CabeceraReclamoDigitadoLocal create(Long numeroDocumentoReferencia, String codigoCliente, Long pais, Integer idReclamo)throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_RCDG_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                CabeceraReclamoDigitadoLocal local = new CabeceraReclamoDigitadoLocal(oid, numeroDocumentoReferencia, codigoCliente, pais, idReclamo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CabeceraReclamoDigitadoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CabeceraReclamoDigitadoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CabeceraReclamoDigitadoLocal findByPrimaryKey(Long  oid) {
		CabeceraReclamoDigitadoLocal local = (CabeceraReclamoDigitadoLocal)em.find(CabeceraReclamoDigitadoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("CabeceraReclamoDigitadoLocal.FindAll");
		
		return (query.getResultList());
	}

}

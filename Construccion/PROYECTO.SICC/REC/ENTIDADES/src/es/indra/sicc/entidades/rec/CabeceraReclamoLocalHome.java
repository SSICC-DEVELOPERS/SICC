package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.CabeceraReclamoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CabeceraReclamoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public CabeceraReclamoLocal create(Long numeroAtencion, Long numeroReclamo, Long pais, Long numeroDocumentoReferencia, Long periodoDocumentoReferencia, Long cliente, Long periodoReclamo, Long subTipoCliente, Long tipoDocumento, Long estadoReclamo, Long tipoCliente) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_CARE_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                CabeceraReclamoLocal local = new CabeceraReclamoLocal(oid, numeroAtencion, numeroReclamo, pais, numeroDocumentoReferencia, periodoDocumentoReferencia, cliente, periodoReclamo, subTipoCliente, tipoDocumento, estadoReclamo, tipoCliente);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CabeceraReclamoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CabeceraReclamoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CabeceraReclamoLocal findByPrimaryKey(Long  oid) {
		CabeceraReclamoLocal local = (CabeceraReclamoLocal)em.find(CabeceraReclamoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("CabeceraReclamoLocal.FindAll");
		
		return query.getResultList();
	}

	public CabeceraReclamoLocal findByUK(Long param1,Long param2) {
		Query query=em.createNamedQuery("CabeceraReclamoLocal.FindByUK");
		
		query.setParameter(1, param1);

		query.setParameter(2, param2);

		return (CabeceraReclamoLocal)(query.getSingleResult());
	}

	public Collection findByNumeroAtencionInterfacePais(Long param1,Long param2) {
		Query query=em.createNamedQuery("CabeceraReclamoLocal.FindByNumeroAtencionInterfacePais");
		
		query.setParameter(1, param1);

		query.setParameter(2, param2);

		return query.getResultList();
	}

}

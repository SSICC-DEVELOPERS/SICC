package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.DocumentoPorSubaccesoLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class DocumentoPorSubaccesoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public DocumentoPorSubaccesoLocal create(Long empresa, Long subacceso, Long tipoDocumento, Long ultimoNumDocLegal, Long limiteNumDocLegal, Long ultimoEjercicioDocInterno,
                            String serieDocLegal, Long ultimoNumDocInterno, Long pais) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_DOSU_SEQ");
		DocumentoPorSubaccesoLocal local = new DocumentoPorSubaccesoLocal(oid, empresa, subacceso, tipoDocumento, ultimoNumDocLegal, limiteNumDocLegal, 
                            ultimoEjercicioDocInterno, serieDocLegal, ultimoNumDocInterno, pais);
		em.persist(local);
		et.commit();
		return local;
	}
        
	public void remove(DocumentoPorSubaccesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DocumentoPorSubaccesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DocumentoPorSubaccesoLocal findByPrimaryKey(Long  oid) {
		DocumentoPorSubaccesoLocal local = (DocumentoPorSubaccesoLocal)em.find(DocumentoPorSubaccesoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public DocumentoPorSubaccesoLocal findByUK(Long subacceso, Long empresa, Long tipoDocumento, Long pais) {
		Query query=em.createNamedQuery("DocumentoPorSubaccesoLocal.FindByUK");
		query.setParameter(1, subacceso);
		query.setParameter(2, empresa);
		query.setParameter(3, tipoDocumento);
		query.setParameter(4, pais);
		return (DocumentoPorSubaccesoLocal)(query.getSingleResult());
	}

}

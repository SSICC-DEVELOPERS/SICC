package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.AcumuladoImpuestosLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class AcumuladoImpuestosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public AcumuladoImpuestosLocal create(Float baseImpPosLocal, Float totalPreciosPosLocal, Float totalDescuentoCabLocal, Float baseImpDescuentoCabLocal, Float baseImpPrecioContableLocal, Float baseImpFleteLocal, Float baseImpTotalLocal, Float totalImpuestoLocal, Float totalImporteLocal, Float baseImpoPosDoc, Float totalPreciosPosDoc, Float totalDescuentoCabDoc, Float baseImpDescuentoCabDoc, Float baseImpPrecioContableDoc, Float baseImpFleteDoc, Float baseImpTotalDoc, Float totalImpuestoDoc, 
                Float totalImporteDoc, Long indicadorImpuestos, Long cabecera) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oidAcum = SecuenciadorOID.obtenerSiguienteValor("FAC_DCAI_SEQ");
		AcumuladoImpuestosLocal local = new AcumuladoImpuestosLocal(oidAcum, baseImpPosLocal, totalPreciosPosLocal, totalDescuentoCabLocal, baseImpDescuentoCabLocal, 
                                    baseImpPrecioContableLocal, baseImpFleteLocal, baseImpTotalLocal, totalImpuestoLocal, totalImporteLocal, baseImpoPosDoc, totalPreciosPosDoc, 
                                    totalDescuentoCabDoc, baseImpDescuentoCabDoc, baseImpPrecioContableDoc, baseImpFleteDoc, baseImpTotalDoc, totalImpuestoDoc, totalImporteDoc, 
                                    indicadorImpuestos, cabecera);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AcumuladoImpuestosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AcumuladoImpuestosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AcumuladoImpuestosLocal findByPrimaryKey(Long  oidAcum) {
		AcumuladoImpuestosLocal local = (AcumuladoImpuestosLocal)em.find(AcumuladoImpuestosLocal.class, oidAcum);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public AcumuladoImpuestosLocal findByUK(Long param1,Long param2) {
		Query query=em.createNamedQuery("AcumuladoImpuestosLocal.FindByUK");
		query.setParameter(1, param1);
		query.setParameter(2, param2);
		return (AcumuladoImpuestosLocal)(query.getSingleResult());
	}
}

package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.EtapasDeudaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class EtapasDeudaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public EtapasDeudaLocal create(String codigoEtapaDeuda, String descripcion, Long edadInicial, Long edadFinal, Boolean indTelefono, Long ordenamientoGestion1, BigDecimal importeDesde, BigDecimal importeHasta, Long diasGraciaCompromisosPago, BigDecimal porcentajeIncumplidas, Long pais) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_ETDE_SEQ");
		et.begin();
		EtapasDeudaLocal local = new EtapasDeudaLocal(oid, codigoEtapaDeuda, descripcion, edadInicial, edadFinal, indTelefono, ordenamientoGestion1, importeDesde, importeHasta, diasGraciaCompromisosPago, porcentajeIncumplidas, pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EtapasDeudaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EtapasDeudaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EtapasDeudaLocal findByPrimaryKey(Long  oid) {
		EtapasDeudaLocal local = (EtapasDeudaLocal)em.find(EtapasDeudaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("EtapasDeudaLocal.FindAll");          
            return query.getResultList();
        }


}

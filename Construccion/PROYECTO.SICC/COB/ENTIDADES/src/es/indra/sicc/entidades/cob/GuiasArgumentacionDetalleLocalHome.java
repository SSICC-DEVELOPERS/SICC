package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.GuiasArgumentacionDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class GuiasArgumentacionDetalleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public GuiasArgumentacionDetalleLocal create(Long ordenArgumento, Boolean valorDefecto, Boolean activarAtributoObservaciones, Long codigoArgumento, Long guiaArgumentalCabecera, Long indObligatorioVoluntario) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_GADE_SEQ");
		et.begin();
		GuiasArgumentacionDetalleLocal local = new GuiasArgumentacionDetalleLocal(oid, ordenArgumento, valorDefecto,  activarAtributoObservaciones, codigoArgumento, guiaArgumentalCabecera, indObligatorioVoluntario);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(GuiasArgumentacionDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(GuiasArgumentacionDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public GuiasArgumentacionDetalleLocal findByPrimaryKey(Long  oid) {
		GuiasArgumentacionDetalleLocal local = (GuiasArgumentacionDetalleLocal)em.find(GuiasArgumentacionDetalleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("GuiasArgumentacionDetalleLocal.FindAll");          
            return query.getResultList();
        }

}

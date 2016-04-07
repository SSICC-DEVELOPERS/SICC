package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.GuiasArgumentacionCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class GuiasArgumentacionCabeceraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public GuiasArgumentacionCabeceraLocal create(String codigoGuiaArgumental, Long pais, String descripcion) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_GACA_SEQ");
		et.begin();
		GuiasArgumentacionCabeceraLocal local = new GuiasArgumentacionCabeceraLocal(oid, codigoGuiaArgumental, pais, descripcion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(GuiasArgumentacionCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(GuiasArgumentacionCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public GuiasArgumentacionCabeceraLocal findByPrimaryKey(Long  oid) {
		GuiasArgumentacionCabeceraLocal local = (GuiasArgumentacionCabeceraLocal)em.find(GuiasArgumentacionCabeceraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("GuiasArgumentacionCabeceraLocal.FindAll");          
            return query.getResultList();
        }

}

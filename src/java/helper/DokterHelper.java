/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Dokter;
import pojos.Klinik;
import util.rsHibernateUtil;

/**
 *
 * @author MR98X
 */
public class DokterHelper {
    public DokterHelper(){};
    public List<Dokter> getDokter() {
        Session session = rsHibernateUtil.getSessionFactory().openSession();
        String query = "from Dokter";
        Query q = session.createQuery(query);
        List<Dokter> list = q.list();
        return list;
    }
    
    public void addNewDokter(Integer id, String nama, String spesialis) {
        Session session = rsHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Dokter dokter = new Dokter(id, nama, spesialis);
        session.saveOrUpdate(dokter);
        transaction.commit();
        session.close();
    }
}

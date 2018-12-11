/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Antrian;
import util.rsHibernateUtil;

/**
 *
 * @author MR98X
 */
public class AntrianHelper {
    public AntrianHelper(){};
    
    public List<Antrian> getAntrian() {
        Session session = rsHibernateUtil.getSessionFactory().openSession();
        String query = "from Antrian";
        Query q = session.createQuery(query);
        List<Antrian> list = q.list();
        return list;
    }
    
    public void addNewAntrian(Date tanggal, String noRm, String nama, String alamat, String namaKlinik) {
        Session session = rsHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Antrian antrian = new Antrian(tanggal, noRm, nama, alamat, namaKlinik);
        session.saveOrUpdate(antrian);
        transaction.commit();
        session.close();
    }
}

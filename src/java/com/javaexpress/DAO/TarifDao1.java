/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.DAO;

import com.javaexpress.bean.TarifBean;
import com.javaexpress.model.Admin;
import com.javaexpress.model.Kota;
import com.javaexpress.model.Status;
import com.javaexpress.model.Tarif;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Repository
@Transactional
public class TarifDao1 {

    static final Logger logger = Logger.getLogger(TarifDao.class.getName());

    @PersistenceUnit
    EntityManagerFactory emf;

    private EntityManager em;

    @Transactional
    public void saveTarif(TarifBean tf) {
        if (em.isOpen()) {
            em.close();
        }
        em = emf.createEntityManager();
        System.out.println("Masuk Ke Save Pertama...");
        Tarif tarif = new Tarif();
        Admin admin = new Admin();
        admin = getDataById(tf.getCreatedBy()); // ini untuk get Adminnya bor
        Status status = new Status();
        status = getDataStatusById(1); // by id disi 1, itu adalah Aktif
        Kota kotaAsal = new Kota();
        kotaAsal = getKota(tf.getKotaAsal());
        Kota kotaTujuan = new Kota();
        kotaTujuan = getKota(tf.getKotaTujuan());
//        status = getDataStatusById(tf.getStatus());
//        DateFormat format = new SimpleDateFormat("yyyy-M-dd");

        tarif.setKotaAsal(kotaAsal);
        tarif.setKotaTujuan(kotaTujuan);
        tarif.setReguler(BigDecimal.valueOf(tf.getReguler()));
        tarif.setKilat(BigDecimal.valueOf(tf.getKilat()));
        tarif.setOns(BigDecimal.valueOf(tf.getOns()));
        tarif.setSds(BigDecimal.valueOf(tf.getSds()));
        tarif.setHds(BigDecimal.valueOf(tf.getHds()));
        tarif.setCreatedBy(admin);
        tarif.setUpdatedBy(admin);
//        System.out.println("Datetime : "+format.parse(tf.getCreatedTime()));
//        tr.setCreatedTime(format.parse(tf.getCreatedTime()));
//        tr.setUpdatedTime(format.parse(tf.getUpdatedTime()));
        tarif.setCreatedTime(new Date());
        tarif.setUpdatedTime(new Date());
        tarif.setStatus(status);
        em.getTransaction().begin();
        em.persist(tarif);
        em.getTransaction().commit();
        em.close();
    }

    public void saveTarifKotaKe2(TarifBean tf) {
        if (em.isOpen()) {
            em.close();
        }
        em = emf.createEntityManager();
        System.out.println("Masuk Ke Save Kedua...");
        Tarif tarif = new Tarif();
        Admin admin = new Admin();
        admin = getDataById(tf.getCreatedBy()); // ini untuk get Adminnya bor
        Status status = new Status();
        status = getDataStatusById(1); // by id disi 1, itu adalah Aktif
        Kota kotaAsal = new Kota();
        kotaAsal = getKota(tf.getKotaAsal());
        Kota kotaTujuan = new Kota();
        kotaTujuan = getKota(tf.getKotaTujuan());
        tarif.setKotaAsal(kotaTujuan); // membalikan ini agar tidak input 2 kali
        tarif.setKotaTujuan(kotaAsal); // membalikan ini agar tidak input 2 kali
        tarif.setReguler(BigDecimal.valueOf(tf.getReguler()));
        tarif.setKilat(BigDecimal.valueOf(tf.getKilat()));
        tarif.setOns(BigDecimal.valueOf(tf.getOns()));
        tarif.setSds(BigDecimal.valueOf(tf.getSds()));
        tarif.setHds(BigDecimal.valueOf(tf.getHds()));
        tarif.setCreatedBy(admin);
        tarif.setUpdatedBy(admin);
        tarif.setCreatedTime(new Date());
        tarif.setUpdatedTime(new Date());
        tarif.setStatus(status);
        em.getTransaction().begin();
        em.persist(tarif);
        em.getTransaction().commit();
        em.close();
    }

    public Kota getKota(int kodeKota) {
        if (em.isOpen()) {
            em.close();
        }
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Kota.findByKodeKota");
        query.setParameter("kodeKota", kodeKota);
        Kota kota = (Kota) query.getSingleResult();
        em.clear();
        return kota;
    }

    public List<Tarif> showAllTarif() {
        if (em.isOpen()) {
            em.close();
        }
        em = emf.createEntityManager();
        List<Tarif> trf = new ArrayList<>();
        trf = em.createNamedQuery("Tarif.findAll").getResultList();
        em.clear();
        return trf;
    }

//    public List<Status> showAllStatus() {
//        if(em.isOpen()){
//            em.close();
//        }
//        em = emf.createEntityManager();
//        List<Status> status = new ArrayList<>();
//        status = em.createNamedQuery("Status.findAll").getResultList();
//        em.clear();
//        return status;
//    }
    public List<Kota> showAllKota() {
//        if(em.isOpen()){
//            em.close();
//        }
        em = emf.createEntityManager();
        List<Kota> kota = new ArrayList<>();
        kota = em.createNamedQuery("Kota.findAll").getResultList();
        em.clear();
        return kota;
    }

    public Admin getDataById(int idAdmin) {
        if (em.isOpen()) {
            em.close();
        }
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Admin.findByIdAdmin");
        query.setParameter("idAdmin", idAdmin);
        Admin admin = (Admin) query.getSingleResult();
        em.clear();
        return admin;
    }

    public Status getDataStatusById(int idStatus) {
        if (em.isOpen()) {
            em.close();
        }
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Status.findByIdStatus");
        query.setParameter("idStatus", idStatus);
        Status status = (Status) query.getSingleResult();
        em.clear();
        return status;
    }

    public void updateStatus(int idTarif, Admin admin) {
        if (em.isOpen()) {
            em.close();
        }
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Tarif.findByIdTarif");
        query.setParameter("idTarif", idTarif);
        Tarif tarif = (Tarif) query.getSingleResult();
        Tarif tarif2 = (Tarif) em.createNativeQuery("SELECT * FROM tarif WHERE kota_asal = " + tarif.getKotaTujuan().getKodeKota() + " AND kota_tujuan = " + tarif.getKotaAsal().getKodeKota(), Tarif.class).getSingleResult();
        if (tarif.getStatus().getStatus().equals("Aktif")) {
            tarif.setStatus(getDataStatusById(2));
            tarif2.setStatus(getDataStatusById(2));
            tarif.setUpdatedBy(admin);
            tarif.setUpdatedTime(new Date()); // update berdasrakan tanggal dan jam
            tarif2.setUpdatedBy(admin);
            tarif2.setUpdatedTime(new Date()); // update berdasrakan tanggal dan jam
        } else {
            tarif.setStatus(getDataStatusById(1));
            tarif.setUpdatedBy(admin);
            tarif.setUpdatedTime(new Date()); // update berdasrakan tanggal dan jam
            tarif2.setStatus(getDataStatusById(1));
            tarif2.setUpdatedBy(admin);
            tarif2.setUpdatedTime(new Date()); // update berdasrakan tanggal dan jam
        }
        em.getTransaction().begin();
        em.merge(tarif);
        em.merge(tarif2);
        em.getTransaction().commit();
        em.close();
    }

    public Tarif getDataByIdTarif(int idTarif) {
//        if (em.isOpen()) {
//            em.close();
//        }
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Tarif.findByIdTarif");
        query.setParameter("idTarif", idTarif);
        Tarif tarif = new Tarif();
        tarif = (Tarif) query.getSingleResult();
        em.clear();
        return tarif;
    }

    // UNTUK CEK KOTA SUDAH TERDAHTAR APA BELUM
    public int getCekDataKota(int kotaAsal, int kotaTujuan) {
        if (em.isOpen()) {
            em.close();
        }
        em = emf.createEntityManager();
        int count = ((Number) em.createNativeQuery("SELECT COUNT(id_tarif) FROM tarif WHERE kota_asal = " + kotaAsal + " AND kota_tujuan = " + kotaTujuan).getSingleResult()).intValue();
        System.out.println("Jumlah Kota Asal = " + count);
        em.clear();
        return count;
    }
    // UNTUK CEK KOTA SUDAH TERDAHTAR APA BELUM

    public void updateTarif(TarifBean tf, int idTarif) throws ParseException {
        if (em.isOpen()) {
            em.close();
        }
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Tarif.findByIdTarif");
        query.setParameter("idTarif", idTarif);
        Tarif tarif = (Tarif) query.getSingleResult();
        tarif.setReguler(BigDecimal.valueOf(tf.getReguler()));
        tarif.setKilat(BigDecimal.valueOf(tf.getKilat()));
        tarif.setOns(BigDecimal.valueOf(tf.getOns()));
        tarif.setSds(BigDecimal.valueOf(tf.getSds()));
        tarif.setHds(BigDecimal.valueOf(tf.getHds()));
        tarif.setUpdatedTime(new Date());
        Admin admin = getDataById(tf.getCreatedBy());
        tarif.setUpdatedBy(admin);

        try {
            Tarif tarif2 = (Tarif) em.createNativeQuery("SELECT * FROM tarif WHERE kota_asal = " + tarif.getKotaTujuan().getKodeKota() + " AND kota_tujuan = " + tarif.getKotaAsal().getKodeKota(), Tarif.class).getSingleResult();
            if (tarif2 != null) {
                // untuk update kota kedua
                tarif2.setReguler(BigDecimal.valueOf(tf.getReguler()));
                tarif2.setKilat(BigDecimal.valueOf(tf.getKilat()));
                tarif2.setOns(BigDecimal.valueOf(tf.getOns()));
                tarif2.setSds(BigDecimal.valueOf(tf.getSds()));
                tarif2.setHds(BigDecimal.valueOf(tf.getHds()));
                tarif2.setUpdatedTime(new Date());
                tarif2.setUpdatedBy(admin);
                // untuk update kota kedua
            }
            em.getTransaction().begin();
            em.merge(tarif);
            em.merge(tarif2);
            em.getTransaction().commit();
            em.close();
        } catch (Exception ex) {
            System.out.println("Errors Update : " + ex.getMessage());
            System.out.println("Data Kota Asal : " + tarif.getKotaTujuan().getNamaKota() + " dengan Kota Tujuan : " + tarif.getKotaAsal().getNamaKota() + "Tidak ditemukan...");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Admin;
import com.javaexpress.model.Pengiriman;
import com.javaexpress.model.Status;
import com.javaexpress.model.Tracking;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.javaexpress.dao.PengirimanDao;

/**
 *
 * @author user
 */
public class TrackingDao {
    private int idTracking;
    private String statusPengiriman;
    private Date createdTime;
    private Date updateTime;
    private PengirimanDao pengiriman;
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public void ActiveDatabase(){
         emf = Persistence.createEntityManagerFactory("JavaExpressPU");
         em = emf.createEntityManager();
         }
    
    public void CloseDatabase(){
         em.close();
         emf.close();
         }
    
    public Tracking selectTracking(String noResi){
    Tracking track = new Tracking();
    PengirimanDao pdao = new PengirimanDao();
    //Pengiriman pengiriman = pdao.getNoResi(noResi);
    ActiveDatabase();
    Query query = em.createQuery("SELECT e from Tracking e where e.kodePengiriman=:param");
    query.setParameter("param", pengiriman);
    track = (Tracking) query.getSingleResult();
    CloseDatabase();
    return track;
    }
    
    public void insertDatabaseTracking(String noResi,String statusPengiriman){
        ActiveDatabase();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Tracking track = new Tracking();
        PengirimanDao pdao = new PengirimanDao();
        //track.setKodePengiriman(pdao.getNoResi(noResi));
        track.setStatusPengiriman(statusPengiriman);
        track.setStatus(new Status(1));
        track.setCreatedBy(new Admin(1));
        track.setUpdatedBy(new Admin(1));
        track.setCreatedTime(new Date());
        track.setUpdateTime(new Date());
        em.persist(track);
        et.commit();
        CloseDatabase();
    }
}

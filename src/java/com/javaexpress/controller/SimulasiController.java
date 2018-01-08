
package com.javaexpress.controller;

import com.javaexpress.bean.CekTarifFormBean;
import com.javaexpress.dao.CekTarifDAO;
import com.javaexpress.model.Kota;
import com.javaexpress.model.Pengiriman;
import com.javaexpress.model.Tarif;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/simulasi")
public class SimulasiController {
    
    @Autowired
    CekTarifDAO dao;
    
    @RequestMapping()
    public String simulasiPage(Model model){
        CekTarifFormBean tarifFormBean = new CekTarifFormBean();
        List<Kota> kotas = dao.findAllKota();
        tarifFormBean.setBeratBarang(1);
        model.addAttribute("kota", kotas);
        model.addAttribute("cekTarif", tarifFormBean);
        model.addAttribute("cek", "");
        return "simulasi";
    }
    
    @RequestMapping("/simulasiresult")
   public String tarif(@ModelAttribute("cekTarif") CekTarifFormBean tarifFormBean, Model model) {
        List<Kota> kotas = dao.findAllKota();
        model.addAttribute("kota", kotas);
        Tarif tarif = new Tarif();
        Kota kotaAsal = new Kota();
        Pengiriman pengiriman = new Pengiriman();
        pengiriman.setBeratBarang(tarifFormBean.getBeratBarang());
        kotaAsal = dao.findKotaById(tarifFormBean.getKotaAsal());
        Kota kotaTujuan = new Kota();
        kotaTujuan = dao.findKotaById(tarifFormBean.getKotaTujuan());
        tarif = dao.findTarifByIdKota(kotaAsal, kotaTujuan);
        model.addAttribute("berat", pengiriman);
        model.addAttribute("kotaAsal", kotaAsal);
        model.addAttribute("kotaTujuan", kotaTujuan);
        model.addAttribute("tarif", tarif);
        model.addAttribute("cek", "ada");
        return "simulasiresult";
    }
    
}


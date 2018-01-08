package com.javaexpress.controller;

import com.javaexpress.bean.CekTarifFormBean;
import com.javaexpress.dao.CekTarifDAO;
import com.javaexpress.model.Kota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    CekTarifDAO dao;
    @RequestMapping()
    public String homePage(Model model) {
        CekTarifFormBean tarifFormBean = new CekTarifFormBean();
        List<Kota> kotas = dao.findAllKota();
        tarifFormBean.setBeratBarang(1);
        model.addAttribute("kota", kotas);
        model.addAttribute("cekTarif", tarifFormBean);
        model.addAttribute("cek", "");
        return "home";
        
    }
    
//    @RequestMapping("tracking")
//    public String 

}

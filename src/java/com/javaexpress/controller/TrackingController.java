
package com.javaexpress.controller;

import com.javaexpress.DTO.TrackingPengirimanDto;
import com.javaexpress.dao.TrackingDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/Tracking")
public class TrackingController {
    
    @RequestMapping
    public String Tracking(Model model){
        String Tracking = null;
        return Tracking;
    }
    
    @RequestMapping("/trackingresult")
    public String trackingResultPage(Model model, @RequestParam("search") String search){
        TrackingPengirimanDto tpd = new TrackingPengirimanDto();
        TrackingDao tdao = new TrackingDao();
        List<String> ls = new ArrayList<>();
        ls.add(tdao.selectTracking(search).getStatusPengiriman());
        tpd.setStatusPengiriman(ls);
        return "trackingresult";
    }
    
}

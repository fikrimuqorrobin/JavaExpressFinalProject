/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.DTO;

import java.util.List;

public class TrackingPengirimanDto {
    private List<String> StatusPengiriman;

    public TrackingPengirimanDto() {
    }

    /**
     * @return the StatusPengiriman
     */
    public List<String> getStatusPengiriman() {
        return StatusPengiriman;
    }

    /**
     * @param StatusPengiriman the StatusPengiriman to set
     */
    public void setStatusPengiriman(List<String> StatusPengiriman) {
        this.StatusPengiriman = StatusPengiriman;
    }
    
}

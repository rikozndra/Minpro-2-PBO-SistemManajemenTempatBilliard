/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniproject2_pbo.model;

/**
 *
 * @author user
 */
public class MejaReguler extends MejaBilliard {
    
    public MejaReguler(int nomorMeja) {
        super(nomorMeja, 30000);
    }

    @Override
    public String getJenisMeja() {
        return "Reguler";
    }

    @Override
    public double hitungBiaya(int durasiJam) {
        return getHargaPerJam() * durasiJam;
    }
    
}
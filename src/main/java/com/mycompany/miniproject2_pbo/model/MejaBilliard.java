/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniproject2_pbo.model;

/**
 *
 * @author user
 */
public abstract class MejaBilliard {
    private int nomorMeja;
    private double hargaPerJam;
    private String status;

    public MejaBilliard(int nomorMeja, double hargaPerJam) {
        this.nomorMeja = nomorMeja;
        this.hargaPerJam = hargaPerJam;
        this.status = "Tersedia";
    }

    public int getNomorMeja() {
        return nomorMeja;
    }

    public void setNomorMeja(int nomorMeja) {
        this.nomorMeja = nomorMeja;
    }

    public double getHargaPerJam() {
        return hargaPerJam;
    }

    public void setHargaPerJam(double hargaPerJam) {
        this.hargaPerJam = hargaPerJam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract String getJenisMeja();

    public abstract double hitungBiaya(int durasiJam);
}

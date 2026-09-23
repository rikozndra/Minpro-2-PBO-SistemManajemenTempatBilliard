/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniproject2_pbo.model;

/**
 *
 * @author user
 */
public class Transaksi {
    
    private int idTransaksi;
    private int nomorMeja;
    private String namaPelanggan;
    private int durasiJam;
    private double totalBayar;

    public Transaksi(int idTransaksi, int nomorMeja,
            String namaPelanggan, int durasiJam,
            double totalBayar) {

        this.idTransaksi = idTransaksi;
        this.nomorMeja = nomorMeja;
        this.namaPelanggan = namaPelanggan;
        this.durasiJam = durasiJam;
        this.totalBayar = totalBayar;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public int getNomorMeja() {
        return nomorMeja;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public int getDurasiJam() {
        return durasiJam;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setDurasiJam(int durasiJam) {
        this.durasiJam = durasiJam;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }
}

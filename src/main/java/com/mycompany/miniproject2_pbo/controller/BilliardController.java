/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniproject2_pbo.controller;

import com.mycompany.miniproject2_pbo.model.MejaBilliard;
import com.mycompany.miniproject2_pbo.model.MejaReguler;
import com.mycompany.miniproject2_pbo.model.MejaVIP;
import com.mycompany.miniproject2_pbo.model.Transaksi;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class BilliardController {
    
    private ArrayList<MejaBilliard> daftarMeja;
    private ArrayList<Transaksi> daftarTransaksi;

    private int idTransaksi = 1;

    public BilliardController() {

        daftarMeja = new ArrayList<>();
        daftarTransaksi = new ArrayList<>();

        // Dummy data awal
        daftarMeja.add(new MejaReguler(1));
    }

    // CREATE
    public boolean tambahMeja(int nomorMeja, String jenisMeja) {

        if (nomorMeja <= 0) {
            return false;
        }

        if (cariMeja(nomorMeja) != null) {
            return false;
        }

        MejaBilliard meja;

        if (jenisMeja.equalsIgnoreCase("Reguler")) {
            meja = new MejaReguler(nomorMeja);

        } else if (jenisMeja.equalsIgnoreCase("VIP")) {
            meja = new MejaVIP(nomorMeja);

        } else {
            return false;
        }

        daftarMeja.add(meja);

        return true;
    }

    // READ
    public void tampilkanMeja() {

        if (daftarMeja.isEmpty()) {
            System.out.println("Belum ada data meja.");
            return;
        }

        System.out.println("\n========== DATA MEJA ==========");

        for (MejaBilliard meja : daftarMeja) {

            System.out.println("Nomor Meja : "
                    + meja.getNomorMeja());

            System.out.println("Jenis Meja : "
                    + meja.getJenisMeja());

            System.out.println("Harga/Jam  : Rp"
                    + meja.getHargaPerJam());

            System.out.println("Status     : "
                    + meja.getStatus());

            System.out.println("-------------------------------");
        }
    }

    // UPDATE
    public boolean ubahMeja(int nomorMeja, String jenisBaru) {

        MejaBilliard mejaLama = cariMeja(nomorMeja);

        if (mejaLama == null) {
            return false;
        }

        if (!mejaLama.getStatus().equals("Tersedia")) {
            return false;
        }

        MejaBilliard mejaBaru;

        if (jenisBaru.equalsIgnoreCase("Reguler")) {
            mejaBaru = new MejaReguler(nomorMeja);

        } else if (jenisBaru.equalsIgnoreCase("VIP")) {
            mejaBaru = new MejaVIP(nomorMeja);

        } else {
            return false;
        }

        int index = daftarMeja.indexOf(mejaLama);
        daftarMeja.set(index, mejaBaru);

        return true;
    }

    // DELETE
    public boolean hapusMeja(int nomorMeja) {

        MejaBilliard meja = cariMeja(nomorMeja);

        if (meja == null) {
            return false;
        }

        if (!meja.getStatus().equals("Tersedia")) {
            return false;
        }

        daftarMeja.remove(meja);

        return true;
    }

    // BUKA MEJA
    public boolean bukaMeja(
            int nomorMeja,
            String namaPelanggan,
            int durasiJam) {

        MejaBilliard meja = cariMeja(nomorMeja);

        if (meja == null) {
            return false;
        }

        if (!meja.getStatus().equals("Tersedia")) {
            return false;
        }

        if (namaPelanggan == null
                || namaPelanggan.trim().isEmpty()) {
            return false;
        }

        if (durasiJam <= 0) {
            return false;
        }

        double totalBayar = meja.hitungBiaya(durasiJam);

        Transaksi transaksi = new Transaksi(
                idTransaksi,
                nomorMeja,
                namaPelanggan,
                durasiJam,
                totalBayar
        );

        daftarTransaksi.add(transaksi);

        idTransaksi++;

        meja.setStatus("Digunakan");

        return true;
    }

    // TAMBAH WAKTU
    public boolean tambahWaktu(
            int nomorMeja,
            int tambahanJam) {

        if (tambahanJam <= 0) {
            return false;
        }

        MejaBilliard meja = cariMeja(nomorMeja);

        if (meja == null) {
            return false;
        }

        if (!meja.getStatus().equals("Digunakan")) {
            return false;
        }

        Transaksi transaksi = cariTransaksiAktif(nomorMeja);

        if (transaksi == null) {
            return false;
        }

        int durasiBaru =
                transaksi.getDurasiJam() + tambahanJam;

        double totalBaru =
                meja.hitungBiaya(durasiBaru);

        transaksi.setDurasiJam(durasiBaru);
        transaksi.setTotalBayar(totalBaru);

        return true;
    }

    // TUTUP MEJA
    public Transaksi tutupMeja(int nomorMeja) {

        MejaBilliard meja = cariMeja(nomorMeja);

        if (meja == null) {
            return null;
        }

        if (!meja.getStatus().equals("Digunakan")) {
            return null;
        }

        Transaksi transaksi = cariTransaksiAktif(nomorMeja);

        if (transaksi == null) {
            return null;
        }

        meja.setStatus("Tersedia");

        daftarTransaksi.remove(transaksi);

        return transaksi;
    }

    // MENCARI MEJA
    private MejaBilliard cariMeja(int nomorMeja) {

        for (MejaBilliard meja : daftarMeja) {

            if (meja.getNomorMeja() == nomorMeja) {
                return meja;
            }
        }

        return null;
    }

    // MENCARI TRANSAKSI AKTIF
    private Transaksi cariTransaksiAktif(int nomorMeja) {

        for (Transaksi transaksi : daftarTransaksi) {

            if (transaksi.getNomorMeja() == nomorMeja) {
                return transaksi;
            }
        }

        return null;
    }
}
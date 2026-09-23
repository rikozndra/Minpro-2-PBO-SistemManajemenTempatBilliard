/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniproject2_pbo.view;

import com.mycompany.miniproject2_pbo.controller.BilliardController;
import com.mycompany.miniproject2_pbo.model.Transaksi;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Menu {
    private Scanner input;
    private BilliardController controller;

    public Menu() {
        input = new Scanner(System.in);
        controller = new BilliardController();
    }

    public void tampilkanMenu() {

        int pilihan;

        do {
            System.out.println("\n==============================");
            System.out.println("   SISTEM MANAJEMEN BILLIARD");
            System.out.println("==============================");
            System.out.println("1. Tambah Meja");
            System.out.println("2. Tampilkan Data Meja");
            System.out.println("3. Ubah Data Meja");
            System.out.println("4. Hapus Meja");
            System.out.println("5. Buka Meja");
            System.out.println("6. Tambah Waktu");
            System.out.println("7. Tutup Meja");
            System.out.println("8. Keluar");
            System.out.println("==============================");

            pilihan = bacaAngka("Pilih menu: ");

            switch (pilihan) {

                case 1:
                    tambahMeja();
                    break;

                case 2:
                    controller.tampilkanMeja();
                    break;

                case 3:
                    ubahMeja();
                    break;

                case 4:
                    hapusMeja();
                    break;

                case 5:
                    bukaMeja();
                    break;

                case 6:
                    tambahWaktu();
                    break;

                case 7:
                    tutupMeja();
                    break;

                case 8:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia.");
            }

        } while (pilihan != 8);
    }

    private void tambahMeja() {

        System.out.println("\n--- TAMBAH MEJA ---");

        int nomorMeja = bacaAngkaPositif("Nomor meja: ");

        String jenisMeja = bacaJenisMeja();

        boolean berhasil = controller.tambahMeja(
                nomorMeja,
                jenisMeja
        );

        if (berhasil) {
            System.out.println("Meja berhasil ditambahkan.");
        } else {
            System.out.println(
                    "Gagal menambahkan meja. "
                    + "Nomor mungkin sudah digunakan."
            );
        }
    }

    private void ubahMeja() {

        System.out.println("\n--- UBAH DATA MEJA ---");

        int nomorMeja = bacaAngkaPositif(
                "Nomor meja yang ingin diubah: "
        );

        String jenisBaru = bacaJenisMeja();

        boolean berhasil = controller.ubahMeja(
                nomorMeja,
                jenisBaru
        );

        if (berhasil) {
            System.out.println("Data meja berhasil diubah.");
        } else {
            System.out.println(
                    "Gagal mengubah data. "
                    + "Meja tidak ditemukan atau sedang digunakan."
            );
        }
    }

    private void hapusMeja() {

        System.out.println("\n--- HAPUS MEJA ---");

        int nomorMeja = bacaAngkaPositif(
                "Nomor meja yang ingin dihapus: "
        );

        boolean berhasil = controller.hapusMeja(nomorMeja);

        if (berhasil) {
            System.out.println("Meja berhasil dihapus.");
        } else {
            System.out.println(
                    "Meja tidak ditemukan atau sedang digunakan."
            );
        }
    }

    private void bukaMeja() {

        System.out.println("\n--- BUKA MEJA ---");

        int nomorMeja = bacaAngkaPositif("Nomor meja: ");

        String namaPelanggan;

        do {
            System.out.print("Nama pelanggan: ");
            namaPelanggan = input.nextLine().trim();

            if (namaPelanggan.isEmpty()) {
                System.out.println(
                        "Nama pelanggan tidak boleh kosong."
                );
            }

        } while (namaPelanggan.isEmpty());

        int durasiJam = bacaAngkaPositif(
                "Durasi awal (jam): "
        );

        boolean berhasil = controller.bukaMeja(
                nomorMeja,
                namaPelanggan,
                durasiJam
        );

        if (berhasil) {
            System.out.println("Meja berhasil dibuka.");
        } else {
            System.out.println(
                    "Gagal membuka meja. "
                    + "Periksa nomor, durasi, atau status meja."
            );
        }
    }

    private void tambahWaktu() {

        System.out.println("\n--- TAMBAH WAKTU ---");

        int nomorMeja = bacaAngkaPositif("Nomor meja: ");

        int tambahanJam = bacaAngkaPositif(
                "Tambahan waktu (jam): "
        );

        boolean berhasil = controller.tambahWaktu(
                nomorMeja,
                tambahanJam
        );

        if (berhasil) {
            System.out.println("Waktu berhasil ditambahkan.");
        } else {
            System.out.println(
                    "Gagal menambahkan waktu. "
                    + "Pastikan meja sedang digunakan."
            );
        }
    }

    private void tutupMeja() {

        System.out.println("\n--- TUTUP MEJA ---");

        int nomorMeja = bacaAngkaPositif("Nomor meja: ");

        Transaksi transaksi = controller.tutupMeja(nomorMeja);

        if (transaksi != null) {

            System.out.println("\n====== STRUK PEMBAYARAN ======");

            System.out.println(
                    "Nama Pelanggan : "
                    + transaksi.getNamaPelanggan()
            );

            System.out.println(
                    "Nomor Meja     : "
                    + transaksi.getNomorMeja()
            );

            System.out.println(
                    "Durasi         : "
                    + transaksi.getDurasiJam()
                    + " jam"
            );

            System.out.println(
                    "Total Bayar    : Rp"
                    + transaksi.getTotalBayar()
            );

            System.out.println("===============================");
            System.out.println("Meja berhasil ditutup.");

        } else {

            System.out.println(
                    "Meja tidak ditemukan atau tidak sedang digunakan."
            );
        }
    }

    private String bacaJenisMeja() {

        String jenisMeja;

        do {
            System.out.print("Jenis meja (Reguler/VIP): ");
            jenisMeja = input.nextLine().trim();

            if (!jenisMeja.equalsIgnoreCase("Reguler")
                    && !jenisMeja.equalsIgnoreCase("VIP")) {

                System.out.println(
                        "Jenis meja hanya Reguler atau VIP."
                );
            }

        } while (!jenisMeja.equalsIgnoreCase("Reguler")
                && !jenisMeja.equalsIgnoreCase("VIP"));

        return jenisMeja;
    }

    private int bacaAngka(String pesan) {

        while (true) {

            System.out.print(pesan);

            String teks = input.nextLine().trim();

            try {

                int angka = Integer.parseInt(teks);

                if (angka < 0) {
                    System.out.println(
                            "Input tidak boleh negatif."
                    );
                    continue;
                }

                return angka;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input harus berupa angka."
                );
            }
        }
    }

    private int bacaAngkaPositif(String pesan) {

        while (true) {

            System.out.print(pesan);

            String teks = input.nextLine().trim();

            try {

                int angka = Integer.parseInt(teks);

                if (angka <= 0) {
                    System.out.println(
                            "Input harus lebih dari 0."
                    );
                    continue;
                }

                return angka;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input harus berupa angka."
                );
            }
        }
    }
}
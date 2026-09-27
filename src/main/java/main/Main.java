package main;

import controller.*;

public class Main {

    public static void main(String[] args) {
        CommisionService commisionService = new CommisionService();

        int pilihan = 0;

        do {
            System.out.println("\n=========== SISTEM MANAJEMEN KOMISI GAMBAR ============");
            System.out.println("[1] Tambah Pesanan Baru");
            System.out.println("[2] Lihat Daftar Pesanan Batch");
            System.out.println("[3] Lihat Rekap Pendapatan Batch Saat Ini");
            System.out.println("[4] Keluar");
            System.out.println("------------------------------------------------------");

            pilihan = ValidasiInput.inputAngka("Pilih menu (1-4): ");

            switch (pilihan) {
                case 1 -> commisionService.tambahPesanan();
                case 2 -> commisionService.tampilkanDaftarPesanan();
                case 3 -> commisionService.tampilkanRekapPendapatan();
                case 4 -> System.out.println("\nTerima kasih telah menggunakan sistem ini!");
                default -> System.out.println("\nPilihan menu tidak valid!");
            }
        } while (pilihan != 4);
    }
}
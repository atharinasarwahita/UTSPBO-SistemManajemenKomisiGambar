package controller;

import models.*;
import java.util.ArrayList;

public class CommisionService {
    private ArrayList<CommisionOrder> daftarPesanan = new ArrayList<>();
    private final int slot = 3;

    //Data Dummy
    public CommisionService() {
        Customer client1 = new Customer("Arin", "081234567890");
        Artwork karya1 = new PersonalUse("Character Fanart", "Full Color", "Buat avatar Twitter");
        double total1 = karya1.hitungTotalHarga();
        daftarPesanan.add(new CommisionOrder("KM01", client1, karya1, false, new PembayaranLunas(total1)));

        Customer client2 = new Customer("Budi", "089876543210");
        Artwork karya2 = new CommersialUse("Stream Overlay", "Chibi", 150000);
        double total2 = karya2.hitungTotalHarga() + 50000;
        daftarPesanan.add(new CommisionOrder("KM02", client2, karya2, true, new PembayaranDP(total2)));
    }

    public boolean isSlotFull() {
        return daftarPesanan.size() >= slot;
    }

    public int getJumlahPesananSaatIni() {
        return daftarPesanan.size();
    }

    public int getBatasMaksimalSlot() {
        return slot;
    }
    
    public boolean isIdExist(String idPesanan) {
        for (CommisionOrder p : daftarPesanan) {
            if (p.getIdPesanan().equalsIgnoreCase(idPesanan)) {
                return true;
            }
        }
        return false;
    }

    // Create (Tambah) Pesanan
    public void tambahPesanan() {
        if (isSlotFull()) {
            System.out.println("\n[!] Maaf, slot komisi batch ini sudah penuh! ("
                    + getJumlahPesananSaatIni() + "/"
                    + getBatasMaksimalSlot() + ")");
            return;
        }

        System.out.println("\n--------------------- DATA PESANAN --------------------");
        int jenis = ValidasiInput.inputAngka("Pilih jenis lisensi (1. Personal / 2. Commercial): ");
        if (jenis < 1 || jenis > 2) {
            System.out.println("Pilihan jenis lisensi tidak valid!");
            return; 
        }

        String idPesanan = ValidasiInput.inputTeks("Masukkan ID Pesanan: ");

        for (CommisionOrder p : daftarPesanan) {
            if (p.getIdPesanan().equalsIgnoreCase(idPesanan)) {
                System.out.println("ID Sudah Digunakan! Silakan gunakan ID lain.");
                return;
            }
        }

        String nama = ValidasiInput.inputTeks("Masukkan Nama Pelanggan: ");
        String noHp = ValidasiInput.inputTeks("Masukkan No HP Pelanggan: ");
        Customer customer = new Customer(nama, noHp);

        String judul = ValidasiInput.inputTeks("Masukkan Judul Karya: ");
        System.out.println("\nPilih Gaya Gambar & Paket Harga:");
        System.out.println("1. Lineart - Rp50.000");
        System.out.println("2. Chibi - Rp100.000");
        System.out.println("3. Full Color - Rp200.000");
        
        int pilGaya = ValidasiInput.inputAngka("Pilih paket (1-3): ");
        while (pilGaya < 1 || pilGaya > 3) {
            System.out.println("Pilihan tidak valid!");
            pilGaya = ValidasiInput.inputAngka("Pilih paket (1-3): ");
        }

        String gaya = switch (pilGaya) {
            case 1 -> "Lineart";
            case 2 -> "Chibi";
            default -> "Full Color";
        };

        Artwork karya = null;
        if (jenis == 1) {
            String catatan = ValidasiInput.inputTeks("Masukkan Catatan Keperluan Pribadi: ");
            karya = new PersonalUse(judul, gaya, catatan);
        } else {
            int biayaLisensi = ValidasiInput.inputAngka("Masukkan Biaya Lisensi Komersial (Rp): ");
            karya = new CommersialUse(judul, gaya, biayaLisensi);
        }

        String expressInput = ValidasiInput.inputTeks("Pengerjaan Express (+Rp50.000)? (y/n): ");
        boolean isExpress = expressInput.equalsIgnoreCase("y");

        // Opsi Pembayaran
        System.out.println("\nPilih Metode Pembayaran:");
        System.out.println("1. DP 50%");
        System.out.println("2. Lunas (Full Payment)");
        int tipeBayar = ValidasiInput.inputAngka("Pilih (1-2): ");

        double totalBiaya = karya.hitungTotalHarga() + (isExpress ? 50000 : 0);
        Pembayaran pembayaran = (tipeBayar == 1) ? new PembayaranDP(totalBiaya) : new PembayaranLunas(totalBiaya);

        CommisionOrder pesananBaru = new CommisionOrder(idPesanan, customer, karya, isExpress, pembayaran);
        daftarPesanan.add(pesananBaru);

        System.out.println("\nYeayy, pesanan komisi kamu berhasil ditambahkan!");
        pesananBaru.tampilkanInvoice();
    }

    // Read (Menampilkan) Pesanan
    public void tampilkanDaftarPesanan() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("\nBelum ada pesanan masuk di batch ini.");
            return;
        }

        System.out.println("\n================ DAFTAR PESANAN BATCH SAAT INI ================");
        for (CommisionOrder p : daftarPesanan) {
            System.out.println("ID Pesanan   : " + p.getIdPesanan());
            System.out.println("Pelanggan    : " + p.getCustomer().getNama() + " (" + p.getCustomer().getNoHp() + ")");
            System.out.println("Judul Karya  : " + p.getArtwork().getJudul() + " [" + p.getArtwork().getGayaGambar() + "]");
            System.out.println("Harga Paket  : Rp" + p.getArtwork().getHargaDasar());
            System.out.println("Layanan Express: " + (p.isExpress() ? "Ya (+Rp50.000)" : "Tidak"));
            System.out.println("\nStatus Bayar : " + p.getPembayaran().getStatusPembayaran());
            System.out.println("Nominal Bayar: Rp" + p.getPembayaran().hitungNominalBayar() + " (Total: Rp" + p.getTotalBayar() + ")");
            System.out.println("-------------------------------------------------------------");
        }
    }

    // Read (Menampilkan) Pendapatan
    public void tampilkanRekapPendapatan() {
        System.out.println("\n=================== REKAP PENDAPATAN ==================");
        if (daftarPesanan.isEmpty()) {
            System.out.println("Belum ada pendapatan.");
            System.out.println("Total Pendapatan: Rp 0");
            return;
        }

        int totalPendapatan = 0;
        int totalPembayaran = 0;
        for (CommisionOrder p : daftarPesanan) {
            totalPendapatan += p.getTotalBayar();
            totalPembayaran += p.getPembayaran().hitungNominalBayar();
        }

        System.out.println("Jumlah Pesanan Diterima   : " + daftarPesanan.size() + "/" + slot);
        System.out.println("Total Uang Pembayaran     : Rp" + totalPembayaran);
        System.out.println("Total Estimasi Pendapatan : Rp" + totalPendapatan);
    }
}
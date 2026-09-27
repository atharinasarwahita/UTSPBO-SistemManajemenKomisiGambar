package models;

public class CommersialUse extends Artwork {
    private double biayaLisensi;

    public CommersialUse (String judul, String gayaGambar, double biayaLisensi) {
        super(judul, gayaGambar);
        this.biayaLisensi = biayaLisensi;
    }

    @Override
    public double hitungTotalHarga() {
        return hargaDasar + biayaLisensi;
    }

    @Override
    public void tampilkanRincian() {
        System.out.println("Tipe Lisensi  : Penggunaan Komersial");
        System.out.println("Biaya Lisensi : Rp" + biayaLisensi);
    }
}

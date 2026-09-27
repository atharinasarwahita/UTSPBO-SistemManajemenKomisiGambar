package models;

public class PersonalUse extends Artwork {
    private String catatanPribadi;

    public PersonalUse (String judul, String gayaGambar, String catatanPribadi) {
        super(judul, gayaGambar);
        this.catatanPribadi = catatanPribadi;
    }

    @Override
    public double hitungTotalHarga() {
        return hargaDasar;
    }

    @Override
    public void tampilkanRincian() {
        System.out.println("Tipe Lisensi  : Penggunaan Pribadi");
        System.out.println("Catatan Client: " + catatanPribadi);
    }
}

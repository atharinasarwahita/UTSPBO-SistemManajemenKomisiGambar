package models;

public class Artwork {
    private String judul;
    protected double hargaDasar;
    private String gayaGambar;

    public Artwork(String judul, String gayaGambar) {
        this.judul = judul;
        this.gayaGambar = gayaGambar;
        
        switch (gayaGambar.toLowerCase()) {
            case "lineart":
                this.hargaDasar = 50000;
                break;
            case "chibi":
                this.hargaDasar = 100000;
                break;
            case "full color":
                this.hargaDasar = 200000;
                break;
            default:
                this.hargaDasar = 50000;
                break;
        }
    }

    public String getJudul() { return judul; }
    public String getGayaGambar() { return gayaGambar; }
    public double getHargaDasar() { return hargaDasar; }
    
    public double hitungTotalHarga() {
        return hargaDasar;
    }

    public void tampilkanRincian() {
        System.out.println("Biaya Lisensi : Rp0 (Personal)");
    }
}
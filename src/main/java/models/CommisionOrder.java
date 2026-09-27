package models;

public class CommisionOrder {
    private String idPesanan;
    private Customer customer;
    private Artwork artwork;
    private boolean isExpress;
    private Pembayaran pembayaran;

    public CommisionOrder(String idPesanan, Customer customer, Artwork artwork, boolean isExpress, Pembayaran pembayaran) {
        this.idPesanan = idPesanan;
        this.customer = customer;
        this.artwork = artwork;
        this.isExpress = isExpress;
        this.pembayaran = pembayaran;
    }

    public String getIdPesanan() { return idPesanan; }
    public Customer getCustomer() { return customer; }
    public Artwork getArtwork() { return artwork; }
    public boolean isExpress() { return isExpress; }
    public Pembayaran getPembayaran() { return pembayaran; }

    public double getTotalBayar() {
        double total = artwork.hitungTotalHarga();
        if (isExpress) {
            total += 50000;
        }
        return total;
    }

    public void tampilkanInvoice() {
        System.out.println("\n==========================================");
        System.out.println("        INVOICE PESANAN KOMISI GAMBAR     ");
        System.out.println("==========================================");
        System.out.println("ID Pesanan     : " + idPesanan);
        System.out.println("Nama Pelanggan : " + customer.getNama());
        System.out.println("No HP          : " + customer.getNoHp());
        System.out.println("------------------------------------------");
        System.out.println("Judul Karya    : " + artwork.getJudul());
        System.out.println("Gaya Gambar    : " + artwork.getGayaGambar());
        System.out.println("Harga Dasar    : Rp" + artwork.getHargaDasar());

        artwork.tampilkanRincian();

        if (isExpress) {
            System.out.println("Layanan Express: Ya (+Rp50.000)");
        } else {
            System.out.println("Layanan Express: Tidak");
        }

        System.out.println("------------------------------------------");
        System.out.println("Total Tagihan  : Rp" + getTotalBayar());
        System.out.println("Status Bayar   : " + pembayaran.getStatusPembayaran());
        System.out.println("Nominal Bayar  : Rp" + pembayaran.hitungNominalBayar());
        System.out.println("==========================================");
    }
}
package models;

public class PembayaranLunas extends Pembayaran {

    public PembayaranLunas(double totalBiaya) {
        super(totalBiaya);
    }

    @Override
    public double hitungNominalBayar() {
        return totalBiaya;
    }

    @Override
    public String getStatusPembayaran() {
        return "Lunas (Full Payment)";
    }
}

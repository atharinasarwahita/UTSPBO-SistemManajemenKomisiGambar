package models;

public class PembayaranDP extends Pembayaran {

    public PembayaranDP(double totalBiaya) {
        super(totalBiaya);
    }

    @Override
    public double hitungNominalBayar() {
        return totalBiaya / 2; // DP 50%
    }

    @Override
    public String getStatusPembayaran() {
        return "DP 50%";
    }
}
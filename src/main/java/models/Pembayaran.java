package models;

public abstract class Pembayaran {
    protected double totalBiaya;

    public Pembayaran(double totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public abstract double hitungNominalBayar();
    public abstract String getStatusPembayaran();
}
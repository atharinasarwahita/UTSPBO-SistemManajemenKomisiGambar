package models;

public class Customer {
    private String nama;
    private String noHp;

    public Customer(String nama, String noHp) {
        this.nama = nama;
        this.noHp = noHp;
    }

    public String getNama() { return nama; }
    public String getNoHp() { return noHp; }
}

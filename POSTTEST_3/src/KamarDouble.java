public class KamarDouble extends KamarKost {
    private String namaPenyewa2;

    public KamarDouble(String nomorKamar, String namaPenyewa, String namaPenyewa2, int hargaPerBulan, boolean tersedia) {
        super(nomorKamar, namaPenyewa, hargaPerBulan, tersedia);
        this.namaPenyewa2 = namaPenyewa2;
    }

    public String getNamaPenyewa2() { return namaPenyewa2; }
    public void setNamaPenyewa2(String namaPenyewa2) { this.namaPenyewa2 = namaPenyewa2; }

    public void tampilkanInfoDouble() {
        System.out.println("--------------------------------------------");
        super.tampilkanInfoDasar();
        System.out.println("Tipe Kamar    : Double (Kapasitas 2 Orang)");
        System.out.println("Penyewa Ke-2  : " + this.namaPenyewa2);
    }
}
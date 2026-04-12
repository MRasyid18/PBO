public class KamarSuite extends KamarKost {
    private String fasilitasTambahan;

    public KamarSuite(String nomorKamar, String namaPenyewa, String fasilitasTambahan, int hargaPerBulan, boolean tersedia) {
        super(nomorKamar, namaPenyewa, hargaPerBulan, tersedia);
        this.fasilitasTambahan = fasilitasTambahan;
    }

    public String getFasilitasTambahan() { return fasilitasTambahan; }
    public void setFasilitasTambahan(String fasilitasTambahan) { this.fasilitasTambahan = fasilitasTambahan; }

    public void tampilkanInfoSuite() {
        System.out.println("--------------------------------------------");
        super.tampilkanInfoDasar();
        System.out.println("Tipe Kamar    : Suite (Premium)");
        System.out.println("Fasilitas     : " + this.fasilitasTambahan);
    }
}
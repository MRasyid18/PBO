public class KamarSuite extends KamarKost {
    private String fasilitasTambahan;

    public KamarSuite(String nomorKamar, String namaPenyewa,
                        String fasilitasTambahan, int hargaPerBulan, boolean tersedia) {
        super(nomorKamar, namaPenyewa, hargaPerBulan, tersedia);
        setFasilitasTambahan(fasilitasTambahan);
    }

    public String getFasilitasTambahan() {
        return fasilitasTambahan;
    }

    public void setFasilitasTambahan(String fasilitasTambahan) {
        if (fasilitasTambahan == null || fasilitasTambahan.trim().isEmpty()) {
            this.fasilitasTambahan = "Tidak ada";
        } else {
            this.fasilitasTambahan = fasilitasTambahan.trim();
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Tipe Kamar    : Suite (Premium)");
        System.out.println("Fasilitas     : " + getFasilitasTambahan());
    }
}
public class KamarSuite extends KamarKost {
    private String fasilitasTambahan; // atribut tambahan khusus Suite

    public KamarSuite(String nomorKamar, String namaPenyewa,
        String fasilitasTambahan, int hargaPerBulan, boolean tersedia) {
        super(nomorKamar, namaPenyewa, hargaPerBulan, tersedia);
        this.fasilitasTambahan = (fasilitasTambahan == null || fasilitasTambahan.trim().isEmpty())
        ? "Tidak ada" : fasilitasTambahan.trim();
    }

    public String getFasilitasTambahan() { return fasilitasTambahan; }

    @Override
    protected void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Tipe Kamar    : Suite (Premium)");
        System.out.println("Fasilitas     : " + getFasilitasTambahan());
    }
}
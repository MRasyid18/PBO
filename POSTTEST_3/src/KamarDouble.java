public class KamarDouble extends KamarKost {
    private String namaPenyewa2;

    public KamarDouble(String nomorKamar, String namaPenyewa,
        String namaPenyewa2, int hargaPerBulan, boolean tersedia) {
        super(nomorKamar, namaPenyewa, hargaPerBulan, tersedia);
        this.namaPenyewa2 = (namaPenyewa2 == null || namaPenyewa2.trim().isEmpty())
                            ? "-" : namaPenyewa2.trim();
    }

    public String getNamaPenyewa2() { return namaPenyewa2; }

    @Override
    protected void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Tipe Kamar    : Double (2 Penyewa)");
        System.out.println("Penyewa 2     : " + getNamaPenyewa2());
    }
}
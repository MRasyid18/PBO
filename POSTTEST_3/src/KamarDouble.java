public class KamarDouble extends KamarKost {
    private String namaPenyewa2;

    public KamarDouble(String nomorKamar, String namaPenyewa,
                        String namaPenyewa2, int hargaPerBulan, boolean tersedia) {
        super(nomorKamar, namaPenyewa, hargaPerBulan, tersedia);
        setNamaPenyewa2(namaPenyewa2);
    }

    public String getNamaPenyewa2() {
        return namaPenyewa2;
    }

    public void setNamaPenyewa2(String namaPenyewa2) {
        if (namaPenyewa2 == null || namaPenyewa2.trim().isEmpty()) {
            this.namaPenyewa2 = "-";
        } else {
            this.namaPenyewa2 = namaPenyewa2.trim();
        }
    }

    public void tampilkanTipeKamar() {
        System.out.println("Tipe Kamar    : Double (2 Penyewa)");
        System.out.println("Penyewa 2     : " + getNamaPenyewa2());
    }
}

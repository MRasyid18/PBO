public class KamarSingle extends KamarKost {

    public KamarSingle(String nomorKamar, String namaPenyewa,
                        int hargaPerBulan, boolean tersedia) {
        super(nomorKamar, namaPenyewa, hargaPerBulan, tersedia);
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Tipe Kamar    : Single (1 Penyewa)");
    }
}
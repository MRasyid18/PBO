public class KamarSingle extends KamarKost {

    public KamarSingle(String nomorKamar, String namaPenyewa,int hargaPerBulan, boolean tersedia){super(nomorKamar, namaPenyewa, hargaPerBulan, tersedia);
    }
    @Override
    protected void tampilkanInfo() {
        super.tampilkanInfo(); // panggil info dasar dari superclass
        System.out.println("Tipe Kamar    : Single (1 Penyewa)");
    }
}
public class KamarDouble extends KamarKost implements IBisaDiSewa {
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

    @Override
    public String getTipeKamar() {
        return "Double";
    }

    @Override
    public int getKapasitasPenyewa() {
        return 2;
    }

    @Override
    public void tampilkanInfo() {
        tampilkanInfoDasar();
        System.out.println("Penyewa 2     : " + getNamaPenyewa2());
    }

    @Override
    public boolean cekKetersediaan() {
        return isTersedia() && getNamaPenyewa2().equals("-");
    }

    @Override
    public String getInfoHargaSewa() {
        return getTipeKamar() + " | Kapasitas: " + getKapasitasPenyewa()
        + " orang | Harga: " + formatHarga(getHargaPerBulan()) + "/bulan";
    }
}

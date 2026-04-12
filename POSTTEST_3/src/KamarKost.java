public class KamarKost {
    protected String nomorKamar;
    protected String namaPenyewa;
    protected int hargaPerBulan;
    protected boolean tersedia;

    public KamarKost(String nomorKamar, String namaPenyewa, int hargaPerBulan, boolean tersedia) {
        this.nomorKamar = nomorKamar;
        this.namaPenyewa = namaPenyewa;
        this.hargaPerBulan = hargaPerBulan;
        this.tersedia = tersedia;
    }

    public String getNomorKamar() { return nomorKamar; }
    public void setNomorKamar(String nomorKamar) { this.nomorKamar = nomorKamar; }

    public String getNamaPenyewa() { return namaPenyewa; }
    public void setNamaPenyewa(String namaPenyewa) { this.namaPenyewa = namaPenyewa; }

    public int getHargaPerBulan() { return hargaPerBulan; }
    public void setHargaPerBulan(int hargaPerBulan) { this.hargaPerBulan = hargaPerBulan; }

    public boolean isTersedia() { return tersedia; }
    public void setTersedia(boolean tersedia) { this.tersedia = tersedia; }

    protected void tampilkanInfoDasar() {
        String status = this.tersedia ? "Tersedia (Kosong)" : "Disewa";
        System.out.println("Nomor Kamar   : " + this.nomorKamar);
        System.out.println("Nama Penyewa  : " + this.namaPenyewa);
        System.out.println("Harga/Bulan   : Rp " + this.hargaPerBulan);
        System.out.println("Status        : " + status);
    }
}
import java.util.Scanner;

public class RekapNilai{
    /*merekap atau memproses input nilai-nilai siswa/mahasiswa yang dimasukkan oleh pengguna secara berulang sampai pengguna mengetikkan angka -1*/
    private static final int SELESAI = -1;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double total = 0;                                                                                    /*penjumlahan seluruh nilai*/
        int jumlahSah = 0;                                                                                    /*penghitung (counter) jumlah data nilai valid*/
        int nomorNilai = 1;                                                                                /*menandai urutan nomor data*/
        int nilai;                                                                                      /*tempat penyimpanan sementara*/

        System.out.println("-----Rekap Nilai Kelas-----");
        System.out.println("Ketik " + SELESAI + " kalau sudah selesai");

        do {
            System.out.print("Nilai ke-" + nomorNilai + " : ");
            nilai = scanner.nextInt();

            if (nilai == SELESAI) {
                break;
            }

            if (nilai < 0 || nilai > 100){
                System.out.println("ditolak - nilai harus 0..100");
                continue;
            }

            char grade;
            if (nilai >= 90){
                grade = 'A';
            } else if (nilai >= 80){
                grade = 'B';
            } else if (nilai >= 70){
                grade = 'C';
            } else if (nilai >= 60){
                grade = 'D';
            } else {
                grade = 'E';
            }

            String keterangan = switch (grade) {
                case 'A' -> "Sangat Baik";
                case 'B' -> "Baik";
                case 'C' -> "Cukup";
                case 'D' -> "Kurang";
                default -> "Tidak Lulus";

            };
            System.out.println("  Grade " + grade + " - " + keterangan);                                         /*Mencetak teks berisi informasi Grade (misal: A, B, C) dan keterangan (misal: Sangat Baik, Cukup) yang didapat dari nilai input sebelumnya ke layar, lalu berpindah ke baris baru.*/
            total += nilai;                                                                                      /*Menambahkan variabel nilai yang baru saja diinput ke dalam variabel total (total = total + nilai). Baris ini digunakan untuk menghitung akumulasi seluruh nilai.*/
            jumlahSah++;                                                                                         /*Menambahkan penambah/counter jumlahSah sebanyak 1 (jumlahSah = jumlahSah + 1). Variabel ini menghitung berapa banyak data nilai valid yang telah dimasukkan.*/
            nomorNilai++;                                                                                        /*Menambahkan penambah nomorNilai sebanyak 1 untuk menandai urutan input nilai berikutnya (misal: Nilai ke-1, Nilai ke-2, dst.).*/
        } while (nilai != SELESAI);                                                                              /*Penutup dari perulangan do-while. Program akan memeriksa apakah nilai yang diinput tidak sama dengan nilai konstanta SELESAI (misal: -1 atau 999). Jika kondisinya benar, perulangan akan berlanjut; jika nilai == SELESAI, perulangan berhenti.*/

        System.out.println();
        System.out.println("Nilai sah : " + jumlahSah);                                                          /*Mencetak jumlah total data nilai valid yang berhasil diproses ke layar.*/

        scanner.close();
    }
}

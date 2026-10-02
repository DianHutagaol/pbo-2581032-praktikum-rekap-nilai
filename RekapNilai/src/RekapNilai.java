import java.util.Scanner;

public class RekapNilai{
    /*merekap atau memproses input nilai-nilai siswa/mahasiswa yang dimasukkan oleh pengguna secara berulang sampai pengguna mengetikkan angka -1*/
    private static final int SELESAI = -1;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double total = 0;
        int jumlahSah = 0;
        int nomorNilai = 1;
        int nilai;

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
            System.out.println("  Grade " + grade + " - " + keterangan);
            total += nilai;
            jumlahSah++;
            nomorNilai++;
        } while (nilai != SELESAI);

            System.out.println();
        System.out.println("Nilai sah : " + jumlahSah);

        if (jumlahSah > 0) {
            double rata = total / jumlahSah;
            System.out.println("Rata-rata : " + String.format("%.2f.", rata));

            String status = rata >= 60 ? "LULUS" : "TIDAK LULUS";
            System.out.println("Status : " + status);


        }
        scanner.close();
    }
}

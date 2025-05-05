package Lab5_Bai2;
import java.util.Scanner;
interface Hinh {
    float pi = 3.14f;
    void nhap();
    void xuat();
    float dienTich();
}
class HinhVuong implements Hinh {
    private float canh;
    public HinhVuong() {
        this.canh = 0;
    }
    public HinhVuong(float canh) {
        this.canh = canh;
    }
    @Override
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap canh hinh vuong: ");
        this.canh = scanner.nextFloat();
    }
    @Override
    public void xuat() {
        System.out.println("Hinh vuong: canh = " + canh + ", dien tich = " + dienTich());
    }
    @Override
    public float dienTich() {
        return canh * canh;
    }
}
class HinhChuNhat implements Hinh {
    private float dai;
    private float rong;

    public HinhChuNhat() {
        this.dai = 0;
        this.rong = 0;
    }
    public HinhChuNhat(float dai, float rong) {
        this.dai = dai;
        this.rong = rong;
    }
    @Override
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chieu dai: ");
        this.dai = scanner.nextFloat();
        System.out.print("Nhap chieu rong: ");
        this.rong = scanner.nextFloat();
    }
    @Override
    public void xuat() {
        System.out.println("Hinh chu nhat: dai = " + dai + ", rong = " + rong + ", dien tich = " + dienTich());
    }
    @Override
    public float dienTich() {
        return dai * rong;
    }
}
class HinhTron implements Hinh {
    private float banKinh;
    public HinhTron() {
        this.banKinh = 0;
    }
    public HinhTron(float banKinh) {
        this.banKinh = banKinh;
    }
    @Override
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ban kinh hinh tron: ");
        this.banKinh = scanner.nextFloat();
    }
    @Override
    public void xuat() {
        System.out.println("Hinh tron: ban kinh = " + banKinh + ", dien tich = " + dienTich());
    }
    @Override
    public float dienTich() {
        return pi * banKinh * banKinh;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong hinh: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Hinh[] ds = new Hinh[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nChon loai hinh se nhap (1=Vuong,2=ChuNhat,3=Tron):");
            int chon = scanner.nextInt();
            scanner.nextLine();
            switch (chon) {
                case 1:
                    ds[i] = new HinhVuong();
                    break;
                case 2:
                    ds[i] = new HinhChuNhat();
                    break;
                case 3:
                    ds[i] = new HinhTron();
                    break;
                default:
                    System.out.println("Lua chon khong hop le, mac dinh la hinh vuong.");
                    ds[i] = new HinhVuong();
            }
            ds[i].nhap();
        }
        System.out.println("\n--- Danh sach hinh va dien tich ---");
        for (Hinh h : ds) {
            h.xuat();
        }
        Hinh max = ds[0];
        for (Hinh h : ds) {
            if (h.dienTich() > max.dienTich()) {
                max = h;
            }
        }
        System.out.println("\nHinh co dien tich lon nhat:");
        max.xuat();
    }
}


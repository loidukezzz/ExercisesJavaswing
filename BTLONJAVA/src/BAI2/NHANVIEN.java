package BAI2;
import java.util.Scanner;

abstract class NHANVIEN {
	String manv;
	String hoten;
	float hesl;
	float luongcb;
	abstract float Tinhthue();
	abstract float Tinhluong();
	public NHANVIEN() {}
	public NHANVIEN(String mnv, String ht, float hsl, float lcb) {
		setManv(mnv);
		setHoten(ht);
		setHesi(hsl);
		setLuongcb(lcb);
	}
	void Nhap() {
		Scanner cin  = new Scanner(System.in);
		System.out.println("Nhập vào mã nhân viên: ");
		manv = cin.nextLine();
		System.out.println("Nhập vào tên nhân viên: ");
		hoten = cin.nextLine();
		System.out.println("Nhập vào hệ số lương: ");
		hesl = cin.nextFloat();
		System.out.println("Nhap vao lương cơ bản: ");
		luongcb = cin.nextFloat();
	}
	void Xuat() {
		System.out.println("Mã nhân viên: " + getManv());
		System.out.println("Tên nhân viên: " + getHoten());
		System.out.println("Hệ số luong: " + getHesl());
		System.out.println("Lương cơ bản: " + getLuongcb());
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public float getHesl() {
		return hesl;
	}
	public void setHesi(float hesl) {
		this.hesl = hesl;
	}
	public float getLuongcb() {
		return luongcb;
	}
	public void setLuongcb(float luongcb) {
		this.luongcb = luongcb;
	}
	
}

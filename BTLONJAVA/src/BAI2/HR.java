package BAI2;
import java.util.Scanner;

public class HR extends NHANVIEN {
	float overtime;

	HR(){}
	HR(String mnv, String ht, float hsl, float lcb, float ot){
		super(mnv,ht,hsl,lcb);
		setOvertime(ot);
	}
	public float getOvertime() {
		return overtime;
	}
	void Nhap() {
		Scanner cin  = new Scanner(System.in);
		super.Nhap();
		System.out.println("Nhập vào tiền làm ngoài giờ: ");
		overtime = cin.nextFloat();
	}
	void Xuat() {
		super.Xuat();
		System.out.println("Tiền làm ngoài giờ: " + getOvertime());
	}
	public void setOvertime(float overtime) {
		this.overtime = overtime;
	}
	@Override
	float Tinhthue() {
		// TODO Auto-generated method stub
		float thue;
		thue = (float) ((getLuongcb() * getHesl() + getOvertime())*0.11);
		return thue;
	}
	@Override
	float Tinhluong() {
		float luong;
		luong = (float) ((getLuongcb() * getHesl() + getOvertime())) - Tinhthue();
		return luong;
	}	
}

package BAI2;
import java.util.Scanner;

public class MARKETING extends NHANVIEN{
	float sanluong;
	MARKETING(){}
	MARKETING(String mnv, String ht, float hsl, float lcb, float sl){
		super(mnv,ht,hsl,lcb);
		setSanluong(sl);
	}
	void Nhap() {
		Scanner cin  = new Scanner(System.in);
		super.Nhap();
		System.out.println("Nhập vào sản lượng: ");
		sanluong = cin.nextFloat();
	}
	void Xuat() {
		super.Xuat();
		System.out.println("Tiền làm ngoài giờ: " + getSanluong());
	}
	public float getSanluong() {
		return sanluong;
	}

	public void setSanluong(float sanluong) {
		this.sanluong = sanluong;
	}

	@Override
	float Tinhthue() {
		// TODO Auto-generated method stub
		float thue;
		thue = (float) ((getLuongcb() * getHesl() + getSanluong())*0.03);
		return thue;
	}
	@Override
	float Tinhluong() {
		// TODO Auto-generated method stub\
		float luong;
		luong = (float) ((getLuongcb() * getHesl() + getSanluong())) - Tinhthue();
		return luong;
	}	
}

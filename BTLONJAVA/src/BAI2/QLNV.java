package BAI2;
import java.util.ArrayList;
import java.util.Scanner;

public class QLNV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<NHANVIEN> nv = new ArrayList();
		int loai;
		Scanner cin = new Scanner(System.in);		
		while(true) {		
			System.out.println("\n0.Thoat. \n1.Nhap 1 NHÂN VIÊN HR. \n2.Nhap 1 NHÂN VIÊN MARKETING. \n3.HIỂN THỊ DANH SÁCH NHÂN VIÊN. \n4.TỔNG LƯƠNG CÔNG TY.");
			loai = cin.nextInt();
			if(loai == 0)
				break;			
			else if(loai ==1) {
				System.out.println("NHẬP VÀO NHÂN VIÊN HR:");
				HR hr = new HR();
				hr.Nhap();
				nv.add(hr);
			}
			else if(loai ==2) {
				System.out.println("NHẬP VÀO NHÂN VIÊN MARKETING:");
				MARKETING mkt = new MARKETING();
				mkt.Nhap();
				nv.add(mkt);
			}
			else 
				if(loai == 3) {
					System.out.println("\nXUẤT TẤT CẢ DANH SÁCH NHÂN VIÊN");
					float tongluong = 0;
					for(NHANVIEN x : nv) {
						x.Xuat();
					}
			}
			else 
				if(loai == 4) {
					System.out.println("\nTỔNG LƯƠNG CỦA CÔNG TY");
					float tongluong = 0;
					for(NHANVIEN x : nv) {
						tongluong += x.Tinhluong();
					}
					System.out.println("TỔNG LƯƠNG CÔNG TY:" + tongluong);
			}
		}
	}
}

package BAI3;

import java.util.Date;

public class NHANVIENOBJECT {
	String Manv;
	String Tennv;
	String Ngaysinh;
	NHANVIENOBJECT(){}
	NHANVIENOBJECT(String m,String t, String ns){
		setManv(m);
		setTennv(t);
		setNgaysinh(ns);
	}
	public String getManv() {
		return Manv;
	}
	public void setManv(String manv) {
		Manv = manv;
	}
	public String getTennv() {
		return Tennv;
	}
	public void setTennv(String tennv) {
		Tennv = tennv;
	}
	public String getNgaysinh() {
		return Ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		Ngaysinh = ngaysinh;
	}
		
}

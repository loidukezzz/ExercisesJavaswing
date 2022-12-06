package BAI3;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NHANVIEN {
	Connect cn = new Connect();
	ResultSet Shownhanvien() throws SQLException {
		cn.connectSQL();
		String sql = "select * from NHANVIEN";
		return cn.LoadData(sql);
	}
	ResultSet Shownvpma(String ma) throws SQLException {
		cn.connectSQL();
		String sql = "select * from NHANVIEN where MANV =N'"+ ma +"'";
		return cn.LoadData(sql);
	}
	public void Themdl(NHANVIENOBJECT nvo) throws SQLException
	{
		String sql = "Insert Into NHANVIEN Values(N'"+nvo.getManv() + "', N'"+nvo.getTennv()+"','"+nvo.getNgaysinh() + "')";
		cn.UpdateData(sql);
	}
	public void Xoa(String ma) throws SQLException
	{
		String sql = "Delete NHANVIEN where MANV =N'"+ ma +"'";
		cn.UpdateData(sql);
	}
	public void Sua(NHANVIENOBJECT nvo) throws SQLException {
		String sql="Update  NHANVIEN set TENNV=N'"+ nvo.getTennv() +"',NAMSINH=N'"+ nvo.getNgaysinh() +"'WHERE MANV =N'"+ nvo.getManv() +"'";
		cn.UpdateData(sql);
	}
}

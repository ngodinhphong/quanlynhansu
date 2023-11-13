package quanlynhansu;

import java.util.ArrayList;

public class TruongPhong extends ThongTinNhanSu {
	
	private int soLuongNVQL = 0;
	private ArrayList<NhanVien>danhSachNhanVienDuoiQuyen;
	
	public int getSoLuongNVQL() {
		return soLuongNVQL;
	}
	public void setSoLuongNVQL(int soLuongNVQL) {
		this.soLuongNVQL = soLuongNVQL;
	}
	public ArrayList<NhanVien> getDanhSachNhanVienDuoiQuyen() {
		return danhSachNhanVienDuoiQuyen;
	}
	public void setDanhSachNhanVienDuoiQuyen(ArrayList<NhanVien> danhSachNhanVienDuoiQuyen) {
		this.danhSachNhanVienDuoiQuyen = danhSachNhanVienDuoiQuyen;
	}
	
	public TruongPhong() {
        super();
        danhSachNhanVienDuoiQuyen = new ArrayList<>();
        setLuong1ngay(200);
        setChucVu("Trưởng Phòng");
    }
	
	@Override
	public double tinhLuong() {
        return luong1Ngay * soNgayLamViec + 100 * danhSachNhanVienDuoiQuyen.size();
    }
	
	@Override
	public void XuatThongTinNhanVien() {
        System.out.printf("%-10s | %-20s | %-10s | %-10d | %-10.2f\n", maSo, hoTen, soDienThoai, soNgayLamViec, luong1Ngay);
    }
	public void tiepNhanNhanVien(NhanVien nv) {
		danhSachNhanVienDuoiQuyen.add(nv);
		setSoLuongNVQL(getDanhSachNhanVienDuoiQuyen().size());
		
	}
	
	public void xoaNhanVien(NhanVien nv) {
		danhSachNhanVienDuoiQuyen.remove(nv);
		setSoLuongNVQL(getDanhSachNhanVienDuoiQuyen().size());
		
	}
}

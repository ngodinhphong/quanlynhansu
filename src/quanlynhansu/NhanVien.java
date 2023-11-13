package quanlynhansu;

public class NhanVien extends ThongTinNhanSu {
	private String maTruongPhong;

	public String getMaTruongPhong() {
		return maTruongPhong;
	}

	public void setMaTruongPhong(String maTruongPhong) {
		this.maTruongPhong = maTruongPhong;
	}

	public NhanVien() {
		setLuong1ngay(100);
		setChucVu("Nhân Viên");
	}
	
	@Override
	public void XuatThongTinNhanVien() {
        System.out.printf("%-10s | %-20s | %-10s | %-10d | %-10.2f\n", maSo, hoTen, soDienThoai, soNgayLamViec, luong1Ngay);
    }
	
	
	
	@Override
	public void themNhanSu() {
		super.themNhanSu();
		tinhLuong();
	}
	@Override
	public double tinhLuong() {
		return luong1Ngay * soNgayLamViec;

	}

	
}

package quanlynhansu;

public class GiamDoc extends ThongTinNhanSu {
	private float soCoPhan;

	public float getSoCoPhan() {
		return soCoPhan;
	}

	public void setSoCoPhan(float soCoPhan) {
		this.soCoPhan = soCoPhan;
	}
	
	
	public GiamDoc() {
		setLuong1ngay(300);
		setChucVu("Giám Đốc");
	}
	
	@Override
	public void XuatThongTinNhanVien() {
        System.out.printf("%-10s | %-20s | %-10s | %-10d | %-10.2f\n", maSo, hoTen, soDienThoai, soNgayLamViec, luong1Ngay);
    }

	@Override
	public void themNhanSu() {
		super.themNhanSu();
		nhapSoCoPhan();
		tinhLuong();
	}

	private void nhapSoCoPhan() {
		while (true) {
			System.out.println("Vui lòng nhập số cổ phần(%): ");
			float soCoPhan = scan.nextFloat();
			if(soCoPhan >= 0 && soCoPhan <= 100) {
				setSoCoPhan(soCoPhan);
				break;
			}else {
				System.out.println("số cổ phần nhập không hợp lệ. Vui lòng nhập lại");
			}
		}
		
	}
	@Override
	public double tinhLuong() {
		return luong1Ngay * soNgayLamViec;

	}
	
}

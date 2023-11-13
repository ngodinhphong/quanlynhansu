package quanlynhansu;

public class KiemTraDieuKien {
	public boolean kiemTraChuoiRong(String chuoi) {
		if (chuoi == null || chuoi.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

	public boolean kiemTraSoRong(double so) {
		if (so == 0 ) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean kiemTraSoDuong(double so) {
		if (so <0 ) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean kiemTraChieuDai(String chuoiNhap, int chieuDai) {
		if(chuoiNhap.length() == chieuDai) {
			return true;
		}
			
        else {
            System.out.println("Chuỗi nhập vào phải có chiều dài là " + chieuDai + ", vui lòng nhập lại:");
            return false;
        }
	}
	
}

package quanlynhansu;

import java.util.ArrayList;
import java.util.Scanner;

public class ThongTinNhanSu {

	protected String maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected int soNgayLamViec;
	protected double luong1Ngay;
	protected String chucVu;
	
	protected Scanner scan = new Scanner(System.in);
	protected KiemTraDieuKien kiemTra = new KiemTraDieuKien();


	public ThongTinNhanSu() {
	}

	public ThongTinNhanSu(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, double lương1Ngay) {
		this.maSo = maSo;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.soNgayLamViec = soNgayLamViec;
		this.luong1Ngay = lương1Ngay;

	}

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(int soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}

	public double getLuong1ngay() {
		return luong1Ngay;
	}

	public void setLuong1ngay(double luong1ngay) {
		this.luong1Ngay = luong1ngay;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public void XuatThongTinNhanVien() {
		System.out.printf("%-10s | %-20s | %-10s | %-10d | %-10.2f\n", maSo, hoTen, soDienThoai, soNgayLamViec,
				luong1Ngay);
	}

	public void themNhanSu() {
		nhapMaSo();
		nhapHoTen();
		nhapSDT();
		nhapSoNgaylamViec();

	}

	private void nhapMaSo() {
		System.out.println("Vui lòng nhập mã số nhân viên (mã số bao gồn 8 ký tự. Ví dụ: nv000001): ");
        String maSo = scan.nextLine();
        while(true) {
            if(kiemTra.kiemTraChieuDai(maSo, 8)) {
            	setMaSo(maSo);
            	break;
            }else {
            	maSo = scan.nextLine();
            }
        }
	}

	private void nhapHoTen() {
		System.out.println("Vui lòng nhập họ tên: ");
        String hoTen = scan.nextLine();
        while(true) {
            if(kiemTra.kiemTraChuoiRong(hoTen)) {
            	System.out.println("Họ Tên không được để trống, vui lòng nhập lại");
            	hoTen = scan.nextLine();
            } else {
            	setHoTen(hoTen);
            	break;
            }
        }
	}

	private void nhapSDT() {
		System.out.println("Vui lòng nhập số điện thoại: ");
        String soDienThoai = scan.nextLine();
        
        while(true) {
            if(kiemTra.kiemTraChieuDai(soDienThoai, 10) ) {
            	setSoDienThoai(soDienThoai);
            	break;
            }else {
            	soDienThoai = scan.nextLine();
            }
        }
	}

	private void nhapSoNgaylamViec() {
		while (true) {
			System.out.println("Vui lòng nhập số ngày làm việc của tháng 10 năm 2023: ");
			int soNgayLamViec = scan.nextInt();
			if (soNgayLamViec > 0 && soNgayLamViec < 31) {
				setSoNgayLamViec(soNgayLamViec);
				break;
			} else {
				System.out.println("Số ngày làm việc nhập không hợp lệ. Vui lòng nhập lại");
			}
		}

	}

	public double tinhLuong() {
		return luong1Ngay * soNgayLamViec;

	}

	public String layTenNhanVien() {
		String[] ten = getHoTen().split(" ");
		return ten[ten.length - 1];
	}

}

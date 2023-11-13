package quanlynhansu;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		ThongTinCongTy thongTinCongTy = new ThongTinCongTy();
		thongTinCongTy.setDanhSachNhanVien(duLieuNhanSu());
		
		int luaChon;
		Scanner scan = new Scanner(System.in);
		
		do {
			
			listMenu();
			luaChon = scan.nextInt();
			 
			switch (luaChon) {
			case 1:
				// 1. nhập thông tin công ty
				thongTinCongTy.nhapThongTinCongTy();
				thongTinCongTy.xuatThongTinCongTy();
				break;
				
			case 2:
				//2. phân bổ nhân viên vào trưởng phòng
				thongTinCongTy.phanBoNhanVienVaoTruongPhong();
				
				break;
				
			case 3:
				// 3. Thêm Nhân sự
				thongTinCongTy.themNhanSu();
				break;
				
			case 4:
				// 4. Xóa thông tin một nhân sự
				thongTinCongTy.XuatThongTinToanNhanVien();
				thongTinCongTy.xoaMotNhanSu();
				break;
				
			case 5:
				// 5. Xuất thôngtin toàn bộ nhân viên.
				System.out.println("Danh sách toàn bộ nhân viên trong công ty");
				thongTinCongTy.XuatThongTinToanNhanVien();
				
				break;
				
			case 6:
				// 6. Tính và xuất tổng lương cho toàn công ty
				thongTinCongTy.tinhTongLuong();
				
				break;
				
			case 7:
				//7. Tìm Nhân viên thường có lương cao nhất
				thongTinCongTy.timNhanVienCoLuongCaoNhat();
				
				break;
				
			case 8:
				// 8. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất
				thongTinCongTy.timTruongPhongCoSoLuongNVDQNhieuNhat();
				break;
				
			case 9:
				// 9. Sắp xếp nhân viên toàn công ty theo thứ tự abc
				System.out.println("Danh sách toàn bộ nhân viên trong công ty được sắp xếp theo thứ tự abc");
				thongTinCongTy.sapXepTheoABC();
				break;
				
			case 10:
				// 10. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần
				System.out.println("Danh sách toàn bộ nhân viên trong công ty theo thứ tự lương giảm dần");
				thongTinCongTy.sapXepLuongGiamDan();
				
				break;
				
			case 11:
				
				// 11.Tìm Giám Đốc có số lượng cổ phần nhiều nhất
				thongTinCongTy.timGiamDocCoSoCoPhanNhieuNhat();
				
				break;
				
			case 12:
				
				// 12.Tính và Xuất tổng thu nhập của từng Giám Đốc
				thongTinCongTy.thuNhanCuaGiamDoc();
				
				break;
				
			case 0:
				System.exit(0);
				break;

			default:
				System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
				break;
			}
			
		} while (true);
		
	}
	
	private static ArrayList<ThongTinNhanSu> duLieuNhanSu() {
		ArrayList<ThongTinNhanSu>duLieu = new ArrayList<ThongTinNhanSu>();
		ThongTinNhanSu ns1 = new NhanVien();
		ns1.setMaSo("nv000001");
        ns1.setHoTen("Hồ Việt Hùng");
        ns1.setSoDienThoai("0325478165");
        ns1.setSoNgayLamViec(24);
        duLieu.add(ns1);
        
        ThongTinNhanSu ns2 = new NhanVien();
		ns2.setMaSo("nv000002");
        ns2.setHoTen("Phạm Gia Kiêm");
        ns2.setSoDienThoai("0325465824");
        ns2.setSoNgayLamViec(26);
        duLieu.add(ns2);
        
        ThongTinNhanSu ns3 = new NhanVien();
		ns3.setMaSo("nv000003");
        ns3.setHoTen("Hà Trung Tín");
        ns3.setSoDienThoai("0967534246");
        ns3.setSoNgayLamViec(24);
        duLieu.add(ns3);
        
        ThongTinNhanSu ns4 = new TruongPhong();
		ns4.setMaSo("nv000004");
        ns4.setHoTen("Nguyễn Thế Trọng");
        ns4.setSoDienThoai("0989175424");
        ns4.setSoNgayLamViec(25);
        duLieu.add(ns4);
        
        ThongTinNhanSu ns5 = new TruongPhong();
		ns5.setMaSo("nv000005");
        ns5.setHoTen("Hà Kiều Xuân");
        ns5.setSoDienThoai("0989175424");
        ns5.setSoNgayLamViec(26);
        duLieu.add(ns5);
        
        ThongTinNhanSu ns6 = new TruongPhong();
		ns6.setMaSo("nv000006");
        ns6.setHoTen("Phạm Trung Khoa");
        ns6.setSoDienThoai("0367872145");
        ns6.setSoNgayLamViec(25);
        duLieu.add(ns6);
        
        ThongTinNhanSu ns7 = new GiamDoc();
		ns7.setMaSo("nv000007");
        ns7.setHoTen("Võ Nam Phương");
        ns7.setSoDienThoai("0986457289");
        ns7.setSoNgayLamViec(26);
        ((GiamDoc)ns7).setSoCoPhan(15);
        duLieu.add(ns7);
		
		return duLieu;
	}

	
	private static void listMenu() {
		System.out.println("\n----MENU----");
		System.out.println("1. Nhập thông tin công ty");
		System.out.println("2. Phân bổ nhân viên vào Trưởng phòng");
		System.out.println("3. Thêm thông tin một nhân sự");
		System.out.println("4. Xóa thông tin một nhân sự");
		System.out.println("5. Xuất ra thông tin toàn bộ người trong công ty");
		System.out.println("6. Tính và xuất tổng lương cho toàn công ty");
		System.out.println("7. Tìm Nhân viên thường có lương cao nhất");
		System.out.println("8. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất");
		System.out.println("9. Sắp xếp nhân viên toàn công ty theo thứ tự abc");
		System.out.println("10. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần");
		System.out.println("11.Tìm Giám Đốc có số lượng cổ phần nhiều nhất");
		System.out.println("12.Tính và Xuất tổng thu nhập của từng Giám Đốc");
		System.out.println("0. Thoát chương trình");
		System.out.print("Chọn chức năng (0-12): ");
	}
	
	

}

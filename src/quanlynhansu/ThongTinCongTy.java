package quanlynhansu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ThongTinCongTy {
	private String tenCongTy;
	private String maSoThue;
	private double doanhThuThang;
	private ArrayList<ThongTinNhanSu> danhSachNhanVien;

	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public double getDoanhThuThang() {
		return doanhThuThang;
	}

	public void setDoanhThuThang(double doanhThuThang) {
		this.doanhThuThang = doanhThuThang;
	}

	public ArrayList<ThongTinNhanSu> getDanhSachNhanVien() {
		return danhSachNhanVien;
	}

	public void setDanhSachNhanVien(ArrayList<ThongTinNhanSu> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}

	private Scanner scan = new Scanner(System.in);
	private KiemTraDieuKien kt = new KiemTraDieuKien();

	// 1. nhập thông tin công ty
	public void nhapThongTinCongTy() {
		nhapTenCongTy();
		nhapMaSoThue();
		nhapDoanhThuThang();
	}

	private void nhapTenCongTy() {
		System.out.println("Nhập thông tin công ty:");
		if (kt.kiemTraChuoiRong(tenCongTy)) {
			while (true) {
				System.out.println("Vui lòng nhập tên công ty: ");
				tenCongTy = scan.next();
				if (kt.kiemTraChuoiRong(tenCongTy)) {
					System.out.println("Tên công ty không được để rỗng");

				} else {
					break;
				}
			}
		} else {
			int chon;
			while (true) {
				System.out.println("bạn có muốn nhập lại tên Công ty không?");
				System.out.println("1. Có\n0. Không");
				chon = scan.nextInt();
				if (chon == 1) {
					while (true) {
						System.out.println("Vui lòng nhập tên công ty: ");
						tenCongTy = scan.next();
						if (kt.kiemTraChuoiRong(tenCongTy)) {
							System.out.println("Tên công ty không được để rỗng");
						} else {
							break;
						}
					}
					break;
				} else if (chon == 0) {
					break;
				} else {
					System.out.println("Vui lòng nhập lựa chọn chính xác");
				}

			}
		}
	}

	private void nhapMaSoThue() {
		if (kt.kiemTraChuoiRong(maSoThue)) {
			while (true) {
				System.out.println("Vui lòng nhập mã số thuế: ");
				maSoThue = scan.next();
				if (kt.kiemTraChieuDai(maSoThue, 10)) {
					break;
				} else {
					System.out.println("Mã số thuế phải có 10 ký tự, Vui lòng nhập lại");

				}
			}
		} else {
			int chon;
			while (true) {
				System.out.println("bạn có muốn nhập lại mã số thuế?");
				System.out.println("1. Có\n0. Không");
				chon = scan.nextInt();
				if (chon == 1) {
					while (true) {
						System.out.println("Vui lòng nhập mã số thuế: ");
						maSoThue = scan.next();
						if (kt.kiemTraChieuDai(maSoThue, 10)) {
							break;
						} else {
							System.out.println("Mã số thuế phải có 10 ký tự, Vui lòng nhập lại");

						}
					}
					break;
				} else if (chon == 0) {
					break;
				} else {
					System.out.println("Vui lòng nhập lựa chọn chính xác");
				}

			}
		}
	}

	private void nhapDoanhThuThang() {
		if (kt.kiemTraSoRong(doanhThuThang)) {
			while (true) {
				System.out.println("Vui lòng nhập doanh thu tháng ");
				doanhThuThang = scan.nextDouble();
				if (kt.kiemTraSoDuong(doanhThuThang)) {
					System.out.println("Doanh thu phải lớn hơn 0. Vui lòng nhập lại: ");
				} else {
					break;
				}
			}
		} else {
			int chon;
			while (true) {
				System.out.println("bạn có muốn nhập lại doanh thu tháng không?");
				System.out.println("1. Có\n0. Không");
				chon = scan.nextInt();
				if (chon == 1) {
					while (true) {
						System.out.println("Vui lòng nhập doanh thu tháng ");
						doanhThuThang = scan.nextDouble();
						if (kt.kiemTraSoDuong(doanhThuThang)) {
							System.out.println("Doanh thu phải lớn hơn 0. Vui lòng nhập lại: ");
						} else {
							break;
						}
					}
					break;
				} else if (chon == 0) {
					break;
				} else {
					System.out.println("Vui lòng nhập lựa chọn chính xác");
				}

			}
		}
	}

	public void xuatThongTinCongTy() {
		System.out.println("Thông tin công ty vừa nhập:");
		System.out.printf("%-20s | %-20s | %-20s\n", "Ten cong ty", "Ma so thue", "Doanh thu thang");
		System.out.printf("%-20s | %-20s | %-20.2f", tenCongTy, maSoThue, doanhThuThang);
	}

	// 2. phân bổ nhân viên vào trưởng phòng
	public void phanBoNhanVienVaoTruongPhong() {
		while (true) {
			danhSachNhanVien();
			System.out.println("Nhập mã nhân viên bạn muốn phân bổ: ");
			String maNV = scan.next();
			NhanVien nvTimDuoc = (NhanVien) timNVTheoMa(maNV);
			if (nvTimDuoc == null) {
				System.out.println("Mã nhân viên bạn  nhập không đúng, vui lòng nhập lại mã nhân viên");

			} else {
				if (kiemTraNhanVienCoMaTP(maNV)) {
					int luaChon;
					while (true) {
						System.out.println(
								"Nhân viên đã có mã trưởng phòng\nBạn có muốn đổi mã trưởng phòng cho nhân viên không?\n1. Có\n0. không");
						luaChon = scan.nextInt();
						if (luaChon == 1) {
							while (true) {
								danhSachTruongPhong();
								System.out.println("Nhập mã trưởng phòng tiếp nhận: ");
								String maTP = scan.next();
								TruongPhong tpTimDuoc = (TruongPhong) timTPTheoMa(maTP);
								if (tpTimDuoc == null) {
									System.out.println(
											"Trưởng Phòng bạn nhập không tồn tại, vui lòng nhập lại mã nhân viên");
								} else {
									TruongPhong tp = (TruongPhong) layTruongPhongDangquanLy(nvTimDuoc);
									tp.xoaNhanVien(nvTimDuoc);

									nvTimDuoc.setMaTruongPhong(maTP);
									tpTimDuoc.tiepNhanNhanVien(nvTimDuoc);

									break;
								}
							}
							break;

						} else if (luaChon == 0) {
							break;
						} else {
							System.out.println("Vui lòng nhập lựa chọn phù hợp");
						}
					}
				} else {
					while (true) {
						danhSachTruongPhong();
						System.out.println("Nhập mã trưởng phòng tiếp nhận: ");
						String maTP = scan.next();
						TruongPhong tpTimDuoc = (TruongPhong) timTPTheoMa(maTP);
						if (tpTimDuoc == null) {
							System.out.println("Trưởng Phòng bạn nhập không tồn tại, vui lòng nhập lại mã nhân viên");

						} else {

							nvTimDuoc.setMaTruongPhong(maTP);
							tpTimDuoc.tiepNhanNhanVien(nvTimDuoc);
							break;
						}
					}
				}
				break;
			}
		}

	}

	private void danhSachNhanVien() {
		System.out.println("Danh sách nhân viên");
		System.out.printf("%-10s | %-20s | %-10s | %-10s\n", "Mã số", "Họ tên", "SDT", "Mã TP");
		for (ThongTinNhanSu ns : danhSachNhanVien) {
			if (ns instanceof NhanVien) {
				System.out.printf("%-10s | %-20s | %-10s | %-10s\n", ns.getMaSo(), ns.getHoTen(), ns.getSoDienThoai(),
						((NhanVien) ns).getMaTruongPhong());
			}
		}

	}

	private void danhSachTruongPhong() {
		System.out.println("Danh sách trưởng phòng");
		System.out.printf("%-10s | %-20s | %-10s | %-10s\n", "Mã số", "Họ tên", "SDT", "Số NV quản lý");
		for (ThongTinNhanSu ns : danhSachNhanVien) {
			if (ns instanceof TruongPhong) {
				System.out.printf("%-10s | %-20s | %-10s | %-10s\n", ns.getMaSo(), ns.getHoTen(), ns.getSoDienThoai(),
						((TruongPhong) ns).getSoLuongNVQL());
			}
		}

	}

	private boolean kiemTraNhanVienCoMaTP(String mNV) {
		for (ThongTinNhanSu ns : danhSachNhanVien)
			if (ns.getMaSo().equals(mNV) && ((NhanVien) ns).getMaTruongPhong() == null)
				return false;
		return true;
	}

	private ThongTinNhanSu timNVTheoMa(String maNV) {
		for (ThongTinNhanSu ns : danhSachNhanVien)
			if (ns instanceof NhanVien && ns.getMaSo().equals(maNV))
				return ns;
		return null;
	}

	private ThongTinNhanSu timTPTheoMa(String maTP) {
		for (ThongTinNhanSu ns : danhSachNhanVien)
			if (ns instanceof TruongPhong && ns.getMaSo().equals(maTP))
				return ns;
		return null;
	}

	private ThongTinNhanSu layTruongPhongDangquanLy(NhanVien nvTimDuoc) {
		for (ThongTinNhanSu ns : danhSachNhanVien)
			if (ns instanceof TruongPhong && ns.getMaSo().equals(nvTimDuoc.getMaTruongPhong()))
				return ns;
		return null;
	}

	// 3. Thêm Nhân sự
	public void themNhanSu() {
		ThongTinNhanSu nhanVienThem;
		int chon;
		do {
			System.out.println("Nhân viên bạn muốn thêm là:\n1. Nhân viên\n2. Trưởng phòng\n3. Giam đốc");
			chon = scan.nextInt();
			switch (chon) {
			case 1:
				nhanVienThem = new NhanVien();
				((NhanVien) nhanVienThem).themNhanSu();
				if (kiemTraNhanVienTonTai(nhanVienThem)) {
					System.out.println("Nhân viên có mã " + nhanVienThem.getMaSo() + " đã tồn tại");
				} else {
					danhSachNhanVien.add(nhanVienThem);
					System.out.println("Nhân viên đã được thêm vào danh sách");
				}

				break;

			case 2:
				nhanVienThem = new TruongPhong();
				((TruongPhong) nhanVienThem).themNhanSu();
				if (kiemTraNhanVienTonTai(nhanVienThem)) {
					System.out.println("Nhân viên có mã " + nhanVienThem.getMaSo() + " đã tồn tại");
				} else {
					danhSachNhanVien.add(nhanVienThem);
					System.out.println("Nhân viên đã được thêm vào danh sách");
				}

				break;

			case 3:

				nhanVienThem = new GiamDoc();
				((GiamDoc) nhanVienThem).themNhanSu();
				if (kiemTraNhanVienTonTai(nhanVienThem)) {
					System.out.println("Nhân viên có mã " + nhanVienThem.getMaSo() + " đã tồn tại");
				} else {
					danhSachNhanVien.add(nhanVienThem);
					System.out.println("Nhân viên đã được thêm vào danh sách");
				}
				break;

			default:
				System.out.println("Vui lòng nhập lại lựa chọn loại nhân viên chính xác");
				break;
			}
		} while (chon == 1 && chon == 2);

	}

	public boolean kiemTraNhanVienTonTai(ThongTinNhanSu nhanVienThem) {
		for (ThongTinNhanSu ns : danhSachNhanVien)
			if (ns.getMaSo().equalsIgnoreCase(nhanVienThem.getMaSo()))
				return true;
		return false;
	}

	// 4. Xóa thông tin một nhân sự
	public void xoaMotNhanSu() {
		System.out.println("nhập mã số nhân sự bạn muốn xóa: ");
		String maNSXoa = scan.next();
		ThongTinNhanSu nhanSuCanXoa = timNSTheoMa(maNSXoa);
		if (nhanSuCanXoa == null) {
			System.out.println("Nhân sự bạn cần xóa với mã số " + maNSXoa + " không tồn tại");
		} else {
			if (nhanSuCanXoa instanceof TruongPhong) {
				xoaTruongPhong((TruongPhong) nhanSuCanXoa);
				System.out.println("Trưởng phòng với mã số " + maNSXoa + " đã được xóa");
			}
			if (nhanSuCanXoa instanceof NhanVien) {
				xoaNhanVien((NhanVien) nhanSuCanXoa);
				System.out.println("Nhân Viên với mã số " + maNSXoa + " đã được xóa");
			}
			if (nhanSuCanXoa instanceof GiamDoc) {
				danhSachNhanVien.remove(nhanSuCanXoa);
				System.out.println("Giám Đốc với mã số " + maNSXoa + " đã được xóa");
			}
		}
	}

	public ThongTinNhanSu timNSTheoMa(String maNSXoa) {
		for (ThongTinNhanSu ns : danhSachNhanVien)
			if (ns.getMaSo().equals(maNSXoa))
				return ns;
		return null;
	}

	public void xoaTruongPhong(TruongPhong truongPhong) {
		for (ThongTinNhanSu ns : danhSachNhanVien) {
			if (ns instanceof NhanVien && ((NhanVien) ns).getMaTruongPhong() != null
					&& ((NhanVien) ns).getMaTruongPhong().equals(((TruongPhong) truongPhong).getMaSo())) {
				((NhanVien) ns).setMaTruongPhong(null);
			}
		}
		danhSachNhanVien.remove(truongPhong);
	}

	public void xoaNhanVien(NhanVien nhanVien) {
		for (ThongTinNhanSu ns : danhSachNhanVien) {
			if (ns instanceof TruongPhong
					&& ((TruongPhong) ns).getMaSo().equals(((NhanVien) nhanVien).getMaTruongPhong())) {
				((TruongPhong) ns).xoaNhanVien(nhanVien);
				;
			}
		}
		danhSachNhanVien.remove(nhanVien);
	}

	// 5. Xuất thôngtin toàn bộ nhân viên.
	public void XuatThongTinToanNhanVien() {
		
		System.out.printf("%-5s | %-10s | %-20s | %-15s | %-10s | %-10s | %-10s | %-10s\n", "STT", "Mã Số", "Họ Tên",
				"Chức Vụ", "SDT", "Số Ngày", "Lương CB", "Lương tháng");
		for (int i = 0; i < danhSachNhanVien.size(); i++) {
			ThongTinNhanSu ns = danhSachNhanVien.get(i);
			System.out.printf("%-5s | %-10s | %-20s | %-15s | %-10s | %-10s | %-10s | %-10s\n", i + 1, ns.getMaSo(),
					ns.getHoTen(), ns.getChucVu(), ns.getSoDienThoai(), ns.getSoNgayLamViec(), ns.getLuong1ngay(),
					ns.tinhLuong());

		}
	}

	// 6. Tính và xuất tổng lương cho toàn công ty
	public void tinhTongLuong() {
		double tongLuong = 0;
		for (ThongTinNhanSu ns : danhSachNhanVien) {
			tongLuong += ns.tinhLuong();
		}
		System.out.println("Tổng lương của công ty là :" + tongLuong);
	}

	// 7. Tìm Nhân viên thường có lương cao nhất
	public void timNhanVienCoLuongCaoNhat() {
		double luongCaoNhat = 0;
		for (ThongTinNhanSu ns : danhSachNhanVien) {
			if (ns instanceof NhanVien && ((NhanVien) ns).tinhLuong() > luongCaoNhat) {
				luongCaoNhat = ((NhanVien) ns).tinhLuong();
			}
		}
		System.out.println("Nhân Viên có lương cao nhất là: ");
		System.out.printf("%-10s | %-20s | %-15s | %-10s | %-10s | %-10s | %-10s\n", "Mã Số", "Họ Tên", "Chức Vụ",
				"SDT", "Số Ngày", "Lương CB", "Lương tháng");
		for (ThongTinNhanSu ns : danhSachNhanVien) {
			if (ns instanceof NhanVien && ((NhanVien) ns).tinhLuong() == luongCaoNhat) {
				System.out.printf("%-10s | %-20s | %-15s | %-10s | %-10s | %-10s | %-10s\n", ns.getMaSo(),
						ns.getHoTen(), ns.getChucVu(), ns.getSoDienThoai(), ns.getSoNgayLamViec(), ns.getLuong1ngay(),
						ns.tinhLuong());

			}
		}
	}

	// 8. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất
	public void timTruongPhongCoSoLuongNVDQNhieuNhat() {
		double luongNhanVien = 0;
		for (ThongTinNhanSu ns : danhSachNhanVien) {
			if (ns instanceof TruongPhong && ((TruongPhong) ns).getSoLuongNVQL() > luongNhanVien) {
				luongNhanVien = ((TruongPhong) ns).getSoLuongNVQL();
			}
		}
		System.out.println("Trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất là: ");
		System.out.printf("%-10s | %-20s | %-15s | %-10s | %-15s\n", "Mã Số", "Họ Tên", "Chức Vụ", "SDT","Số lượng NVDQ");
		for (ThongTinNhanSu ns : danhSachNhanVien) {
			if (ns instanceof TruongPhong && ((TruongPhong) ns).getSoLuongNVQL() == luongNhanVien) {
				System.out.printf("%-10s | %-20s | %-15s | %-10s | %-15s\n", ns.getMaSo(), ns.getHoTen(),
						ns.getChucVu(), ns.getSoDienThoai(), ((TruongPhong) ns).getSoLuongNVQL());

			}
		}
	}

	// 9. Sắp xếp nhân viên toàn công ty theo thứ tự abc
	public void sapXepTheoABC() {
		Collections.sort(danhSachNhanVien, (ns1, ns2) -> ns1.layTenNhanVien().compareTo(ns2.layTenNhanVien()));
		XuatThongTinToanNhanVien();

	}

	// 10. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần
	public void sapXepLuongGiamDan() {
		Collections.sort(danhSachNhanVien, (ns1, ns2) -> (int) (ns2.tinhLuong() - ns1.tinhLuong()));
		XuatThongTinToanNhanVien();
	}
	
	// 11.Tìm Giám Đốc có số lượng cổ phần nhiều nhất
	public void timGiamDocCoSoCoPhanNhieuNhat() {
		float soCophan = 0;
		for (ThongTinNhanSu ns : danhSachNhanVien) {
			if (ns instanceof GiamDoc && ((GiamDoc) ns).getSoCoPhan() > soCophan) {
				soCophan = ((GiamDoc) ns).getSoCoPhan();
			}
		}
		System.out.println("Giám Đốc có số cổ phần nhiều nhất là");
		System.out.printf("%-10s | %-20s | %-15s\n", "Mã Số", "Họ Tên", "Số Cổ Phần");
		for (ThongTinNhanSu ns : danhSachNhanVien) {
			if (ns instanceof GiamDoc && ((GiamDoc) ns).getSoCoPhan() == soCophan) {
				System.out.printf("%-10s | %-20s | %-15s\n", ns.getMaSo(), ns.getHoTen(), ((GiamDoc) ns).getSoCoPhan());
			}
		}
	}
	
	// 12.Tính và Xuất tổng thu nhập của từng Giám Đốc
	public void thuNhanCuaGiamDoc() {
		System.out.println("thu nhập của từng Giám Đốc: ");
		System.out.printf("%-10s | %-20s | %-10s | %-12s\n", "Mã Số", "Họ Tên", "SDT", "Thu Nhập");
		for (ThongTinNhanSu ns : danhSachNhanVien) {
			if (ns instanceof GiamDoc ) {
				System.out.printf("%-10s | %-20s | %-10s | %-12s\n", ns.getMaSo(), ns.getHoTen(), ns.getSoDienThoai(), ns.tinhLuong() - ((GiamDoc) ns).getSoCoPhan() * loiNhuanCongTy());

			}
		}
	}
	
	private double loiNhuanCongTy() {
		return doanhThuThang - tongLuong();
	}

	private double tongLuong() {
		double tongLuong = 0;
		for (ThongTinNhanSu ns : danhSachNhanVien) {
			return tongLuong += ns.tinhLuong();
		}
		return tongLuong;
	}
	

}

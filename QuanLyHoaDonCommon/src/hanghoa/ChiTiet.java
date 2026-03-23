package hanghoa;

public class ChiTiet extends HangHoa{
	private int soLuong;
	private double donGia;
	
	public ChiTiet(String maSo, String ten, String nsxuat, int soLuong, double donGia) {
		super(maSo, ten, nsxuat);
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	
	public ChiTiet(String maSo, String ten, String nsxuat) {
		super(maSo, ten, nsxuat);
	}
	
	public ChiTiet() {
		super();
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	
}

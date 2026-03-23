package hanghoa;

public class HangHoa {
	private String maSo;
	private String ten;
	private String nsxuat;
	public HangHoa(String maSo, String ten, String nsxuat) {
		super();
		this.maSo = maSo;
		this.ten = ten;
		this.nsxuat = nsxuat;
	}
	public HangHoa() {
		super();
	}
	public String getMaSo() {
		return maSo;
	}
	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNsxuat() {
		return nsxuat;
	}
	public void setNsxuat(String nsxuat) {
		this.nsxuat = nsxuat;
	}
	
}

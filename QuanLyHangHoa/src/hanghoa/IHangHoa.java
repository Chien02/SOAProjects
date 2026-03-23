package hanghoa;

import javax.ws.rs.core.Response;

public interface IHangHoa {
	Response themHangHoa(ChiTietDTO chiTiet);
	Response chinhSuaHangHoa(ChiTietDTO chiTiet);
	Response xoaHangHoa(ChiTietDTO chiTiet);
	Response xemChiTiet(String maSo);
	Response getDanhSach();
}

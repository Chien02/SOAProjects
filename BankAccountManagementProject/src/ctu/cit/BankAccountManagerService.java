package ctu.cit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
// import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BankAccountManagerService { // Removed 'implements IBankAccountManager' as it's not provided
    // Use a thread-safe Map for efficient, safe, concurrent access.
    // Key: soTaiKhoan (String), Value: BankAccount object
    private static final Map<String, BankAccount> accounts = new ConcurrentHashMap<>();

    // Static initializer block for some dummy data
    static {
        accounts.put("111", new BankAccount("111", "Nguyen Van A", 5000000, true));
        accounts.put("222", new BankAccount("222", "Tran Thi B", 10000000, true));
        accounts.put("333", new BankAccount("333", "Le Van C", 200000, false));
    }

    @POST
    @Path("/add")
    public BankAccount themTaiKhoan(BankAccount account) {
        if (account == null || account.getSoTaiKhoan() == null || accounts.containsKey(account.getSoTaiKhoan())) {
            // In a real app, a custom exception is better. For now, returning null.
            return null;
        }
        accounts.put(account.getSoTaiKhoan(), account);
        return account;
    }

    @GET
    @Path("/list")
    public List<BankAccount> layDanhSachTaiKhoan() {
        // Return a new list from the values of the map
        return new ArrayList<>(accounts.values());
    }

    @GET
    @Path("/{soTaiKhoan}")
    public BankAccount timTaiKhoan(@PathParam("soTaiKhoan") String soTaiKhoan) {
        BankAccount account = accounts.get(soTaiKhoan);
        return account; // Returns the account or null if not found
    }

    @PUT
    @Path("/{soTaiKhoan}/lock")
    public BankAccount khoaTaiKhoan(@PathParam("soTaiKhoan") String soTaiKhoan) {
        BankAccount account = accounts.get(soTaiKhoan);
        if (account != null) {
            account.khoaTaiKhoan();
        }
        return account;
    }

    @PUT
    @Path("/{soTaiKhoan}/unlock")
    public BankAccount moKhoaTaiKhoan(@PathParam("soTaiKhoan") String soTaiKhoan) {
        BankAccount account = accounts.get(soTaiKhoan);
        if (account != null) {
            account.moKhoaTaiKhoan();
        }
        return account;
    }

    @POST
    @Path("/{soTaiKhoan}/deposit")
    public BankAccount napTien(@PathParam("soTaiKhoan") String soTaiKhoan, @QueryParam("amount") double soTien) {
        BankAccount account = accounts.get(soTaiKhoan);
        if (account == null) {
            return null;
        }
        if (account.napTien(soTien)) {
            return account;
        }
        return null;
    }

    @POST
    @Path("/{soTaiKhoan}/withdraw")
    public BankAccount rutTien(@PathParam("soTaiKhoan") String soTaiKhoan, @QueryParam("amount") double soTien) {
        BankAccount account = accounts.get(soTaiKhoan);
        if (account == null) {
            return null;
        }
        if (account.rutTien(soTien)) {
            return account;
        }
        return null;
    }

    @POST
    @Path("/transfer")
    public boolean chuyenTien(@QueryParam("from") String soTaiKhoanNguon, @QueryParam("to") String soTaiKhoanDich, @QueryParam("amount") double soTien) {
        BankAccount nguon = accounts.get(soTaiKhoanNguon);
        BankAccount dich = accounts.get(soTaiKhoanDich);
        if (nguon == null || dich == null) {
            return false;
        }
        return nguon.chuyenTien(dich, soTien);
    }
}

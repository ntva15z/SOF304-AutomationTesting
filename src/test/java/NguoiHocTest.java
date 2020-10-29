package Model;

import Helper.DateHelper;
import Helper.UtilityHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class NguoiHocTest {
    private NguoiHoc nh;

    @BeforeEach
    void setUp() {
        nh = new NguoiHoc();
    }

    @AfterEach
    void tearDown() {
        nh = null;
    }

    @Test
    void getMaNH() {
        String expected = null;
        String actual = nh.getMaNH();
        assertEquals(expected, actual);
    }

    @Test
    void setMaNH() {
        String manh = "nh01";
        nh.setMaNH(manh);
        String expected = "nh01";
        String actual = nh.getMaNH();
        assertEquals(expected, actual);
    }

    @Test
    void getHoTen() {
        String expected = null;
        String actual = nh.getHoTen();
        assertEquals(expected, actual);
    }

    @Test
    void setHoTen() {
        String hoten = "abbbb";
        nh.setHoTen(hoten);
        String expected = "abbbb";
        String actual = nh.getHoTen();
        assertEquals(expected, actual);
    }

    @Test
    void getNgaySinh() {
        Date expected = null;
        Date actual = nh.getNgaySinh();
        assertEquals(expected, actual);
    }

    @Test
    void setNgaySinh() {
        String ngaysinh = "06/05/1996";
        nh.setNgaySinh(DateHelper.toDate(ngaysinh));
        String expected = "06/05/1996";
        String actual = DateHelper.toString(nh.getNgaySinh());
        assertEquals(expected, actual);
    }

    @Test
    void setNgaySinhInValid() {
        String ngaysinh = "aaaa1111";
        assertThrows(RuntimeException.class, () -> nh.setNgaySinh(DateHelper.toDate(ngaysinh)));
    }

    @Test
    void isGioiTinh() {
        boolean gioitinh = false;
        assertEquals(gioitinh, nh.isGioiTinh());
    }

    @Test
    void setGioiTinh() {
        boolean gioitinh = true;
        nh.setGioiTinh(gioitinh);
        boolean expected = true;
        boolean actual = nh.isGioiTinh();
        assertEquals(expected, actual);
    }

    @Test
    void getDienThoai() {
        String expected = null;
        String actual = nh.getDienThoai();
        assertEquals(expected, actual);
    }

    @Test
    void setDienThoai() {
        String dienthoai = "0123456789";
        nh.setDienThoai(dienthoai);
        String expected = "0123456789";
        String actual = nh.getDienThoai();
        assertEquals(expected, actual);
    }

    @Test
    void setDienThoaiInValid() {
        String dienthoai = "aaaaaaaaa";
        assertThrows(NullPointerException.class,()->nh.setDienThoai(dienthoai));
    }
    @Test
    void setDienThoaiInValid2() {
        String dienthoai = "11111111111111";
        assertThrows(NullPointerException.class,()->nh.setDienThoai(dienthoai));
    }

    @Test
    void getEmail() {
        String expected = null;
        String actual = nh.getEmail();
        assertEquals(expected, actual);
    }

    @Test
    void setEmail() {
        String email = "abcaaa@gmail.com";
        nh.setEmail(email);
        String expected = "abcaaa@gmail.com";
        String actual = nh.getEmail();
        assertEquals(expected, actual);
    }

    @Test
    void setEmailInValid() {
        String email = "1213123123123";
        assertThrows(NullPointerException.class,()->nh.setEmail(email));
    }

    @Test
    void getGhiChu() {
        String expected = null;
        String actual = nh.getGhiChu();
        assertEquals(expected, actual);
    }

    @Test
    void setGhiChu() {
        String email = "adsadasdsadsa";
        nh.setGhiChu(email);
        String expected = "adsadasdsadsa";
        String actual = nh.getGhiChu();
        assertEquals(expected, actual);
    }

    @Test
    void getMaNV() {
        String expected = null;
        String actual = nh.getMaNV();
        assertEquals(expected, actual);
    }

    @Test
    void setMaNV() {
        String email = "nv01";
        nh.setMaNV(email);
        String expected = "nv01";
        String actual = nh.getMaNV();
        assertEquals(expected, actual);
    }

    @Test
    void getNgayDK() {
        Date expected = null;
        Date actual = nh.getNgayDK();
        assertEquals(expected, actual);
    }

    @Test
    void setNgayDK() {
        Date ngaydk = DateHelper.now();
        nh.setNgayDK(ngaydk);
        Date actual = nh.getNgayDK();
        assertEquals(ngaydk, actual);
    }
}
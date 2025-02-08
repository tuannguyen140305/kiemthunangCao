package org.example.kiemthu;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

public class tinh {

    @Test
    void kiemThuNhan() {
        assertEquals(6, nhan(2, 3));
        assertEquals(0, nhan(0, 5));
        assertThrows(IllegalArgumentException.class, () -> nhan(2, null));
    }

    int nhan(Integer a, Integer b) {
        if (a == null || b == null) throw new IllegalArgumentException();
        return a * b;
    }

    @Test
    void kiemThuChia() {
        assertEquals(2, chia(6, 3));
        assertThrows(ArithmeticException.class, () -> chia(6, 0));
    }

    int chia(int a, int b) {
        if (b == 0) throw new ArithmeticException("Không thể chia cho 0");
        return a / b;
    }

    @Test
    void kiemThuTrungBinh() {
        assertEquals(5, trungBinh(Arrays.asList(5, 5, 5)));
        assertThrows(ArithmeticException.class, () -> trungBinh(Collections.emptyList()));
    }

    int trungBinh(List<Integer> so) {
        if (so.isEmpty()) throw new ArithmeticException("Danh sách rỗng");
        return so.stream().mapToInt(Integer::intValue).sum() / so.size();
    }

    @Test
    void kiemThuLayPhanTuTaiChiMuc() {
        List<Integer> danhSach = Arrays.asList(1, 2, 3);
        assertEquals(2, layPhanTuTaiChiMuc(danhSach, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> layPhanTuTaiChiMuc(danhSach, 5));
    }

    int layPhanTuTaiChiMuc(List<Integer> danhSach, int chiMuc) {
        return danhSach.get(chiMuc);
    }

    @Test
    void kiemThuLayTen() {
        NguoiDung nguoiDung = new NguoiDung("John");
        assertEquals("John", nguoiDung.layTen());
        NguoiDung nguoiDungRong = new NguoiDung(null);
        assertThrows(NullPointerException.class, () -> nguoiDungRong.layTen());
    }

    class NguoiDung {
        private String ten;
        NguoiDung(String ten) { this.ten = ten; }
        String layTen() {
            if (ten == null) throw new NullPointerException("Tên bị rỗng");
            return ten;
        }
    }

    @Test
    void kiemThuTimMin() {
        assertEquals(1, timMin(new int[]{3, 1, 4}));
        assertThrows(IllegalArgumentException.class, () -> timMin(new int[]{}));
    }

    int timMin(int[] mang) {
        if (mang.length == 0) throw new IllegalArgumentException("Mảng rỗng");
        return Arrays.stream(mang).min().getAsInt();
    }
}

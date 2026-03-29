package com.Polycake.dao;

import com.Polycake.entity.Voucher;
import com.Polycake.utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VoucherDAO {
    
    // Tìm voucher theo mã code
    public Voucher getVoucherByCode(String code) {
        String query = "SELECT * FROM Vouchers WHERE VoucherCode = ?";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
             
            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Voucher v = new Voucher();
                    v.setVoucherId(rs.getInt("VoucherID"));
                    v.setVoucherCode(rs.getString("VoucherCode"));
                    v.setDiscountValue(rs.getBigDecimal("DiscountValue"));
                    v.setExpiryDate(rs.getTimestamp("ExpiryDate"));
                    v.setMinOrderValue(rs.getBigDecimal("MinOrderValue"));
                    return v;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Trả về null nếu mã không tồn tại
    }
}
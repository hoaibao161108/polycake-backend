package com.Polycake.dao;

import com.Polycake.entity.OrderDetail;
import com.Polycake.utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO {
    
    // Thêm chi tiết đơn hàng
    public boolean insertOrderDetail(OrderDetail od) {
        String query = "INSERT INTO OrderDetails (OrderID, ProductID, Quantity, PriceAtTime) VALUES (?, ?, ?, ?)";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
             
            ps.setInt(1, od.getOrderId());
            ps.setInt(2, od.getProductId());
            ps.setInt(3, od.getQuantity());
            ps.setBigDecimal(4, od.getPriceAtTime());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy danh sách sản phẩm trong 1 đơn hàng cụ thể
    public List<OrderDetail> getDetailsByOrderId(int orderId) {
        List<OrderDetail> list = new ArrayList<>();
        String query = "SELECT * FROM OrderDetails WHERE OrderID = ?";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
             
            ps.setInt(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    OrderDetail od = new OrderDetail();
                    od.setOrderDetailId(rs.getInt("OrderDetailID"));
                    od.setOrderId(rs.getInt("OrderID"));
                    od.setProductId(rs.getInt("ProductID"));
                    od.setQuantity(rs.getInt("Quantity"));
                    od.setPriceAtTime(rs.getBigDecimal("PriceAtTime"));
                    list.add(od);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

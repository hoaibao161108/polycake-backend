package com.Polycake.dao;

import com.Polycake.entity.Review;
import com.Polycake.utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
    
    // Thêm đánh giá mới
    public boolean insertReview(Review review) {
        String query = "INSERT INTO Reviews (ProductID, UserID, Rating, Comment, CreatedAt) VALUES (?, ?, ?, ?, GETDATE())";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
             
            ps.setInt(1, review.getProductId());
            ps.setInt(2, review.getUserId());
            ps.setInt(3, review.getRating());
            ps.setString(4, review.getComment());
            // CreatedAt được tự động lấy thời gian hiện tại từ DB bằng GETDATE()
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy danh sách đánh giá của 1 sản phẩm
    public List<Review> getReviewsByProductId(int productId) {
        List<Review> list = new ArrayList<>();
        String query = "SELECT * FROM Reviews WHERE ProductID = ? ORDER BY CreatedAt DESC";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
             
            ps.setInt(1, productId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Review r = new Review();
                    r.setReviewId(rs.getInt("ReviewID"));
                    r.setProductId(rs.getInt("ProductID"));
                    r.setUserId(rs.getInt("UserID"));
                    r.setRating(rs.getInt("Rating"));
                    r.setComment(rs.getString("Comment"));
                    r.setCreatedAt(rs.getTimestamp("CreatedAt"));
                    list.add(r);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

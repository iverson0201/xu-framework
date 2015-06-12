package com.xu.threadLocal.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xu on 2015/6/5.
 * http://my.oschina.net/huangyong/blog/159725
 */
public class ProductServiceImpl implements ProductService {

    private static final String UPDATE_PRODUCT_SQL = "update product set price = ? where id = ?";
    private static final String INSERT_LOG_SQL = "insert into log(created,description) values (?,?)";

    public void updateProductPrice(long productId, int price) {
        Connection conn = DBUtil.getConn();
        try {
            conn.setAutoCommit(false);

            updateProduct(conn, UPDATE_PRODUCT_SQL, productId, price);
            insertLog(conn,INSERT_LOG_SQL,"Create product.");

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn();
        }
    }

    private void insertLog(Connection conn, String insertLogSql, String logDescription) throws SQLException {

        PreparedStatement pstmt = conn.prepareStatement(insertLogSql);
        pstmt.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
        pstmt.setString(2, logDescription);
        int rows = pstmt.executeUpdate();
        if (rows != 0){
            System.out.println("Insert log success");
        }
    }

    private void updateProduct(Connection conn, String updateProductSql, long productId, int price) throws SQLException {

        PreparedStatement pstmt = conn.prepareStatement(updateProductSql);
        pstmt.setInt(1, price);
        pstmt.setLong(2,productId);
        int rows = pstmt.executeUpdate();
        if (rows != 0){
            System.out.println("Update Product Success");
        }
    }

    public static void main(String[] args) {
        //ProductService productService = new ProductServiceImpl();
        //productService.updateProductPrice(1,3000);

        for (int i = 0; i < 10; i++){
            ProductService productService = new ProductServiceImpl();
            ClientThread thread = new ClientThread(productService);
            thread.start();
        }
    }
}

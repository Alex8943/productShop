package com.example.demo.Repository;

import com.example.demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements ICrudRepository<Product> {

    @Autowired
    JdbcTemplate template;

    @Override
    public void create(Product product) {
        String sql = "INSERT INTO product (productName, productPrice) VALUES (?,?)";
        template.update(sql, product.getProductName(), product.getProductPrice());
    }

    @Override
    public List<Product> readAll() {
        String sql = "SELECT * FROM product";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public Product getProduct(long productid) {
        String sql = "SELECT * FROM product WHERE productID=?";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return template.queryForObject(sql, rowMapper, productid);
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE product SET productName=?, productPrice=? WHERE productID=?";
        template.update(sql, product.getProductName(), product.getProductPrice(), product.getProductID());
    }

    @Override
    public void delete(long productid) {
        String sql = "DELETE FROM product WHERE productID=?";
        template.update(sql, productid);
    }

}

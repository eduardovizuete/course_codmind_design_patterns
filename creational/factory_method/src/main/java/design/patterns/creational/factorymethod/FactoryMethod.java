/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package design.patterns.creational.factorymethod;

import design.patterns.creational.factorymethod.dao.ProductDAO;
import design.patterns.creational.factorymethod.entities.Product;
import design.patterns.creational.factorymethod.enums.DBType;
import design.patterns.creational.factorymethod.factory.DBAdapterFactory;
import design.patterns.creational.factorymethod.factory.IDBAdapter;
import design.patterns.creational.factorymethod.factory.MySQLAdapter;
import design.patterns.creational.factorymethod.factory.OracleAdapter;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author eduardo
 */
public class FactoryMethod {

    public static void main(String[] args) {
        //OracleAdapter adapter = new OracleAdapter();
        //MySQLAdapter adapter = new MySQLAdapter();
        
        //IDBAdapter adapter = DBAdapterFactory.getAdapter(DBType.MYSQL);
        //IDBAdapter adapter = DBAdapterFactory.getAdapter(DBType.ORACLE);
        //Connection connection = adapter.getConnection();
        
        //ProductDAO dao = new ProductDAO(DBType.MYSQL);
        //ProductDAO dao = new ProductDAO(DBType.ORACLE);
        ProductDAO dao = new ProductDAO();
        
        Product product1 = new Product(2L, "Producto 2", 10);
        dao.saveProduct(product1);
        
        List<Product> allProducts = dao.getAllProducts();
        allProducts.stream().forEach(System.out::println);
    }
    
}

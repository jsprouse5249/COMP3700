import javax.swing.*;
import java.util.ArrayList;

public class ProductListModel {
    public ArrayList<Product> getList() {
        return productsList;
    }

    public ArrayList<Product> productsList = new ArrayList<>();
}

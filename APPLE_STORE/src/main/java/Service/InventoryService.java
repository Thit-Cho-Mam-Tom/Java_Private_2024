package Service;

import DAO.InventoryDAO;
import Model.Inventory;
import java.util.List;

public class InventoryService {

    private InventoryDAO inventoryDAO = new InventoryDAO();

    // Lưu tồn kho
    public void saveInventory(Inventory inventory) {
        inventoryDAO.save(inventory);
    }

    // Lấy tồn kho theo productId
    public Inventory getInventoryByProductId(int productId) {
        return inventoryDAO.getById(productId);
    }

    // Cập nhật tồn kho
    public void updateInventory(Inventory inventory) {
        inventoryDAO.update(inventory);
    }

    // Xóa tồn kho theo productId
    public void deleteInventory(int productId) {
        inventoryDAO.delete(productId);
    }
}

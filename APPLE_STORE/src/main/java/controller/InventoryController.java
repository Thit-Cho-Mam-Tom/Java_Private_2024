package controller;

import Service.InventoryService;
import Model.Inventory;
import java.util.List;

public class InventoryController {

    private InventoryService inventoryService = new InventoryService();

    // Lưu thông tin kho
    public void saveInventory(Inventory inventory) {
        inventoryService.saveInventory(inventory);
    }

    // Lấy thông tin kho theo ID
    public Inventory getInventoryById(int id) {
        return inventoryService.getInventoryByProductId(id);
    }

    // Cập nhật thông tin kho
    public void updateInventory(Inventory inventory) {
        inventoryService.updateInventory(inventory);
    }

    // Xóa thông tin kho
    public void deleteInventory(int id) {
        inventoryService.deleteInventory(id);
    }
}

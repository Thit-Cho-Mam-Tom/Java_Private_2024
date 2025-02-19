package Service;

import DAO.CategoryDAO;
import Model.Category;
import java.util.List;

public class CategoryService {

    private CategoryDAO categoryDAO = new CategoryDAO();

    // Lưu danh mục
    public void saveCategory(Category category) {
        categoryDAO.save(category);
    }

    // Lấy danh mục theo ID
    public Category getCategoryById(int id) {
        return categoryDAO.getById(id);
    }

    // Lấy tất cả danh mục
    public List<Category> getAllCategories() {
        return categoryDAO.getAll();
    }

    // Cập nhật danh mục
    public void updateCategory(Category category) {
        categoryDAO.update(category);
    }

    // Xóa danh mục theo ID
    public void deleteCategory(int id) {
        categoryDAO.delete(id);
    }
}

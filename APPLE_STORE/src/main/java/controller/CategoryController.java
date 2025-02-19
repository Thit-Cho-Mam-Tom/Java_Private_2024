package controller;

import Service.CategoryService;
import Model.Category;
import java.util.List;

public class CategoryController {

    private CategoryService categoryService = new CategoryService();

    // Lưu danh mục
    public void saveCategory(Category category) {
        categoryService.saveCategory(category);
    }

    // Lấy danh mục theo ID
    public Category getCategoryById(int id) {
        return categoryService.getCategoryById(id);
    }

    // Lấy tất cả danh mục
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Cập nhật danh mục
    public void updateCategory(Category category) {
        categoryService.updateCategory(category);
    }

    // Xóa danh mục
    public void deleteCategory(int id) {
        categoryService.deleteCategory(id);
    }
}

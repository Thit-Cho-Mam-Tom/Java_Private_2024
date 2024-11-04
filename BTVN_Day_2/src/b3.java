class bai3 {
    public static void main(String[] args) {
        String input = "abc123ifa3i";

        // Tạo hai StringBuilder để lưu trữ chữ và số riêng biệt
        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();

        // Duyệt qua từng ký tự trong chuỗi
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.append(c);
            } else if (Character.isDigit(c)) {
                digits.append(c);
            }
        }

        // Phân nhóm các chuỗi chữ cái và số
        String[] letterGroups = letters.toString().split(" ");
        String[] digitGroups = digits.toString().split(" ");

        // Xuất các nhóm chữ cái
        for (String group : letterGroups) {
            System.out.print(group + " ");
        }
        System.out.println();

        // Xuất các nhóm chữ số
        for (String group : digitGroups) {
            System.out.print(group + " ");
        }
    }
}

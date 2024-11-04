public class Student {
    protected String StudentCode;
    protected String FullName;
    protected Byte age;
    protected String gender;
    protected String phoneNumber;
    protected String email;
    public Student(){

    }
    public Student(String studentCode, String fullName, Byte age, String gender, String phoneNumber, String email) {
        this.StudentCode = studentCode;
        this.FullName = fullName;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getStudentCode() {
        return StudentCode;
    }

    public String getFullName() {
        return FullName;
    }

    public Byte getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setStudentCode(String studentCode) {
        StudentCode = studentCode;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void display() {
        System.out.printf("%-15s %-30s %-5s %-10s %-15s %-30s%n",
                "Mã sinh viên", "Họ và tên", "Tuổi", "Giới tính", "Số điện thoại", "Email");
        System.out.printf("%-15s %-30s %-5d %-10s %-15s %-30s%n",
                StudentCode, FullName, age, gender, phoneNumber, email);
    }
}

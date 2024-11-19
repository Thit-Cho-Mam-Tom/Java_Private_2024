import java.util.Scanner;

public class Address {
    protected String commune;
    protected String district;
    protected String city;

    public Address() {
    }

    public Address(String commune, String district, String city) {
        this.commune = commune;
        this.district = district;
        this.city = city;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "commune='" + commune + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập commune: ");
        this.commune =sc.nextLine();
        System.out.println("nhập district: ");
        this.district=sc.nextLine();
        System.out.println("nhập city: ");
        this.city=sc.nextLine();
    }
    public void output(){
        System.out.printf("%-20s%-20s%-20s", commune, district, city);
    }
}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarManager implements CarManagerIMPL {
    private List<Car> carManagerIMPLS = new ArrayList<>();

    @Override
    public boolean addCar(Car c) {
       return carManagerIMPLS.add(c);
    }

    @Override
    public boolean editCar(Car c) {
        for(int i = 0; i < carManagerIMPLS.size();i++){
            if(carManagerIMPLS.get(i).getProduct_id().equals(c.getProduct_id())){
                carManagerIMPLS.set(i,c);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delCar(Car c) {
        return carManagerIMPLS.remove(c);
    }

    @Override
    public List<Car> searchCar(String name) {
       List<Car> carManagers= new ArrayList<>();
       for(Car x : carManagers){
           if(x.getProduct_name().contains(name)){
               carManagers.add(x);
           }
       }
       return carManagers;
    }

    @Override
    public List<Car> sortedCar(double price) {
        List<Car> sortedList = new ArrayList<>();
        sortedList.sort((a, b) -> Double.compare(Double.parseDouble(a.getProduct_price()), Double.parseDouble(b.getProduct_price())));
        return sortedList;
    }

}

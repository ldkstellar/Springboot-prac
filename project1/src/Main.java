


public class Main {
    public static void main(String[] args) {
       Driver me = new Driver("me",1);
       Driver unlicensed = new Driver("unlicensed",0);
       CarInterface car = new GoCart();
       CarInterface smallCar = new SmallCar();
       car.setDriver(me);
       car.setDriver(unlicensed);
       smallCar.setDriver(unlicensed);

        
    }
}
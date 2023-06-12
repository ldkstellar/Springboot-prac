public abstract class AbstractCar implements  CarInterface{
    protected  int velocity;

    @Override
    public void brake() {
        if(velocity <0)
            this.velocity = 0;

    }
}

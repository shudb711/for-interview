package all.javalearn.base.extend;

/**
 * @Description:
 * @Author:shudebao
 * @Email:shudebao@weshare.com.cn
 * @Date:2019/4/10
 */
public class BmCar extends Car {
    private String made;

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public static void main(String[] args)
    {
        Car car = new BmCar();
        car.setColor("red");
        System.out.println("car color:" + car.getColor());

        BmCar bmCar = new BmCar();
        bmCar.setColor("green");
        System.out.println("bmCar color:" + car.getColor());
    }
}

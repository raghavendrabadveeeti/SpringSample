import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by J1011436 on 6/24/2016.
 */
public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("car.xml");

        Car obj = (Car) context.getBean("car");

        System.out.println("Hellow World ");
        System.out.println(obj.getBrand());
        System.out.println(obj.getModelName());
        System.out.println(obj.getBrand());
        System.out.println(obj.getBrand());

    }
}


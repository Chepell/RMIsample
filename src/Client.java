import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// Клиент запускается вторым
public class Client {
    private static final String UNIC_BINDING_NAME = "math.calculation";

    public static void main(String[] args) {
        try {
            // получение реестра расшаренных объектов по хосту и порту
            Registry registry = LocateRegistry.getRegistry("localhost", 2095);
            // получение проки-объека из реестра по уникальному имени
            RemoteMathService service = (RemoteMathService) registry.lookup(UNIC_BINDING_NAME);
            // вызов метода интерфейса у объекта-сервиса
            int factorial = service.factorial(10);
            System.out.format("Result of service invocation: %d", factorial);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}

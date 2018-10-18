import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Сервер стартует первым
public class Server {
    private static final String UNIC_BINDING_NAME = "math.calculation";

    public static void main(String[] args) throws InterruptedException {
        try {
            // создание объекта для удаленного доступа
            final RemoteMathServiceImpl service = new RemoteMathServiceImpl();
            // создание реестра расшаренных объектов
            final Registry registry = LocateRegistry.createRegistry(2095);
            // создание заглушки/приемника удаленных вызовов
            Remote stub = UnicastRemoteObject.exportObject(service, 0);
            // регистрация заглушки в реестре
            registry.bind(UNIC_BINDING_NAME, stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

        Thread.sleep(Integer.MAX_VALUE);
    }
}

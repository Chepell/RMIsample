import java.rmi.Remote;
import java.rmi.RemoteException;

// интерфейс для межпрограмного взаимодействия
public interface RemoteMathService extends Remote {

    int factorial(int x) throws RemoteException;

}

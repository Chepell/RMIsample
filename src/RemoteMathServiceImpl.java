import java.rmi.RemoteException;

// серверный класс с реализацией интерфейса
public class RemoteMathServiceImpl implements RemoteMathService {
    @Override
    public int factorial(int x) throws RemoteException {
        if (x <= 1) return 1;
        return x * factorial( x - 1);
    }
}

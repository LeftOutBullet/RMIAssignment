import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {
    public String reverse(String starter)throws RemoteException;
    public char MinChar(String starter) throws RemoteException;
    public String CaseChanger (String starter) throws RemoteException;

}

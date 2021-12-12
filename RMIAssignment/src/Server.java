import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Locale;

public class Server extends UnicastRemoteObject implements MyInterface {

    public Server() throws RemoteException {}

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);
    }

    @Override
    public String reverse(String starter) throws RemoteException {

        String returned="";
        char ch;

        for (int i=0; i<starter.length(); i++)
        {
            ch= starter.charAt(i);
            returned= ch+returned;
        }

        return returned;
    }

    @Override
    public char MinChar(String starter) throws RemoteException {

        int x=200;
        int ascii;
        char character;
        char newchr='Z';

        for (int i=0;i<starter.length();i++){
            character = starter.charAt(i);
            ascii = (int) character;

            if (ascii<x) {
                x=ascii;
                newchr=character;
            }
        }
        return newchr;
    }

    @Override
    public String CaseChanger(String starter) throws RemoteException {

        char character;
        String dummy="";
        String finale="";

        for (int i=0;i<starter.length();i++){
            if (Character.isUpperCase(starter.charAt(i))) {
                dummy=dummy+starter.charAt(i);
                finale=finale+dummy.toLowerCase();
                dummy="";
            }
            else{
                dummy=dummy+starter.charAt(i);
                finale=finale+dummy.toUpperCase();
                dummy="";
            }
        }
        return finale;
    }


}

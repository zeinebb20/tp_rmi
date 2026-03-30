import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnuaireImpl extends UnicastRemoteObject implements IAnnuaire {
    private Map<String, String> contacts;

    protected AnnuaireImpl() throws RemoteException {
        super();
        contacts = new HashMap<>();
    }

    @Override
    public synchronized void ajouterContact(String nom, String numero) {
        contacts.put(nom, numero);
    }

    @Override
    public synchronized String rechercherNumero(String nom) {
        return contacts.getOrDefault(nom, "Contact introuvable.");
    }

    @Override
    public synchronized List<String> listerContacts() {
        List<String> liste = new ArrayList<>();
        contacts.forEach((nom, num) -> liste.add(nom + " : " + num));
        return liste;
    }
}


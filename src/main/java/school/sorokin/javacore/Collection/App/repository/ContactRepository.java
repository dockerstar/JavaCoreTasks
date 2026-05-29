package school.sorokin.javacore.Collection.App.repository;

import school.sorokin.javacore.Collection.App.exception.NotFoundContact;
import school.sorokin.javacore.Collection.App.exception.NotFoundGroup;
import school.sorokin.javacore.Collection.App.model.Contact;

import java.util.*;

public class ContactRepository {
    List<Contact> contactList = new ArrayList<>();

    public void save(Contact contact) {
        contactList.add(contact);
    }

    public void delete(String name, String phone) {
        boolean status = false;
        Iterator<Contact> contactIterator = contactList.iterator();
        while (contactIterator.hasNext()) {
            Contact contact = contactIterator.next();
            if (contact.getName().equals(name) &&
                    contact.getPhone().equals(phone)) {
                contactIterator.remove();
                status = true;
                break;
            }
        }

        if (!status) throw new NotFoundContact("Контакт не найден, чтоб удалить");
    }

    public void getAll() {
        Iterator<Contact> contactIterator = contactList.iterator();
        while (contactIterator.hasNext()) {
            System.out.println(contactIterator.next());
        }
    }

    public Contact get(String name, String phone) {
        Iterator<Contact> contactIterator = contactList.iterator();
        boolean status = false;
        Contact contact = new Contact();
        while (contactIterator.hasNext()) {
            Contact contact1 = contactIterator.next();
            if (contact1.getName().equals(name) &&
                    contact1.getPhone().equals(phone)) {
                contact = contact1;
                status = true;
                break;
            }
        }
        if (!status) {
            throw new NotFoundContact("Контакт не найден");
        } else {
            return contact;
        }
    }

    public List<Contact> getAllContactsInGroup(String group) {
        Iterator<Contact> contactIterator = contactList.iterator();
        List<Contact> searchContactForGroup = new ArrayList<>();
        Map<String, List<Contact>> mapContactForGroup = new HashMap<>();
        while (contactIterator.hasNext()) {
            Contact contact = contactIterator.next();
            if (contact.getGroup().equals(group))
                searchContactForGroup.add(contact);
        }
        if (!searchContactForGroup.isEmpty()) {
            return searchContactForGroup;
        } else throw new NotFoundGroup("Такой группы нет!");
    }
}

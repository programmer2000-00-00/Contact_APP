package controller;

import dto.Contact;
import service.Contactservice;
import ui.ScannerUi;

import java.util.Scanner;

public class Controller {

    public  Contactservice contactservice;

    public Controller(){
        contactservice=new Contactservice();
    }
    public  void start(){

    boolean b = true;
        while (b) {
        menu();
        int action = getAction();
        switch (action) {
            case 1:
                addContact();
                break;
            case 2:
                contactservice.getAll();
                break;
            case 3:
                editContact();
                break;
            case 4:
                deleteContact();
                break;
            case 5:searchContact();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("ERROR operation number");
        }

    }


}

    private  void editContact() {
        contactservice.getAll();

        System.out.print("Enter the id : ");
        Integer id = ScannerUi.SCAN_INT.nextInt();

        System.out.print("Enter  new name: ");
        String Newname = ScannerUi.SCAN_STR.next();

        System.out.print("Enter new surname: ");
        String Newsurname = ScannerUi.SCAN_STR.next();

        System.out.print("Enter  new phone_num number: ");
        String Newphone_num = ScannerUi.SCAN_STR.next();
        Contact contact=new Contact();
        contact.setId(id);
        contact.setName(Newname);
        contact.setSurname(Newsurname);
        contact.setPhone(Newphone_num);

        contactservice.edit(contact);
    }

    private  void searchContact() {
        System.out.print("Enter Something: ");
        String someThing = ScannerUi.SCAN_STR.next();

        contactservice.search(someThing);

    }

    private  void menu() {
        System.out.println("\t\t Welcome My dto.Contact");
        System.out.println("1. Add dto.Contact");
        System.out.println("2. Show Contacts");
        System.out.println("3. Edit contact");
        System.out.println("4. Delete dto.Contact");
        System.out.println("5. Search dto.Contact");
        System.out.println("0. EXIT ");
        System.out.print("Choose operation number: ");
    }

    public  void addContact() {
        System.out.print("Enter first name: ");
        String name = ScannerUi.SCAN_STR.next();

        System.out.print("Enter last name: ");
        String surname = ScannerUi.SCAN_STR.next();

        System.out.print("Enter phone number: ");
        String phone_num = ScannerUi.SCAN_STR.next();
        Contact contact=new Contact();

        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone_num);

        contactservice.saveContact(contact);

    }

    public static int getAction() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        return n;
    }


    public  void deleteContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter phone: ");
        String phone_num = scanner.next();

        contactservice.delete(phone_num);
    }

    public  void createTable() {
        contactservice.createTable();
    }
}

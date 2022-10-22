package service;

import dto.Contact;
import repository.ContactRepository;

public class Contactservice {
     public    ContactRepository contactRepository;

     public Contactservice(){
         contactRepository=new ContactRepository();
     }
    public  void createTable() {
        contactRepository.createTable();
    }

    public  void getAll() {
        contactRepository.getAll();
    }

    public void saveContact(Contact contact) {

         if(contact.getPhone().isEmpty()){
             System.out.println("Number is required");
         }
         Contact con=contactRepository.getContactByPhone(contact.getPhone());

        if(con!=null){
            System.out.println("Phone already exists");
            return;
        }
        if(!contact.getPhone().matches("(\\ 998)?\\d{9}"))
        {
            System.out.println("wrong phone number");
            return;
        }

        if(!contact.getPhone().startsWith("998")) {
            contact.setPhone("998"+contact.getPhone());
        }


//        Boolean b = contactRepository.exists(contact.getPhone());
//        if (b) {
//            System.out.println("Phone Already exists");
//            return;
//        }
        int n = contactRepository.saveContact(contact);
        if (n != 0) {
            System.out.println("dto.Contact Added");
        }

    }


    public void delete(String phone) {

        int n=contactRepository.delete(phone);

        if(n!=0){
            System.out.println("dto.Contact deleted");
        }
    }

    public void search(String someThing) {

         Contact contact=contactRepository.search(someThing);

         if(contact!=null){
             System.out.println(contact);
         }
    }

    public void edit(Contact contact) {
         int n=contactRepository.edit(contact);

         if(n!=0){
             System.out.println("Successefully edited");
             return;
         }

        System.out.println("Error");
    }
}
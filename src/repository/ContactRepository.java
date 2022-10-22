package repository;

import db.DatabaseConnection;
import dto.Contact;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContactRepository {

    public int saveContact(Contact contact) {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            String sql = String.format("insert into contact (name,surname,phone_num) values('%s','%s','%s');",
                    contact.getName(), contact.getSurname(), contact.getPhone());
            int n = stmt.executeUpdate(sql);
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public Boolean exists(String phone) {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select count(*) from contact where phone_num = '" + phone + "';");
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
   public boolean getBylength(String phone_num){
       Connection con = null;
       try {
           con = DatabaseConnection.getConnection();
           Statement stmt = con.createStatement();

           ResultSet rs = stmt.executeQuery("select id,name,surname,phone_num from contact where phone_num = '" + phone_num + "';");

           while (rs.next()) {
               return true;
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           try {
               if (con != null)
                   con.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return false;
   }
    public Contact getContactByPhone(String phone_num) {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select id,name,surname,phone_num from contact where phone_num = '" + phone_num + "';");

            while (rs.next()) {
                Contact contact=new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setSurname(rs.getString("surname"));
                contact.setPhone(rs.getString("phone_num"));
                return contact;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void createTable() {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            int n = stmt.executeUpdate("create table if not exists contact( " +
                    " id serial primary key," +
                    " name varchar(20)," +
                    " surname varchar(20)," +
                    " phone_num varchar(12) not null unique" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    public static void getAll() {

        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select id,name,surname,phone_num from contact");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone_num = rs.getString("phone_num");
                System.out.println(id + " " + name + " " + surname + " " + phone_num);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public int delete(String phone_num) {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            String sql = String.format("Delete from contact where phone_num = '%s'", phone_num);
            int n = stmt.executeUpdate(sql);
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public Contact search(String someThing) {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();

            ResultSet set = stmt.executeQuery("select * from contact where name ilike ('" + someThing + "%') " +
                    " or surname ilike ('" + someThing + "%') or phone_num ilike ('" + someThing + "%')");
            while (set.next()) {
               Contact contact=new Contact();
               contact.setId(set.getInt("id"));
                contact.setName(set.getString("name"));
                contact.setSurname(set.getString("surname"));
                contact.setPhone(set.getString("phone_num"));

                return contact;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int edit(Contact contact) {

        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            String sql = String.format("Update contact set name='%s',surname='%s',phone_num='%s' where id='%d'", contact.getName(),contact.getSurname(),contact.getPhone(),contact.getId());
            int n = stmt.executeUpdate(sql);
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}
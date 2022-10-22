package dto;

public  class Contact {
    private Integer id;
    private String name;
    private String surname;
    private String phone_num;

    public Contact() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone_num;
    }

    public void setPhone(String phone_num) {
        this.phone_num = phone_num;
    }

    @Override
    public String toString() {
        return "dto.Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone_num + '\'' +
                '}';
    }
}

// Java Contact Manager Project
// Author: Selena Holcomb

public class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name.trim();
        this.phone = phone.trim();
        this.email = email.trim();
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public void setPhone(String phone) {
        this.phone = phone.trim();
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Phone: " + phone + " | Email: " + email;
    }
}
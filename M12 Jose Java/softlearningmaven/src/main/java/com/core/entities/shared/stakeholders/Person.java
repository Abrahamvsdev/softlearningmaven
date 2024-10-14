package com.core.entities.shared.stakeholders;
import com.core.checks.Check;
public abstract class Person {


    protected String name;
    protected String surname;
    protected String email;
    protected String address;
    protected String dni;
    protected String number; // de telefono
    protected int antiquity; //cuando nacio
    protected Person(){};

    // Constructor el metodo tiene que ser void a la fuerza porque es abstracto y no retorna nada
    public void person(String name, String surname, String email, String address, String dni, String number, int antiquity) throws Exception {
        StringBuilder errors = new StringBuilder();
        int errorCode;
        
        
        if ((errorCode = this.setName(name)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        if ((errorCode = this.setSurname(surname)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        if ((errorCode = this.setEmail(email)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        if ((errorCode = this.setAddress(address)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        if ((errorCode = this.setDni(dni)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        if ((errorCode = this.setNumber(number)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        if ((errorCode = this.setAntiquity(antiquity)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        if (errors.length() > 0) {
            throw new Exception("No es posible crear al tipo: \n" + errors.toString());
        }
    }

    //getter
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDni() {
        return dni;
    }

    public String getNumber() {
        return number;
    }

    public int getAntiquity() {
        return antiquity;
    }

    //setter
    public int setName(String name) {
        int errorName = Check.minMaxLength(name);
        if (errorName == 0) {
            this.name = name;
        }
        return errorName;
    }

    public int setSurname(String surname) {
        int errorSurname = Check.minMaxLength(surname);
        if (errorSurname == 0) {
            this.surname = surname;
        }
        return errorSurname;
    }

    public int setEmail(String email) {
        int errorEmail = Check.checkEmail(email);
        if (errorEmail == 0) {
            this.email = email;
        }
        return errorEmail;
    }

    public int setAddress(String address) {
        int errorAddress = Check.minMaxLength(address);
        if (errorAddress == 0) {
            this.address = address;
        }
        return errorAddress;
    }

    public int setDni(String dni) {
        int errorDni = Check.checkDNI(dni);
        if (errorDni == 0) {
            this.dni = dni;
        }
        return errorDni;
    }

    public int setNumber(String number) {
        int errorNumber = Check.minMaxLength(number);
        if (errorNumber == 0) {
            this.number = number;
        }
        return errorNumber;
    }

    public int setAntiquity(int antiquity){
        //check range de int
        int errorAntiquity = Check.range(antiquity);
        if (errorAntiquity == 0) {
            this.antiquity = antiquity;
        }
        return errorAntiquity;
    }

    
    public abstract String getContactData();

    
    public String getDetails() {
        //crear superstring con .append para eficiencia, pero primero asegurar que no es nulo NO HACE FALTA

        return "Name: " + name + ", Surname: " + surname + ", Email: " + email + ", Address: " + address +
                ", DNI: " + dni + ", Number: " + number + ", Antiquity: " + antiquity;
    }
}

package sample;

// Aleksandr Kudin – 101258693
// Oleksii Pedko – 101242285
// CRN – 13803-202001

public class Address {
    public String streetInfo1;
    public String streetInfo2;
    public String city;
    public String postalCode;
    public String province;
    public String country;

    // constructor
    public Address(String streetInfo1, String streetInfo2, String city, String postalCode, String province, String country) {
        this.streetInfo1 = streetInfo1;
        this.streetInfo2 = streetInfo2;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
    }

    public void setStreetInfo1(String streetInfo1) {
        this.streetInfo1 = streetInfo1;
    }

    public void setStreetInfo2(String streetInfo2) {
        this.streetInfo2 = streetInfo2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        String s = streetInfo1 + " " + streetInfo2 + " " + city + " " + postalCode + " " + province + " " + country;
        return s;
    }
}

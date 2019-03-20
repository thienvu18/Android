package thienvu.bt04;

public class Model {
    private String name;
    private String phoneNumber;
    private int avatar1Uri;
    private int avatar2Uri;

    public Model(String name, String phoneNumber, int avatar1Uri, int avatar2Uri) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.avatar1Uri = avatar1Uri;
        this.avatar2Uri = avatar2Uri;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAvatar1Uri() {
        return avatar1Uri;
    }

    public int getAvatar2Uri() {
        return avatar2Uri;
    }
}

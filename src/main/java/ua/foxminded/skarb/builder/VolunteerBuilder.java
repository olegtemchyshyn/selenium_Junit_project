package ua.foxminded.skarb.builder;;

public class VolunteerBuilder {

    private final String email;
    private String firstName;
    private String lastName;
    private String password;

    private VolunteerBuilder(Builder builder) {
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
    }

    // Getter methods
    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {

        private String email;
        private String firstName;
        private String lastName;
        private String password;

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public VolunteerBuilder build() {
            return new VolunteerBuilder(this);
        }
    }
}

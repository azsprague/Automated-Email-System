package email;

/**
 * Contains the data to be used for sending an email, including the
 * header, body, sending email, password, recipients, and time to send.
 * 
 * @author Aidan Sprague
 * @version 2020.12.20
 */
public class Data {

    private String header;
    private String body;
    private String email;
    private String password;
    private String[] recipients;
    private String time;
    
    /**
     * Constructor for the class.
     * @param header
     * @param body
     * @param email
     * @param password
     * @param recipients
     * @param time
     */
    public Data(String header, String body, String email, String password, String[] recipients, String time) {
        this.header = header;
        this.body = body;
        this.email = email;
        this.password = password;
        this.recipients = recipients;
        this.time = time;
    }

    public String getHeader() {return header;}
    public String getBody() {return body;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public String[] getRecipients() {return recipients;}
    public String getTime() {return time;}
    
    /**
     * Returns a string representation of a Data object.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Header:\t\t" + header);
        builder.append("Body:\t\t" + body);
        builder.append("From:\t\t" + email);
        builder.append("To:\t\t");
        for (String email : recipients) {builder.append("\t\t\t" + email);}
        builder.append("Time:\t\t" + time);
        return builder.toString();
    }
}

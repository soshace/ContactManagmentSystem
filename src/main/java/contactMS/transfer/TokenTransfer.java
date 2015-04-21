package contactMS.transfer;

public class TokenTransfer {

    private final String token;

    public TokenTransfer(String token) {
        this.token = token;
    }

    public TokenTransfer() {
        this.token = "";
    }

    public String getToken() {
        return this.token;
    }
}

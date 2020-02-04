package Goprove;

public class ProveResult {
    public boolean status;
    public String[] errors;

    public ProveResult(boolean status, String[] errors) {
        this.status = status;
        this.errors = errors;
    }
}

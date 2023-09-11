package org.example.csv;

public class WarningException extends RuntimeException {
    private DataWarning warning;

    public WarningException(DataWarning warning) {
        this.warning = warning;
    }

    public DataWarning getWarning() {
        return warning;
    }

    public void setWarning(DataWarning warning) {
        this.warning = warning;
    }
}

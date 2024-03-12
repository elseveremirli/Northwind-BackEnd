package org.example.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult {
    public SuccessDataResult(Object data, String message) {
        super(data, true , message);
    }
    public SuccessDataResult(Object data) {
        super(data, true );
    }
    public SuccessDataResult(String message) {
        super(null, true , message);
    }
    public SuccessDataResult() {
        super(null, true );
    }
}

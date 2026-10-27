package pl.bsjhx.katas.designpatterns.adapter;

class ExternalCurrencyApiException extends RuntimeException {
    public ExternalCurrencyApiException(String message, Exception e) {
        super(message, e);
    }

    public ExternalCurrencyApiException(String message) {
        super(message);
    }
}

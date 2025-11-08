package chainofresponsibility;

public interface LoggingProcessor {
    void setNextHandler(LoggingProcessor loggingProcessor);
    void handleRequest();
}

package main.java.JVM.OOM;

/**
 * java.lang.Object
 * java.lang.Throwable
 * java.lang.Error
 * java.lang.VirtualMachineError
 * java.lang.StackOverflowError
 */
public class StackOverFlowError {
    public static void main(String[] args) {
        stackOverFlow();
    }
    public static void stackOverFlow() {
        stackOverFlow();
    }
}

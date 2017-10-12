package dasniko.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
public class MBeanHandler implements RequestHandler<Void, Void> {

    @Override
    public Void handleRequest(Void input, Context context) {
        LambdaLogger log = context.getLogger();

        log.log(runtimeBean());
        log.log(memoryBean());
        log.log(operationSystemBean());

        return null;
    }

    private String runtimeBean() {
        RuntimeMXBean mx = ManagementFactory.getRuntimeMXBean();

        return "RuntimeMXBean info:" +
                "\nBootClassPath: " + mx.getBootClassPath() +
                "\nClassPath: " + mx.getClassPath() +
                "\nInputArguments: " + mx.getInputArguments() +
                "\nLibraryPath: " + mx.getLibraryPath() +
                "\nManagementSpecVersion: " + mx.getManagementSpecVersion() +
                "\nMxBeanName: " + mx.getName() +
                "\nSpecName: " + mx.getSpecName() +
                "\nSpecVendor: " + mx.getSpecVendor() +
                "\nSpecVersion: " + mx.getSpecVersion() +
                "\nStartTime: " + mx.getStartTime() +
                "\nUptime: " + mx.getUptime() +
                "\nSystemProperties: " + mx.getSystemProperties() +
                "\nVmName: " + mx.getVmName() +
                "\nVmVendor: " + mx.getVmVendor() +
                "\nVmVersion: " + mx.getVmVersion();
    }

    private String memoryBean() {
        MemoryMXBean mx = ManagementFactory.getMemoryMXBean();

        return "MemoryMXBean info: " +
                "\nHeapMemoryUsage: " + mx.getHeapMemoryUsage().toString() +
                "\nNonHeapMemoryUsage: " + mx.getNonHeapMemoryUsage().toString() +
                "\nObjectPendingFinalizationCount: " + mx.getObjectPendingFinalizationCount();
    }

    private String operationSystemBean() {
        OperatingSystemMXBean mx = ManagementFactory.getOperatingSystemMXBean();

        return "OperatingSystemMXBean info: " +
                "\nArch: " + mx.getArch() +
                "\nName: " + mx.getName() +
                "\nVersion: " + mx.getVersion() +
                "\nAvailabeProcessors: " + mx.getAvailableProcessors() +
                "\nSystemLoadAverage: " + mx.getSystemLoadAverage();
    }

}

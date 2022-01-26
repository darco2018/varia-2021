package org.java9_11;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class ProcessAPI {

    public static void main(String[] args) {

        ProcessHandle self = ProcessHandle.current();
        long PID = self.pid();
        ProcessHandle.Info procInfo = self.info();

        Optional<String[]> arguments = procInfo.arguments();
        Optional<String> cmd =  procInfo.commandLine();
        Optional<Instant> startTime = procInfo.startInstant();
        Optional<Duration> cpuUsage = procInfo.totalCpuDuration();

        System.out.println( "PID: " + PID +
                "\n arguments:" + Arrays.toString(arguments.get()) +
                "\n\n cmdLine: " + cmd.get() +
                "\n\n startTime: " + startTime.get() +
                "\n cpuUsage: " + cpuUsage.get());

        System.out.println("---------------------------------------------");
        Stream<ProcessHandle> childProc = ProcessHandle.current().children();

        childProc.forEach(procHandle -> {
            System.out.println("@@@");
            System.out.println(procHandle.info());
            if(procHandle.destroy()){
                System.out.println("Could not kill process " + procHandle.pid());
            } else {
                System.out.println("Could kill " + procHandle.pid());
            }
        });
    }
}

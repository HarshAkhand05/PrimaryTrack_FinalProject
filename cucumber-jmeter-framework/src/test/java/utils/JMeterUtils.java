package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JMeterUtils {

    static String JMETER_PATH = "C:\\Users\\harsh\\Downloads\\apache-jmeter-5.6.3\\apache-jmeter-5.6.3\\bin\\jmeter.bat";
    static String TEST_PLAN = "C:\\Users\\harsh\\Downloads\\cucumber-jmeter-framework\\cucumber-jmeter-framework\\testplan.jmx";
    static String RESULT_FILE = "target/results.jtl";

    public static void runJMeter() throws Exception {

                ProcessBuilder pb = new ProcessBuilder(
                JMETER_PATH, "-n",
                "-t", TEST_PLAN,
                "-l", RESULT_FILE
        );



        pb.redirectErrorStream(true);
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
        );

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        if (process.waitFor() != 0) {
            throw new RuntimeException("JMeter failed!");
        }
    }

    public static void validatePerformance(int threshold) throws Exception {

        List<String> lines = Files.readAllLines(Paths.get(RESULT_FILE));

        for (String line : lines) {
            if (line.contains("elapsed")) continue;

            String[] data = line.split(",");
            int responseTime = Integer.parseInt(data[1]);

            if (responseTime > threshold) {
                throw new AssertionError("Performance issue: " + responseTime);
            }
        }
    }
}

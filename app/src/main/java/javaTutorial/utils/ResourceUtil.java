package javaTutorial.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Retrieve Resources from the resource directory. We need to be able to get files from the resource
 * directory because that's where some data is stored. (22-Apr-2023)
 */
public final class ResourceUtil {

    /**
     * Ain't never going to happen!
     */
    private ResourceUtil(){}

    /**
     * Retrieve a file as a List
     * @param filename The filename of the file to retrieve
     * @return The contents of the file in a List
     */
    public static List<String> readFileAsList(String filename) {
        List<String> data = new ArrayList<>();
        try (InputStream is = ResourceUtil.class.getClassLoader().getResourceAsStream(filename);
             InputStreamReader streamReader =
                new InputStreamReader(Objects.requireNonNull(is), StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}

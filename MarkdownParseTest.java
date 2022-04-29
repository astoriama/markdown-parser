
import static org.junit.Assert.*;

import java.beans.Transient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException {
        ArrayList<String>  l1 = new ArrayList<String>();
        l1.add("https://something.com");
        l1.add("some-thing.html");

        
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(l1,links);
    }
}
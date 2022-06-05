
import static org.junit.Assert.*;

import java.beans.Transient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
public class MarkdownParseTest {

    @Test
    public void testSnippet1() throws IOException {
        String contents= Files.readString(Path.of("./Snippet1.md"));
        List<String> expect = List.of("`google.com","google.com","ucsd.edu");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet2() throws IOException {
        String contents= Files.readString(Path.of("./Snippet2.md"));
        List<String> expect = List.of("a.com", "a.com(())","example.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet3() throws IOException {
        String contents= Files.readString(Path.of("./Snippet3.md"));
        List<String> expect = List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

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
        System.out.println("hi");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(l1,links);


    }


    // @Test
    // public void testFile1() throws IOException {
    //     String contents= Files.readString(Path.of("./test-file.md"));
    //     List<String> expect = List.of("https://something.com", "some-thing.html");
    //     assertEquals(MarkdownParse.getLinks(contents), expect);
    // }

    // @Test
    // public void testFile2() throws IOException {
    //     String contents= Files.readString(Path.of("./test-file2.md"));
    //     List<String> expect = List.of("https://something.com", "some-page.html");
    //     assertEquals(MarkdownParse.getLinks(contents), expect);
    // }

    // @Test
    // public void testLinkAtBeginning() {
    //     String contents= "[link title](a.com)";
    //     List<String> expect = List.of("a.com");
    //     assertEquals(MarkdownParse.getLinks(contents), expect);
    // }

    // @Test
    // public void testSpaceInURL() {
    //     String contents = "[title](space in-url.com)";
    //     List<String> expect = List.of();
    //     assertEquals(MarkdownParse.getLinks(contents), expect);
    // }

    // @Test
    // public void testSpaceAfterParen() {
    //     String contents = "[title]( space-in-url.com)";
    //     List<String> expect = List.of("space-in-url.com");
    //     assertEquals(expect, MarkdownParse.getLinks(contents));
    // }

    // @Test
    // public void testSpaceBeforeParen() {
    //     String contents = "[title]   (should-not-count.com)";
    //     List<String> expect = List.of();
    //     assertEquals(MarkdownParse.getLinks(contents), expect);
    // }

    // @Test
    // public void testNestedParens() throws IOException {
    //     String contents = Files.readString(Path.of("test-parens-inside-link.md"));
    //     List<String> expect = List.of("something.com()", "something.com((()))", "something.com", "boring.com");
    //     assertEquals(expect, MarkdownParse.getLinks(contents));
    // }

    // @Test
    // public void testMissingCloseParen() throws IOException {
    //     String contents = Files.readString(Path.of("test-missing-paren-plus-test-file2.md"));
    //     List<String> expect = List.of("https://something.com", "some-page.html");
    //     assertEquals(MarkdownParse.getLinks(contents), expect);
    // }
}

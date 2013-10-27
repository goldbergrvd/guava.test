package guava.test.html;

import com.google.common.escape.Escaper;
import com.google.common.html.HtmlEscapers;
import org.junit.*;
import static org.junit.Assert.*;

public class HtmlEscapersTest{
	
	@Test
	public void testHtmlEscaper(){
		assertEquals("&lt;", HtmlEscapers.htmlEscaper().escape("<"));
		assertEquals("&gt;", HtmlEscapers.htmlEscaper().escape(">"));
		assertEquals("&#39;", HtmlEscapers.htmlEscaper().escape("'"));
		assertEquals("&quot;", HtmlEscapers.htmlEscaper().escape("\""));
		assertEquals("&amp;", HtmlEscapers.htmlEscaper().escape("&"));
	}
}
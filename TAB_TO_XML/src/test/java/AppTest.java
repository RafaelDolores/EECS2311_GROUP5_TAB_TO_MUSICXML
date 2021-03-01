import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import TAB_TO_XML.App;

class AppTest {

	@Test
	public void identifyInstrumentTest1() {
		ArrayList<String> guitarTab = new ArrayList<>();
		guitarTab.add("|-----------0-----|-0---------------|");
		guitarTab.add("|---------0---0---|-0---------------|");
		guitarTab.add("|-------1-------1-|-1---------------|");
		guitarTab.add("|-----2-----------|-2---------------|");
		guitarTab.add("|---2-------------|-2---------------|");
		guitarTab.add("|-0---------------|-0---------------|");
		guitarTab.add("");
		guitarTab.add("|-----------0-----|-0---------------|");
		guitarTab.add("|---------0---0---|-0---------------|");
		guitarTab.add("|-------1-------1-|-1---------------|");
		guitarTab.add("|-----2-----------|-2---------------|");
		guitarTab.add("|---2-------------|-2---------------|");
		guitarTab.add("|-0---------------|-0---------------|");
		guitarTab.add("");
		guitarTab.add("|-----------0-----|-0---------------|");
		guitarTab.add("|---------0---0---|-0---------------|");
		guitarTab.add("|-------1-------1-|-1---------------|");
		guitarTab.add("|-----2-----------|-2---------------|");
		guitarTab.add("|---2-------------|-2---------------|");
		guitarTab.add("|-0---------------|-0---------------|");
		String actual = App.identifyInstrument(guitarTab);
		String expected = "Guitar";
		assertEquals(actual,expected);
	}
	
	@Test
	public void identifyInstrumentTest2() {
		ArrayList<String> drumTab = new ArrayList<>();
		drumTab.add("CC|x---------------|--------x-------|");
		drumTab.add("HH|--x-x-x-x-x-x-x-|----------------|");
		drumTab.add("SD|----o-------o---|oooo------------|");
		drumTab.add("HT|----------------|----oo----------|");
		drumTab.add("MT|----------------|------oo--------|");
		drumTab.add("BD|o-------o-------|o-------o-------|");
		String actual = App.identifyInstrument(drumTab);
		String expected = "Drums";
		assertEquals(actual,expected);
	}
	
	@Test
	public void identifyInstrumentTest3() {
		ArrayList<String> bassTab = new ArrayList<>();
		bassTab.add("G |--------7-----------|");
		bassTab.add("D |--------------------|");
		bassTab.add("A |--------------------|");
		bassTab.add("E |-/5--7-----7--5--7--|");
		bassTab.add("");
		bassTab.add("G |--------7-----------|");
		bassTab.add("D |--------------------|");
		bassTab.add("A |--------------------|");
		bassTab.add("E |-/5--7-----7--5--7--|");
		bassTab.add("");
		bassTab.add("G |--------7-----------|");
		bassTab.add("D |--------------------|");
		bassTab.add("A |--------------------|");
		bassTab.add("E |-/5--7-----7--5--7--|");
		String actual = App.identifyInstrument(bassTab);
		String expected = "Bass";
		assertEquals(actual,expected);
	}
	
	@Test
	public void guitarTabToXMLTest1() {
		ArrayList<String> tabAsList = App.getFileList(
				"|-----------0-----|-0---------------|\n"
				+ "|---------0---0---|-0---------------|\n"
				+ "|-------1-------1-|-1---------------|\n"
				+ "|-----2-----------|-2---------------|\n"
				+ "|---2-------------|-2---------------|\n"
				+ "|-0---------------|-0---------------|");
		String actual = App.guitarTabToXML(tabAsList);
		String expected = "<score-partwise version=\"3.1\">\n"
				+ "  <part-list>\n"
				+ "    <score-part id=\"P1\">\n"
				+ "      <part-name>Classical Guitar</part-name>\n"
				+ "    </score-part>\n"
				+ "  </part-list>\n"
				+ "  <part id=\"P1\">\n"
				+ "    <measure number=\"1\">\n"
				+ "      <attributes>\n"
				+ "        <divisions>2</divisions>\n"
				+ "        <key>\n"
				+ "          <fifths>0</fifths>\n"
				+ "        </key>\n"
				+ "        <time>\n"
				+ "          <beats>4</beats>\n"
				+ "          <beat-type>4</beat-type>\n"
				+ "        </time>\n"
				+ "        <clef>\n"
				+ "          <sign>TAB</sign>\n"
				+ "          <line>5</line>\n"
				+ "        </clef>\n"
				+ "        <staff-details>\n"
				+ "          <staff-lines>6</staff-lines>\n"
				+ "          <staff-tuning line=\"1\">\n"
				+ "            <tuning-step>E</tuning-step>\n"
				+ "            <tuning-octave>2</tuning-octave>\n"
				+ "          </staff-tuning>\n"
				+ "          <staff-tuning line=\"2\">\n"
				+ "            <tuning-step>A</tuning-step>\n"
				+ "            <tuning-octave>2</tuning-octave>\n"
				+ "          </staff-tuning>\n"
				+ "          <staff-tuning line=\"3\">\n"
				+ "            <tuning-step>D</tuning-step>\n"
				+ "            <tuning-octave>3</tuning-octave>\n"
				+ "          </staff-tuning>\n"
				+ "          <staff-tuning line=\"4\">\n"
				+ "            <tuning-step>G</tuning-step>\n"
				+ "            <tuning-octave>3</tuning-octave>\n"
				+ "          </staff-tuning>\n"
				+ "          <staff-tuning line=\"5\">\n"
				+ "            <tuning-step>B</tuning-step>\n"
				+ "            <tuning-octave>3</tuning-octave>\n"
				+ "          </staff-tuning>\n"
				+ "          <staff-tuning line=\"6\">\n"
				+ "            <tuning-step>E</tuning-step>\n"
				+ "            <tuning-octave>4</tuning-octave>\n"
				+ "          </staff-tuning>\n"
				+ "        </staff-details>\n"
				+ "      </attributes>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>E</step>\n"
				+ "          <octave>2</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>1</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>eighth</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>6</string>\n"
				+ "            <fret>0</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>B</step>\n"
				+ "          <octave>2</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>1</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>eighth</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>5</string>\n"
				+ "            <fret>2</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>E</step>\n"
				+ "          <octave>3</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>1</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>eighth</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>4</string>\n"
				+ "            <fret>2</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>G</step>\n"
				+ "          <alter>1</alter>\n"
				+ "          <octave>3</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>1</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>eighth</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>3</string>\n"
				+ "            <fret>1</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>B</step>\n"
				+ "          <octave>3</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>1</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>eighth</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>2</string>\n"
				+ "            <fret>0</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>E</step>\n"
				+ "          <octave>4</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>1</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>eighth</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>1</string>\n"
				+ "            <fret>0</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>B</step>\n"
				+ "          <octave>3</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>1</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>eighth</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>2</string>\n"
				+ "            <fret>0</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>G</step>\n"
				+ "          <alter>1</alter>\n"
				+ "          <octave>3</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>1</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>eighth</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>3</string>\n"
				+ "            <fret>1</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "    </measure>\n"
				+ "    <measure number=\"2\">\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>E</step>\n"
				+ "          <octave>2</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>8</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>whole</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>6</string>\n"
				+ "            <fret>0</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <chord/>\n"
				+ "        <pitch>\n"
				+ "          <step>B</step>\n"
				+ "          <octave>2</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>8</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>whole</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>5</string>\n"
				+ "            <fret>2</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <chord/>\n"
				+ "        <pitch>\n"
				+ "          <step>E</step>\n"
				+ "          <octave>3</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>8</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>whole</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>4</string>\n"
				+ "            <fret>2</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <chord/>\n"
				+ "        <pitch>\n"
				+ "          <step>G</step>\n"
				+ "          <alter>1</alter>\n"
				+ "          <octave>3</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>8</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>whole</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>3</string>\n"
				+ "            <fret>1</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <chord/>\n"
				+ "        <pitch>\n"
				+ "          <step>B</step>\n"
				+ "          <octave>3</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>8</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>whole</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>2</string>\n"
				+ "            <fret>0</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <chord/>\n"
				+ "        <pitch>\n"
				+ "          <step>E</step>\n"
				+ "          <octave>4</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>8</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>whole</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>1</string>\n"
				+ "            <fret>0</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <barline location=\"right\">\n"
				+ "        <bar-style>light-heavy</bar-style>\n"
				+ "      </barline>\n"
				+ "    </measure>\n"
				+ "  </part>\n"
				+ "</score-partwise>\n";
		assertEquals(expected, actual);
	}
	
	@Test
	public void bassTabToXMLTest1() {
		ArrayList<String> tabAsList = App.getFileList(
				"|-----------0-----|-0---------------|\n"
				+ "|---------0---0---|-0---------------|\n"
				+ "|-------1-------1-|-1---------------|\n"
				+ "|-----2-----------|-2---------------|\n");
		String actual = App.bassTabToXML(tabAsList);
		String expected = "<score-partwise version=\"3.1\">\n"
				+ "  <part-list>\n"
				+ "    <score-part id=\"P1\">\n"
				+ "      <part-name>Bass Guitar</part-name>\n"
				+ "    </score-part>\n"
				+ "  </part-list>\n"
				+ "  <part id=\"P1\">\n"
				+ "    <measure number=\"1\">\n"
				+ "      <attributes>\n"
				+ "        <divisions>2</divisions>\n"
				+ "        <key>\n"
				+ "          <fifths>0</fifths>\n"
				+ "        </key>\n"
				+ "        <time>\n"
				+ "          <beats>4</beats>\n"
				+ "          <beat-type>4</beat-type>\n"
				+ "        </time>\n"
				+ "        <clef>\n"
				+ "          <sign>TAB</sign>\n"
				+ "          <line>2</line>\n"
				+ "        </clef>\n"
				+ "        <staff-details>\n"
				+ "          <staff-lines>4</staff-lines>\n"
				+ "          <staff-tuning line=\"1\">\n"
				+ "            <tuning-step>E</tuning-step>\n"
				+ "            <tuning-octave>1</tuning-octave>\n"
				+ "          </staff-tuning>\n"
				+ "          <staff-tuning line=\"2\">\n"
				+ "            <tuning-step>A</tuning-step>\n"
				+ "            <tuning-octave>1</tuning-octave>\n"
				+ "          </staff-tuning>\n"
				+ "          <staff-tuning line=\"3\">\n"
				+ "            <tuning-step>D</tuning-step>\n"
				+ "            <tuning-octave>2</tuning-octave>\n"
				+ "          </staff-tuning>\n"
				+ "          <staff-tuning line=\"4\">\n"
				+ "            <tuning-step>2</tuning-step>\n"
				+ "            <tuning-octave>3</tuning-octave>\n"
				+ "          </staff-tuning>\n"
				+ "        </staff-details>\n"
				+ "      </attributes>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>F</step>\n"
				+ "          <alter>1</alter>\n"
				+ "          <octave>1</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>1</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>eighth</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>4</string>\n"
				+ "            <fret>2</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>A</step>\n"
				+ "          <alter>1</alter>\n"
				+ "          <octave>1</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>1</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>eighth</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>3</string>\n"
				+ "            <fret>1</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>D</step>\n"
				+ "          <octave>1</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>1</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>eighth</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>2</string>\n"
				+ "            <fret>0</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>G</step>\n"
				+ "          <octave>2</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>1</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>eighth</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>1</string>\n"
				+ "            <fret>0</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>D</step>\n"
				+ "          <octave>1</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>1</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>eighth</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>2</string>\n"
				+ "            <fret>0</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>A</step>\n"
				+ "          <alter>1</alter>\n"
				+ "          <octave>1</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>2</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type>quarter</type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>3</string>\n"
				+ "            <fret>1</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <pitch>\n"
				+ "          <step>F</step>\n"
				+ "          <alter>1</alter>\n"
				+ "          <octave>1</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>0</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type></type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>4</string>\n"
				+ "            <fret>2</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <chord/>\n"
				+ "        <pitch>\n"
				+ "          <step>A</step>\n"
				+ "          <alter>1</alter>\n"
				+ "          <octave>1</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>0</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type></type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>3</string>\n"
				+ "            <fret>1</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <chord/>\n"
				+ "        <pitch>\n"
				+ "          <step>D</step>\n"
				+ "          <octave>1</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>0</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type></type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>2</string>\n"
				+ "            <fret>0</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <note>\n"
				+ "        <chord/>\n"
				+ "        <pitch>\n"
				+ "          <step>G</step>\n"
				+ "          <octave>2</octave>\n"
				+ "        </pitch>\n"
				+ "        <duration>0</duration>\n"
				+ "        <voice>1</voice>\n"
				+ "        <type></type>\n"
				+ "        <notations>\n"
				+ "          <technical>\n"
				+ "            <string>1</string>\n"
				+ "            <fret>0</fret>\n"
				+ "          </technical>\n"
				+ "        </notations>\n"
				+ "      </note>\n"
				+ "      <barline location=\"right\">\n"
				+ "        <bar-style>light-heavy</bar-style>\n"
				+ "      </barline>\n"
				+ "    </measure>\n"
				+ "  </part>\n"
				+ "</score-partwise>\n";
		
		assertEquals(expected, actual);
	}

}

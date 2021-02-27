package TAB_TO_XML;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import Interface.Controller;


	public class BParser {

			
		/**
		 * Read the text tablature line by line
		 * 
		 * @param path is the file's path that we want to read
		 * @return an ArrayList filled with contents of the ArrayList
		 *         <p>
		 *         each line is an element in our array list
		 */

		/**
		 * Counts duration of a note.
		 * 
		 * @param parse is the array list of strings that contains a whole line of notes
		 * @return an integer representing the duration of the note.
		 */
		public static Integer durationCount(ArrayList<String> parse, int row, int division) {
			Integer count = 1;
			
			outerloop: 
			for (int i = row + 1; i < parse.get(0).length(); i++) {
					for (int j = 0; j < parse.size(); j++) {
						if (Character.isDigit(parse.get(j).charAt(i))) {
							break outerloop;
						}
						else {
							if (j == parse.size() - 1) {
								count++;
							}
						}
					}
				}
			count = count / division;
			if (count > 8) {
				count = 8;
			}
			return count;
		}

		/// May require fix again
		/**
		 * Counts the division of the whole tablature
		 * 
		 * @param parse is the array list of strings that contains a whole line of notes
		 * @return an integer that represents the division of the whole tablature.
		 */
		public static int divisionCount(ArrayList<String> parse) {
			return (parse.get(0).length()-1) / 8;
		}


		/**
		 * Method used to get the step count.
		 * 
		 * @param parse is the array list of strings that contains a whole line of notes
		 * @return an String that represents the fret of the note.
		 */
		public static String stepCount(int row, int column) {

			String[][] fretboard = new String[][] {
				{ "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G" },
				{ "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D" },
				{ "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A" },
				{ "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E" },};
				
				return fretboard[row][column];
		}

		/**
		 * Method used to get the type
		 * 
		 * @param parse is the array list of strings that contains a whole line of notes
		 * @return an String that represents the type of the note.
		 */
		public static String typeDeclare(int duration) {
			String[] types = new String[] { "", "eighth", "quarter", "quarter and eighth", "half", "", "quarter and half", "", "whole" };
			return types[duration];
		}

		public static String octaveCount(int row, int column) {
			String[][] fretboard = new String[][] { 
				{ "2", "2", "2", "2", "2", "2", "2", "2", "2", "3", "3", "3", "3" },
				{ "1", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2" },
				{ "1", "1", "1", "1", "1", "1", "1", "2", "2", "2", "2", "2", "2" },
				{ "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "2" },};

				return fretboard[row][column];
		}
		
		// inputing strings of lines.
		public static ArrayList<ArrayList<String>> method1(ArrayList<String> inputFile){	
			
			
			ArrayList<ArrayList<String>> Collections = new ArrayList<ArrayList<String>>();
			
			ArrayList<String> eachCollection = new ArrayList<String>();
			
			for (int i = 0; i < inputFile.size(); i++) {
				if (inputFile.get(i).contains("|-")) {
					for (int j = 0; j < 4; j++) {
						eachCollection.add(inputFile.get(i+j));
					}
					eachCollection.add(" ");
					Collections.add(eachCollection);
					eachCollection = new ArrayList<String>();
					i = i + 3;
				}
				
				
			}
			
			// returns 2d arrays of the input lines 
			return Collections;
		}
		
		
		// input of six lines
		public static ArrayList<ArrayList<String>> method2(ArrayList<String> input){ 
			
			ArrayList<ArrayList<String>> sections = new ArrayList<ArrayList<String>>();
			ArrayList<String> eachSection = new ArrayList<String>();
			
			// assumes that all the measures have 17 dashes/notes excluding the vertical lines
			for (int i = 0; i < (input.get(0).length()-1)/18; i++) {	
				for (int j = 0; j < 4; j++) {
					eachSection.add(input.get(j).substring(1+18*i, 18*(i+1)));
				}
				sections.add(eachSection);
				eachSection = new ArrayList<String>();
			}
			
			// returns  2d array of substrings of the measure excluding the vertical lines	
			return sections;
												
		}
		
		public String parseAlter(String note) { 
			
			for (int i = 0; i < note.length(); i++) { 
				if (note.charAt(i) == '#') { 
					return "1";
				}
			
			}
			return "0";
		}
		public static boolean isChord(ArrayList<String> line, char note) { 
			return false;
			
		}
		public static String[] parseChord() {return null;}
	}
	
	
	
	

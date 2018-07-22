package com.apawale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 @author Abhishek P.
 This class implements merge logic for zipcodes.
 Input is provided by input.csv from resources folder

 */

public class ZipRangeMerge {

	private static ArrayList<RangeDS> rangeList = new ArrayList<RangeDS>();

	private static final Logger logger = LoggerFactory
			.getLogger(ZipRangeMerge.class);

	public static void main(String[] args) {

		try {
			
			//Java 8 forEach & lambda 
			readData().forEach(name -> ZipRangeMerge.AddRange(name));

		} catch (Exception e) {
			logger.error(e.getStackTrace().toString());
		}

		showRange();

	}

	public static void AddRange(RangeDS toAdd) {
		if (rangeList.size() == 0)
			rangeList.add(toAdd);
		else {
			// Add new Range, if the range overlaps with existing range, merge
			// them
			ListIterator<RangeDS> iter = rangeList.listIterator();
			boolean add = true; // flag
			while (iter.hasNext()) {
				RangeDS range = iter.next();
				// new range within existing range, no need to add
				if (range.getLower() <= toAdd.getLower()
						&& range.getUpper() >= toAdd.getUpper()) {
					add = false;
				}
				// new range is out of existing range, add it
				else if (range.getLower() > toAdd.getUpper()
						|| range.getUpper() < toAdd.getLower()) {
					add = true;
				}
				// Range overlaps, remove existing, update toAdd
				else {
					if (range.getLower() < toAdd.getLower())
						toAdd.setLower(range.getLower());
					if (range.getUpper() > toAdd.getUpper())
						toAdd.setUpper(range.getUpper());
					iter.remove();
					add = true;
				}
			}// end of while
			if (add)
				rangeList.add(toAdd);
		}// end of else

	}

	public static void showRange() {
		if (rangeList.size() > 0) {
			for (RangeDS range : rangeList) {
				System.out.println(range.toString());
			}
		}

	}

	public static int size() {
		return rangeList.size();
	}

	public static List<RangeDS> getZipRanges() {
		return rangeList;
	}

	public static void clear() {
		rangeList.clear();
	}

	public static ArrayList<RangeDS> readData() throws IOException {
		String file = "./resource/input.csv";
		ArrayList<RangeDS> content = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				content.add(new RangeDS(Integer.parseInt(line.split(",")[0]),
						Integer.parseInt(line.split(",")[1])));
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			logger.error(sw.toString());
		}
		return content;
	}

}

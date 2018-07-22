package com.apawale;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class ZipRangeMergeTest {

	private ArrayList<RangeDS> expectedResult;

	@Before
	public void setUp() {
		System.out.println("@Before - setUp");
		this.expectedResult = new ArrayList<RangeDS>();
	}

	@After
	public void tearDown() {
		System.out.println("@After - tearDown");
		this.expectedResult.clear();
		ZipRangeMerge.clear();
	}

	@Test
	public void ZipRangetestWithNumbers() {

		setUp();

		RangeDS a = new RangeDS(3, 5);
		RangeDS b = new RangeDS(10, 13);
		RangeDS c = new RangeDS(8, 11);
		RangeDS d = new RangeDS(15, 19);
		RangeDS e = new RangeDS(13, 16);

		ZipRangeMerge.AddRange(a);
		ZipRangeMerge.AddRange(b);
		ZipRangeMerge.AddRange(c);
		ZipRangeMerge.AddRange(d);
		ZipRangeMerge.AddRange(e);

		// Test size
		Assert.assertEquals("failure - expected result size match", 2,
				ZipRangeMerge.size());

		// Test content
		ArrayList<RangeDS> expectedResult = new ArrayList<RangeDS>();
		expectedResult.add(a);
		RangeDS f = new RangeDS(8, 19);
		expectedResult.add(f);
		Assert.assertEquals("failure - expected result content match",
				expectedResult, ZipRangeMerge.getZipRanges());

		expectedResult.clear();
	}

	@Test
	public void ZipRangetestWithData1() {
		setUp();

		RangeDS a = new RangeDS(94133, 94133);
		RangeDS b = new RangeDS(94200, 94299);
		RangeDS c = new RangeDS(94600, 94699);

		ZipRangeMerge.AddRange(a);
		ZipRangeMerge.AddRange(b);
		ZipRangeMerge.AddRange(c);

		Assert.assertEquals("failure - expected result size match", 3,
				ZipRangeMerge.size());

		RangeDS e = new RangeDS(94133, 94133);
		RangeDS f = new RangeDS(94200, 94299);
		RangeDS g = new RangeDS(94600, 94699);
		expectedResult.add(e);
		expectedResult.add(f);
		expectedResult.add(g);
		Assert.assertEquals("failure - expected result content match",
				expectedResult, ZipRangeMerge.getZipRanges());

		tearDown();

	}

	@Test
	public void ZipRangetestWithData2() {
		setUp();

		RangeDS a = new RangeDS(94133, 94133);
		RangeDS b = new RangeDS(94200, 94299);
		RangeDS c = new RangeDS(94226, 94399);

		ZipRangeMerge.AddRange(a);
		ZipRangeMerge.AddRange(b);
		ZipRangeMerge.AddRange(c);

		Assert.assertEquals("failure - expected result size match", 2,
				ZipRangeMerge.size());

		RangeDS e = new RangeDS(94133, 94133);
		RangeDS f = new RangeDS(94200, 94399);

		expectedResult.add(e);
		expectedResult.add(f);

		Assert.assertEquals("failure - expected result content match",
				expectedResult, ZipRangeMerge.getZipRanges());

		tearDown();

	}

}

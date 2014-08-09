package com.lithium.bm;

import com.google.caliper.Benchmark;
import com.google.caliper.Param;

/**
 * Created by kedar.mhaswade on 8/9/14.
 */
public final class StringCmpBenchmark {

	@Param ({"100000"}) int length;

	@Benchmark public  int measureQuad(int reps) {
		int ll = this.length;
		int dummy = 0;
		for (int i = 0; i < reps; i++)
			dummy += StringCmp.replaceUsingQuadraticAlgoritm(StringCmp.randomString(ll)).length();
		return dummy;
	}
	@Benchmark public  int measureHashSet(int reps) {
		int ll = this.length;
		int dummy = 0;
		for (int i = 0; i < reps; i++)
			dummy += StringCmp.replaceUsingHashSet(StringCmp.randomString(ll)).length();
		return dummy;
	}
}

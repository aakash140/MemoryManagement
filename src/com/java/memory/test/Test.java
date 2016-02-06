package com.java.memory.test;

/**
 *
 * @author Aakash Gupta
 *
 */
public class Test {

	public static void main(String[] args) {
		long memory1, memory2;
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Total Designated Memory: " + runtime.maxMemory() + " bytes\n\n");
		Integer[] integer = new Integer[1000];

		memory1 = runtime.freeMemory();
		System.out.println("Total Memory: " + runtime.totalMemory() + " bytes");
		System.out.println("Memory ready for new objects: " + memory1 + " bytes");
		System.out.println("\n\n-----GC IN PROGRESS----\n");

		// REQUEST GC TO RUN
		runtime.gc();

		memory1 = runtime.freeMemory();
		System.out.println("Total Memory: " + runtime.totalMemory() + " bytes");
		System.out.println("Memory ready for new objects after GC: " + memory1 + " bytes");

		System.out.println("\n\n-------Creating 1000 objects------");
		for (int i = 0; i < integer.length; i++)
			integer[i] = new Integer(i);
		memory2 = runtime.freeMemory();
		System.out.println("Total Memory: " + runtime.totalMemory() + " bytes");
		System.out.println("Memory ready for new objects after allocation: " + memory2 + " bytes");
		System.out.println("Memory used by allocated objects: " + (memory1 - memory2) + " bytes");

		System.out.println("\n\n-----Deallocating Objects-----");
		for (int i = 0; i < integer.length; i++)
			integer[0] = null;

		System.out.println("\n\n-----GC IN PROGRESS----\n");
		// REQUEST GC TO RUN
		runtime.gc();

		memory2 = runtime.freeMemory();
		System.out.println("Total Memory: " + runtime.totalMemory() + " bytes");
		System.out.println("Memory ready for new objects after deallocation and running GC: " + memory2 + " bytes");
	}
}
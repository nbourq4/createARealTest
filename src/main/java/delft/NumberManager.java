package delft;

import java.util.ArrayList;
import java.util.List;

public class NumberManager {
	private List<Integer> numbers;

	public NumberManager() {
		this.numbers = new ArrayList<>();
	}

	// Add a number to the list
	public void addNumber(int number) {
		numbers.add(number);
	}

	// Get the sum of all numbers
	public int getSum() {
		return numbers.stream().mapToInt(Integer::intValue).sum();
	}

	// Get the largest number in the list
	public int getMax() {
		if (numbers.isEmpty()) {
			throw new IllegalStateException("No numbers in the list");
		}
		return numbers.stream().mapToInt(Integer::intValue).max().orElseThrow();
	}

	// Clear all numbers
	public void clear() {
		numbers.clear();
	}

	// Get the current list of numbers
	public List<Integer> getNumbers() {
		return new ArrayList<>(numbers);
	}
}


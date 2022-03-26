package fr.nnyimc.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


@TestInstance(Lifecycle.PER_CLASS)
public class CalculatorTest {

	private static Instant startedAt;
	private Calculator calculator;
	
	@BeforeAll
	public void initStartingTime() {
		startedAt = Instant.now();
	}
	
	@BeforeEach
	public void initCalculator() {
		calculator = new Calculator();
	}
	
	@AfterEach
	public void nullifyCalculator() {
		calculator = null;
	}
	
	@AfterAll
	public void showTestDuration() {
		final Instant endedAt= Instant.now();
		final long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.println("TOTAL TIME: " + duration + "ms");
	} 
	
	@Test
	public void shouldAddTwoPositiveNumbers() {
		
		final int firstInteger = 5;
		final int secondInteger = 3;
		
		final int sum = calculator.add(firstInteger, secondInteger);

		// assertEquals(8, sum);
		assertThat(sum).isEqualTo(8);
	}
	
	@Test
	public void shouldMultiplyTwoPositiveNumbers() {
		
		final int firstInteger = 3;
		final int secondInteger = 5;
		
		final int product = calculator.multiply(firstInteger, secondInteger);
		
		// assertEquals(15, product);
		assertThat(product).isEqualTo(15);
	}
	
	@ParameterizedTest(name = "{0} x 0 shouldBeEqualToZero")
	@ValueSource(ints = { 1, 2, 10, 50, 100})
	public void shouldMultiplyArgumentsReturnZero(int number) {
		
		// Arrange step is covered by @ParameterizedTest
		
		int obtainedProduct = calculator.multiply(number, 0);
		
		// assertEquals(0, obtainedProduct);
		assertThat(obtainedProduct).isEqualTo(0);
	}
	
	@ParameterizedTest(name = "{0} + {1} should add up to {2}")
	@CsvSource({ "1, 1, 2", "3, 3, 6", "4, 6, 10" })
	public void shouldReturnSumOfArguments( int number1, int number2, int sumOfBothNumbers) {
		
		// Arrange step is covered by @ParameterizedTest
		
		int obtainedSum = calculator.add(number1, number2);
		
		// assertEquals(sumOfBothNumbers, obtainedSum);
		assertThat(obtainedSum).isEqualTo(sumOfBothNumbers);
	}
	
	@Test
	public void shouldListDigitsInNumber() {
		
		int number = 554120;
		
		Set<Integer> actualDigits = calculator.listDigits(number);
		
		assertThat(actualDigits).containsExactlyInAnyOrder(5, 4, 1, 2, 0);
	}
	
}

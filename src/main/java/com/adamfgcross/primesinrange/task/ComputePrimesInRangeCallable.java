package com.adamfgcross.primesinrange.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComputePrimesInRangeCallable implements Callable<List<String>> {

	private Long rangeMin;
	private Long rangeMax;
	private List<Long> primes = new ArrayList<>();
	private static final Logger logger = LoggerFactory.getLogger(ComputePrimesInRangeCallable.class);
	
	public ComputePrimesInRangeCallable(Long rangeMin, Long rangeMax) {
		this.rangeMin = rangeMin;
		this.rangeMax = rangeMax;
	}
	
	@Override
	public List<String> call() {
		logger.info("computing primes in range " + rangeMin + " to " + rangeMax);
		for (long i = rangeMin; i < rangeMax; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
			if (Thread.currentThread().isInterrupted()) {
                System.out.println("Task was interrupted!");
                break;
            }
		}
		return primes.stream().map(p -> p.toString()).toList();
	}

	private boolean isPrime(Long number) {
		if (number < 2) {
            return false;
        }

        // Check divisibility up to the square root of the number
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
	}
	
}

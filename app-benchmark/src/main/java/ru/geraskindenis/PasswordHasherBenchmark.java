package ru.geraskindenis;

import org.openjdk.jmh.annotations.*;
import ru.geraskindenis.security.PasswordHasher;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class PasswordHasherBenchmark {

    private PasswordHasher passwordHasher;

    private String testPassword;

    @Setup(Level.Trial)
    public void setUp() {
        // PasswordHasher теперь доступен из модуля application
        this.passwordHasher = new PasswordHasher();
        this.testPassword = "mySecretPassword123!";
    }

    @Benchmark
    public String hashPassword() {
        return passwordHasher.hashPassword(testPassword);
    }
}

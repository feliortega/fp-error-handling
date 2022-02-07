package ninja.functor;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

public class OptionalTest extends BaseTest {
  private final static String EMPTY_FALLBACK = "empty value";

  private static <T> Optional<T> builder(Supplier<T> supplier) {
    try {
      return Optional.of(supplier.get());
    } catch (Throwable e) {
      return Optional.empty();
    }
  }

  @Test
  public void test() {
    Arrays.stream(USER_SUPPLIER)
        .map(OptionalTest::builder)
        .map(user -> user.map(User::getEmail))
        .map(email -> email.isEmpty()
            ? "error: " + EMPTY_FALLBACK
            : "email: " + email.get())
        .forEach(System.out::println);
  }
}

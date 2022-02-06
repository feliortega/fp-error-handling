package ninja.functor;

import java.util.Optional;
import java.util.function.Supplier;
import ninja.functor.util.UnsafeUtil;
import org.junit.jupiter.api.Test;

public class OptionalTest {
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
    UnsafeUtil.getUserSupplierStream()
        .map(OptionalTest::builder)
        .map(user -> user.map(User::getEmail))
        .map(email -> email.isEmpty()
            ? "error: " + EMPTY_FALLBACK
            : "email: " + email.get())
        .forEach(System.out::println);
  }
}

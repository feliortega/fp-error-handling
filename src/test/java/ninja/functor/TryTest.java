package ninja.functor;

import java.util.function.Function;
import ninja.functor.util.UnsafeUtil;
import org.junit.jupiter.api.Test;

public class TryTest {
  private final static Function<Throwable, String> ERROR_FALLBACK = e -> e.toString();

  @Test
  public void test() {
    UnsafeUtil.getUserSupplierStream()
        .map(Try::build)
        .map(user -> user.map(User::getEmail))
        .map(email -> email.isError()
            ? "error: " + ERROR_FALLBACK.apply(email.getError()) // fallback function
            : "email: " + email.getValue())
        .forEach(System.out::println);
  }
}

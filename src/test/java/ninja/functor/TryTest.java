package ninja.functor;

import java.util.Arrays;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

public class TryTest extends BaseTest {
  private final static Function<Throwable, String> ERROR_FALLBACK = e -> e.toString();

  @Test
  public void test() {
    Arrays.stream(USER_SUPPLIER)
        .map(Try::build)
        .map(user -> user.map(User::getEmail))
        .map(email -> email.isError()
            ? "error: " + ERROR_FALLBACK.apply(email.getError()) // fallback function
            : "email: " + email.getValue())
        .forEach(System.out::println);
  }
}

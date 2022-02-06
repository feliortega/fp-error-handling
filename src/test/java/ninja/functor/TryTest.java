package ninja.functor;

import ninja.functor.util.UserUtil;
import org.junit.jupiter.api.Test;

public class TryTest {
  @Test
  public void test() {
    UserUtil.getSuppliers().forEach(userSupplier -> {
      final Try<String> email = Try.build(userSupplier)
          .map(User::getEmail);

      final String message = email.isError()
          ? "error: " + email.getError().getClass().getSimpleName()
          : "email: " + email.getValue();
      System.out.println(message);
    });
  }
}

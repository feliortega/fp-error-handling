package ninja.functor;

import java.util.Optional;
import java.util.function.Supplier;
import ninja.functor.util.UserUtil;
import org.junit.jupiter.api.Test;

public class OptionalTest {
  @Test
  public void test() {
    final String emptyMessage = "not defined";

    UserUtil.getSuppliers()
        .map(this::optionalHandler)
        .forEach(databaseRead -> {
          final Optional<String> email = databaseRead
              .map(User::getEmail);
          final String message = email.isEmpty()
              ? emptyMessage // fallback
              : email.get();
          System.out.println(message);
        });
  }

  private <T> Optional<T> optionalHandler(Supplier<T> supplier) {
    try {
      return Optional.of(supplier.get());
    } catch (Throwable e) {
      return Optional.empty();
    }
  }
}

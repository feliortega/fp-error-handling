package ninja.functor;

import java.util.function.Supplier;

public class BaseTest {
  public final static Supplier<User>[] USER_SUPPLIER = new Supplier[] {
      () -> new User("email@domain.com"),
      () -> null,
      () -> new User(String.valueOf(5 / 0))
  };
}

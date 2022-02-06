package ninja.functor.util;

import java.util.function.Supplier;
import java.util.stream.Stream;
import ninja.functor.User;

public class UserUtil {
  private UserUtil() {
    // Utility class
  }
  public static final Stream<Supplier<User>> getSuppliers(){
    return Stream.of(
        () -> new User("email@domain.com"),
        () -> null,
        () -> new User(String.valueOf(5/0)));
  }
}

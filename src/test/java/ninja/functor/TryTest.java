package ninja.functor;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class TryTest {
  @Test
  public void test() {
    Stream.of(
            null,
            new User(null),
            new User("email@domain.com"))
        .forEach(user -> {
          final Try<String> email = Try.build(() -> user)
              .map(User::getEmail);

          final String message = email.isError()
              ? "error: " + email.error.toString()
              : "email: " + email.value;
          System.out.println(message);

          assertTrue(email.isError() ? email.error != null : email.error == null);
        });
  }

  public static class User {
    private final String email;
    public User(String email){
      this.email = email;
    }
    public String getEmail(){
      return email;
    }
  }
}

package ninja.functor;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class Try<T> {
  private final Optional<T> value;

  private final Optional<Throwable> error;

  private Try(T value) {
    this.value = Optional.of(value);
    this.error = Optional.empty();
  }

  private Try(Throwable error) {
    this.value = Optional.empty();
    this.error = Optional.of(error);
  }

  public T getValue() {
    return value.get();
  }

  public Throwable getError() {
    return error.get();
  }

  public boolean isError() {
    return error.isPresent();
  }

  public static <T> Try<T> build(Supplier<T> constructor) {
    try {
      return new Try(constructor.get());
    } catch (Throwable e) {
      return new Try(e);
    }
  }

  public <B> Try<B> map(Function<T, B> function) {
    if (isError()) {
      return new Try(getError());
    } else {
      return build(() -> function.apply(getValue()));
    }
  }
}
